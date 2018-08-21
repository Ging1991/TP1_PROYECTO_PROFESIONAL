package persistencia.dao.interfaz;

public interface DAOAbstractFactory {
	
	public PersonaDAO crearPersonaDAO();
	
	public LocalidadDAO crearLocalidadDAO();
	
	public TipoContactoDAO crearTipoContactoDAO();
		
}