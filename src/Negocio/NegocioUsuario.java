package Negocio;

import java.util.ArrayList;
import java.util.List;
import Dao.Dao_Usuario;
import Entidad.Contacto;
import Entidad.Direccion;
import Entidad.Usuario;
import Interface.InterfaceUsuario;

public class NegocioUsuario implements InterfaceUsuario {

	private Dao_Usuario daoUsuario = new Dao_Usuario();
	
	
	@Override
	public void SPAltaUsuario(Usuario usuario, String fecha) {
		// TODO Auto-generated method stub
		daoUsuario.SPAltaUsuario(usuario, fecha);
		
	}

	@Override
	public void SPAltaDireccionUsuario(Direccion direccion) {
		// TODO Auto-generated method stub
		daoUsuario.SPAltaDireccionUsuario(direccion);
	}


	@Override
	public void SPAltaContactoUsuario(Contacto contacto) {
		// TODO Auto-generated method stub
		daoUsuario.SPAltaContactoUsuario(contacto);
	}

	@Override
	public ArrayList<Usuario> Obtener_lista_usuarios() {
		ArrayList<Usuario> lista = daoUsuario.Obtener_lista_usuarios();
		return lista;
	}

	@Override
	public void SPModificarUsuario(Usuario usuario, String fecha) {
		// TODO Auto-generated method stub
		daoUsuario.SPModificarUsuario(usuario, fecha);
	}

	@Override
	public void SPModificarDireccionUsuario(Direccion direccion) {
		// TODO Auto-generated method stub
		daoUsuario.SPModificarDireccionUsuario(direccion);
	}

	@Override
	public void SPModificarContactoUsuario(Contacto contacto) {
		// TODO Auto-generated method stub
		daoUsuario.SPModificarContactoUsuario(contacto);
	}

	@Override
	public Usuario Obtener_usuario(String nombreUsuario) {
	Usuario usuario = new Usuario();
		usuario = daoUsuario.Obtener_usuario(nombreUsuario);
		
		// TODO Auto-generated method stub
		return usuario;
	}

	

	

}
