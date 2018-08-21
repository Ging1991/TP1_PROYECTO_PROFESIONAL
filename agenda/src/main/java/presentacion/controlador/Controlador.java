package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaEditarContacto;
import presentacion.vista.VentanaLocalidad;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.LocalidadDTO;
import dto.PersonaDTO;

public class Controlador implements ActionListener {
	private Vista vista;
	private List<PersonaDTO> personas_en_tabla;
	private VentanaPersona ventanaPersona;
	private VentanaLocalidad ventanaLocalidad;
	private VentanaEditarContacto ventanaEditarContacto;
	private Agenda agenda;
	
	public Controlador(Vista vista, Agenda agenda) {
		this.vista = vista;
		this.agenda = agenda;
		this.vista.getBtnAgregar().addActionListener(this);
		this.vista.getBtnBorrar().addActionListener(this);
		this.vista.getBtnReporte().addActionListener(this);
		this.vista.getBtnEditar().addActionListener(this);
	}
	
	public void inicializar() {
		this.llenarTabla();
		vista.show();
		System.out.println("Inicializando");
	}
	
	private void llenarTabla() {
		System.out.println("Llenando tabla");
		vista.getModelPersonas().setRowCount(0);
		vista.getModelPersonas().setColumnCount(0);
		vista.getModelPersonas().setColumnIdentifiers(vista.getNombreColumnas());
		//nombreColumnas = {"Nombre y apellido","Telefono","Mail","Calle","Numero","Piso","Depto","Localidad","Cumpleaños", "Tipo de Contacto"};
		personas_en_tabla = agenda.obtenerPersonas();
		System.out.println(personas_en_tabla.size());
		
		for (int i = 0; i < personas_en_tabla.size(); i ++) {
			Object[] fila = {
					personas_en_tabla.get(i).getNombre(),
					personas_en_tabla.get(i).getTelefono(),
					personas_en_tabla.get(i).getEmail(),
					personas_en_tabla.get(i).getCalle(),
					personas_en_tabla.get(i).getNumero(),
					personas_en_tabla.get(i).getPiso(),
					personas_en_tabla.get(i).getDepto(),
					personas_en_tabla.get(i).getLocalidad_id().toString(),
					personas_en_tabla.get(i).getFecha_nacimiento().toString(),
					personas_en_tabla.get(i).getTipo_contacto_id().toString()
					};
			System.out.println(fila);
			this.vista.getModelPersonas().addRow(fila);
		
		}
		
		System.out.println("Saliendo de llenar tabla");
	}
	
	public void actionPerformed(ActionEvent e) {
		
		// boton agregar contacto de la vista principal
		if(e.getSource() == this.vista.getBtnAgregar())	{
			this.ventanaPersona = new VentanaPersona(this);
		}
		
		// boton borrar contacto de la vista principal	
		else if(e.getSource() == vista.getBtnBorrar()) {
			int[] filas_seleccionadas = vista.getTablaPersonas().getSelectedRows();
			for (int fila:filas_seleccionadas)
				agenda.borrarPersona(personas_en_tabla.get(fila));
			
			llenarTabla();
		}

		// boton editar contacto de la vista principal	
		else if(e.getSource() == vista.getBtnEditar()) {
			int[] filas_seleccionadas = vista.getTablaPersonas().getSelectedRows();
			if (filas_seleccionadas.length>0) {
				PersonaDTO persona = personas_en_tabla.get(0);
				ventanaEditarContacto = new VentanaEditarContacto(this, persona);
			}
		}

		// boton generar reporte de la vista principal
		else if(e.getSource() == vista.getBtnReporte()) {
			ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
			reporte.mostrar();				
		}
		
		
		// BOTONES DE LA VISTA PERSONA (AGREGAR CONTACTO)
		if (ventanaPersona != null) {
		
		// boton agregar contacto de la vista persona
			if(e.getSource() == ventanaPersona.getBtnAgregarPersona()) {
				PersonaDTO nuevaPersona = new PersonaDTO(
						-1,
						ventanaPersona.getLocalidad().getLocalidad_id(),
						ventanaPersona.getTipoContacto().getTipo_contacto_id(),
						ventanaPersona.getNombre(),
						ventanaPersona.getTelefono(),
						ventanaPersona.getMail(),
						ventanaPersona.getCalle(),
						ventanaPersona.getNumero(),
						ventanaPersona.getPiso(),
						ventanaPersona.getDepto(),
						ventanaPersona.getFecha()
						);
				agenda.agregarPersona(nuevaPersona);
				llenarTabla();
				ventanaPersona.dispose();
			}
			
			// boton agregar localidad de la vista persona
			else if(e.getSource() == ventanaPersona.getBtnAgregarLocalidad()) {
				ventanaLocalidad = new VentanaLocalidad(this);
			}
			
		}
		
		// BOTONES DE LA VENTANA DE AGREGAR LOCALIDAD
		if (ventanaLocalidad != null) {
			if(e.getSource() == ventanaLocalidad.getBtnAgregarLocalidad()) {
				LocalidadDTO localidad = new LocalidadDTO(-1, ventanaLocalidad.getDescripcion().getText());
				agenda.agregarLocalidad(localidad);
				ventanaPersona.cargarLocalidades();
				ventanaLocalidad.dispose();
			}
		}		
		
		// BOTONES DE LA VENTANA DE EDITAR CONTACTO
		if (ventanaEditarContacto != null) {
			if(e.getSource() == ventanaEditarContacto.getBtnEditarContacto()) {
				PersonaDTO contacto = new PersonaDTO(
						ventanaEditarContacto.getPersonaOriginal().getPersona_id(),
						ventanaEditarContacto.getLocalidad().getLocalidad_id(),
						ventanaEditarContacto.getTipoContacto().getTipo_contacto_id(),
						ventanaEditarContacto.getNombre(),
						ventanaEditarContacto.getTelefono(),
						ventanaEditarContacto.getMail(),
						ventanaEditarContacto.getCalle(),
						ventanaEditarContacto.getNumero(),
						ventanaEditarContacto.getPiso(),
						ventanaEditarContacto.getDepto(),
						ventanaEditarContacto.getFecha()
						);
				agenda.actualizarPersona(contacto);
				llenarTabla();
				ventanaEditarContacto.dispose();
			}
		}
		
	}
	
}