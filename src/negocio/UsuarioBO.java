package negocio;

import java.util.LinkedList;

import entidades.Administrador;
import entidades.Usuario;
import persistencia.DAOAdministrador;
import persistencia.DAOUsuario;

public abstract class UsuarioBO {
	
	public abstract boolean createUsuario(Usuario usuario);
	
	public abstract Usuario findUsuario(int id);
	
	public abstract LinkedList<Usuario> allUsuarios();
	
	public abstract boolean updateUsuario(Usuario usuario);
	
	public boolean deleteUsuario(int id) {
		return DAOUsuario.deleteUsuario(id);
	}
	

	
	/**
	 * 
	 * Creamos un usuario Administrador para arrancar con uno de fabrica
	 * @return boolean
	 */
	public boolean bootstrap() {
		Usuario admin = DAOAdministrador.findUsuario(0);
		if(admin == null) {
			Administrador user = new Administrador();
			user.setEmail("admin@utec");
			user.setPswd("admin");
			return DAOAdministrador.createUsuario(user);
		}
		return false;
	}
	
	/**
	 * 
	 * Login de Usuario
	 * @param username
	 * @param password
	 * @return
	 */
	public int login(String username, String password) {
		return DAOUsuario.login(username, password);
	}

}
