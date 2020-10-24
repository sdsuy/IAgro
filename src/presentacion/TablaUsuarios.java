package presentacion;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;

import aplicacion.IAgro;
import entidades.Usuario;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JComboBox;

public class TablaUsuarios {

	private JFrame frame;
	private JTable tableUsuarios;
	
	private IAgro iagro;
	
	LinkedList<Usuario> usuarios;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JLabel lblNewLabel;
	private JTextField textNombre;
	private JLabel lblNewLabel_1;
	private JTextField textApellido;
	private JLabel lblNewLabel_2;
	private JComboBox comboBoxRol;
    private TableRowSorter<ModeloTabla> sorter;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TablaUsuarios window = new TablaUsuarios();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Start the application.
	 */
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
	public TablaUsuarios() {
		initialize();
	}
	
	/**
	 * Create the application with IAgro.
	 */
	public TablaUsuarios(IAgro iagro) {
		this.iagro = iagro;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
//	private void initialize(LinkedList<Usuario> usuarios, String[] columnas) {
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		usuarios = iagro.getUsuarios();
		String[] columnas = iagro.getColumnas();
		
		int x = usuarios.size();
		int y = columnas.length;
		
		Object[][] datos = new Object[x][y];
		
		for(Usuario usuario: usuarios) {
			datos[usuarios.indexOf(usuario)][0] = usuario.getId();
			datos[usuarios.indexOf(usuario)][1] = usuario.getNombre();
			datos[usuarios.indexOf(usuario)][2] = usuario.getApellido();
			datos[usuarios.indexOf(usuario)][3] = usuario.getUser();
			datos[usuarios.indexOf(usuario)][4] = usuario.getPswd();
			datos[usuarios.indexOf(usuario)][5] = usuario.getEmail();
			if(usuario.getRol().equals("administrador") || usuario.getRol().equals("experto"))
			datos[usuarios.indexOf(usuario)][6] = usuario.getCedula();
			if(usuario.getRol().equals("administrador"))
			datos[usuarios.indexOf(usuario)][7] = usuario.getInstituto();
			if(usuario.getRol().equals("experto"))
			datos[usuarios.indexOf(usuario)][8] = usuario.getProfesion();
			datos[usuarios.indexOf(usuario)][9] = usuario.getList_tareas();
			datos[usuarios.indexOf(usuario)][10] = usuario.getRol();
		}
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		// creo un modelo para la tabla
		ModeloTabla model = new ModeloTabla(columnas, datos);
		
		sorter = new TableRowSorter<ModeloTabla>(model);
		tableUsuarios = new JTable(model);
		tableUsuarios.setRowSorter(sorter);
		
		JScrollPane scrollPane = new JScrollPane(tableUsuarios);
		frame.getContentPane().add(scrollPane);
		
		menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		mnNewMenu = new JMenu("Usuario");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Modificar");
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Eliminar");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		lblNewLabel = new JLabel("nombre");
		menuBar.add(lblNewLabel);
		
		textNombre = new JTextField();
//		textNombre.setText("");
		menuBar.add(textNombre);
		textNombre.setColumns(10);
		
		textNombre.getDocument().addDocumentListener(
				new DocumentListener() {
					@Override
					public void removeUpdate(DocumentEvent e) {
						filterColumns();
					}
					@Override
					public void insertUpdate(DocumentEvent e) {
						filterColumns();
					}
					@Override
					public void changedUpdate(DocumentEvent e) {
						filterColumns();
					}
				});
		
		lblNewLabel_1 = new JLabel("apellido");
		menuBar.add(lblNewLabel_1);
		
		textApellido = new JTextField();
		menuBar.add(textApellido);
		textApellido.setColumns(10);
		
		textApellido.getDocument().addDocumentListener(
				new DocumentListener() {
					@Override
					public void removeUpdate(DocumentEvent e) {
						filterColumns();
					}
					@Override
					public void insertUpdate(DocumentEvent e) {
						filterColumns();
					}
					@Override
					public void changedUpdate(DocumentEvent e) {
						filterColumns();
					}
				});
		
		lblNewLabel_2 = new JLabel("rol");
		menuBar.add(lblNewLabel_2);
		
		comboBoxRol = new JComboBox();
		menuBar.add(comboBoxRol);
		
		
	}
	
	/** 
     * Update the row filter regular expression from the expression in
     * the text box.
     */
    private void filterColumns() {
        RowFilter<ModeloTabla, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try {
        	List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(2);
        	filters.add(RowFilter.regexFilter(textNombre.getText(), 1));
        	filters.add(RowFilter.regexFilter(textApellido.getText(), 2));
//            rf = RowFilter.regexFilter(textNombre.getText(), 1);
        	rf = RowFilter.andFilter(filters);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }
    
    class ModeloTabla extends AbstractTableModel {
    	
    	private String[] columnNames;
    	private Object[][] data;

    	public ModeloTabla(String[] columnNames, Object[][] data) {
			super();
			this.columnNames = columnNames;
			this.data = data;
		}

		public int getColumnCount() {
    		return columnNames.length;
    	}

    	public int getRowCount() {
    		return data.length;
    	}

    	public String getColumnName(int col) {
    		return columnNames[col];
    	}

		public Object getValueAt(int row, int col) {
    		return data[row][col];
    	}
    }

}
