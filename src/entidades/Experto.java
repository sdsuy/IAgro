package entidades;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Experto extends Usuario {
	
	private String profesion;
	private int cedula;
	private String list_tareas;

	public Experto() {
		super();
	}

	public Experto(int id, String nombre, String apellido, String user, String pswd, String email, String profesion,
			int cedula, String list_tareas) {
		super(id, nombre, apellido, user, pswd, email);
		this.profesion = profesion;
		this.cedula = cedula;
		this.list_tareas = list_tareas;
	}

	@Override
	public String getRol() {
		return "experto";
	}

	@Override
	public String getInstituto() {
		throw new NotImplementedException(); // no se implementa en experto
	}

	@Override
	public void setInstituto(String instituto) {
		throw new NotImplementedException(); // no se implementa en experto
	}

	@Override
	public String getProfesion() {
		return profesion;
	}

	@Override
	public void setProfesion(String profesion) {
		this.profesion = profesion;
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
