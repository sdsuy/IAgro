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
import javax.swing.ImageIcon;
import java.awt.Color;

public class RegistroFormulario {

	private JFrame frmRegistroDeFormulario;
	
	private IAgro iagro;
	private JTextField textField;
	
	private JLabel lblObligatorio;
	
	private boolean obligatorio = true;

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
		frmRegistroDeFormulario.setBounds(100, 100, 567, 425);
		frmRegistroDeFormulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroDeFormulario.getContentPane().setLayout(null);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCrear.setBounds(61, 145, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnCrear);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(61, 188, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(61, 229, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnModificar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnListar.setBounds(61, 269, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnListar);
		
		JLabel lblNewLabel = new JLabel("Formulario");
		lblNewLabel.setBounds(81, 117, 126, 16);
		frmRegistroDeFormulario.getContentPane().add(lblNewLabel);
		
		JLabel lblCasillas = new JLabel("Casillas");
		lblCasillas.setBounds(231, 117, 126, 16);
		frmRegistroDeFormulario.getContentPane().add(lblCasillas);
		
		JButton btnCrearCasillas = new JButton("Crear");
		btnCrearCasillas.setBounds(205, 145, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnCrearCasillas);
		
		JButton btnEliminarCasilla = new JButton("Eliminar");
		btnEliminarCasilla.setBounds(205, 188, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnEliminarCasilla);
		
		JButton btnModificarCasillas = new JButton("Modificar");
		btnModificarCasillas.setBounds(205, 229, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnModificarCasillas);
		
		JButton btnListarCasillas = new JButton("Listar ");
		btnListarCasillas.setBounds(205, 269, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnListarCasillas);
		
		textField = new JTextField();
		textField.setBounds(10, 80, 130, 26);
		frmRegistroDeFormulario.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNombreFormulario = new JLabel("Nombre Formulario");
		lblNombreFormulario.setBounds(10, 58, 98, 16);
		frmRegistroDeFormulario.getContentPane().add(lblNombreFormulario);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(344, 85, 197, 252);
		frmRegistroDeFormulario.getContentPane().add(textPane);
		
		JLabel lblResumen = new JLabel("Resumen");
		lblResumen.setBounds(344, 61, 126, 16);
		frmRegistroDeFormulario.getContentPane().add(lblResumen);
		
		lblObligatorio = new JLabel("*");
		lblObligatorio.setForeground(Color.RED);
		lblObligatorio.setBounds(118, 59, 26, 14);
		frmRegistroDeFormulario.getContentPane().add(lblObligatorio);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(RegistroFormulario.class.getResource("/IMG/registroFormulario.jpg")));
		lblFondo.setBounds(0, 0, 551, 386);
		frmRegistroDeFormulario.getContentPane().add(lblFondo);
	}
	
    private void switchObligatorio() {
        obligatorio = obligatorio ? false: true;
		
		lblObligatorio.setVisible(obligatorio);
		
    }
		
		
	
	
	
	
}
