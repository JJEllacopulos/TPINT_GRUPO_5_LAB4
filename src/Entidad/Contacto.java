package Entidad;

public class Contacto {
	
	//Campos
	private int id_contacto;
	private String nombre_usuario;
	private String email;
	private String telefono;
	private boolean estado;
	
	//Constructores
	public Contacto() {
		
	}
	
	public Contacto(int id_contacto, String nombre_usuario, String email, String telefono, boolean estado) {
		super();
		this.id_contacto = id_contacto;
		this.nombre_usuario = nombre_usuario;
		this.email = email;
		this.telefono = telefono;
		this.estado = estado;
	}
	
	//Gets y sets

	public int getId_contacto() {
		return id_contacto;
	}

	public void setId_contacto(int id_contacto) {
		this.id_contacto = id_contacto;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
}
