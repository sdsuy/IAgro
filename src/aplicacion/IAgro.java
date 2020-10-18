package aplicacion;

import negocio.AdministradorBO;
import presentacion.Login;

public class IAgro {
	
	Login login;
	int id; // id del usuario logueado
	private AdministradorBO administrador;

	public static void main(String[] args) {
		IAgro iagro = new IAgro();
		iagro.start();
//		login.main(this);
	}
	
	public IAgro() {
		login = new Login(this);
	}
	
	private void start() {
		administrador = new AdministradorBO();
		login.start();
	}
	
	public void login(String username, String password) {
		id = administrador.login(username, password);
	}

	public int getId() {
		return id;
	}

}
