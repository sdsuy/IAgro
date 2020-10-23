package entidades;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Comun extends Usuario {

	private String list_tareas;

	public Comun() {
		super();
	}
	
	

	@Override
	public String getRol() {
		return "comun";
	}
	
	@Override
	public String getInstituto() {
		throw new NotImplementedException(); // no se implementa en comun
	}

	@Override
	public void setInstituto(String instituto) {
		throw new NotImplementedException(); // no se implementa en comun
	}
	
	@Override
	public String getProfesion() {
		throw new NotImplementedException(); // no se implementa en comun
	}

	@Override
	public void setProfesion(String profesion) {
		throw new NotImplementedException(); // no se implementa en comun
		
	}

	@Override
	public int getCedula() {
		throw new NotImplementedException(); // no se implementa en comun
	}

	@Override
	public void setCedula(int cedula) {
		throw new NotImplementedException(); // no se implementa en comun
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
