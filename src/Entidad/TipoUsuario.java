package Entidad;

public class TipoUsuario {

	//Campos
	private String tipo_usuario;
	private String descripcion;
	
	//Constructores
	public TipoUsuario() {
		
	}
	
	public TipoUsuario(String tipo_usuario, String descripcion) {
		
		this.tipo_usuario = tipo_usuario;
		this.descripcion = descripcion;
		
	}
	
	//Gets y sets
	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
