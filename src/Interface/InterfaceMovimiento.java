package Interface;

import Entidad.Movimiento;

public interface InterfaceMovimiento {
	
	public void SPAltaMovimiento(Movimiento movimiento, String fecha);
	public int SPObtenerUltimoId();
}
