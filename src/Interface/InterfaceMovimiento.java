package Interface;

import java.util.ArrayList;

import Entidad.Movimiento;

public interface InterfaceMovimiento {
	
	public void SPAltaMovimiento(Movimiento movimiento, String fecha);
	public int SPObtenerUltimoId();
	public ArrayList<Movimiento> Obtener_Lista_Movimientos(String cbuNombre);
}
