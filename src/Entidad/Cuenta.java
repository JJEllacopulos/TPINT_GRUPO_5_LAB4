package Entidad;

import java.util.Date;

public class Cuenta {
	
	int id;
	TipoCuenta tipoCuenta;
	Usuario usuario;
	Date Fecha;
	String  Cbu;
	Double Saldo;
	
	public Cuenta() {
		id=0;
		tipoCuenta = new TipoCuenta();
		usuario = new Usuario();
		Fecha = new Date();
		Cbu = "";
		Saldo = 0.0;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public String getCbu() {
		return Cbu;
	}
	public void setCbu(String cbu) {
		Cbu = cbu;
	}
	public Double getSaldo() {
		return Saldo;
	}
	public void setSaldo(Double saldo) {
		Saldo = saldo;
	}
	

}
