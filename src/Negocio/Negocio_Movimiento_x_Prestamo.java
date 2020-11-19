package Negocio;

import Dao.Dao_Movimiento_x_Prestamo;
import Entidad.Movimiento_x_Prestamo;
import Entidad.Prestamo;

public class Negocio_Movimiento_x_Prestamo {
	
	Dao_Movimiento_x_Prestamo dao_Movimiento_x_Prestamo = new Dao_Movimiento_x_Prestamo();
	
	public void SPAlta_movimieto_x_prestamo(Movimiento_x_Prestamo movimiento_x_Prestamo) {
		
		dao_Movimiento_x_Prestamo.SPAltaMovimiento_x_Prestamo(movimiento_x_Prestamo);
		
	}
	
}
