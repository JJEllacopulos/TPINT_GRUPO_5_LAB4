package Negocio;

import java.util.ArrayList;
import java.util.List;
import Dao.Dao_Usuario;
import Entidad.Usuario;
import Interface.InterfaceUsuario;

public class NegocioUsuario implements InterfaceUsuario {

	private Dao_Usuario daoUsuario = new Dao_Usuario();
	
	@Override
	public void SPAltaUsuario(Usuario usuario, String fecha) {
		// TODO Auto-generated method stub
		daoUsuario.SPAltaUsuario(usuario, fecha);
		
	}
	

}
