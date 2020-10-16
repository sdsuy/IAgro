package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;

import negocio.AdministradorBO;

public class Login {

	private JFrame frame;
	
	private AdministradorBO administrador = new AdministradorBO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		if(administrador.bootstrap())
	// emitir algun mensaje que se debe cambiar la contraseña del administrador creado de fabrica
			; // cierro el if luego de emitir el mensaje en caso que sea el primer uso
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
