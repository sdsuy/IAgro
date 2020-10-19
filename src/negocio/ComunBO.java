package negocio;

import java.util.LinkedList;

import entidades.Comun;
import entidades.Usuario;
import persistencia.DAOComun;
import persistencia.DAOUsuario;

public class ComunBO extends UsuarioBO {

	@Override
	public boolean createUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario findUsuario(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Usuario> allUsuarios() {//para sprint 2..!
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
