package presentacion;

import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JTable;

import aplicacion.IAgro;
import entidades.Usuario;

import java.awt.BorderLayout;

public class TablaUsuarios {

	private JFrame frame;
	private JTable tableUsuarios;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TablaUsuarios window = new TablaUsuarios();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TablaUsuarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(LinkedList<Usuario> usuarios, String[] columnas) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int x = usuarios.size();
		int y = columnas.length;
		
		Object[][] datos = new Object[x][y];
		
		for(Usuario usuario: usuarios) {
			datos[usuarios.indexOf(usuario)][0] = usuario.getId();
			datos[usuarios.indexOf(usuario)][0] = usuario.getNombre();
			datos[usuarios.indexOf(usuario)][1] = usuario.getApellido();
			datos[usuarios.indexOf(usuario)][0] = usuario.getUser();
			datos[usuarios.indexOf(usuario)][0] = usuario.getPswd();
			datos[usuarios.indexOf(usuario)][0] = usuario.getEmail();
			datos[usuarios.indexOf(usuario)][0] = usuario.getInstituto();
			datos[usuarios.indexOf(usuario)][2] = usuario.getCedula();
			datos[usuarios.indexOf(usuario)][0] = usuario.getProfesion();
			datos[usuarios.indexOf(usuario)][0] = usuario.getRol();
		}
		
		tableUsuarios = new JTable(datos, columnas);
		frame.getContentPane().add(tableUsuarios, BorderLayout.CENTER);
		
		
	}

}
