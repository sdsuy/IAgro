package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entidades.Formulario;
import entidades.Usuario;

public class DAOFormulario {
	private static Connection conexion = DatabaseManager.getConexion();
	
	private static final String INSERT_FORMULARIO = "INSERT INTO FORMULARIO (ID_FORMULARIO,ID_USUARIO,MET_MUESTREO,EQUIPAMIENTO,NOM_FORMULARIO,"
			+ "RESUMEN,DEPARTAMENTO,FECHA,ZONA,TIP_MUESTREO,GEOPUNTO,LOCALIDAD,EST_MUESTREO) VALUES (SEQ_ID_FORMULARIO.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String DELETE_FORMULARIO = "DELETE FROM FORMULARIO SET ID_FORMULARIO=?";
	private static final String UPDATE_FORMULARIO = "UPDATE FORMULARIO SET MET_MUESTREO = ?,EQUIPAMIENTO = ?,NOM_FORMULARIO = ?,\"\n"
			+ "			+ \"RESUMEN = ?,DEPARTAMENTO = ?,FECHA = ?,ZONA = ?,TIP_MUESTREO = ?,GEOPUNTO = ?,LOCALIDAD = ?,EST_MUESTREO = ? WHERE ID_FORMULARIO = ?";
	private static final String ALL_FORMULARIO = "SELECT * FROM FORMULARIO";
	private static final String FIND_FORMULARIO = "SELECT * FROM FORMULARIO WHERE ID_FORMULARIO = ?";
	
	//Insertar un formulario
	public static boolean nuevoFormulario(Formulario formulario) {
		
		try {
			PreparedStatement insertForm = conexion.prepareStatement(INSERT_FORMULARIO);
			
			insertForm.setInt(1, formulario.getUser().getId());
			insertForm.setString(2, formulario.getMet_muestreo());
			insertForm.setString(3, formulario.getEquipamiento());
			insertForm.setString(4, formulario.getNom_formulario());
			insertForm.setString(5, formulario.getResumen());
			insertForm.setString(6, formulario.getDepartamento());
			insertForm.setDate(7, formulario.getFecha());
			insertForm.setString(8, formulario.getZona());
			insertForm.setString(9, formulario.getTip_muestreo());
			insertForm.setLong(10, formulario.getGeopunto());
			insertForm.setString(11, formulario.getLocalidad());
			insertForm.setString(12, formulario.getEst_muestreo());
			
			
			int filasAgregadas = insertForm.executeUpdate();
			
			return filasAgregadas>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static boolean deleteFormulario(int id) {
		
		try {
			PreparedStatement elimForm = conexion.prepareStatement(DELETE_FORMULARIO);
			elimForm.setInt(1, id);
			
			int retorno = elimForm.executeUpdate();
			
			return retorno > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static boolean updateForm(Formulario formulario) {
		
		try {
			PreparedStatement update = conexion.prepareStatement(UPDATE_FORMULARIO);
			
			
			update.setString(1, formulario.getMet_muestreo());
			update.setString(2, formulario.getEquipamiento());
			update.setString(3, formulario.getNom_formulario());
			update.setString(4, formulario.getResumen());
			update.setString(5, formulario.getDepartamento());
			update.setDate(6, formulario.getFecha());
			update.setString(7, formulario.getZona());
			update.setString(8, formulario.getTip_muestreo());
			update.setLong(9, formulario.getGeopunto());
			update.setString(10, formulario.getLocalidad());
			update.setString(11, formulario.getEst_muestreo());
			
			
			int filasAgregadas = update.executeUpdate();
			
			return filasAgregadas>0;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static Formulario findForm(int id) {
		Formulario form = new Formulario();
		Usuario user = null;
		try {
			PreparedStatement find = conexion.prepareStatement(FIND_FORMULARIO);
			
			find.setInt(1, id);
			
			ResultSet rs = find.executeQuery();
			if(rs.next()) {
				form.setId_formulario(rs.getInt("ID_FORMULARIO"));
				form.setMet_muestreo(rs.getString("MET_MUESTREO"));
				form.setEquipamiento(rs.getString("EQUIPAMIENTO"));
				form.setResumen(rs.getString("RESUMEN"));
				form.setDepartamento(rs.getString("DEPARTAMENTO"));
				form.setFecha(rs.getDate("FECHA"));
				form.setZona(rs.getString("ZONA"));
				form.setTip_muestreo(rs.getString("TIP_MUESTREO"));
				form.setGeopunto(rs.getLong("GEOPUNTO"));
				form.setLocalidad(rs.getString("LOCALIDAD"));
				form.setEst_muestreo(rs.getString("EST_MUESTREO"));	
				//user.setId(rs.getInt("ID_USUARIO"));
				//form.setUser(user);
				
			}
			
			return form ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static LinkedList<Formulario> allFormularios(){
		LinkedList<Formulario> formularios = new LinkedList<>();
		
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(ALL_FORMULARIO);
			
			while(rs.next()) {
				Usuario user = null;
				Formulario form = new Formulario();
				
				form.setId_formulario(rs.getInt("ID_FORMULARIO"));
				form.setMet_muestreo(rs.getString("MET_MUESTREO"));
				form.setEquipamiento(rs.getString("EQUIPAMIENTO"));
				form.setResumen(rs.getString("RESUMEN"));
				form.setDepartamento(rs.getString("DEPARTAMENTO"));
				form.setFecha(rs.getDate("FECHA"));
				form.setZona(rs.getString("ZONA"));
				form.setTip_muestreo(rs.getString("TIP_MUESTREO"));
				form.setGeopunto(rs.getLong("GEOPUNTO"));
				form.setLocalidad(rs.getString("LOCALIDAD"));
				form.setEst_muestreo(rs.getString("EST_MUESTREO"));	
				user.setId(rs.getInt("ID_USUARIO"));
				form.setUser(user);
				formularios.add(form);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
