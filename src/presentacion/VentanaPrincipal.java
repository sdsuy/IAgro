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
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;

public class VentanaPrincipal {

	private JFrame frame;

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
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 734, 29);
		desktopPane.add(menuBar);
		
		JMenu mnAdministrador = new JMenu("Administrador");
		menuBar.add(mnAdministrador);
		
		JMenu mnAlta = new JMenu("Alta");
		mnAdministrador.add(mnAlta);
		
		JMenuItem mntmAltaAdministrador = new JMenuItem("Adminnistrador");
		mnAlta.add(mntmAltaAdministrador);
		
		JMenuItem mntmAltaExperto = new JMenuItem("Experto");
		mnAlta.add(mntmAltaExperto);
		
		JMenuItem mntmAltaComun = new JMenuItem("Comun");
		mnAlta.add(mntmAltaComun);
		
		JMenu mnBaja = new JMenu("Baja");
		mnAdministrador.add(mnBaja);
		
		JMenuItem mntmBajaAdministrador = new JMenuItem("Adminnistrador");
		mnBaja.add(mntmBajaAdministrador);
		
		JMenuItem mntmBajaExperto = new JMenuItem("Experto");
		mnBaja.add(mntmBajaExperto);
		
		JMenuItem mntmBajaComun = new JMenuItem("Comun");
		mnBaja.add(mntmBajaComun);
		
		JMenu mnModificacion = new JMenu("Modificacion");
		mnAdministrador.add(mnModificacion);
		
		JMenuItem mntmModificacionAdministrador = new JMenuItem("Adminnistrador");
		mnModificacion.add(mntmModificacionAdministrador);
		
		JMenuItem mntmModificacionExperto = new JMenuItem("Experto");
		mnModificacion.add(mntmModificacionExperto);
		
		JMenuItem mntmModificacionComun = new JMenuItem("Comun");
		mnModificacion.add(mntmModificacionComun);
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
