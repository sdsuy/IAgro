package entidades;

public abstract class Usuario {
	
	public static final String INSERT_USUARIO = "INSERT INTO USUARIOS (ID_USUARIO, NOMBRE, APELLIDO, NOMB_USUARIO, CONTRASENIA, EMAIL) VALUES (SEQ_ID_USUARIO.NEXTVAL,?,?,?,?,?)";
	public static final String DELETE_USUARIO = "DELETE FROM USUARIOS WHERE ID_USUARIO = ?";
	public static final String UPDATE_USUARIO = "UPDATE USUARIOS SET NOMBRE=?,APELLIDO=?,NOMB_USUARIO=?,CONTRASENIA=?,EMAIL=? WHERE ID_USUARIO=?";
	
	private int id_usuario;
	private String nombre;
	private String apellido;
	private String user;
	private String pswd;
	private String email;
	
	public Usuario() {
		super();
		
	}
	public Usuario(int id_usuario, String nombre, String apellido, String user, String pswd, String email) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.user = user;
		this.pswd = pswd;
		this.email = email;
	}

	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
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
	
	
	

}
