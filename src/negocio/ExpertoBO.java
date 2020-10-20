package negocio;

import java.util.LinkedList;

import entidades.Usuario;
import persistencia.DAOExperto;

public class ExpertoBO extends UsuarioBO {
	
	
	private LinkedList<Usuario> experts;
	
	//linkedlist expertos
	public ExpertoBO() {
			this.experts = new LinkedList<>();
	}
	
	/**
	 * 
	 * Agrego un Experto
	 * @param Usuario
	 * @return
	 */
	
	@Override
	public boolean createUsuario(Usuario usuario) {
		return DAOExperto.createUsuario(usuario);
	}
	
	/**
	 * 
	 * Busco un Usuario
	 * @param int
	 * @return Usuario
	 */

	@Override
	public Usuario findUsuario(int id) {
		return DAOExperto.findUsuario(id);
	}
	
	/**
	 * 
	 * Actualizar un Usuaro
	 * @param Usuario
	 * @return boolean
	 */

	@Override
	public boolean updateUsuario(Usuario usuario) {
		return DAOExperto.updateUsuario(usuario);
	}
	
	

}
