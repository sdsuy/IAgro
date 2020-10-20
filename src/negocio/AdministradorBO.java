package negocio;

import java.util.LinkedList;

import entidades.Usuario;
import persistencia.DAOAdministrador;

public class AdministradorBO extends UsuarioBO {
	
	private LinkedList<Usuario> admins;
	
	//Constructor que crea un linkedlist de usuario vacio
	public AdministradorBO() {
		this.admins = new LinkedList<>();
	}
	
	/**
	 * 
	 * Agrego un Usuario administrador
	 * @param Usuario
	 * @return
	 */
	@Override
	public boolean createUsuario(Usuario usuario) {
		return DAOAdministrador.createUsuario(usuario);
	}

	/**
	 * 
	 * Busco un Usuario Administrador 
	 * @param int
	 * @return Usuario
	 */
	@Override
	public Usuario findUsuario(int id) {
		return DAOAdministrador.findUsuario(id);
	}
	
	
	/**
	 * 
	 * Actualizar usuario Administrador
	 * @param Usuario
	 * @return boolean
	 */
	@Override
	public boolean updateUsuario(Usuario usuario) {
		return DAOAdministrador.updateUsuario(usuario);
	}
	
}
