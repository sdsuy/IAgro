package entidades;

public class Comun extends Usuario {
	
	private String list_tarea;

	public Comun() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comun(int id_usuario, String nombre, String apellido, String user, String pswd, String email) {
		super(id_usuario, nombre, apellido, user, pswd, email);
		
	}

	public String getList_tarea() {
		return list_tarea;
	}

	public void setList_tarea(String list_tarea) {
		this.list_tarea = list_tarea;
	}	

}
