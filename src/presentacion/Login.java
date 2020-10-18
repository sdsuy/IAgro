package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import aplicacion.IAgro;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frmIagro;
	
	private JTextField txtFieldUser;
	private JTextField textFieldPass;
	
	private IAgro iagro;
	private JPasswordField passwordField;

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
	 * 
	 * Hago visible la ventana de Login
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmIagro.setVisible(true);
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
		initialize();
	}

	/**
	 * 
	 * Constructor con la aplicacion de IAgro integrada.
	 */
	public Login(IAgro iagro) {
		this.iagro = iagro;
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
		frmIagro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frmIagro.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		txtFieldUser = new JTextField();
		txtFieldUser.setBounds(316, 225, 151, 34);
		desktopPane.add(txtFieldUser);
		txtFieldUser.setColumns(10);
		
		textFieldPass = new JPasswordField();
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
				iagro.login(username, password); // seteo el id del usuario
				System.out.println(iagro.getId());
				if(iagro.getId() > 0) { // si se encuentra un id
					iagro.findUsuario(); // busco el usuario con ese id y su nivel de permisos
					if(iagro.getUsuario().getId() >= 0) { // si encuentro un usuario con ese id
//						System.out.println(iagro.getUsuario().getRol());
						iagro.menuPrincipal(); // abro la Ventana Principal
						frmIagro.dispose(); // cierro login
					}
				} else {
					// TODO:
					// mostrar un dialogo que los datos ingresados no fueron correctos
				}
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
