package Interface;
import java.util.ArrayList;
import Dao.Dao_Cuentas;
import Entidad.Cuenta;



public interface InterfaceCuentas {	

	public void SPAltaCuenta(Cuenta cuenta);
	public ArrayList<Cuenta> Obtener_lista_CuentasCliente();
	public ArrayList<Cuenta> Obtener_todasLasCuentas () ;

}
