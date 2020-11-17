package Negocio;

import java.util.ArrayList;

import Dao.Dao_Cuentas;
import Dao.Dao_Movimiento;
import Entidad.Movimiento;
import Interface.InterfaceMovimiento;

public class NegocioMovimiento implements InterfaceMovimiento{
	private Dao_Movimiento daoMovimiento = new Dao_Movimiento();
	
	@Override
	public void SPAltaMovimiento(Movimiento movimiento, String fecha) {
		
		// TODO Auto-generated method stub
		daoMovimiento.SPAltaMovimiento(movimiento, fecha);
	}
	
	@Override
	public int SPObtenerUltimoId() {		
		// TODO Auto-generated method stub
		return daoMovimiento.SPObtenerUltimoId();
	}

	@Override
	public ArrayList<Movimiento> Obtener_Lista_Movimientos(String cbuNombre) {
		// TODO Auto-generated method stub
		ArrayList<Movimiento> listaMovimientos = new ArrayList<Movimiento>();
		listaMovimientos = daoMovimiento.Obtener_Lista_Movimientos(cbuNombre);
		return listaMovimientos;
	}

}

