package negocio;

import java.util.LinkedList;

import entidades.Administrador;
import persistencia.DAOAdministrador;

public class AdministradorBO {
	
	private LinkedList<Administrador> admins;
	private Administrador admin;
	
	//Constructor que crea un linkedlist de personas vacio
	public AdministradorBO() {
		this.admins = new LinkedList<>();
	}
	
	/**
	 * 
	 * Agrego un administrador
	 * @param admin
	 * @return
	 */
	public boolean agregarAdmin(Administrador adm) {
		
		return DAOAdministrador.nuevoUsuario(adm);
		
	}
	
	//Cargo los Administradores
	public void obtenerAdmins() {
		
		admins = DAOAdministrador.selectUser();
	}
	
	/**
	 * 
	 * Actualizo un administrador
	 * @param adm
	 * @return
	 */
	public boolean actualizarAdmin(Administrador adm) {
		
		return DAOAdministrador.updateUser(adm);
	
	}
	
	/**
	 * 
	 * Elimino un Administrador
	 * @param idAdmin
	 * @return
	 */
	public boolean eliminarAdmin(int idUser) {
		
		return DAOAdministrador.deleteAdmin(idUser);
	}
	
	/**
	 * 
	 * Getter del linkedlist Admins
	 * @return
	 */
	public LinkedList<Administrador> getPersonas() {
		
		return admins;
	}
	
	/**
	 * Busco un administrador
	 * @param cedula
	 */
	
	public void buscarAdmin(int cedula) {
		
		admin = DAOAdministrador.findUser(cedula);
		
	}
	
	/**
	 * Getter de Administrador
	 * @return
	 */
	public Administrador getPersona() {
		return admin;
		
	}
	
}
