package Entidad;

import java.util.Date;

public class Cuenta {
	
	//Campos
	private String cbu_cuenta;
	private String nombre_usuario;
	private String tipo_Cuenta;
	private String fecha_creacion;
	private Double saldo;
	private boolean estado;
	
	//Constructores
	public Cuenta() {
		
	}
	
	public Cuenta(String cbu_cuenta, String nombre_usuario, String tipo_Cuenta, String fecha_creacion, Double saldo, boolean estado) {
		
		this.cbu_cuenta = cbu_cuenta;
		this.nombre_usuario = nombre_usuario;
		this.tipo_Cuenta = tipo_Cuenta;
		this.fecha_creacion = fecha_creacion;
		this.saldo = saldo;
		this.estado = estado;
	}
	
	//Gets y sets
	public String getCbu_cuenta() {
		return cbu_cuenta;
	}

	public void setCbu_cuenta(String cbu_cuenta) {
		this.cbu_cuenta = cbu_cuenta;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getTipo_Cuenta() {
		return tipo_Cuenta;
	}

	public void setTipo_Cuenta(String tipo_Cuenta) {
		this.tipo_Cuenta = tipo_Cuenta;
	}

	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String string) {
		this.fecha_creacion = string;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
}
