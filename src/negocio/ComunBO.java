package negocio;

import java.util.LinkedList;

import entidades.Comun;
import persistencia.DAOComun;

public class ComunBO {
	private LinkedList<Comun> comunes;
	//constructor
	public ComunBO(){
		comunes = DAOComun.listarUsuarios();	
	}
	
	//insertar nuevo usuario comun
	public void insertarUsuario(Comun usuario){
		DAOComun.nuevoUsuario(usuario);
		System.out.println("Usuario ingresado");
	}
	
	//modificar usuario Comun
	public void modificarComun(){
		//
	}
	//eliminar usuario Comun
	public void eliminarComun(Comun usuario){
		DAOComun.borrarUsuario(usuario);
		System.out.println("Usuario compún "+usuario.getUser()+"eliminado");
	}
	
	//obtener lista usuario Comun
	public LinkedList<Comun> listarComun(){
		return DAOComun.listarUsuarios();
	}
	
	//encontrar usuario por nombre de usuario
	public Comun encontrarUsuario(String nombreUsuario){
		return DAOComun.encontrarUsuario(nombreUsuario);
	}
	
}
