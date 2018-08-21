package presentacion.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import persistencia.conexion.Conexion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista {
	private JFrame frame;
	private JTable tablaPersonas;
	private JButton btnAgregar, btnBorrar, btnReporte, btnEditar;
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = {"Nombre y apellido","Telefono","Mail","Calle","Numero","Piso","Depto","Localidad","Cumpleaños", "Tipo de Contacto"};

	public Vista() {
		super();
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1093, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1034, 262);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(10, 11, 1009, 182);
		panel.add(spPersonas);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		tablaPersonas = new JTable(modelPersonas);
				
		/*
		tablaPersonas = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			//new String[] {
				//"Nombre y apellido", "Telefono", "Mail", "calle", "num", "piso", "depto", "Localidad", "Cumplea\u00F1os", "Tipo de Contacto"
			//}
			nombreColumnas
		));
		*/
		spPersonas.setViewportView(tablaPersonas);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 228, 89, 23);
		panel.add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(109, 228, 89, 23);
		panel.add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(208, 228, 89, 23);
		panel.add(btnBorrar);
		
		btnReporte = new JButton("Reporte");
		btnReporte.setBounds(307, 228, 89, 23);
		panel.add(btnReporte);
	}
	
	public void show()
	{
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frame.addWindowListener(new WindowAdapter() 
		{
			@Override
		    public void windowClosing(WindowEvent e) {
		        int confirm = JOptionPane.showOptionDialog(
		             null, "Estas seguro que quieres salir de la Agenda!?", 
		             "Confirmacion", JOptionPane.YES_NO_OPTION,
		             JOptionPane.QUESTION_MESSAGE, null, null, null);
		        if (confirm == 0) {
		        	Conexion.getConexion().cerrarConexion();
		           System.exit(0);
		        }
		    }
		});
		this.frame.setVisible(true);
	}
	
	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public JButton getBtnReporte(){
		return btnReporte;
	}

	public JButton getBtnEditar(){
		return btnEditar;
	}
	
	public DefaultTableModel getModelPersonas()	{
		return modelPersonas;
	}
	
	public JTable getTablaPersonas(){
		return tablaPersonas;
	}

	public String[] getNombreColumnas()	{
		return nombreColumnas;
	}
}
