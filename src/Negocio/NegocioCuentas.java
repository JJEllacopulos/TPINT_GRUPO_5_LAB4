package Negocio;

import java.util.ArrayList;
import java.util.List;
import Dao.Dao_Cuentas;
import Entidad.Cuenta;
import Entidad.Usuario;
import Interface.InterfaceCuentas;


public class NegocioCuentas implements InterfaceCuentas {

	private Dao_Cuentas daoCuentas = new Dao_Cuentas();
	
	@Override
	public void SPAltaCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		daoCuentas.SPAltaCuenta(cuenta);
	}
	
	@Override
	public ArrayList<Cuenta> Obtener_lista_CuentasCliente() {
		ArrayList<Cuenta> lista = daoCuentas.Obtener_lista_CuentasCliente();
		return lista;
	}

	@Override
	public ArrayList<Cuenta> Obtener_todasLasCuentas() {
		ArrayList<Cuenta> lista = daoCuentas.Obtener_todasLasCuentas ();
		return lista;
		
	}
	@Override
	public void SPModificarCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		daoCuentas.SPModificarCuenta(cuenta);
		
	}
	@Override
	public Cuenta Obtener_cuenta(String cbuCuenta) {
		// TODO Auto-generated method stub
		Cuenta cuenta = new Cuenta();
		cuenta = daoCuentas.Obtener_cuenta(cbuCuenta);
		return cuenta;
	}


}
