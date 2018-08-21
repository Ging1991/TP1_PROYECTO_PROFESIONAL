package persistencia.dao.interfaz;

import java.util.List;
import dto.PersonaDTO;

public interface PersonaDAO {
	
	public boolean insert(PersonaDTO persona);

	public boolean delete(PersonaDTO persona);
	
	public void update(PersonaDTO persona);
	
	public List<PersonaDTO> readAll();
	
}