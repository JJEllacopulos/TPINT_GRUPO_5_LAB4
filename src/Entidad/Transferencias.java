package Entidad;

import java.util.Date;

public class Transferencias {
	
	//Campos
	private int id_transferencia;
	private int id_movimiento;
	private String cbu_cuenta_destino;
	
	//Constructores
	public Transferencias() {
		
	}

	public Transferencias(int id_transferencia, int id_movimiento, String cbu_cuenta_destino) {
		
		this.id_transferencia = id_transferencia;
		this.id_movimiento = id_movimiento;
		this.cbu_cuenta_destino = cbu_cuenta_destino;
	}

	//Gets y sets
	public int getId_transferencia() {
		return id_transferencia;
	}

	public void setId_transferencia(int id_transferencia) {
		this.id_transferencia = id_transferencia;
	}

	public int getId_movimiento() {
		return id_movimiento;
	}

	public void setId_movimiento(int id_movimiento) {
		this.id_movimiento = id_movimiento;
	}

	public String getCbu_cuenta_destino() {
		return cbu_cuenta_destino;
	}

	public void setCbu_cuenta_destino(String cbu_cuenta_destino) {
		this.cbu_cuenta_destino = cbu_cuenta_destino;
	}
	
}
