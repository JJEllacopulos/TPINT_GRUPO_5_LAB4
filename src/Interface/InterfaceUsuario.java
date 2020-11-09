package Interface;
import java.util.ArrayList;
import Dao.Dao_Usuario;
import Entidad.Contacto;
import Entidad.Direccion;
import Entidad.Usuario;

public interface InterfaceUsuario {
	
	public void SPAltaUsuario(Usuario usuario, String fecha);
	public void SPAltaDireccionUsuario(Direccion direccion);
	public void SPAltaContactoUsuario(Contacto contacto);
}
