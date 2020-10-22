package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidades.Formulario;

public class DAOFormulario {
	private static Connection conexion = DatabaseManager.getConexion();
	
	private static final String INSERT_FORMULARIO = "INSERT INTO FORMULARIO (ID_FORMULARIO,ID_USUARIO,MET_MUESTREO,EQUIPAMIENTO,NOM_FORMULARIO,"
			+ "RESUMEN,DEPARTAMENTO,FECHA,ZONA,TIP_MUESTREO,GEOPUNTO,LOCALIDAD,EST_MUESTREO) VALUES (SEQ_ID_FORMULARIO.NEXTVAL,SEQ_ID_USUARIO.CURRVAL,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String DELETE_FORMULARIO = "DELETE FROM FORMULARIO SET ID_FORMULARIO=?";
	private static final String UPDATE_FORMULARIO = "UPDATE FORMULARIO SET MET_MUESTREO = ?,EQUIPAMIENTO = ?,NOM_FORMULARIO = ?,\"\n"
			+ "			+ \"RESUMEN = ?,DEPARTAMENTO = ?,FECHA = ?,ZONA = ?,TIP_MUESTREO = ?,GEOPUNTO = ?,LOCALIDAD = ?,EST_MUESTREO = ? WHERE ID_FORMULARIO = ?";
	private static final String ALL_FORMULARIO = "SELECT * FROM FORMULARIO";
	private static final String FIND_FORMULARIO = "SELECT * FROM FORMULARIO WHERE ID_FORMULARIO = ?";
	
	//Insertar un formulario
	public static boolean nuevoFormulario(Formulario formulario) {
		try {
			PreparedStatement insertForm = conexion.prepareStatement(INSERT_FORMULARIO);
			
			insertForm.setString(1, formulario.getMet_muestreo());
			insertForm.setString(2, formulario.getEquipamiento());
			insertForm.setString(3, formulario.getNom_formulario());
			insertForm.setString(4, formulario.getResumen());
			insertForm.setString(5, formulario.getDepartamento());
			insertForm.setDate(6, formulario.getFecha());
			insertForm.setString(7, formulario.getZona());
			insertForm.setString(8, formulario.getTip_muestreo());
			insertForm.setLong(9, formulario.getGeopunto());
			insertForm.setString(10, formulario.getLocalidad());
			insertForm.setString(11, formulario.getEst_muestreo());
			
			int filasAgregadas = insertForm.executeUpdate();
			
			return filasAgregadas>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
}
