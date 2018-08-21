package persistencia.dao.interfaz;

import java.util.List;
import dto.TipoContactoDTO;

public interface TipoContactoDAO {
	
	public boolean insert(TipoContactoDTO tipo);
	
	public String selectDescripcion(Integer tipo_contacto_id);
	
	public List<TipoContactoDTO> readAll();
	
}