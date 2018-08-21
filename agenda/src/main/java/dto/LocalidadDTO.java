package dto;

public class LocalidadDTO {
	private Integer localidad_id;
	private String descripcion;
	
	public LocalidadDTO(Integer localidad_id, String descripcion) {
		this.localidad_id = localidad_id;
		this.descripcion = descripcion;
	}

	public Integer getLocalidad_id() {
		return localidad_id;
	}

	public void setLocalidad_id(Integer localidad_id) {
		this.localidad_id = localidad_id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return descripcion;
	}
	
}