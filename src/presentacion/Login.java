package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import aplicacion.IAgro;
import javax.swing.JTextArea;

public class Login {

	private JFrame frame;
	
	private JTextField txtFieldUser;
	private JPasswordField textFieldPass;
	
	private JLabel lblCmbiarPass;
	private JTextArea txtAreaDatosDefault;
	
	private IAgro iagro;

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
	 * 
	 * Hago visible la ventana de Login
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
	public Login() {
		initialize();
	}

	/**
	 * 
	 * Constructor con la aplicacion de IAgro inyectada.
	 */
	public Login(IAgro iagro) {
		this.iagro = iagro;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("IAgro");
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		txtAreaDatosDefault = new JTextArea();
		txtAreaDatosDefault.setEditable(false);
		txtAreaDatosDefault.setVisible(false);
		
		lblCmbiarPass = new JLabel();
		lblCmbiarPass.setVisible(false);
		lblCmbiarPass.setForeground(Color.RED);
		lblCmbiarPass.setBounds(194, 300, 373, 79);
		desktopPane.add(lblCmbiarPass);
		txtAreaDatosDefault.setForeground(new Color(0, 0, 128));
		txtAreaDatosDefault.setLineWrap(true);
		txtAreaDatosDefault.setBounds(10, 11, 235, 46);
		txtAreaDatosDefault.setOpaque(false);
		desktopPane.add(txtAreaDatosDefault);
		
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
		
		JLabel lblError = new JLabel("Error. Usuario o Contrase\u00F1a incorrectos.");
		lblError.setVisible(false);
		lblError.setForeground(Color.RED);
		lblError.setBounds(270, 126, 208, 41);
		desktopPane.add(lblError);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtFieldUser.getText();
				String password = textFieldPass.getText();
				iagro.login(username, password); // seteo el id del usuario
				System.out.println(iagro.getId());
				if(iagro.getId() > 0) { // si se encuentra un id
					iagro.findUsuario(); // busco el usuario con ese id y su nivel de permisos
					if(iagro.getUsuario().getId() > 0) { // si encuentro un usuario con ese id
//						System.out.println(iagro.getUsuario().getRol());
						iagro.menuPrincipal(); // abro la Ventana Principal
						frame.dispose(); // cierro login
					}
				} else {
					// TODO:
					lblError.setVisible(true);
				}
			}
		});
		btnEntrar.setBounds(325, 356, 109, 23);
		desktopPane.add(btnEntrar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFondo.setIcon(new ImageIcon(Login.class.getResource("/IMG/login.png")));
		lblFondo.setBounds(0, 0, 734, 461);
		desktopPane.add(lblFondo);
		
		
	}
	
	public void mensajeEditarAdminPassword(){
		iagro.refreshUsuarios();
		System.out.println(iagro.getUsuarios().getFirst().getRol());
		txtAreaDatosDefault.setText("Administrador Default: " + iagro.getUsuarios().getFirst().getUser() + "\r\nContrase\u00F1a Default: " + iagro.getUsuarios().getFirst().getPswd());
		lblCmbiarPass.setVisible(true);
		lblCmbiarPass.setText("Debe cambiar la contrase\u00F1a por defecto del Administrador!");
		txtAreaDatosDefault.setVisible(true);
	}
}
