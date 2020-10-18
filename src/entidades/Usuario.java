package entidades;

public abstract class Usuario {
	
	private int id;
	private String nombre;
	private String apellido;
	private String user;
	private String pswd;
	private String email;
	
	private String profesion; // usuario experto
	
	private int cedula; // usuario experto y administrador
	private String list_tareas; // usuario experto y administrador
	
	private String instituto; // usuario administrador

	public Usuario() {
		super();
	}

	public Usuario(int id, String nombre, String apellido, String user, String pswd, String email, String profesion,
			int cedula, String list_tareas, String instituto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.user = user;
		this.pswd = pswd;
		this.email = email;
		this.profesion = profesion;
		this.cedula = cedula;
		this.list_tareas = list_tareas;
		this.instituto = instituto;
	}
	
	abstract String getRol();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
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
