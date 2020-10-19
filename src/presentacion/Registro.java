package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Registro {

	private JFrame frame;
	private JTextField textFieldDocumento;
	private JTextField textFieldMail;
	private JTextField textFieldNombre1;
	private JTextField textFieldNombre2;
	private JTextField textFieldApellido1;
	private JTextField textFieldApellido2;
	private JPasswordField ConfirmaPassword;
	private JPasswordField Password;
	private JTextField textFieldInstituto;
	private JTextField textFieldProfesion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro window = new Registro();
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
	public Registro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDocumento = new JLabel("Cedula");
		lblDocumento.setBounds(6, 24, 88, 16);
		frame.getContentPane().add(lblDocumento);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(148, 52, 117, 29);
		frame.getContentPane().add(btnBuscar);
		
		textFieldDocumento = new JTextField();
		textFieldDocumento.setBounds(6, 52, 130, 26);
		frame.getContentPane().add(textFieldDocumento);
		textFieldDocumento.setColumns(10);
		
		textFieldMail = new JTextField();
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(292, 52, 273, 26);
		frame.getContentPane().add(textFieldMail);
		
		JLabel lblEmail = new JLabel("Mail");
		lblEmail.setBounds(292, 24, 88, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(6, 91, 88, 16);
		frame.getContentPane().add(lblNombres);
		
		textFieldNombre1 = new JTextField();
		textFieldNombre1.setColumns(10);
		textFieldNombre1.setBounds(6, 114, 130, 26);
		frame.getContentPane().add(textFieldNombre1);
		
		textFieldNombre2 = new JTextField();
		textFieldNombre2.setColumns(10);
		textFieldNombre2.setBounds(150, 114, 130, 26);
		frame.getContentPane().add(textFieldNombre2);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(292, 91, 88, 16);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(6, 153, 88, 16);
		frame.getContentPane().add(lblApellidos);
		
		textFieldApellido1 = new JTextField();
		textFieldApellido1.setColumns(10);
		textFieldApellido1.setBounds(6, 181, 130, 26);
		frame.getContentPane().add(textFieldApellido1);
		
		textFieldApellido2 = new JTextField();
		textFieldApellido2.setColumns(10);
		textFieldApellido2.setBounds(150, 181, 130, 26);
		frame.getContentPane().add(textFieldApellido2);
		
		ConfirmaPassword = new JPasswordField();
		ConfirmaPassword.setBounds(292, 181, 131, 26);
		frame.getContentPane().add(ConfirmaPassword);
		
		Password = new JPasswordField();
		Password.setBounds(292, 114, 131, 26);
		frame.getContentPane().add(Password);
		
		JLabel lblRepetirClave = new JLabel("Repetir Clave");
		lblRepetirClave.setBounds(292, 153, 88, 16);
		frame.getContentPane().add(lblRepetirClave);
		
		JComboBox comboBoxRol = new JComboBox();
		comboBoxRol.setModel(new DefaultComboBoxModel(new String[] {"", "Adminsitrador", "Experto", "Comun"}));
		comboBoxRol.setToolTipText("");
		comboBoxRol.setBounds(6, 260, 173, 27);
		frame.getContentPane().add(comboBoxRol);
		
		JLabel lblRol = new JLabel("Rol");
		lblRol.setBounds(6, 236, 88, 16);
		frame.getContentPane().add(lblRol);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.setBounds(6, 398, 117, 29);
		frame.getContentPane().add(btnAlta);
		
		JButton btnBaja = new JButton("Modificar");
		btnBaja.setBounds(130, 398, 117, 29);
		frame.getContentPane().add(btnBaja);
		
		JButton btnModificar = new JButton("Eliminar");
		btnModificar.setBounds(258, 398, 117, 29);
		frame.getContentPane().add(btnModificar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(387, 398, 117, 29);
		frame.getContentPane().add(btnListar);
		
		JLabel lblInstituto = new JLabel("Instituto");
		lblInstituto.setBounds(435, 91, 88, 16);
		frame.getContentPane().add(lblInstituto);
		
		textFieldInstituto = new JTextField();
		textFieldInstituto.setColumns(10);
		textFieldInstituto.setBounds(435, 114, 130, 26);
		frame.getContentPane().add(textFieldInstituto);
		
		JButton btnListarTareas = new JButton("Listar Tareas");
		btnListarTareas.setBounds(516, 398, 117, 29);
		frame.getContentPane().add(btnListarTareas);
		
		JLabel lblProfesion = new JLabel("Profesion");
		lblProfesion.setBounds(435, 153, 88, 16);
		frame.getContentPane().add(lblProfesion);
		
		textFieldProfesion = new JTextField();
		textFieldProfesion.setColumns(10);
		textFieldProfesion.setBounds(435, 181, 130, 26);
		frame.getContentPane().add(textFieldProfesion);
	}
}
