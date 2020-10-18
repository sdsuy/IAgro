package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidades.Administrador;
import entidades.Experto;

public class DAOExperto extends DAOUsuario {
	
	private static Connection conexion = DatabaseManager.getConexion();
	
	private static final String INSERT_EXPERT = "INSERT INTO EXPERTOS (ID_USUARIO, LIST_TAREAS, CEDULA, PROFESION) VALUES (SEQ_ID_USUARIO.NEXTVAL,?,?,?)";
	private static final String UPDATE_EXPERT = "UPDATE EXPERTOS SET LIST_TAREAS=?, CEDULA=?, PROFESION=? WHERE ID_USUARIO=?";
	private static final String ALL_EXPERTS = "SELECT * FROM EXPERTOS";
	private static final String FIND_EXPERT = "SELECT * FROM EXPERTOS WHERE NOMB_USUARIO=?";
	
	
	
	public static boolean nuevoUsuario(Experto user) {
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
			
			
			insertarExperto.setString(1, user.getLis_tareas());
			insertarExperto.setInt(2, user.getCedula());
			insertarExperto.setString(3, user.getProfesion());
			
			int filasAgregadas2 = insertarExperto.executeUpdate();
			
			
			conexion.commit();
			
			return filasAgregadas1 > 0 && filasAgregadas2 > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}
	

}
