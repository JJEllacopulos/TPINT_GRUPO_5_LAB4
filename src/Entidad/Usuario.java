package Entidad;

import java.util.Date;

public class Usuario {
	
	//Campos
	private String nombre_usuario;
	private String dni;
	private String nombre_real;
	private String apellido_real;
	private String tipo_usuario;
	private String password;
	private String cuil;
	private String sexo;
	private int id_estado;
	private Date fecha_nacimiento;
	private Contacto contacto;
	private Direccion direccion;
	
	
	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion1(Direccion direccion) {
		this.direccion = direccion;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	private boolean estado;
	
	//Constructores
	public Usuario() {
		
	}
	
	public Usuario(String nombre_usuario, String dni, String nombre_real, String apellido_real, String tipo_usuario, String password, String cuil, String sexo, int id_estado, Date fecha_nacimiento, boolean estado) {
		
		this.nombre_usuario = nombre_usuario;
		this.dni = dni;
		this.nombre_real = nombre_real;
		this.apellido_real = apellido_real;
		this.tipo_usuario = tipo_usuario;
		this.password = password;
		this.cuil = cuil;
		this.sexo = sexo;
		this.id_estado = id_estado;
		this.fecha_nacimiento = fecha_nacimiento;
		this.estado = estado;
		
		
	}
	
	//Gets y sets
	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre_real() {
		return nombre_real;
	}

	public void setNombre_real(String nombre_real) {
		this.nombre_real = nombre_real;
	}

	public String getApellido_real() {
		return apellido_real;
	}

	public void setApellido_real(String apellido_real) {
		this.apellido_real = apellido_real;
	}

	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getId_estado() {
		return id_estado;
	}

	public void setId_estado(int id_estado) {
		this.id_estado = id_estado;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public void setDireccion(Direccion direccion) {
		// TODO Auto-generated method stub
		this.direccion = direccion;
	}

	
}
