package dto;

public class TipoContactoDTO {
	private Integer tipo_contacto_id;
	private String descripcion;

	public TipoContactoDTO(Integer tipo_contacto_id, String descripcion) {
		this.tipo_contacto_id = tipo_contacto_id;
		this.descripcion = descripcion;
	}

	public Integer getTipo_contacto_id() {
		return tipo_contacto_id;
	}

	public void setTipo_contacto_id(Integer tipo_contacto_id) {
		this.tipo_contacto_id = tipo_contacto_id;
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