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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmIagro;
	
	private AdministradorBO administrador = new AdministradorBO();
	private JTextField txtFieldUser;
	private JTextField textFieldPass;

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
//		if(administrador.bootstrap())
	// emitir algun mensaje que se debe cambiar la contraseña del administrador creado de fabrica
//			; // cierro el if luego de emitir el mensaje en caso que sea el primer uso
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
		
		txtFieldUser = new JTextField();
		txtFieldUser.setBounds(316, 225, 151, 34);
		desktopPane.add(txtFieldUser);
		txtFieldUser.setColumns(10);
		
		textFieldPass = new JTextField();
		textFieldPass.setColumns(10);
		textFieldPass.setBounds(316, 286, 144, 34);
		desktopPane.add(textFieldPass);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBounds(355, 195, 1, 1);
		desktopPane.add(desktopPane_1);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtFieldUser.getText();
				String password = textFieldPass.getText();
				administrador.login(username, password);
				System.out.println(administrador.getId());
			}
		});
		btnEntrar.setBounds(324, 342, 109, 23);
		desktopPane.add(btnEntrar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFondo.setIcon(new ImageIcon(Login.class.getResource("/IMG/login.png")));
		lblFondo.setBounds(0, 0, 734, 461);
		desktopPane.add(lblFondo);
	}
}
