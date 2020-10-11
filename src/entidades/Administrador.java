package entidades;

public class Administrador extends Usuario {
	
    private int cedula;
	private String list_tareas;
	private String instituto;
	
	
	public Administrador() {
	}
	
	public Administrador(int id_usuario, String nombre, String apellido, String user, String pswd, String email, int cedula, String list_tareas, String instituto) {
		
		super(id_usuario, nombre, apellido, user, pswd, email);
		this.cedula = cedula;
		this.instituto = instituto;
		this.list_tareas = list_tareas;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getList_tareas() {
		return list_tareas;
	}

	public void setList_tareas(String list_tareas) {
		this.list_tareas = list_tareas;
	}

	public String getInstituto() {
		return instituto;
	}

	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}
	
	
	
	
	

}
