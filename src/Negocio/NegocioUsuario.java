package Negocio;

import java.util.ArrayList;
import java.util.List;
import Dao.Dao_Usuario;
import Entidad.Contacto;
import Entidad.Direccion;
import Entidad.Localidad;
import Entidad.Provincias;
import Entidad.Usuario;
import Interface.InterfaceUsuario;

public class NegocioUsuario implements InterfaceUsuario {

	private Dao_Usuario daoUsuario = new Dao_Usuario();
	
	public NegocioUsuario() {
		
	}

	@Override
	public int SPAltaUsuario(Usuario usuario, String fecha) {
		// TODO Auto-generated method stub
		int filas = daoUsuario.SPAltaUsuario(usuario, fecha);
		return filas;
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
	
	@Override
	public boolean Verificar_usuario(String nombreUsuario, String contraseņaUsuario) {
		
		return daoUsuario.Confirmar_usuario(nombreUsuario, contraseņaUsuario);
	}


	@Override
	public void SPEliminarDireccionUsuario(String usuarioNombre) {
		// TODO Auto-generated method stub
		daoUsuario.SPEliminarDireccionUsuario(usuarioNombre);
	}

	@Override
	public void SPEliminarContactoUsuario(String usuarioNombre) {
		// TODO Auto-generated method stub
		daoUsuario.SPEliminarContactoUsuario(usuarioNombre);
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
	public int SPModificarUsuario(Usuario usuario, String fecha) {
		// TODO Auto-generated method stub
		int filas = 0;
		filas = daoUsuario.SPModificarUsuario(usuario, fecha);
		return filas;
	}

	@Override
	public int SPEliminarUsuario(String usuarioNombre) {
		// TODO Auto-generated method stub
		int filas = 0;
		filas = daoUsuario.SPEliminarUsuario(usuarioNombre);
		
		return filas;
	}

	@Override
	public ArrayList<Localidad> Listar_Localidades(int idProvincia) {
		ArrayList<Localidad> localidad = daoUsuario.Listar_Localidades(idProvincia);
		
		return localidad;
	}

	@Override
	public ArrayList<Provincias> Listar_Provincias() {
		ArrayList<Provincias> provincias = daoUsuario.Listar_Provincias();
		
		return provincias;
	}

	

}
