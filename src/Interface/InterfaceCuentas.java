package Interface;
import java.util.ArrayList;
import Dao.Dao_Cuentas;
import Entidad.Cuenta;
import Entidad.TipoCuenta;



public interface InterfaceCuentas {	

	public void SPAltaCuenta(Cuenta cuenta);
	public void SPModificarCuenta(Cuenta cuenta);
	public ArrayList<Cuenta> Obtener_lista_CuentasCliente();
	public ArrayList<Cuenta> Obtener_todasLasCuentas () ;
	public Cuenta Obtener_cuenta(String cbuCuenta);
	public void Eliminar_cuenta(String cbuCuenta);
	public ArrayList<TipoCuenta> Obtener_TipoCuentas();
	public ArrayList<Cuenta> Obtener_Datos_Cuenta(String nombre_usuario);
	boolean StringIsNumeric(String nombre_usuario);
}
