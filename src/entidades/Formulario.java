package entidades;

import java.util.Date;

public class Formulario extends Usuario {
	
	private int id_formulario;
	private String met_muestreo;
	private String equipamiento;
	private String nom_formulario;
	private String resumen;
	private String departamento;
	private Date fecha;
	private String zona;
	private String tip_muestreo;
	private Long geopunto;
	private String localidad;
	private String est_muestreo;
	
	public Formulario() {
		super();
	}

	public Formulario(int id_formulario, String met_muestreo, String equipamiento, String nom_formulario,
			String resumen, String departamento, Date fecha, String zona, String tip_muestreo, Long geopunto,
			String localidad, String est_muestreo) {
		super();
		this.id_formulario = id_formulario;
		this.met_muestreo = met_muestreo;
		this.equipamiento = equipamiento;
		this.nom_formulario = nom_formulario;
		this.resumen = resumen;
		this.departamento = departamento;
		this.fecha = fecha;
		this.zona = zona;
		this.tip_muestreo = tip_muestreo;
		this.geopunto = geopunto;
		this.localidad = localidad;
		this.est_muestreo = est_muestreo;
	}

	public int getId_formulario() {
		return id_formulario;
	}

	public void setId_formulario(int id_formulario) {
		this.id_formulario = id_formulario;
	}

	public String getMet_muestreo() {
		return met_muestreo;
	}

	public void setMet_muestreo(String met_muestreo) {
		this.met_muestreo = met_muestreo;
	}

	public String getEquipamiento() {
		return equipamiento;
	}

	public void setEquipamiento(String equipamiento) {
		this.equipamiento = equipamiento;
	}

	public String getNom_formulario() {
		return nom_formulario;
	}

	public void setNom_formulario(String nom_formulario) {
		this.nom_formulario = nom_formulario;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getTip_muestreo() {
		return tip_muestreo;
	}

	public void setTip_muestreo(String tip_muestreo) {
		this.tip_muestreo = tip_muestreo;
	}

	public Long getGeopunto() {
		return geopunto;
	}

	public void setGeopunto(Long geopunto) {
		this.geopunto = geopunto;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getEst_muestreo() {
		return est_muestreo;
	}

	public void setEst_muestreo(String est_muestreo) {
		this.est_muestreo = est_muestreo;
	}

	@Override
	public String getRol() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProfesion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProfesion(String profesion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCedula() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCedula(int cedula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getList_tareas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setList_tareas(String list_tareas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInstituto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInstituto(String instituto) {
		// TODO Auto-generated method stub
		
	}
	
	

}
