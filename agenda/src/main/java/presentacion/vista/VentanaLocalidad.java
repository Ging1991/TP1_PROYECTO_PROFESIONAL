package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import presentacion.controlador.Controlador;

public class VentanaLocalidad extends JFrame {
	private static final long serialVersionUID = 1L;
	private Controlador controlador;
	private JPanel contenedor_principal;
	private JTextField inDescripcion;
	private JButton btnAgregarLocalidad;
	
	public VentanaLocalidad(Controlador controlador) {
		super();
		this.controlador = controlador;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 814, 560);
		contenedor_principal = new JPanel();
		contenedor_principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenedor_principal);
		contenedor_principal.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 788, 499);
		contenedor_principal.add(panel);
		panel.setLayout(null);
		
		JLabel lblDescripcion = new JLabel("Nombre de la localidad");
		lblDescripcion.setBounds(10, 11, 113, 14);
		panel.add(lblDescripcion);
		
		inDescripcion = new JTextField();
		inDescripcion.setBounds(115, 8, 164, 20);
		panel.add(inDescripcion);
		inDescripcion.setColumns(10);
		
		btnAgregarLocalidad = new JButton("Agregar localidad");
		btnAgregarLocalidad.addActionListener(this.controlador);
		btnAgregarLocalidad.setBounds(682, 416, 89, 23);
		panel.add(btnAgregarLocalidad);
		
		this.setVisible(true);
	}
	
	public JTextField getDescripcion() {
		return inDescripcion;
	}
	
	public JButton getBtnAgregarLocalidad() {
		return btnAgregarLocalidad;
	}

}