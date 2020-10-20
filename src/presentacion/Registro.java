package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import aplicacion.IAgro;
import entidades.Usuario;
import negocio.UsuarioBO;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JTextField textFieldUserName;
	
	private IAgro iagro;

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
	public Registro() {
		initialize();
	}
	
	public Registro(IAgro iagro) {
		this.iagro = iagro; // inyecto la aplicacion IAgro en la ventana
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
		
		JLabel lblPassword = new JLabel("Clave");
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
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldDocumento.getText().isEmpty() || textFieldMail.getText().isEmpty() || textFieldNombre1.getText().isEmpty() ||  
						textFieldApellido1.getText().isEmpty() || textFieldUserName.getText().isEmpty()  || textFieldApellido2.getText().isEmpty() || ConfirmaPassword.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No tiene todos lo campos","Error",JOptionPane.ERROR_MESSAGE);
				}else {
						String repClave="";
						
						String nombRol = comboBoxRol.getSelectedItem().toString();
						
						UsuarioBO usuario=null;
						Usuario user=null;
						int x=Integer.parseInt(textFieldDocumento.getText());
						user.setCedula(x);
						user.setEmail(textFieldMail.getText().toUpperCase());
						user.setNombre(textFieldNombre1.getText().toUpperCase());
						user.setApellido(textFieldApellido1.getText().toUpperCase());
						user.setPswd(Password.getText());
						user.setUser(textFieldUserName.getText());
						repClave=ConfirmaPassword.getText();
						if(repClave.equals(ConfirmaPassword.getText())) {
							
							boolean resultado = usuario.createUsuario(user);
							if(resultado) {
								limpiarCampos();
								JOptionPane.showMessageDialog(null, "La operacion se realizo con exito","Correcto",JOptionPane.INFORMATION_MESSAGE);
							}
							
							else {
								JOptionPane.showMessageDialog(null, "Se produjo un error","Error",JOptionPane.ERROR_MESSAGE);
							}

							}
						else {
							JOptionPane.showMessageDialog(null, "Su clave no coincide","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
		});
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
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(348, 233, 88, 16);
		frame.getContentPane().add(lblUserName);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setColumns(10);
		textFieldUserName.setBounds(348, 261, 130, 26);
		frame.getContentPane().add(textFieldUserName);
		
	}
	private void limpiarCampos() {
		textFieldDocumento.setText("");
		textFieldMail.setText("");
		textFieldNombre1.setText("");
		textFieldNombre2.setText("");
		textFieldApellido1.setText("");
		textFieldApellido2.setText("");
		textFieldInstituto.setText("");
		textFieldProfesion.setText("");
		textFieldUserName.setText("");
		Password.setText("");
		ConfirmaPassword.setText("");
		
	}
}
