package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

import aplicacion.IAgro;

import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {

	private JFrame frame;
	
	private IAgro iagro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Launch the application.
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
	public VentanaPrincipal() {
		initialize();
	}
	
	/**
	 * Create the application con IAgro integrado.
	 */
	public VentanaPrincipal(IAgro iagro) {
		this.iagro = iagro; // inyecto la aplicacion IAgro en la ventana
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println(iagro.getUsuario().getRol());
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 734, 29);
		desktopPane.add(menuBar);
		
		JMenu mnAdministrador = new JMenu("Usuarios");
		menuBar.add(mnAdministrador);
		
		mnAdministrador.setVisible(false);
		
		JMenu mnFormulario = new JMenu("Formularios");
		menuBar.add(mnFormulario);
		
		mnFormulario.setVisible(false);
		
		// Si el usuario logueado tiene como rol administrador muestro el menu Usuarios
		if(iagro.getUsuario().getRol().equals("administrador")) mnAdministrador.setVisible(true); mnFormulario.setVisible(true);
		if(iagro.getUsuario().getRol().equals("Experto")|| iagro.getUsuario().getRol().equals("Comun")) mnFormulario.setVisible(true);
		JMenuItem mntmAlta = new JMenuItem("Alta");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iagro.registro();
			}
		});
		mnAdministrador.add(mntmAlta);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iagro.listado();
			}
		});
		mnAdministrador.add(mntmListar);
		
		JMenuItem mnCrear = new JMenuItem("Crear");
		mnCrear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				iagro.registroFormulario();
			}
		});
		mnFormulario.add(mnCrear);
	
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
