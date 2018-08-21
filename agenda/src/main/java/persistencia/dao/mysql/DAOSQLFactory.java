package persistencia.dao.mysql;

import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.TipoContactoDAO;

public class DAOSQLFactory implements DAOAbstractFactory {

	@Override
	public PersonaDAO crearPersonaDAO() {
		return new PersonaDAOSQL();
	}

	@Override
	public LocalidadDAO crearLocalidadDAO() {
		return new LocalidadDAOSQL();
	}

	@Override
	public TipoContactoDAO crearTipoContactoDAO() {
		return new TipoContactoDAOSQL();
	}

}