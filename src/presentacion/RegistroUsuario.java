package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import aplicacion.IAgro;
import entidades.Administrador;
import entidades.Comun;
import entidades.Experto;
import entidades.Usuario;
import negocio.UsuarioBO;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RegistroUsuario {

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
	private JTextField textFieldListaTareas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroUsuario window = new RegistroUsuario();
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
	public RegistroUsuario() {
		initialize();
	}
	
	public RegistroUsuario(IAgro iagro) {
		this.iagro = iagro; // inyecto la aplicacion IAgro en la ventana
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Registro Usuario");
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
		lblEmail.setBounds(292, 24, 26, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(6, 91, 52, 16);
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
		lblPassword.setBounds(292, 91, 40, 16);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(6, 153, 52, 16);
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
		
		JLabel lblObligatorio1 = new JLabel("*");
		lblObligatorio1.setForeground(Color.RED);
		lblObligatorio1.setBounds(30, 235, 26, 14);
		frame.getContentPane().add(lblObligatorio1);
		lblObligatorio1.setVisible(false);
		
		JLabel lblObligatorio2 = new JLabel("*");
		lblObligatorio2.setForeground(Color.RED);
		lblObligatorio2.setBounds(258, 237, 26, 14);
		frame.getContentPane().add(lblObligatorio2);
		lblObligatorio2.setVisible(false);
		
		JLabel lblObligatorio3 = new JLabel("*");
		lblObligatorio3.setForeground(Color.RED);
		lblObligatorio3.setBounds(64, 154, 26, 14);
		frame.getContentPane().add(lblObligatorio3);
		lblObligatorio3.setVisible(false);
		
		JLabel lblObligatorio4 = new JLabel("*");
		lblObligatorio4.setForeground(Color.RED);
		lblObligatorio4.setBounds(338, 92, 26, 14);
		frame.getContentPane().add(lblObligatorio4);
		lblObligatorio4.setVisible(false);
		
		JLabel lblObligatorio5 = new JLabel("*");
		lblObligatorio5.setForeground(Color.RED);
		lblObligatorio5.setBounds(64, 92, 26, 14);
		frame.getContentPane().add(lblObligatorio5);
		lblObligatorio5.setVisible(false);
		
		JLabel lblObligatorio6 = new JLabel("*");
		lblObligatorio6.setForeground(Color.RED);
		lblObligatorio6.setBounds(327, 25, 26, 14);
		frame.getContentPane().add(lblObligatorio6);
		lblObligatorio6.setVisible(false);
		
		JComboBox comboBoxRol = new JComboBox();
		comboBoxRol.setModel(new DefaultComboBoxModel(new String[] {"","Administrador", "Experto", "Comun"}));
		comboBoxRol.setToolTipText("");
		comboBoxRol.setBounds(6, 260, 173, 27);
		frame.getContentPane().add(comboBoxRol);
		
		JLabel lblRol = new JLabel("Rol");
		lblRol.setBounds(6, 236, 26, 16);
		frame.getContentPane().add(lblRol);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblObligatorio1.setVisible(true);
				lblObligatorio2.setVisible(true);
				lblObligatorio3.setVisible(true);
				lblObligatorio4.setVisible(true);
				lblObligatorio5.setVisible(true);
				lblObligatorio6.setVisible(true);
				
				if(textFieldDocumento.getText().isEmpty() || textFieldMail.getText().isEmpty() || textFieldNombre1.getText().isEmpty() ||  
						textFieldApellido1.getText().isEmpty() || textFieldUserName.getText().isEmpty()  || textFieldApellido2.getText().isEmpty() || ConfirmaPassword.getText().isEmpty() || comboBoxRol.equals("")) {
					JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos obligatorios","Error",JOptionPane.ERROR_MESSAGE);
						
				} 
				
				//else if () {
					
				//}
				
				
				else {
					
					    
					    
						String repClave="";
						
						String nombRol = comboBoxRol.getSelectedItem().toString();
						
						Usuario user = null;
						if(nombRol.equals("Administrador")) {
							System.out.println("Rol Admin: "+nombRol);
							user = new Administrador();
						}
						else if(nombRol.equals("Experto")){
							System.out.println("Rol Experto: "+nombRol);
							user = new Experto();
							
						}
						else if(nombRol.equals("Comun")) {
							System.out.println("Rol Comun: "+nombRol);
							user = new Comun();
						}
						user.setNombre(textFieldNombre1.getText().toUpperCase());
						user.setApellido(textFieldApellido1.getText().toUpperCase());
						user.setUser(textFieldUserName.getText());
						user.setPswd(Password.getText());
						user.setEmail(textFieldMail.getText().toUpperCase());
						
						//Hasta aqui asigno los atributo de usuario
						if(nombRol.equals("Administrador") || nombRol.equals("Experto")) {
							int x=Integer.parseInt(textFieldDocumento.getText());
							user.setCedula(x);
						}
						if(user.getRol().equals("Administrador")) {
							user.setInstituto(textFieldInstituto.getText());
							iagro.createUsuario(user);
							System.out.println(user);
						}
						if(user.getRol().equals("Experto")) {
							user.setProfesion(textFieldProfesion.getText());
							iagro.createUsuario(user);
						}
						if(user.getRol().equals("Comun")) {
							user.setList_tareas(textFieldListaTareas.getText());
							iagro.createUsuario(user);
						}
						
						//Compruebo que la contrasenias sean iguales.
						repClave=ConfirmaPassword.getText();
						if(repClave.equals(ConfirmaPassword.getText())) {
							
							boolean resultado = iagro.createUsuario(user);
							if(true) {
								limpiarCampos();
								JOptionPane.showMessageDialog(null, "La operacion se realizo con exito","Correcto",JOptionPane.INFORMATION_MESSAGE);
								
								lblObligatorio1.setVisible(false);
								lblObligatorio2.setVisible(false);
								lblObligatorio3.setVisible(false);
								lblObligatorio4.setVisible(false);
								lblObligatorio5.setVisible(false);
								lblObligatorio6.setVisible(false);
								
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
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBaja.setBounds(130, 398, 117, 29);
		frame.getContentPane().add(btnBaja);
		
		JButton btnModificar = new JButton("Eliminar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioBO user=null;
				Usuario usuario=null;
				int result=JOptionPane.showConfirmDialog(null, "Desea continuar?",null,JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_OPTION) {
					boolean resultado = user.deleteUsuario(usuario.getId());
					
					if (resultado) {
						limpiarCampos();
						
						JOptionPane.showMessageDialog(null, "La operacion se realizo con exito","Correcto",JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Se produjo un error","Error",JOptionPane.ERROR_MESSAGE);
					}
				}else {
					if(result==JOptionPane.NO_OPTION);
				}
				
			

				
			}
		});
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
		lblUserName.setBounds(202, 236, 52, 16);
		frame.getContentPane().add(lblUserName);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setColumns(10);
		textFieldUserName.setBounds(202, 259, 130, 26);
		frame.getContentPane().add(textFieldUserName);
		
		textFieldListaTareas = new JTextField();
		textFieldListaTareas.setColumns(10);
		textFieldListaTareas.setBounds(359, 259, 130, 26);
		frame.getContentPane().add(textFieldListaTareas);
		
		JLabel lblListaTareas = new JLabel("Lista Tareas");
		lblListaTareas.setBounds(359, 236, 88, 16);
		frame.getContentPane().add(lblListaTareas);
		
		
		
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
