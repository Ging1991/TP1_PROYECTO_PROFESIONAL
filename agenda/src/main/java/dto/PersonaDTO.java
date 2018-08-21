package dto;

import java.sql.Date;

public class PersonaDTO {
	private Integer persona_id, localidad_id, tipo_contacto_id;
	private String nombre, telefono, email, calle, numero, piso, depto;
	private Date fecha_nacimiento;
	
	public PersonaDTO(int persona_id, int localidad_id, int tipo_contacto_id, String nombre, String telefono,
			String email, String calle, String numero, String piso, String depto, Date fecha_nacimiento) {
		this.persona_id = persona_id;
		this.localidad_id = localidad_id;
		this.tipo_contacto_id = tipo_contacto_id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.calle = calle;
		this.numero = numero;
		this.piso = piso;
		this.depto = depto;
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Integer getPersona_id() {
		return persona_id;
	}

	public void setPersona_id(Integer persona_id) {
		this.persona_id = persona_id;
	}

	public Integer getLocalidad_id() {
		return localidad_id;
	}

	public void setLocalidad_id(Integer localidad_id) {
		this.localidad_id = localidad_id;
	}

	public Integer getTipo_contacto_id() {
		return tipo_contacto_id;
	}

	public void setTipo_contacto_id(Integer tipo_contacto_id) {
		this.tipo_contacto_id = tipo_contacto_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

}