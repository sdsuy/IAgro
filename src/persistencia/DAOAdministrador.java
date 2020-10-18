package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.Administrador;
import entidades.Usuario;

public class DAOAdministrador extends DAOUsuario {
	
private static Connection conexion = DatabaseManager.getConexion();
	
	private static final String INSERT_ADMIN = "INSERT INTO ADMINISTRADORES (ID_USUARIO,CEDULA,INSTITUTO,LIST_TAREAS) VALUES (SEQ_ID_USUARIO.CURRVAL,?,?,?)";
	private static final String UPDATE_ADMIN = "UPDATE ADMINISTRADORES SET CEDULA=?,INSTITUTO=?,LIST_TAREAS=? WHERE ID_USUARIO=?";
	private static final String ALL_ADMIN = "--ES UN JOIN--";
	private static final String FIND_ADMIN = "SELECT\r\n" + 
			"    usuarios.*,\r\n" + 
			"    administradores.*\r\n" + 
			"FROM\r\n" + 
			"    administradores\r\n" + 
			"    INNER JOIN usuarios ON usuarios.id_usuario = administradores.id_usuario\r\n" + 
			"WHERE\r\n" + 
			"    administradores.id_usuario = ?";
	
	public static boolean createUsuario(Usuario usuario) {
		try {
			PreparedStatement insertarUsuario = conexion.prepareStatement(INSERT_USUARIO);
			PreparedStatement insertarAdmin = conexion.prepareStatement(INSERT_ADMIN);
			
			// Usamos una transaccion con auto commit deshabilitado
			// ya que son 2 consultas y ambas deben hacerse al mismo tiempo
			conexion.setAutoCommit(false);
			
			// Primero inserto un Usuario
			insertarUsuario.setString(1, usuario.getNombre());
			insertarUsuario.setString(2, usuario.getApellido());
			insertarUsuario.setString(3, usuario.getUser());
			insertarUsuario.setString(4, usuario.getPswd());
			insertarUsuario.setString(5, usuario.getEmail());
			int filasAgregadas1 = insertarUsuario.executeUpdate();
			
			// Despues inserto el Administrador relacionado a ese usuario
			insertarAdmin.setInt(1, usuario.getCedula());
			insertarAdmin.setString(2, usuario.getInstituto());
			insertarAdmin.setString(3, usuario.getList_tareas());
			int filasAgregadas2 = insertarAdmin.executeUpdate();
			
			// Hacemos el commit con ambas consultas de una vez sola
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
			PreparedStatement modificarAdmin = conexion.prepareStatement(UPDATE_ADMIN);
			
			conexion.setAutoCommit(false);
			
			//Primero modifico datos propios del Usuario
			modificarUser.setString(1, user.getNombre());
			modificarUser.setString(2, user.getApellido());
			modificarUser.setString(3, user.getUser());
			modificarUser.setString(4, user.getPswd());
			modificarUser.setString(5, user.getEmail());
			modificarUser.setInt(6, user.getId());
			int filasAgregadas1 = modificarUser.executeUpdate();
			
			//Despues modifico datos propios del Administrador
			modificarAdmin.setInt(1, user.getCedula());
			modificarAdmin.setString(2, user.getInstituto());
			modificarAdmin.setString(3, user.getList_tareas());
			modificarUser.setInt(4, user.getId());
			int filasAgregadas2 = modificarAdmin.executeUpdate();
			
			// Hacemos el commit con ambas consultas de una vez sola
			conexion.commit();
			
			return filasAgregadas1 > 0 && filasAgregadas2 > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	public static Usuario findUsuario(int id) {
		Usuario usuario = new Administrador();
		try {
			PreparedStatement pst = conexion.prepareStatement(FIND_ADMIN);
			
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				usuario.setId(rs.getInt("ID_USUARIO"));
				usuario.setNombre(rs.getString("NOMBRE"));
				usuario.setApellido(rs.getString("APELLIDO"));
				usuario.setUser(rs.getString("NOMB_USUARIO"));
				usuario.setPswd(rs.getString("CONTRASENIA"));
				usuario.setEmail(rs.getString("EMAIL"));
				usuario.setCedula(rs.getInt("CEDULA"));
				usuario.setInstituto(rs.getString("INSTITUTO"));
				usuario.setList_tareas(rs.getString("LIST_TAREAS"));
			}
			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static LinkedList<Usuario> selectUsuario(){
		LinkedList<Usuario> users = new LinkedList<>();
		
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(ALL_ADMIN);
			
			while(rs.next()) {
				Usuario user = new Administrador();
				user.setId(rs.getInt("ID_USUARIO"));
				user.setNombre(rs.getString("NOMBRE"));
				user.setApellido(rs.getString("APELLIDO"));
				user.setUser(rs.getString("NOMB_USUARIO"));
				user.setPswd(rs.getString("CONTRASENIA"));
				user.setEmail(rs.getString("EMAIL"));
				user.setCedula(rs.getInt("CEDULA"));
				user.setInstituto(rs.getString("INSTITUTO"));
				user.setList_tareas(rs.getString("LIST_TAREAS"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
		
	}

}
