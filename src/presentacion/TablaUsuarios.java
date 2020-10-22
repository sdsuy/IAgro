package presentacion;

import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JTable;

import aplicacion.IAgro;
import entidades.Usuario;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class TablaUsuarios {

	private JFrame frame;
	private JTable tableUsuarios;
	
	private IAgro iagro;
	
	LinkedList<Usuario> usuarios;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	

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
	 * Start the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
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
	 * Create the application with IAgro.
	 */
	public TablaUsuarios(IAgro iagro) {
		this.iagro = iagro;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
//	private void initialize(LinkedList<Usuario> usuarios, String[] columnas) {
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		usuarios = iagro.getUsuarios();
		String[] columnas = iagro.getColumnas();
		
		int x = usuarios.size();
		int y = columnas.length;
		
		Object[][] datos = new Object[x][y];
		
		for(Usuario usuario: usuarios) {
			datos[usuarios.indexOf(usuario)][0] = usuario.getId();
			datos[usuarios.indexOf(usuario)][1] = usuario.getNombre();
			datos[usuarios.indexOf(usuario)][2] = usuario.getApellido();
			datos[usuarios.indexOf(usuario)][3] = usuario.getUser();
			datos[usuarios.indexOf(usuario)][4] = usuario.getPswd();
			datos[usuarios.indexOf(usuario)][5] = usuario.getEmail();
			if(usuario.getRol().equals("administrador") || usuario.getRol().equals("experto"))
			datos[usuarios.indexOf(usuario)][6] = usuario.getCedula();
			if(usuario.getRol().equals("administrador"))
			datos[usuarios.indexOf(usuario)][7] = usuario.getInstituto();
			if(usuario.getRol().equals("experto"))
			datos[usuarios.indexOf(usuario)][8] = usuario.getProfesion();
			datos[usuarios.indexOf(usuario)][9] = usuario.getList_tareas();
			datos[usuarios.indexOf(usuario)][10] = usuario.getRol();
		}
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		tableUsuarios = new JTable(datos, columnas);
		
		JScrollPane scrollPane = new JScrollPane(tableUsuarios);
		frame.getContentPane().add(scrollPane);
		
		menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		mnNewMenu = new JMenu("Usuario");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Modificar");
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Eliminar");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		
	}

}
