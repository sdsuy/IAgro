package entidades;

public abstract class Usuario {
	
	private int id;
	private String nombre;
	private String apellido;
	private String user;
	private String pswd;
	private String email;

	public Usuario() {
		super();
	}

	public Usuario(int id, String nombre, String apellido, String user, String pswd, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.user = user;
		this.pswd = pswd;
		this.email = email;
	}
	
	public abstract String getRol();

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

	abstract public String getProfesion();

	abstract public void setProfesion(String profesion);

	abstract public int getCedula();

	abstract public void setCedula(int cedula);

	abstract public String getList_tareas();

	abstract public void setList_tareas(String list_tareas);

	abstract public String getInstituto();

	abstract public void setInstituto(String instituto);

}
