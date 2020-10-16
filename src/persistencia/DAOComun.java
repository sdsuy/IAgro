package persistencia;
import entidades.Comun;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class DAOComun {
	private static Connection conexion = DatabaseManager.getConexion();
	
	public static boolean nuevoUsuario(Comun usuario){
		String consulta = "INSERT INTO COMUNES (ID_USUARIO, LIST_TAREAS, NOMBRE, APELLIDO, NOMB_USUARIO, CONTRASENIA, EMAIL, CEDULA, INSTITUTO,) "
				+ "VALUES (SEQ_ID_USUARIO.NEXT_VAL,?,?,?,?,?,?,?)";
		try {
			Statement sentencia = conexion.createStatement();
			sentencia.executeQuery(consulta);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean borrarUsuario(Comun usuario){
		String consulta = "DELETE FROM COMUNES WHERE ID_USUARIO ="+ usuario.getId(); 
		try {
			Statement sentencia = conexion.createStatement();
			sentencia.executeQuery(consulta);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static LinkedList<Comun> listarUsuarios(){
		LinkedList<Comun> usuarios = new LinkedList<>();
		String consulta = "SELECT * FROM COMUNES";
		try {
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(consulta);
			
			while(resultados.next()) {
				Comun user = new Comun();
				user.setId(resultados.getInt("ID_USUARIO"));
				user.setNombre(resultados.getString("NOMBRE"));
				user.setApellido(resultados.getString("APELLIDO"));
				user.setUser(resultados.getString("NOMB_USUARIO"));
				user.setPswd(resultados.getString("CONTRASENIA"));
				user.setEmail(resultados.getString("EMAIL"));
				user.setList_tarea(resultados.getString("LIST_TAREAS"));
				usuarios.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public static boolean updateUsuario(Comun usuario){
		final String consulta = "UPDATE ADMINISTRADOR SET NOMBRE=?,APELLIDO=?,NOMB_USUARIO=?,CONTRASENIA=?,EMAIL=?,CEDULA=?,INSTITUTO,LIST_TAREAS WHERE ID_USUARIO=?";
		PreparedStatement pst;
		try {
			pst = conexion.prepareStatement(consulta);
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getApellido());
			pst.setString(3, usuario.getUser());
			pst.setString(4, usuario.getPswd());
			pst.setString(5, usuario.getEmail());
			pst.setString(8, usuario.getList_tarea());  
			
			int filasAgregadas = pst.executeUpdate();
			return filasAgregadas > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block                                                                                                          
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public static Comun encontrarUsuario(String nombreUsuario){
		Comun usuario = new Comun();
		final String consulta = "SELECT * FROM COMUN WHERE NOMB_USUARIO=?";
		try {
			PreparedStatement pst = conexion.prepareStatement(consulta);
			
			pst.setString(1, nombreUsuario);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				usuario.setId(rs.getInt("ID_USUARIO"));
				usuario.setNombre(rs.getString("NOMBRE"));
				usuario.setApellido(rs.getString("APELLIDO"));
				usuario.setUser(rs.getString("NOMB_USUARIO"));
				usuario.setPswd(rs.getString("CONTRASENIA"));
				usuario.setEmail(rs.getString("EMAIL"));
				usuario.setList_tarea(rs.getString("LIST_TAREAS"));
			}
			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
