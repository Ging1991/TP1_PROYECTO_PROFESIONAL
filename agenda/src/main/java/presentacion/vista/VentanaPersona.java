package presentacion.vista;

import java.sql.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import dto.LocalidadDTO;
import dto.TipoContactoDTO;
import modelo.Agenda;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.controlador.Controlador;
import javax.swing.JComboBox;

public class VentanaPersona extends JFrame {
	private static final long serialVersionUID = 1L;
	private Controlador controlador;
	private JPanel contenedor_principal;
	private JPanel panel;
	private JCalendar inFecha;
	private JTextField inMail, inCalle, inDepto, inNum, inPiso, inTelefono, inNombre;
	private JButton btnAgregarPersona, btnAgregarLocalidad, btnAgregarTipoContacto;
	private JComboBox<LocalidadDTO> inLocalidad;
	private JComboBox <TipoContactoDTO> inTipoContacto;
	
	public VentanaPersona(Controlador controlador) {
		super();
		this.controlador = controlador;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 814, 560);
		contenedor_principal = new JPanel();
		contenedor_principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenedor_principal);
		contenedor_principal.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 11, 788, 499);
		contenedor_principal.add(panel);
		panel.setLayout(null);
		
		//Medidas de la ventana
		int columna1 = 50;
		int columna2 = 250;
		int columna3 = 500;
		
		int fila1 = 10;
		int fila2 = 50;
		int fila3 = 90;
		int fila4 = 130;
		int fila5 = 170;
		int fila6 = 210;
		int fila7 = 250;
		int fila8 = 290;
		int fila9 = 330;
		
		int anchoLabelGrande = 200;
		int anchoLabelChico = 50;
		int anchoCajaGrande = 200;
		int altoLabel = 15;
		int altoCaja = 20;

		// Las etiquetas
		JLabel lblNombre = new JLabel("Nombre y apellido");
		JLabel lblTelefono = new JLabel("Telefono");
		JLabel lblMail = new JLabel("Mail");
		JLabel lblFecha = new JLabel("Fecha de nacimiento");
		JLabel lblTipo = new JLabel("Tipo De Contacto");		
		JLabel lblCalle = new JLabel("Calle");
		JLabel lblNum = new JLabel("N°");
		JLabel lblPiso = new JLabel("Piso");
		JLabel lblDepto = new JLabel("Depto");
		JLabel lblLocalidad = new JLabel("Localidad");
		
		lblNombre.setBounds(  columna1, fila1, anchoLabelGrande, altoLabel);
		lblTelefono.setBounds(columna1, fila2, anchoLabelGrande, altoLabel);
		lblMail.setBounds(    columna1, fila3, anchoLabelGrande, altoLabel);
		lblFecha.setBounds(   columna1, fila4, anchoLabelGrande, altoLabel);
		lblTipo.setBounds(    columna1, fila5, anchoLabelGrande, altoLabel);
		lblCalle.setBounds(    columna1, fila6, anchoLabelGrande, altoLabel);
		lblNum.setBounds(     columna1, fila7, anchoLabelChico, altoLabel);
		lblPiso.setBounds(    columna3+100, fila7, anchoLabelChico, altoLabel);
		lblDepto.setBounds(   columna3+200, fila7, anchoLabelChico, altoLabel);
		lblLocalidad.setBounds(   columna1, fila8, anchoLabelGrande, altoLabel);

		panel.add(lblNombre);
		panel.add(lblTelefono);
		panel.add(lblMail);
		panel.add(lblFecha);
		panel.add(lblTipo);
		panel.add(lblCalle);
		panel.add(lblNum);
		panel.add(lblPiso);
		panel.add(lblDepto);
		panel.add(lblLocalidad);
		
		// Las cajas de texto
		inMail = new JTextField();
		inTelefono = new JTextField();
		inFecha = new JCalendar();
		inCalle = new JTextField();
		inDepto = new JTextField();
		inNum = new JTextField();
		inPiso = new JTextField();
		inNombre = new JTextField();
		
		inNombre.setColumns(10);
		inMail.setColumns(10);
		inTelefono.setColumns(10);
		inCalle.setColumns(10);
		inDepto.setColumns(10);
		inNum.setColumns(10);
		inPiso.setColumns(10);

		inNombre.setBounds(  columna2, fila1, anchoCajaGrande, altoCaja);
		inTelefono.setBounds(columna2, fila2, anchoCajaGrande, altoCaja);
		inMail.setBounds(    columna2, fila3, anchoCajaGrande, altoCaja);
		inFecha.setBounds(   columna2, fila4, anchoCajaGrande+200, altoCaja);
		inCalle.setBounds(columna2, fila6, 110, 20);
		inNum.setBounds(  columna2, fila7, 42, 20);
		inPiso.setBounds( columna3+150, fila7, 42, 20);
		inDepto.setBounds(columna3+250, fila7, 32, 20);

		panel.add(inNombre);
		panel.add(inMail);
		panel.add(inTelefono);
		panel.add(inFecha);
		panel.add(inCalle);
		panel.add(inNum );
		panel.add(inDepto);
		panel.add(inPiso);
		
		// Los desplegables
		cargarLocalidades();
		cargarTiposDeContacto();

		inTipoContacto.setBounds(columna2, fila5, anchoCajaGrande, altoCaja);
		panel.add(inTipoContacto);
		
		// Los botones
		btnAgregarPersona = new JButton("Agregar contacto");
		btnAgregarTipoContacto = new JButton("...");
		btnAgregarLocalidad = new JButton("...");
		
		
		btnAgregarPersona.addActionListener(this.controlador);
		btnAgregarLocalidad.addActionListener(this.controlador);
		btnAgregarTipoContacto.addActionListener(this.controlador);
		
		btnAgregarPersona.setBounds(columna3, fila9, anchoCajaGrande, altoCaja);
		btnAgregarLocalidad.setBounds(columna3, fila8, anchoCajaGrande, altoCaja);
		btnAgregarTipoContacto.setBounds(columna3, fila5, anchoCajaGrande, altoCaja);

		panel.add(btnAgregarPersona);
		panel.add(btnAgregarTipoContacto);
		panel.add(btnAgregarLocalidad);
		
		this.setVisible(true);
	}
	
	public void cargarLocalidades() {
		Agenda agenda = new Agenda(new DAOSQLFactory());
		List<LocalidadDTO> localidades = agenda.obtenerLocalidades();
		JComboBox<LocalidadDTO> lista = new JComboBox<LocalidadDTO>();

		for (LocalidadDTO localidad : localidades)
			lista.addItem(localidad);
		
		if (inLocalidad != null)
			panel.remove(inLocalidad);
		inLocalidad = lista;
		inLocalidad.setBounds(250, 290, 200, 20);
		panel.add(inLocalidad);
	}
	
	public void cargarTiposDeContacto() {
		Agenda agenda = new Agenda(new DAOSQLFactory());
		List<TipoContactoDTO> tipos = agenda.obtenerTiposDeContacto();
		JComboBox<TipoContactoDTO> lista = new JComboBox<TipoContactoDTO>();

		for (TipoContactoDTO tipo: tipos)
			lista.addItem(tipo);
		
		inTipoContacto = lista;
	}
	
	// GETTERS DE DATOS Y BOTONES
	public LocalidadDTO getLocalidad() {
		return (LocalidadDTO)inLocalidad.getSelectedItem();
	}
	
	public TipoContactoDTO getTipoContacto() {
		return (TipoContactoDTO)inTipoContacto.getSelectedItem();
	}
	
	public String getNombre() {
		return inNombre.getText();
	}

	public String getTelefono() {
		return inTelefono.getText();
	}
	
	public String getMail() {
		return inMail.getText();
	}
    
	public String getCalle() {
		return inCalle.getText();
	}

	public String getNumero() {
		return inNum.getText();
	}
	
	public String getPiso() {
		return inPiso.getText();
	}
	
	public String getDepto() {
		return inDepto.getText();
	}
	
	public Date getFecha() {
		java.util.Date utilDate = inFecha.getDate();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
	
	public JButton getBtnAgregarPersona() {
		return btnAgregarPersona;
	}

	public JButton getBtnAgregarLocalidad() {
		return btnAgregarLocalidad;
	}
	
	public JButton getBtnAgregarTipoContacto() {
		return btnAgregarTipoContacto;
	}

}