package aplicacion;

import java.util.LinkedList;

import entidades.Usuario;
import negocio.AdministradorBO;
import negocio.ComunBO;
import negocio.ExpertoBO;
import negocio.UsuarioBO;
import presentacion.Login;
import presentacion.RegistroUsuario;
import presentacion.RegistroFormulario;
import presentacion.TablaUsuarios;
import presentacion.VentanaPrincipal;

public class IAgro {
	
	private Login login; // capa presentacion de login
	private VentanaPrincipal ventana; // capa presentacion de ventana principal
	private RegistroUsuario registro; // capa presentacion de registro
	private RegistroFormulario registroFormulario;// capa presentacion de Registro_Formulario
	private TablaUsuarios listado; // capa presentacion de listado
	private UsuarioBO usuario_; // capa de negocios de usuario logueado
	private UsuarioBO userService; // capa de negocios para gestionar los usuarios
	private Usuario usuario; // usuario logueado
	private LinkedList<Usuario> usuarios; // lista de todos los usuarios
	int id; // id del usuario logueado

	public static void main(String[] args) {
		IAgro iagro = new IAgro(); // Se crea una instancia
		iagro.start();
	}
	
	/**
	 * 
	 * Constructor de IAgro con la UI inicial de login sin mostrarla
	 */
	public IAgro() {
		login = new Login(this); // Inyecto esta clase a login
	}
	
	/**
	 * 
	 * Metodo para arrancar IAgro con la capa de negocios inicial y mostrando login
	 */
	private void start() {
		usuario_ = new AdministradorBO(); // instancia la capa de negocio.
		refreshUsuarios();
		// si es el primer uso creamos un usuario administrador:
		if(usuarios.size() < 1) if(usuario_.bootstrap()) login.mensajeEditarAdminPassword();
		login.start(); // muestro la ventana de login con al menos 1 usuario por defecto cargado en la BD
	}
	
	//***********************************************
	// Metodos para el manejo de la capa presentacion
	//***********************************************
	
	public int getId() {
		return id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void menuPrincipal() {
		ventana = new VentanaPrincipal(this); // no instancio la ventana hasta que realmente se ha logueado correctamente un usuario
		ventana.start();
	}
	
	public void registro() {
		registro = new RegistroUsuario(this); // instancio la ventana de registro al hacer click en Alta en el menu Usuario
		registro.start();
	}
	
	public void listado() {
		listado = new TablaUsuarios(this); // instancio la ventana de listado al hacer click en Listar en el menu Usuario
		listado.start();
	}
	
	public void registroFormulario() {
		registroFormulario = new RegistroFormulario(this);
		registroFormulario.start();
	}
	
	public LinkedList<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public String[] getColumnas() {
		String[] columnas = { "ID", "NOMBRE", "APELLIDO", "USUARIO", "CONTRASENIA", "E-MAIL", "CEDULA", "INSTITUTO", "PROFESION", "LISTA DE TAREAS", "ROL"};
		return columnas;
	}
	
	//**********************************************
	// Metodos para el manejo de la capa de negocios
	//**********************************************
	
	public void login(String username, String password) {
		id = usuario_.login(username, password);
	}
	
	public void findUsuario(){
		usuario = usuario_.findUsuario(id); // lo busco como administrador
		if(!(usuario.getId() > 0)) {
			usuario_ = new ExpertoBO(); // si no encuentra lo busco como experto
			usuario = usuario_.findUsuario(id);
		} else if(!(usuario.getId() > 0)) {
			usuario_ = new ComunBO(); // si no encuentra lo busco como comun
			usuario = usuario_.findUsuario(id);
		}
	}
	
	public void refreshUsuarios() {
		usuarios = usuario_.allUsuarios(); // cargo la lista usuarios
	}
	
	public boolean createUsuario(Usuario usuario) {
		if(usuario.getRol().equals("administrador")) {
			userService = new AdministradorBO();
		} else if(usuario.getRol().equals("experto")) {
			userService = new ExpertoBO();
		} else if(usuario.getRol().equals("comun")) {
			userService = new ComunBO();
		}
		return userService.createUsuario(usuario);
	}
	
	

}
