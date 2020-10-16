package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.Administrador;

public class DAOAdministrador extends DAOUsuario {
	
private static Connection conexion = DatabaseManager.getConexion();
	
	private static final String INSERT_ADMIN = "INSERT INTO ADMINISTRADORES (ID_USUARIO,CEDULA,INSTITUTO,LIST_TAREAS) VALUES (SEQ_ID_USUARIO.NEXTVAL,?,?,?)";
	private static final String UPDATE_ADMIN = "UPDATE ADMINISTRADOR SET NOMBRE=?,APELLIDO=?,NOMB_USUARIO=?,CONTRASENIA=?,EMAIL=?,CEDULA=?,INSTITUTO,LIST_TAREAS WHERE ID_USUARIO=?";
	private static final String ALL_ADMIN = "SELECT * FROM ADMINISTRADOR";
	private static final String FIND_ADMIN = "SELECT * FROM ADMINISTRADOR WHERE NOMB_USUARIO=?";
	
	public static boolean nuevoUsuario(Administrador user) {
		try {
			PreparedStatement insertarUsuario = conexion.prepareStatement(INSERT_USUARIO);
			PreparedStatement insertarAdmin = conexion.prepareStatement(INSERT_ADMIN);
			
			// Usamos una transaccion con auto commit deshabilitado
			// ya que son 2 consultas y ambas deben hacerse al mismo tiempo
			conexion.setAutoCommit(false);
			
			// Primero inserto un Usuario
			insertarUsuario.setString(1, user.getNombre());
			insertarUsuario.setString(2, user.getApellido());
			insertarUsuario.setString(3, user.getUser());
			insertarUsuario.setString(4, user.getPswd());
			insertarUsuario.setString(5, user.getEmail());
			int filasAgregadas1 = insertarUsuario.executeUpdate();
			
			// Despues inserto el Administrador relacionado a ese usuario
			insertarAdmin.setInt(1, user.getCedula());
			insertarAdmin.setString(2, user.getInstituto());
			insertarAdmin.setString(3, user.getList_tareas());
			int filasAgregadas2 = insertarAdmin.executeUpdate();
			
			// Hacemos el commit con ambas consultas de una vez sola
			conexion.commit();
			
			return filasAgregadas1 > 0 && filasAgregadas2 > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	public static boolean updateUser(Administrador user) {
		try {
			PreparedStatement modificarUser = conexion.prepareStatement(UPDATE_USUARIO);
			PreparedStatement modificarAdmin = conexion.prepareStatement(UPDATE_ADMIN);
			
			conexion.setAutoCommit(false);
			
			modificarUser.setString(1, user.getNombre());
			modificarUser.setString(2, user.getApellido());
			modificarUser.setString(3, user.getUser());
			modificarUser.setString(4, user.getPswd());
			modificarUser.setString(5, user.getEmail());
			int filasAgregadas1 = modificarUser.executeUpdate();
			
			modificarAdmin.setInt(6, user.getCedula());
			modificarAdmin.setString(7, user.getInstituto());
			modificarAdmin.setString(8, user.getList_tareas());
			int filasAgregadas2 = modificarAdmin.executeUpdate();
			
			conexion.commit();
			
			return filasAgregadas1 > 0 && filasAgregadas2 > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	public static Administrador findUser(int documento) {
		Administrador usuario = new Administrador();
		try {
			PreparedStatement pst = conexion.prepareStatement(FIND_ADMIN);
			
			pst.setInt(1, documento);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				usuario.setId_usuario(rs.getInt("ID_USUARIO"));
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
	
	public static LinkedList<Administrador> selectUser(){
		LinkedList<Administrador> users = new LinkedList<>();
		
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(ALL_ADMIN);
			
			while(rs.next()) {
				Administrador user = new Administrador();
				user.setId_usuario(rs.getInt("ID_USUARIO"));
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
