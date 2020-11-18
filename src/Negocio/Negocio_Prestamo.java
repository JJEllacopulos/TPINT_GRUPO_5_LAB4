package Negocio;

import Dao.Dao_Prestamo;
import Entidad.Cuenta;
import Entidad.Prestamo;

public class Negocio_Prestamo {
	
	private Dao_Prestamo dao_prestamo = new Dao_Prestamo();
	
	public void SPNuevo_Prestamo(Prestamo prestamo) {
		dao_prestamo.SPNuevoPrestamo(prestamo);
	}
	
}
