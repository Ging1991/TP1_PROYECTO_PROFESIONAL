package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.TipoContactoDAO;
import dto.TipoContactoDTO;

public class TipoContactoDAOSQL implements TipoContactoDAO {
	private static final String insert = "INSERT INTO tipo_contacto(tipo_contacto_id, descripcion) VALUES(?, ?)";
	private static final String readall = "SELECT tipo_contacto_id, descripcion FROM tipo_contacto";
	private static final String selectDescripcion = "SELECT descripcion FROM tipo_contacto WHERE tipo_contacto_id = ?";
	
	@Override
	public boolean insert(TipoContactoDTO tipo) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, tipo.getTipo_contacto_id());
			statement.setString(2, tipo.getDescripcion());
			
			if(statement.executeUpdate() > 0)
				return true;
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<TipoContactoDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet;
		List<TipoContactoDTO> tipos_de_contacto = new ArrayList<TipoContactoDTO>();
		Conexion conexion = Conexion.getConexion();
		
		try	{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
				tipos_de_contacto.add(new TipoContactoDTO(
						resultSet.getInt("tipo_contacto_id"),
						resultSet.getString("descripcion")
						));
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tipos_de_contacto;
	}

	@Override
	public String selectDescripcion(Integer tipo_id) {
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		String ret = null;
		
		try	{
			statement = conexion.getSQLConexion().prepareStatement(selectDescripcion);
			statement.setInt(1, tipo_id);
			resultSet = statement.executeQuery();			
			if (resultSet.next())
				ret = resultSet.getString("descripcion");
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
}