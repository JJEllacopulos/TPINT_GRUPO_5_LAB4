package Entidad;

import java.util.Date;

public class Usuario {
	
	int Id;
	String Usuario;
	String Nombre;
	String Apellido;
	String Dni;
	String Password;
	String Cuil;
	String Sexo;
	String Nacionalidad;
	Date Fecha;
	Contacto contacto;
	Direccion direccion;
	TipoUsuario tipoUsuario;
	
	public Usuario(int id, String usuario, String nombre, String apellido, String dni, String password, String cuil,
			String sexo, String nacionalidad, Date fecha, Contacto contacto, Direccion direccion,
			TipoUsuario tipoUsuario) {
		super();
		Id = id;
		Usuario = usuario;
		Nombre = nombre;
		Apellido = apellido;
		Dni = dni;
		Password = password;
		Cuil = cuil;
		Sexo = sexo;
		Nacionalidad = nacionalidad;
		Fecha = fecha;
		this.contacto = contacto;
		this.direccion = direccion;
		this.tipoUsuario = tipoUsuario;
	}

	public Usuario() {
		Id = 0;
		Usuario = "";
		Nombre = "";
		Apellido = "";
		Dni = "";
		Password = "";
		Cuil = "";
		Sexo = "";
		Nacionalidad = "";
		Fecha = new Date();
		contacto = new Contacto();
		direccion = new Direccion();
		tipoUsuario = new TipoUsuario();
		
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getDni() {
		return Dni;
	}
	public void setDni(String dni) {
		Dni = dni;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getCuil() {
		return Cuil;
	}
	public void setCuil(String cuil) {
		Cuil = cuil;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public String getNacionalidad() {
		return Nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public Contacto getContacto() {
		return contacto;
	}
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
