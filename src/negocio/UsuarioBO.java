package negocio;

import java.util.LinkedList;

import entidades.Administrador;
import entidades.Usuario;
import persistencia.DAOAdministrador;
import persistencia.DAOUsuario;

public abstract class UsuarioBO {
	
	public abstract boolean createUsuario(Usuario usuario);
	
	public abstract Usuario findUsuario(int id);
	
	public LinkedList<Usuario> allUsuarios() {
		return DAOUsuario.allUsuarios();
	}
	
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
		Usuario usuario = new Administrador();
		usuario.setNombre("nombre");
		usuario.setApellido("apellido");
		usuario.setUser("admin");
		usuario.setPswd("1234");
		usuario.setEmail("admin@utec");
		usuario.setCedula(1234);
		usuario.setInstituto("UTec");
		usuario.setList_tareas("tareas");
		return DAOAdministrador.createUsuario(usuario);
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
