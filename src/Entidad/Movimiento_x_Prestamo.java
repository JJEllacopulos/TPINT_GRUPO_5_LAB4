package Entidad;

public class Movimiento_x_Prestamo {
	
	//Campos
	private int id_movimiento;
	private int id_prestamo;
	
	//Constructores
	public Movimiento_x_Prestamo() {
		
	}

	public Movimiento_x_Prestamo(int id_movimiento, int id_prestamo) {
		
		this.id_movimiento = id_movimiento;
		this.id_prestamo = id_prestamo;
	}
	
	//Gets y sets
	public int getId_movimiento() {
		return id_movimiento;
	}

	public void setId_movimiento(int id_movimiento) {
		this.id_movimiento = id_movimiento;
	}

	public int getId_prestamo() {
		return id_prestamo;
	}

	public void setId_prestamo(int id_prestamo) {
		this.id_prestamo = id_prestamo;
	}
	
	
}
