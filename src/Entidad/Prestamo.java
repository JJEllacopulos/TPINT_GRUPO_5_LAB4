package Entidad;

import java.util.Date;

public class Prestamo {
	
	//Campos
	private int id_prestamo;
	private String cbu_cuenta_deudor;
	private Double inporte_pedido;
	private Double inporte_con_intereses;
	private Date plazo_de_pago;
	private Double pago_x_mes;
	private Double monto_actual;
	private int cantidad_cuotas;
	private int cuotas_a_pagar;
	private boolean aprobacion;
	private boolean estado;
	
	//Constructores
	public Prestamo() {
		
	}

	public Prestamo(int id_prestamo, String cbu_cuenta_deudor, Double inporte_pedido, Double inporte_con_intereses, Date plazo_de_pago, Double pago_x_mes, Double monto_actual, int cantidad_cuotas,boolean aprobacion, boolean estado, int cuotas_a_pagar) {
		
		this.id_prestamo = id_prestamo;
		this.cbu_cuenta_deudor = cbu_cuenta_deudor;
		this.inporte_pedido = inporte_pedido;
		this.inporte_con_intereses = inporte_con_intereses;
		this.plazo_de_pago = plazo_de_pago;
		this.pago_x_mes = pago_x_mes;
		this.monto_actual = monto_actual;
		this.cantidad_cuotas = cantidad_cuotas;
		this.cuotas_a_pagar = cuotas_a_pagar;
		this.aprobacion = aprobacion;
		this.estado = estado;
	}
	
	//Gets y sets
	public int getId_prestamo() {
		return id_prestamo;
	}

	public void setId_prestamo(int id_prestamo) {
		this.id_prestamo = id_prestamo;
	}

	public String getCbu_cuenta_deudor() {
		return cbu_cuenta_deudor;
	}

	public void setCbu_cuenta_deudor(String cbu_cuenta_deudor) {
		this.cbu_cuenta_deudor = cbu_cuenta_deudor;
	}

	public Double getInporte_pedido() {
		return inporte_pedido;
	}

	public void setInporte_pedido(Double inporte_pedido) {
		this.inporte_pedido = inporte_pedido;
	}

	public Double getInporte_con_intereses() {
		return inporte_con_intereses;
	}

	public void setInporte_con_intereses(Double inporte_con_intereses) {
		this.inporte_con_intereses = inporte_con_intereses;
	}

	public Date getPlazo_de_pago() {
		return plazo_de_pago;
	}

	public void setPlazo_de_pago(Date plazo_de_pago) {
		this.plazo_de_pago = plazo_de_pago;
	}

	public Double getPago_x_mes() {
		return pago_x_mes;
	}

	public void setPago_x_mes(Double pago_x_mes) {
		this.pago_x_mes = pago_x_mes;
	}
	
	public Double getMonto_actual() {
		return monto_actual;
	}

	public void setMonto_actual(Double monto_actual) {
		this.monto_actual = monto_actual;
	}

	public int getCantidad_cuotas() {
		return cantidad_cuotas;
	}

	public void setCantidad_cuotas(int cantidad_cuotas) {
		this.cantidad_cuotas = cantidad_cuotas;
	}
	
	public int getCuotas_a_pagar() {
		return cuotas_a_pagar;
	}

	public void setCuotas_a_pagar(int cuotas_a_pagar) {
		this.cuotas_a_pagar = cuotas_a_pagar;
	}
	
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public boolean getAprobacion() {
		return aprobacion;
	}

	public void setAprobacion(boolean aprobacion) {
		this.aprobacion = aprobacion;
	}
	
}
