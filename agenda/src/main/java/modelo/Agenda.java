package modelo;

import java.util.List;

import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoContactoDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.TipoContactoDAO;

public class Agenda {
	private PersonaDAO personaDAO;	
	private LocalidadDAO localidadDAO;
	private TipoContactoDAO tipoContactoDAO;
	
	public Agenda(DAOAbstractFactory metodo_persistencia) {
		personaDAO = metodo_persistencia.crearPersonaDAO();
		localidadDAO = metodo_persistencia.crearLocalidadDAO();
		tipoContactoDAO = metodo_persistencia.crearTipoContactoDAO();
	}
	
	public void agregarPersona(PersonaDTO nuevaPersona) {
		personaDAO.insert(nuevaPersona);
	}

	public void actualizarPersona(PersonaDTO nuevaPersona) {
		personaDAO.update(nuevaPersona);
	}

	public void agregarLocalidad(LocalidadDTO localidad) {
		localidadDAO.insert(localidad);
	}

	public void borrarPersona(PersonaDTO persona_a_eliminar) {
		personaDAO.delete(persona_a_eliminar);
	}
	
	public List<PersonaDTO> obtenerPersonas() {
		return personaDAO.readAll();		
	}
	
	public List<LocalidadDTO> obtenerLocalidades() {
		return localidadDAO.readAll();		
	}
	
	public List<TipoContactoDTO> obtenerTiposDeContacto() {
		return tipoContactoDAO.readAll();		
	}
	
}