package Negocio;

import java.util.ArrayList;
import java.util.List;
import Dao.Dao_Cuentas;
import Entidad.Cuenta;
import Entidad.TipoCuenta;
import Entidad.Usuario;
import Interface.InterfaceCuentas;


public class NegocioCuentas implements InterfaceCuentas {

	private Dao_Cuentas daoCuentas = new Dao_Cuentas();
	
	@Override
	public int SPAltaCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		int filas = 0;
		filas = daoCuentas.SPAltaCuenta(cuenta);
		return filas;
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
	public int SPModificarCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		int filas = 0;
		filas = daoCuentas.SPModificarCuenta(cuenta);
		return filas;
	}
	@Override
	public Cuenta Obtener_cuenta(String cbuCuenta) {
		// TODO Auto-generated method stub
		Cuenta cuenta = new Cuenta();
		cuenta = daoCuentas.Obtener_cuenta(cbuCuenta);
		return cuenta;
	}

	@Override
	public int Eliminar_cuenta(String cbuCuenta) {
		// TODO Auto-generated method stub
		int filas = 0;
		filas =  daoCuentas.SPEliminarCuenta(cbuCuenta);
		return filas;
	}

	@Override
	public ArrayList<TipoCuenta> Obtener_TipoCuentas() {
		// TODO Auto-generated method stub
		ArrayList<TipoCuenta> listaTipoCuenta = new ArrayList<TipoCuenta>();
		listaTipoCuenta = daoCuentas.Obtener_TipoCuentas();
		return listaTipoCuenta;
	}
	
	@Override
	public ArrayList<Cuenta> Obtener_Datos_Cuenta(String nombre_usuario) {
		// TODO Auto-generated method stub
		ArrayList<Cuenta> listaTipoCuenta = new ArrayList<Cuenta>();
		listaTipoCuenta = daoCuentas.Obtener_Datos_Cuenta(nombre_usuario);
		return listaTipoCuenta;
	}
	
	@Override
	public ArrayList<Cuenta> Obtener_cuentas_activas(String tipoCuenta1, String tipoCuenta2) {
		ArrayList<Cuenta> lista = daoCuentas.Obtener_cuentas_activas( tipoCuenta1, tipoCuenta2);
		return lista;
	}
	
	@Override
	public boolean StringIsNumeric(String nombre_usuario) {
		try {
			Integer.parseInt(nombre_usuario);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}	
	}
	
	@Override
	public int Existe_Alias_cuenta(String cbuCuenta,String alias) {
		// TODO Auto-generated method stub
		int filas = 0;
		filas = daoCuentas.Existe_Alias_cuenta(cbuCuenta,alias);
		return filas;
	}
	
	

}
