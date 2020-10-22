package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;

import aplicacion.IAgro;

public class Registro_Formulario {

	private JFrame frame;
	
	private IAgro iagro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro_Formulario window = new Registro_Formulario();
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
	public Registro_Formulario() {
		initialize();
	}
	
	public Registro_Formulario(IAgro iagro) {
		this.iagro = iagro; // inyecto la aplicacion IAgro en la ventana
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
