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
		return DAOExperto.createExperto(usuario);
	}
	
	/**
	 * 
	 * Busco un Usuario
	 * @param int
	 * @return Usuario
	 */

	@Override
	public Usuario findUsuario(int id) {
		return DAOExperto.findExperto(id);
	}
	
	/**
	 * 
	 * Actualizar un Usuaro
	 * @param Usuario
	 * @return boolean
	 */

	@Override
	public LinkedList<Usuario> allUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return DAOExperto.updateExperto(usuario);
	}

}
