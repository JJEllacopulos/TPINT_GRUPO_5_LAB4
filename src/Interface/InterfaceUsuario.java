package Interface;
import java.util.ArrayList;
import Dao.Dao_Usuario;
import Entidad.Contacto;
import Entidad.Direccion;
import Entidad.Usuario;

public interface InterfaceUsuario {
	
	public int SPAltaUsuario(Usuario usuario, String fecha);
	public void SPAltaDireccionUsuario(Direccion direccion);
	public void SPAltaContactoUsuario(Contacto contacto);
	public ArrayList<Usuario> Obtener_lista_usuarios ();
	public int SPModificarUsuario(Usuario usuario, String fecha);
	public void SPModificarDireccionUsuario(Direccion direccion);
	public void SPModificarContactoUsuario(Contacto contacto);
	
	public Usuario Obtener_usuario (String nombreUsuario);
	public boolean Verificar_usuario (String nombreUsuario, String contraseņaUsuario);
	
	public int SPEliminarUsuario(String usuarioNombre);
	public void SPEliminarDireccionUsuario(String usuarioNombre);
	public void SPEliminarContactoUsuario(String usuarioNombre);
	boolean StringIsNumeric(String nombre_usuario);
}