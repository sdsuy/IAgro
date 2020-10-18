package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DAOUsuario {
	
	protected static final String INSERT_USUARIO = "INSERT INTO usuarios (ID_USUARIO, NOMBRE, APELLIDO, NOMB_USUARIO, CONTRASENIA, EMAIL) VALUES (SEQ_ID_USUARIO.NEXTVAL,?,?,?,?,?)";
	protected static final String UPDATE_USUARIO = "UPDATE usuarios SET NOMBRE=?,APELLIDO=?,NOMB_USUARIO=?,CONTRASENIA=?,EMAIL=? WHERE ID_USUARIO=?";
	
	private static final String DELETE_USUARIO = "DELETE FROM usuarios WHERE id_usuario = ?";
	private static final String LOGIN = "SELECT id_usuario FROM usuarios WHERE nomb_usuario=? AND contrasenia=?";
	
	private static Connection conexion = DatabaseManager.getConexion();
	
	public static boolean deleteUsuario(int id) {
		try {
			PreparedStatement eliminarUsuario = conexion.prepareStatement(DELETE_USUARIO);
			
			conexion.setAutoCommit(false);
			
			eliminarUsuario.setInt(1, id);
			
			int retorno = eliminarUsuario.executeUpdate();
			
			return retorno > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static int login(String username, String password) {
		int id = 0;
		try {
			PreparedStatement pst = conexion.prepareStatement(LOGIN);
			pst.setString(1, username);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) id = rs.getInt("ID_USUARIO");			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

}
