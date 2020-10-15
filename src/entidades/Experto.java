package entidades;

public class Experto extends Usuario {
	
	
	private String lis_tareas;
	private int cedula;
	private String profesion;
	private Experto() {
		super();
		
	}
	private Experto(int id_usuario, String nombre, String apellido, String user, String pswd, String email) {
		super(id_usuario, nombre, apellido, user, pswd, email);
	
	}
	
	public String getLis_tareas() {
		return lis_tareas;
	}
	public void setLis_tareas(String lis_tareas) {
		this.lis_tareas = lis_tareas;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public String getProfesion() {
		return profesion;
	}
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}


