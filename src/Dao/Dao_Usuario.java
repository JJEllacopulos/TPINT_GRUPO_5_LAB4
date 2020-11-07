package Dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import Entidad.Usuario;
import Entidad.Contacto;
import Entidad.Direccion;
import Entidad.TipoUsuario;


public class Dao_Usuario {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "ROOT";
	private String dbName = "Banco";
	

	public void SPAltaUsuario(Usuario usuario)
	{
		Connection cn = null;
		  try
		  {
			 cn = DriverManager.getConnection(host+dbName,user,pass);
			 CallableStatement cst = cn.prepareCall("CALL crearUsuario(?,?,?,?,?,?,?,?,?,?,?)");
			 cst.setString(1, usuario.getNombre_usuario());
			 cst.setString(2, usuario.getDni());
			 cst.setString(3, usuario.getNombre_real());
			 cst.setString(4, usuario.getApellido_real());
			 cst.setString(5, usuario.getTipo_usuario());
			 cst.setString(6, usuario.getPassword());
			 cst.setString(7, usuario.getCuil());
			 cst.setString(8, usuario.getSexo());
			 cst.setString(9, usuario.getNacionalidad());
			 cst.setDate(10, (java.sql.Date) usuario.getFecha_nacimiento());
			 cst.setBoolean(11, usuario.getEstado());
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	


}

