package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;

import aplicacion.IAgro;

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
	}

}
