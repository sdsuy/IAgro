package negocio;

import java.util.LinkedList;

import entidades.Comun;
import entidades.Usuario;
import persistencia.DAOComun;
import persistencia.DAOUsuario;

public class ComunBO extends UsuarioBO {
	private LinkedList<Usuario> comunes;
	
	//constructor
	public ComunBO() {
		comunes = DAOComun.listarComunes();
	}
	
	//insertar nuevo usuario comun
	public void insertarUsuario(Comun usuario){
		DAOComun.createComun(usuario);
		System.out.println("Ingresando usuario");
	}
	
	//modificar usuario Comun
	public void modificarComun(Comun usuario){
		DAOComun.updateUser(usuario);
		System.out.println("Modificando usuario");
	}
	//eliminar usuario Comun
	public void eliminarComun(int id){
		DAOUsuario.deleteUsuario(id);
		System.out.println("Usuario compún eliminado");
	}
	
	//obtener lista usuario Comun
	public LinkedList<Usuario> listarComun(){
		return comunes;
	}
	
	//encontrar usuario por id de usuario
	public Usuario encontrarUsuario(int id){
		return DAOComun.findComun(id);
	}

	@Override
	public boolean createUsuario(Usuario usuario) {
		return DAOComun.createComun(usuario);
		
	}

	@Override
	public Usuario findUsuario(int id) {
		return DAOComun.findComun(id);
	}

	@Override
	public LinkedList<Usuario> allUsuarios() {
		return comunes;
	}

	@Override
	public boolean updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
