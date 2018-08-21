package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.LocalidadDAO;
import dto.LocalidadDTO;

public class LocalidadDAOSQL implements LocalidadDAO {
	private static final String insert = "INSERT INTO localidades(descripcion) VALUES(?)";
	private static final String readall = "SELECT localidad_id, descripcion FROM localidades";
	private static final String selectDescripcion = "SELECT descripcion FROM localidades WHERE localidad_id = ?";
	
	
	@Override
	public boolean insert(LocalidadDTO localidad) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setString(1, localidad.getDescripcion());
			
			if(statement.executeUpdate() > 0)
				return true;
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<LocalidadDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet;
		List<LocalidadDTO> localidades = new ArrayList<LocalidadDTO>();
		Conexion conexion = Conexion.getConexion();
		
		try	{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
				localidades.add(new LocalidadDTO(
						resultSet.getInt("localidad_id"),
						resultSet.getString("descripcion")
						));
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return localidades;
	}

	@Override
	public String selectDescripcion(Integer localidadID) {
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		String ret = null;
		
		try	{
			statement = conexion.getSQLConexion().prepareStatement(selectDescripcion);
			statement.setInt(1, localidadID);
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