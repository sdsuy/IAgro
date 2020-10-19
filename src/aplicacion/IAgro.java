package aplicacion;

import entidades.Usuario;
import negocio.AdministradorBO;
import negocio.ComunBO;
import negocio.ExpertoBO;
import negocio.UsuarioBO;
import presentacion.Login;
import presentacion.VentanaPrincipal;

public class IAgro {
	
	private Login login; // capa presentacion de login
	private VentanaPrincipal ventana; // capa presentacion de ventana principal
	private UsuarioBO usuario_; // capa de negocios de usuario
	private Usuario usuario; // usuario logueado
	int id; // id del usuario logueado

	public static void main(String[] args) {
		IAgro iagro = new IAgro();//Se crea una instancia
		iagro.start();//instancia la capa de negocio.
//		login.main(this);
	}
	
	public IAgro() {
		login = new Login(this);//Le paso la propia clase instanciada...!
	}
	
	private void start() {
		usuario_ = new AdministradorBO();
		login.start();
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

}
