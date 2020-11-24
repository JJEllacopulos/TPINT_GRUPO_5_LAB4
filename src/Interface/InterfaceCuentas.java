package Interface;
import java.util.ArrayList;
import Dao.Dao_Cuentas;
import Entidad.Cuenta;
import Entidad.TipoCuenta;



public interface InterfaceCuentas {	

	public int SPAltaCuenta(Cuenta cuenta);
	public int SPModificarCuenta(Cuenta cuenta);
	public ArrayList<Cuenta> Obtener_lista_CuentasCliente();
	public ArrayList<Cuenta> Obtener_todasLasCuentas () ;
	public Cuenta Obtener_cuenta(String cbuCuenta);
	public int Eliminar_cuenta(String cbuCuenta);
	public ArrayList<TipoCuenta> Obtener_TipoCuentas();
	public ArrayList<Cuenta> Obtener_Datos_Cuenta(String nombre_usuario);
	public ArrayList<Cuenta> Obtener_cuentas_activas(String tipoCuenta1, String tipoCuenta2);
	boolean StringIsNumeric(String nombre_usuario);
	public int Existe_Alias_cuenta(String cbuCuenta, String alias);
}
