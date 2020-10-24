package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;

import aplicacion.IAgro;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroFormulario {

	private JFrame frmRegistroDeFormulario;
	
	private IAgro iagro;

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
		frmRegistroDeFormulario.setBounds(100, 100, 456, 293);
		frmRegistroDeFormulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroDeFormulario.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.setBounds(59, 84, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnNewButton);
		
		JButton btnBaja = new JButton("Eliminar");
		btnBaja.setBounds(59, 127, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnBaja);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(59, 168, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnModificar);
		
		JButton btnBaja_1 = new JButton("Listar");
		btnBaja_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBaja_1.setBounds(59, 208, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnBaja_1);
		
		JLabel lblNewLabel = new JLabel("Formulario");
		lblNewLabel.setBounds(79, 56, 126, 16);
		frmRegistroDeFormulario.getContentPane().add(lblNewLabel);
		
		JLabel lblCasillas = new JLabel("Casillas");
		lblCasillas.setBounds(262, 56, 126, 16);
		frmRegistroDeFormulario.getContentPane().add(lblCasillas);
		
		JButton btnNewButton_1 = new JButton("Crear");
		btnNewButton_1.setBounds(236, 84, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnNewButton_1);
		
		JButton btnBaja_2 = new JButton("Eliminar");
		btnBaja_2.setBounds(236, 127, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnBaja_2);
		
		JButton btnModificar_1 = new JButton("Modificar");
		btnModificar_1.setBounds(236, 168, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnModificar_1);
		
		JButton btnBaja_1_1 = new JButton("Listar");
		btnBaja_1_1.setBounds(236, 208, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnBaja_1_1);
	}
}
