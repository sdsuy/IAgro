package negocio;

import java.util.LinkedList;

import entidades.Usuario;
import persistencia.DAOAdministrador;

public class AdministradorBO extends UsuarioBO {
	
	private LinkedList<Usuario> admins;
	
	//Constructor que crea un linkedlist de personas vacio
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
		return DAOAdministrador.createAdministrador(usuario);
	}

	/**
	 * 
	 * Busco un Usuario
	 * @param int
	 * @return Usuario
	 */
	@Override
	public Usuario findUsuario(int id) {
		return DAOAdministrador.findAdministrador(id);
	}
	
	
	/**
	 * 
	 * Actualizar usuarop
	 * @param Usuario
	 * @return boolean
	 */
	@Override
	public boolean updateUsuario(Usuario usuario) {
		
		return DAOAdministrador.updateAdministrador(usuario);
	
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
