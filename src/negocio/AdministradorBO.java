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
	 * Agrego un administrador
	 * @param Usuario
	 * @return
	 */
	@Override
	public boolean createUsuario(Usuario usuario) {
		return DAOAdministrador.createUsuario(usuario);
	}

	/**
	 * 
	 * Busco un Usuario
	 * @param int
	 * @return Usuario
	 */
	@Override
	public Usuario findUsuario(int id) {
		return DAOAdministrador.findUsuario(id);
	}
	
	
	/**
	 * 
	 * Actualizar usuarop
	 * @param Usuario
	 * @return boolean
	 */
	@Override
	public boolean updateUsuario(Usuario usuario) {
		
		return DAOAdministrador.updateUsuario(usuario);
	
	}
	
	/**
	 * 
	 * Getter del linkedlist Admins
	 * @return
	 */
	@Override
	public LinkedList<Usuario> allUsuarios() {
		
		return admins;
	}
	
}
