package negocio;

import java.util.LinkedList;

import entidades.Comun;
import entidades.Usuario;
import persistencia.DAOComun;

public class ComunBO extends UsuarioBO {
	private LinkedList<Comun> comunes;
	
	//constructor
	public ComunBO() {
//		comunes = DAOComun.listarUsuarios();
	}
	
	//insertar nuevo usuario comun
	public void insertarUsuario(Comun usuario){
		DAOComun.nuevoUsuario(usuario);
		System.out.println("Ingresando usuario");
	}
	
	//modificar usuario Comun
	public void modificarComun(Comun usuario){
//		DAOComun.updateUsuario(usuario);
		System.out.println("Modificando usuario");
	}
	//eliminar usuario Comun
	public void eliminarComun(Comun usuario){
//		DAOComun.borrarUsuario(usuario);
		System.out.println("Usuario compún "+usuario.getUser()+"eliminado");
	}
	
	//obtener lista usuario Comun
	public LinkedList<Comun> listarComun(){
		return comunes;
	}
	
	//encontrar usuario por nombre de usuario
	public Comun encontrarUsuario(String nombreUsuario){
//		return DAOComun.encontrarUsuario(nombreUsuario);
		return null;
	}

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
	public LinkedList<Usuario> allUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
