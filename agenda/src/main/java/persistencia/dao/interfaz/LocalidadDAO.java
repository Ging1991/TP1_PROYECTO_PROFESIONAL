package persistencia.dao.interfaz;

import java.util.List;
import dto.LocalidadDTO;

public interface LocalidadDAO {
	
	public boolean insert(LocalidadDTO localidad);
	
	public String selectDescripcion(Integer localidadID);
	
	public List<LocalidadDTO> readAll();
	
}