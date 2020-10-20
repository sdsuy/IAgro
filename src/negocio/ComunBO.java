package negocio;

import java.util.LinkedList;

import entidades.Comun;
import entidades.Usuario;
import persistencia.DAOComun;
import persistencia.DAOUsuario;

public class ComunBO extends UsuarioBO {
	
	private LinkedList<Usuario> comuns;
	
	//Constructor que crea un linkedlist de comun vacio
	public ComunBO() {
		this.comuns = new LinkedList<>();
	}
	
	/**
	 * 
	 * Agrego un Usuario comun
	 * @param Usuario
	 * @return
	 */

	@Override
	public boolean createUsuario(Usuario usuario) {
		
		return DAOComun.createUsuario(usuario);
	}
	
	/**
	 * 
	 * Busco un Usuario Comun
	 * @param int
	 * @return Usuario
	 */

	@Override
	public Usuario findUsuario(int id) {
		
		return DAOComun.findUsuario(id);
	}

	/**
	 * 
	 * Actualizar usuario comun
	 * @param usuario
	 * @return boolean
	 */

	@Override
	public boolean updateUsuario(Usuario usuario) {
		
		return DAOComun.updateUsuario(usuario);
	}
	
}
