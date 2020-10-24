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
		frmRegistroDeFormulario.setBounds(100, 100, 750, 500);
		frmRegistroDeFormulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroDeFormulario.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.setBounds(20, 84, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnNewButton);
		
		JButton btnBaja = new JButton("Eliminar");
		btnBaja.setBounds(20, 127, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnBaja);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(20, 168, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnModificar);
		
		JButton btnBaja_1 = new JButton("Listar");
		btnBaja_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBaja_1.setBounds(20, 208, 117, 29);
		frmRegistroDeFormulario.getContentPane().add(btnBaja_1);
		
		JLabel lblNewLabel = new JLabel("Formulario");
		lblNewLabel.setBounds(44, 56, 126, 16);
		frmRegistroDeFormulario.getContentPane().add(lblNewLabel);
	}
}
