package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class DAOUsuario {
	
	protected static final String INSERT_USUARIO = "INSERT INTO USUARIOS (ID_USUARIO, NOMBRE, APELLIDO, NOMB_USUARIO, CONTRASENIA, EMAIL) VALUES (SEQ_ID_USUARIO.NEXTVAL,?,?,?,?,?)";
	protected static final String UPDATE_USUARIO = "UPDATE USUARIOS SET NOMBRE=?,APELLIDO=?,NOMB_USUARIO=?,CONTRASENIA=?,EMAIL=? WHERE ID_USUARIO=?";
	
	private static final String DELETE_USUARIO = "DELETE FROM USUARIOS WHERE ID_USUARIO = ?";
	private static Connection conexion = DatabaseManager.getConexion();
	
	public static boolean deleteUser(int id) {
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

}
