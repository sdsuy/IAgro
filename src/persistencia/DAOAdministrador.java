package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.Administrador;

public class DAOAdministrador {
	
private static Connection conexion = DatabaseManager.getConexion();
	
	private static final String INSERT_ADMIN = "INSERT INTO ADMINISTRADOR (ID_USUARIO,NOMBRE,APELLIDO,NOMB_USUARIO,CONTRASENIA,EMAIL,CEDULA,INSTITUTO,LIST_TAREAS) VALUES (SEQ_ID_USUARIO.NEXTVAL,?,?,?,?,?,?,?,?)";
	private static final String DELETE_ADMIN = "DELETE FROM ADMINISTRADOR WHERE ID_USUARIO = ?";
	private static final String UPDATE_ADMIN = "UPDATE ADMINISTRADOR SET NOMBRE=?,APELLIDO=?,NOMB_USUARIO=?,CONTRASENIA=?,EMAIL=?,CEDULA=?,INSTITUTO,LIST_TAREAS WHERE ID_USUARIO=?";
	private static final String ALL_ADMIN = "SELECT * FROM ADMINISTRADOR";
	private static final String FIND_ADMIN = "SELECT * FROM ADMINISTRADOR WHERE NOMB_USUARIO=?";
	
	public static boolean nuevoUsuario(Administrador user) {
		try {
			PreparedStatement pst = conexion.prepareStatement(INSERT_ADMIN);
			
			pst.setString(1, user.getNombre());
			pst.setString(2, user.getApellido());
			pst.setString(3, user.getUser());
			pst.setString(4, user.getPswd());
			pst.setString(5, user.getEmail());
			pst.setInt(6, user.getCedula());
			pst.setString(7, user.getInstituto());
			pst.setString(8, user.getList_tareas());
			
			int filasAgregadas = pst.executeUpdate();
			return filasAgregadas > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	public static boolean deleteUser(int id) {
		try {
			PreparedStatement pst = conexion.prepareStatement(DELETE_ADMIN);
			
			pst.setInt(1, id);
			int retorno = pst.executeUpdate();
			
			return retorno > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static boolean updateUser(Administrador user) {
		try {
			PreparedStatement pst = conexion.prepareStatement(UPDATE_ADMIN);
			
			pst.setString(1, user.getNombre());
			pst.setString(2, user.getApellido());
			pst.setString(3, user.getUser());
			pst.setString(4, user.getPswd());
			pst.setString(5, user.getEmail());
			pst.setInt(6, user.getCedula());
			pst.setString(7, user.getInstituto());
			pst.setString(8, user.getList_tareas());
			
			
			int filasAgregadas = pst.executeUpdate();
			return filasAgregadas > 0;
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
