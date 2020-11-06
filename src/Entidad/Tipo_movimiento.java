package Entidad;

public class Tipo_movimiento {
	
	//Campos
	private String tipo_movimiento;
	private String descripcion;
	
	//Constructores
	public Tipo_movimiento() {
		
	}
	
	public Tipo_movimiento(String tipo_movimiento, String descripcion) {
		
		this.tipo_movimiento = tipo_movimiento;
		this.descripcion = descripcion;
	}
	
	//Gets y sets
	public String getTipo_movimiento() {
		return tipo_movimiento;
	}

	public void setTipo_movimiento(String tipo_movimiento) {
		this.tipo_movimiento = tipo_movimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
