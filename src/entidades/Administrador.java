package entidades;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Administrador extends Usuario {
	
	private String instituto;
	private int cedula;
	private String list_tareas;

	public Administrador() {
		super();
	}

	public Administrador(int id, String nombre, String apellido, String user, String pswd, String email,
			String instituto, int cedula, String list_tareas) {
		super(id, nombre, apellido, user, pswd, email);
		this.instituto = instituto;
		this.cedula = cedula;
		this.list_tareas = list_tareas;
	}

	@Override
	public String getRol() {
		return "administrador";
	}

	@Override
	public String getInstituto() {
		return instituto;
	}

	@Override
	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}

	@Override
	public String getProfesion() {
		throw new NotImplementedException(); // no se implementa en administrador
	}

	@Override
	public void setProfesion(String profesion) {
		throw new NotImplementedException(); // no se implementa en administrador
	}

	@Override
	public int getCedula() {
		return cedula;
	}

	@Override
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	@Override
	public String getList_tareas() {
		return list_tareas;
	}

	@Override
	public void setList_tareas(String list_tareas) {
		this.list_tareas = list_tareas;
	}

}
