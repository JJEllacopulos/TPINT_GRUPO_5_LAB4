package Entidad;

public class Direccion {
	
	//Campos
	private int id_direccion;
	private String nombre_usuario;
	private String altura;
	private String calle;
	private String localidad;
	private String provincia;
	private String pais;
	private boolean estado;
	
	//Constructores
	public Direccion() {
		
	}
	
	public Direccion(int id_direccion, String nombre_usuario, String altura, String calle, String localidad, String provincia, String pais, boolean estado) {
		
		this.id_direccion = id_direccion;
		this.nombre_usuario = nombre_usuario;
		this.altura = altura;
		this.calle = calle;
		this.localidad = localidad;
		this.provincia = provincia;
		this.pais = pais;
		this.estado = estado;
	}
	
	//Gets y sets
	public int getId_direccion() {
		return id_direccion;
	}

	public void setId_direccion(int id_direccion) {
		this.id_direccion = id_direccion;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
}
