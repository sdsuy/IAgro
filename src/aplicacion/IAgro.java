package aplicacion;

import java.util.LinkedList;

import entidades.Usuario;
import negocio.AdministradorBO;
import negocio.ComunBO;
import negocio.ExpertoBO;
import negocio.UsuarioBO;
import presentacion.Login;
import presentacion.Registro;
import presentacion.VentanaPrincipal;

public class IAgro {
	
	private Login login; // capa presentacion de login
	private VentanaPrincipal ventana; // capa presentacion de ventana principal
	private Registro registro; // capa presentacion de registro
	private UsuarioBO usuario_; // capa de negocios de usuario
	private Usuario usuario; // usuario logueado
	private LinkedList<Usuario> usuarios; // lista de todos los usuarios
	int id; // id del usuario logueado

	public static void main(String[] args) {
		IAgro iagro = new IAgro(); // Se crea una instancia
		iagro.start();
	}
	
	public IAgro() {
		login = new Login(this); // Inyecto esta clase a login
	}
	
	private void start() {
		usuario_ = new AdministradorBO(); // instancia la capa de negocio.
		usuarios = usuario_.allUsuarios(); // cargo la lista usuarios
		// si es el primer uso creamos un usuario administrador:
		if(usuarios.size() < 1) if(usuario_.bootstrap()) login.mensajeEditarAdminPassword();
		login.start(); // muestro la ventana de login
	}
	
	public void login(String username, String password) {
		id = usuario_.login(username, password);
	}

	public int getId() {
		return id;
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

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void menuPrincipal() {
		ventana = new VentanaPrincipal(this); // no instancio la ventana hasta que realmente se ha logueado correctamente un usuario
		ventana.start();
	}
	
	public void registro() {
		// registro = new Registro(this); // instancio la ventana de registro al hacer click en Alta en el menu Usuario
		// registro.start();
	}

	public LinkedList<Usuario> getUsuarios() {
		return usuarios;
	}

}
