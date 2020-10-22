package persistencia;
import entidades.Comun;
import entidades.Experto;
import entidades.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class DAOComun extends DAOUsuario {
	private static Connection conexion = DatabaseManager.getConexion();
	
	private static final String INSERT_COMUN = "INSERT INTO COMUNES (ID_USUARIO, LIST_TAREAS) VALUES (SEQ_ID_USUARIO.CURRVAL,?)";
	private static final String UPDATE_COMUN = "UPDATE COMUNES SET LIST_TAREAS=? WHERE ID_USUARIO=?";
	private static final String ALL_COMUNES = "SELECT * FROM COMUNES"; //+join
	private static final String FIND_COMUN = "SELECT\r\n" + 
			"    usuarios.*,\r\n" + 
			"    comunes.*\r\n" + 
			"FROM\r\n" + 
			"    comunes\r\n" + 
			"    INNER JOIN usuarios ON usuarios.id_usuario = comunes.id_usuario\r\n" + 
			"WHERE\r\n" + 
			"    comunes.id_usuario = ?";
	
	public static boolean createUsuario(Usuario user){
		try {
			PreparedStatement insertarUsuario = conexion.prepareStatement(INSERT_USUARIO);
			PreparedStatement insertarComun = conexion.prepareStatement(INSERT_COMUN);
			
			conexion.setAutoCommit(false);
			
			insertarUsuario.setString(1, user.getNombre());
			insertarUsuario.setString(2, user.getApellido());
			insertarUsuario.setString(3, user.getUser());
			insertarUsuario.setString(4, user.getPswd());
			insertarUsuario.setString(5, user.getEmail());
			int filasAgregadas1 = insertarUsuario.executeUpdate();
			
			insertarComun.setString(1, user.getList_tareas());
			int filasAgregadas2 = insertarComun.executeUpdate();
			
			
			conexion.commit();
			
			return filasAgregadas1 > 0 && filasAgregadas2 > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	public static boolean updateUsuario(Usuario user) {
		
		try {
			PreparedStatement modificarUser = conexion.prepareStatement(UPDATE_USUARIO);
			PreparedStatement modificarComun = conexion.prepareStatement(UPDATE_COMUN);
			
			conexion.setAutoCommit(false);
			
			modificarUser.setString(1, user.getNombre());
			modificarUser.setString(2, user.getApellido());
			modificarUser.setString(3, user.getUser());
			modificarUser.setString(4, user.getPswd());
			modificarUser.setString(5, user.getEmail());
			modificarUser.setInt(6, user.getId());
			int filasAgregadas1 = modificarUser.executeUpdate();
			
			
			modificarComun.setString(1, user.getList_tareas());
			int filasAgregadas2 = modificarComun.executeUpdate();
			
			conexion.commit();
			
			return filasAgregadas1 > 0 && filasAgregadas2 > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	public static Usuario findUsuario(int id) {
		Usuario usuario = new Experto();
		try {
			PreparedStatement pst = conexion.prepareStatement(FIND_COMUN);
			
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				usuario.setId(rs.getInt("ID_USUARIO"));
				usuario.setNombre(rs.getString("NOMBRE"));
				usuario.setApellido(rs.getString("APELLIDO"));
				usuario.setUser(rs.getString("NOMB_USUARIO"));
				usuario.setPswd(rs.getString("CONTRASENIA"));
				usuario.setEmail(rs.getString("EMAIL"));
				usuario.setList_tareas(rs.getString("LIST_TAREAS"));
				
				
			}
			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static LinkedList<Usuario> listarUsuarios(){
		LinkedList<Usuario> users = new LinkedList<>();
		
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(ALL_COMUNES);
			
			while(rs.next()) {
				Comun user = new Comun();
				user.setId(rs.getInt("ID_USUARIO"));
				user.setNombre(rs.getString("NOMBRE"));
				user.setApellido(rs.getString("APELLIDO"));
				user.setUser(rs.getString("NOMB_USUARIO"));
				user.setPswd(rs.getString("CONTRASENIA"));
				user.setEmail(rs.getString("EMAIL"));
				user.setList_tareas(rs.getString("LIST_TAREAS"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
		
	}
}
