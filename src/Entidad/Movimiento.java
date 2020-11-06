package Entidad;

import java.util.Date;

public class Movimiento {
	
	//Campos
	private int id_movimiento;
	private String cbu_cuenta;
	private String tipo_movimiento;
	private Date fecha_creacion;
	private String detalles;
	private Double importe;
	
	//Constructores
	public Movimiento() {
		
	}


	public Movimiento(int id_movimiento, String cbu_cuenta, String tipo_movimiento, Date fecha_creacion, String detalles, Double importe) {
		
		this.id_movimiento = id_movimiento;
		this.cbu_cuenta = cbu_cuenta;
		this.tipo_movimiento = tipo_movimiento;
		this.fecha_creacion = fecha_creacion;
		this.detalles = detalles;
		this.importe = importe;
	}

	//Gets y sets
	public int getId_movimiento() {
		return id_movimiento;
	}


	public void setId_movimiento(int id_movimiento) {
		this.id_movimiento = id_movimiento;
	}


	public String getCbu_cuenta() {
		return cbu_cuenta;
	}


	public void setCbu_cuenta(String cbu_cuenta) {
		this.cbu_cuenta = cbu_cuenta;
	}


	public String getTipo_movimiento() {
		return tipo_movimiento;
	}


	public void setTipo_movimiento(String tipo_movimiento) {
		this.tipo_movimiento = tipo_movimiento;
	}


	public Date getFecha_creacion() {
		return fecha_creacion;
	}


	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}


	public String getDetalles() {
		return detalles;
	}


	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}


	public Double getImporte() {
		return importe;
	}


	public void setImporte(Double importe) {
		this.importe = importe;
	}
	
}
