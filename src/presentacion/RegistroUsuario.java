package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import aplicacion.IAgro;
import entidades.Administrador;
import entidades.Comun;
import entidades.Experto;
import entidades.Usuario;
import negocio.UsuarioBO;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class RegistroUsuario {

	private JFrame frame;
	//private JTextField textFieldDocumento;
	private JFormattedTextField formattedTextFieldCedula;
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
	private JTextField textFieldListaTareas;
	
	private JLabel lblObligatorio1;
	private JLabel lblObligatorio2;
	private JLabel lblObligatorio3;
	private JLabel lblObligatorio4;
	private JLabel lblObligatorio5;
	private JLabel lblObligatorio6;
	private JLabel lblObligatorio7;
	
	private boolean obligatorio = true;
	private IAgro iagro;

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
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDocumento = new JLabel("Cedula");
		lblDocumento.setBounds(6, 24, 88, 16);
		frame.getContentPane().add(lblDocumento);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(148, 52, 117, 29);
		frame.getContentPane().add(btnBuscar);
		
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("#.###.###-#");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		formattedTextFieldCedula = new JFormattedTextField(formatter);
		formattedTextFieldCedula.setBounds(6, 52, 130, 26);
		frame.getContentPane().add(formattedTextFieldCedula);
		formattedTextFieldCedula.setColumns(10);
		
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
		lblRepetirClave.setBounds(292, 153, 72, 16);
		frame.getContentPane().add(lblRepetirClave);
		
		lblObligatorio1 = new JLabel("*");
		lblObligatorio1.setForeground(Color.RED);
		lblObligatorio1.setBounds(30, 235, 26, 14);
		frame.getContentPane().add(lblObligatorio1);
		
		lblObligatorio2 = new JLabel("*");
		lblObligatorio2.setForeground(Color.RED);
		lblObligatorio2.setBounds(258, 237, 26, 14);
		frame.getContentPane().add(lblObligatorio2);
		
		lblObligatorio3 = new JLabel("*");
		lblObligatorio3.setForeground(Color.RED);
		lblObligatorio3.setBounds(64, 154, 26, 14);
		frame.getContentPane().add(lblObligatorio3);
		
		lblObligatorio4 = new JLabel("*");
		lblObligatorio4.setForeground(Color.RED);
		lblObligatorio4.setBounds(338, 92, 26, 14);
		frame.getContentPane().add(lblObligatorio4);
		
		lblObligatorio5 = new JLabel("*");
		lblObligatorio5.setForeground(Color.RED);
		lblObligatorio5.setBounds(64, 92, 26, 14);
		frame.getContentPane().add(lblObligatorio5);
		
		lblObligatorio6 = new JLabel("*");
		lblObligatorio6.setForeground(Color.RED);
		lblObligatorio6.setBounds(327, 25, 26, 14);
		frame.getContentPane().add(lblObligatorio6);
		
		// se Utiliza? / indicamos con un * que el campo repetir la pass es obligatorio
		lblObligatorio7 = new JLabel("*");
		lblObligatorio7.setForeground(Color.RED);
		lblObligatorio7.setBounds(368, 154, 21, 14);
		frame.getContentPane().add(lblObligatorio7);
		
		switchObligatorio();
		
		JComboBox comboBoxRol = new JComboBox();
		comboBoxRol.setModel(new DefaultComboBoxModel(new String[] {"","Administrador", "Experto", "Comun"}));
		comboBoxRol.setToolTipText("");
		comboBoxRol.setBounds(6, 260, 173, 27);
		frame.getContentPane().add(comboBoxRol);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setColumns(10);
		textFieldUserName.setBounds(202, 259, 130, 26);
		frame.getContentPane().add(textFieldUserName);
		
		JLabel lblRol = new JLabel("Rol");
		lblRol.setForeground(Color.WHITE);
		lblRol.setBounds(6, 236, 26, 16);
		frame.getContentPane().add(lblRol);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchObligatorio();
				
				// Patr�n para validar el email
		        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		        
		        Matcher mather = pattern.matcher(textFieldMail.getText());
				
		        //controlamos si hay algun campo vacio
				if(formattedTextFieldCedula.getText().isEmpty() || textFieldMail.getText().isEmpty() || textFieldNombre1.getText().isEmpty() ||  
						textFieldApellido1.getText().isEmpty() || textFieldUserName.getText().isEmpty()  || textFieldApellido2.getText().isEmpty() || ConfirmaPassword.getText().isEmpty() || comboBoxRol.equals("")) {
					JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos obligatorios","Error",JOptionPane.ERROR_MESSAGE);
						
				} 
				
				//controlamos si el mail tiene un formato invalido
				else if (mather.find() == false) {
					JOptionPane.showMessageDialog(null, "El Email que ingreso no tiene formato valido","Error",JOptionPane.ERROR_MESSAGE);
				}
				
				//controlamos que el nombre de usuario no tenga numeros
				else if (textFieldUserName.getText().contains("1") ||
						textFieldUserName.getText().contains("2") ||
						textFieldUserName.getText().contains("3") ||
						textFieldUserName.getText().contains("4") ||
						textFieldUserName.getText().contains("5") ||
						textFieldUserName.getText().contains("6") ||
						textFieldUserName.getText().contains("7") ||
						textFieldUserName.getText().contains("8") ||
						textFieldUserName.getText().contains("9")) {
					
					JOptionPane.showMessageDialog(null, "El nombre de usuario no puede contener numeros","Error",JOptionPane.ERROR_MESSAGE);
					
				}
				
				//controlamos el largo de la pass y si contiene numeros
				else if (Password.getText().length()<8 || !(
						Password.getText().contains("1") ||
						Password.getText().contains("2") ||
						Password.getText().contains("3") ||
						Password.getText().contains("4") ||
						Password.getText().contains("5") ||
						Password.getText().contains("6") ||
						Password.getText().contains("7") ||
						Password.getText().contains("8") ||
						Password.getText().contains("9")
						)) {
					JOptionPane.showMessageDialog(null, "El largo de la clave debe ser mayor o igual a 8 caracteres","Error",JOptionPane.ERROR_MESSAGE);
				}
				
				
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
							int x=Integer.parseInt(formattedTextFieldCedula.getText());
							user.setCedula(x);
						}
						if(user.getRol().equals("administrador")) {
							user.setInstituto(textFieldInstituto.getText());
							System.out.println(user);
						}
						if(user.getRol().equals("experto")) {
							user.setProfesion(textFieldProfesion.getText());
						}
						user.setList_tareas(textFieldListaTareas.getText());
						
						//Compruebo que la contrasenias sean iguales.
						repClave=ConfirmaPassword.getText();
						if(repClave.equals(ConfirmaPassword.getText())) {
							
							// creo el usuario pasadas las comprobaciones
							boolean resultado = iagro.createUsuario(user);
							if(resultado) {
								limpiarCampos();
								JOptionPane.showMessageDialog(null, "La operacion se realizo con exito","Correcto",JOptionPane.INFORMATION_MESSAGE);
								
								switchObligatorio();
								
							} else {
								JOptionPane.showMessageDialog(null, "Se produjo un error","Error",JOptionPane.ERROR_MESSAGE);
							}

						} else {
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
		
		JLabel lblProfesion = new JLabel("Profesion");
		lblProfesion.setBounds(435, 153, 88, 16);
		frame.getContentPane().add(lblProfesion);
		
		textFieldProfesion = new JTextField();
		textFieldProfesion.setColumns(10);
		textFieldProfesion.setBounds(435, 181, 130, 26);
		frame.getContentPane().add(textFieldProfesion);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setBounds(202, 236, 52, 16);
		frame.getContentPane().add(lblUserName);
		
		textFieldListaTareas = new JTextField();
		textFieldListaTareas.setColumns(10);
		textFieldListaTareas.setBounds(359, 259, 130, 26);
		frame.getContentPane().add(textFieldListaTareas);
		
		JLabel lblListaTareas = new JLabel("Lista Tareas");
		lblListaTareas.setForeground(Color.WHITE);
		lblListaTareas.setBounds(359, 236, 88, 16);
		frame.getContentPane().add(lblListaTareas);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(RegistroUsuario.class.getResource("/IMG/registroUsuarios.jpg")));
		lblFondo.setBounds(0, -1, 734, 462);
		frame.getContentPane().add(lblFondo);
	}
	
	private void switchObligatorio() {
		
		obligatorio = obligatorio ? false: true;
		
		lblObligatorio1.setVisible(obligatorio);
		lblObligatorio2.setVisible(obligatorio);
		lblObligatorio3.setVisible(obligatorio);
		lblObligatorio4.setVisible(obligatorio);
		lblObligatorio5.setVisible(obligatorio);
		lblObligatorio6.setVisible(obligatorio);
		lblObligatorio6.setVisible(obligatorio);
		lblObligatorio7.setVisible(obligatorio);
		
		
	}
	
	private void limpiarCampos() {
		formattedTextFieldCedula.setText("");
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
