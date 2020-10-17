package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;

import negocio.AdministradorBO;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import java.awt.Font;

public class Login {

	private JFrame frmIagro;
	
	private AdministradorBO administrador = new AdministradorBO();
	private JTextField txtFieldUser;
	private JTextField textPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmIagro.setVisible(true);
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
		frmIagro = new JFrame();
		frmIagro.setTitle("IAgro");
		frmIagro.setBounds(100, 100, 750, 500);
		frmIagro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frmIagro.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFondo.setIcon(new ImageIcon(Login.class.getResource("/IMG/login.png")));
		lblFondo.setBounds(0, 0, 734, 461);
		desktopPane.add(lblFondo);
		
		txtFieldUser = new JTextField();
		txtFieldUser.setBounds(324, 225, 143, 34);
		desktopPane.add(txtFieldUser);
		txtFieldUser.setColumns(10);
		
		textPass = new JTextField();
		textPass.setColumns(10);
		textPass.setBounds(324, 288, 143, 34);
		desktopPane.add(textPass);
	}
}
