package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.Experto;
import entidades.Usuario;

public class DAOExperto extends DAOUsuario {
	
	private static Connection conexion = DatabaseManager.getConexion();
	
	private static final String INSERT_EXPERT = "INSERT INTO EXPERTOS (ID_USUARIO, CEDULA, PROFESION, LIST_TAREAS) VALUES (SEQ_ID_USUARIO.CURRVAL,?,?,?)";
	private static final String UPDATE_EXPERT = "UPDATE EXPERTOS SET LIST_TAREAS=?, CEDULA=?, PROFESION=? WHERE ID_USUARIO=?";
	private static final String ALL_EXPERTS = "SELECT * FROM EXPERTOS"; //+join
	private static final String FIND_EXPERT = "SELECT\r\n" + 
			"    usuarios.*,\r\n" + 
			"    expertos.*\r\n" + 
			"FROM\r\n" + 
			"    expertos\r\n" + 
			"    INNER JOIN usuarios ON usuarios.id_usuario = expertos.id_usuario\r\n" + 
			"WHERE\r\n" + 
			"    expertos.id_usuario = ?";
	
	
	
	public static boolean createUsuario(Usuario user) {
		try {
			PreparedStatement insertarUsuario = conexion.prepareStatement(INSERT_USUARIO);
			PreparedStatement insertarExperto = conexion.prepareStatement(INSERT_EXPERT);
			
			
			conexion.setAutoCommit(false);
			
			
			insertarUsuario.setString(1, user.getNombre());
			insertarUsuario.setString(2, user.getApellido());
			insertarUsuario.setString(3, user.getUser());
			insertarUsuario.setString(4, user.getPswd());
			insertarUsuario.setString(5, user.getEmail());
			int filasAgregadas1 = insertarUsuario.executeUpdate();
			
			insertarExperto.setInt(1, user.getCedula());
			insertarExperto.setString(2, user.getProfesion());
			insertarExperto.setString(3, user.getList_tareas());
			
			int filasAgregadas2 = insertarExperto.executeUpdate();
			
			
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
			PreparedStatement modificarExperto = conexion.prepareStatement(UPDATE_EXPERT);
			
			conexion.setAutoCommit(false);
			
			
			modificarUser.setString(1, user.getNombre());
			modificarUser.setString(2, user.getApellido());
			modificarUser.setString(3, user.getUser());
			modificarUser.setString(4, user.getPswd());
			modificarUser.setString(5, user.getEmail());
			modificarUser.setInt(6, user.getId());
			int filasAgregadas1 = modificarUser.executeUpdate();
			
			
			modificarExperto.setString(1, user.getList_tareas());
			modificarExperto.setInt(2, user.getCedula());
			modificarExperto.setString(3, user.getProfesion());
			modificarUser.setInt(4, user.getId());
			int filasAgregadas2 = modificarExperto.executeUpdate();
			
			
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
			PreparedStatement pst = conexion.prepareStatement(FIND_EXPERT);
			
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
				usuario.setCedula(rs.getInt("CEDULA"));
				usuario.setProfesion(rs.getString("PROFESION"));
				
			}
			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static LinkedList<Experto> listarUsuarios(){
		LinkedList<Experto> users = new LinkedList<>();
		
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(ALL_EXPERTS);
			
			while(rs.next()) {
				Experto user = new Experto();
				user.setId(rs.getInt("ID_USUARIO"));
				user.setNombre(rs.getString("NOMBRE"));
				user.setApellido(rs.getString("APELLIDO"));
				user.setUser(rs.getString("NOMB_USUARIO"));
				user.setPswd(rs.getString("CONTRASENIA"));
				user.setEmail(rs.getString("EMAIL"));
				user.setList_tareas(rs.getString("LIST_TAREAS"));
				user.setCedula(rs.getInt("CEDULA"));
				user.setProfesion(rs.getString("INSTITUTO"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
		
	}
	
	
	
	

}
