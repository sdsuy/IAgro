package persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Comun;
import entidades.Experto;

public class DAOExperto {
	
	private static Connection conexion = DatabaseManager.getConexion();
	
	public static boolean nuevoUsuario(Experto usuario) {
		String consulta = "INSERT INTO EXPERTOS (ID_USUARIO, LIST_TAREAS, CEDULA, PROFESION, NOMBRE, APELLIDO, NOMB_USUARIO, CONTRASENIA, EMAIL) "
				+ "VALUES (SEQ_ID_USUARIO.NEXT_VAL,?,?,?,?,?,?,?,?)";
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
	
	

}
