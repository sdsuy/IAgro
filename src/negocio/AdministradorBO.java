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
		
		return DAOAdministrador.deleteUser(idUser);
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
	
	public void buscarAdmin(String user) {
		
		admin = DAOAdministrador.findUser(user);
		
	}
	
	/**
	 * Getter de Administrador
	 * @return
	 */
	public Administrador getPersona() {
		return admin;
		
	}
	
	/**
	 * 
	 * Creamos un usuario Administrador para arrancar con uno de fabrica
	 * @return
	 */
	public boolean bootstrap() {
		Administrador admin = DAOAdministrador.findUser("jose");
		if(admin == null) {
			Administrador user = new Administrador();
			user.setEmail("admin@utec");
			user.setPswd("admin");
			return DAOAdministrador.nuevoUsuario(user);
		}
		return false;
	}
	
}
