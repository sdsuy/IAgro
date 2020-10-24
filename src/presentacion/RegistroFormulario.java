package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;

import aplicacion.IAgro;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class RegistroFormulario {

	private JFrame frmRegistroDeFormulario;
	
	private IAgro iagro;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroFormulario window = new RegistroFormulario();
					window.frmRegistroDeFormulario.setVisible(true);
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
					frmRegistroDeFormulario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistroFormulario() {
		initialize();
	}
	
	public RegistroFormulario(IAgro iagro) {
		this.iagro = iagro; // inyecto la aplicacion IAgro en la ventana
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistroDeFormulario = new JFrame();
		frmRegistroDeFormulario.setTitle("Registro de Formulario");
		frmRegistroDeFormulario.setBounds(100, 100, 567, 403);
		frmRegistroDeFormulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroDeFormulario.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(62, 168, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnNewButton);
		
		JButton btnBaja = new JButton("Eliminar");
		btnBaja.setBounds(62, 211, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnBaja);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(62, 252, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnModificar);
		
		JButton btnBaja_1 = new JButton("Listar");
		btnBaja_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBaja_1.setBounds(62, 292, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnBaja_1);
		
		JLabel lblNewLabel = new JLabel("Formulario");
		lblNewLabel.setBounds(82, 140, 126, 16);
		frmRegistroDeFormulario.getContentPane().add(lblNewLabel);
		
		JLabel lblCasillas = new JLabel("Casillas");
		lblCasillas.setBounds(232, 140, 126, 16);
		frmRegistroDeFormulario.getContentPane().add(lblCasillas);
		
		JButton btnNewButton_1 = new JButton("Crear");
		btnNewButton_1.setBounds(206, 168, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnNewButton_1);
		
		JButton btnBaja_2 = new JButton("Eliminar");
		btnBaja_2.setBounds(206, 211, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnBaja_2);
		
		JButton btnModificar_1 = new JButton("Modificar");
		btnModificar_1.setBounds(206, 252, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnModificar_1);
		
		JButton btnBaja_1_1 = new JButton("Listar");
		btnBaja_1_1.setBounds(206, 292, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnBaja_1_1);
		
		textField = new JTextField();
		textField.setBounds(65, 85, 130, 26);
		frmRegistroDeFormulario.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNombreFormulario = new JLabel("Nombre Formulario");
		lblNombreFormulario.setBounds(62, 61, 126, 16);
		frmRegistroDeFormulario.getContentPane().add(lblNombreFormulario);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(344, 85, 217, 252);
		frmRegistroDeFormulario.getContentPane().add(textPane);
		
		JLabel lblResumen = new JLabel("Resumen");
		lblResumen.setBounds(344, 61, 126, 16);
		frmRegistroDeFormulario.getContentPane().add(lblResumen);
	}
}
