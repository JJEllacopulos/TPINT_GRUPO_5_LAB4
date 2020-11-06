package Entidad;

public class TipoCuenta {
	
	//Campos
	private String tipo_cuenta;
	private String descripcion;
	
	//Constructores
	public TipoCuenta() {
		
	}
	
	public TipoCuenta(String tipo_cuenta, String descripcion) {
		
		this.tipo_cuenta = tipo_cuenta;
		this.descripcion = descripcion;
	}
	
	//Gets y sets
	public String getTipo_cuenta() {
		return tipo_cuenta;
	}

	public void setTipo_cuenta(String tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
