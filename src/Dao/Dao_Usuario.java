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
	private String dbName = "banco";
	

	public void SPAltaUsuario(Usuario usuario, String fecha)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection cn = null;
		  try
		  {
			 cn = DriverManager.getConnection(host+dbName, user,pass);
			 CallableStatement cst = cn.prepareCall("CALL PRO_ingresar_datos_usuario(?,?,?,?,?,?,?,?,?,?,?)");
			 cst.setString(1, usuario.getNombre_usuario());
			 cst.setString(2, usuario.getDni());
			 cst.setString(3, usuario.getNombre_real());
			 cst.setString(4, usuario.getApellido_real());
			 cst.setString(5, usuario.getTipo_usuario());
			 cst.setString(6, usuario.getPassword());
			 cst.setString(7, usuario.getCuil());
			 cst.setString(8, usuario.getSexo());
			 cst.setString(9, usuario.getNacionalidad());
			 cst.setDate(10, java.sql.Date.valueOf(fecha));
			 cst.setBoolean(11, usuario.getEstado());
			 cst.execute();
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}
			
	}

	public void SPAltaDireccionUsuario(Direccion direccion)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection cn = null;
		  try
		  {
			 cn = DriverManager.getConnection(host+dbName, user,pass);
			 CallableStatement cst = cn.prepareCall("CALL PRO_ingresar_direccion(?,?,?,?,?,?)");
			 cst.setString(1, direccion.getNombre_usuario());
			 cst.setString(2, direccion.getAltura());
			 cst.setString(3, direccion.getCalle());
			 cst.setString(4, direccion.getLocalidad());
			 cst.setString(5, direccion.getProvincia());
			 cst.setString(6, direccion.getPais());
			 cst.execute();
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	/*
	 	CREATE PROCEDURE PRO_ingresar_contacto(
		
		ing_nombre_usuario VARCHAR(25),
		ing_email VARCHAR(50),
		ing_telefono VARCHAR(25)
		 */
	public void SPAltaContactoUsuario(Contacto contacto)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection cn = null;
		  try
		  {
			 cn = DriverManager.getConnection(host+dbName, user,pass);
			 CallableStatement cst = cn.prepareCall("CALL PRO_ingresar_contacto(?,?,?)");
			 cst.setString(1, contacto.getNombre_usuario());
			 cst.setString(2, contacto.getEmail());
			 cst.setString(3, contacto.getTelefono());
		
			 cst.execute();
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
public ArrayList<Usuario> Obtener_lista_usuarios () {
		
		
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ArrayList<Usuario> x = new ArrayList<Usuario>();
		
		Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(host+dbName, user,pass);
			CallableStatement st = cn.prepareCall("CALL PRO_Listar_usuario_full");
			
			
			ResultSet resultado = st.executeQuery();
			/*  
 nombre_usuario, dni_usuario, nombre_real, apellido_real, contraseña_usuario, cuil_usuario, sexo, nacionalidad, fecha_nacimiento,
calle, altura, localidad, provincia, pais,
email, telefono
			 */
			while(resultado.next()){
				
				Direccion direccion = new Direccion();
				Contacto contacto = new Contacto();
				Usuario aux = new Usuario();
				aux.setNombre_usuario(resultado.getString("nombre_usuario"));
				aux.setDni(resultado.getString("dni_usuario"));
				aux.setNombre_real(resultado.getString("nombre_real"));
				aux.setApellido_real(resultado.getString("apellido_real"));
				aux.setPassword(resultado.getString("contraseña_usuario"));
				aux.setCuil(resultado.getString("cuil_usuario"));
				aux.setSexo(resultado.getString("sexo"));
				aux.setNacionalidad(resultado.getString("nacionalidad"));
				aux.setFecha_nacimiento(resultado.getDate("fecha_nacimiento"));
				direccion.setAltura(resultado.getString("altura"));
				direccion.setCalle(resultado.getString("calle"));
				direccion.setLocalidad(resultado.getString("localidad"));
				direccion.setProvincia(resultado.getString("provincia"));
				direccion.setPais(resultado.getString("pais"));
				contacto.setEmail(resultado.getString("email"));
				contacto.setTelefono(resultado.getString("telefono"));
				
				aux.setDireccion(direccion); 
				aux.setContacto(contacto); 
				
				x.add(aux);
				
			}
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return x;
		
	}


public Usuario Obtener_usuario (String nombreUsuario) {
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Usuario aux = new Usuario();
		Direccion direccion = new Direccion();
		Contacto contacto = new Contacto();
		Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(host+dbName, user,pass);
			CallableStatement st = cn.prepareCall("CALL PRO_Obtener_usuario(?)");
			 st.setString(1, nombreUsuario);
			 
			
			ResultSet resultado = st.executeQuery();

			while(resultado.next()){
				aux.setNombre_usuario(resultado.getString("nombre_usuario"));
				aux.setDni(resultado.getString("dni_usuario"));
				aux.setNombre_real(resultado.getString("nombre_real"));
				aux.setApellido_real(resultado.getString("apellido_real"));
				aux.setPassword(resultado.getString("contraseña_usuario"));
				aux.setCuil(resultado.getString("cuil_usuario"));
				aux.setSexo(resultado.getString("sexo"));
				aux.setNacionalidad(resultado.getString("nacionalidad"));
				aux.setFecha_nacimiento(resultado.getDate("fecha_nacimiento"));
				direccion.setAltura(resultado.getString("altura"));
				direccion.setCalle(resultado.getString("calle"));
				direccion.setLocalidad(resultado.getString("localidad"));
				direccion.setProvincia(resultado.getString("provincia"));
				direccion.setPais(resultado.getString("pais"));
				contacto.setEmail(resultado.getString("email"));
				contacto.setTelefono(resultado.getString("telefono"));
				
				aux.setDireccion(direccion); 
				aux.setContacto(contacto); 
				
				
			}
				
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return aux;
		
	}



public void SPModificarUsuario(Usuario usuario, String fecha)
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Connection cn = null;
	  try
	  {
		 cn = DriverManager.getConnection(host+dbName, user,pass);
		 CallableStatement cst = cn.prepareCall("CALL PRO_Alterar_usuario(?,?,?,?,?,?,?,?,?,?)");
		 cst.setString(1, usuario.getNombre_usuario());
		 cst.setString(2, usuario.getDni());
		 cst.setString(3, usuario.getNombre_real());
		 cst.setString(4, usuario.getApellido_real());
		 cst.setString(5, usuario.getTipo_usuario());
		 cst.setString(6, usuario.getPassword());
		 cst.setString(7, usuario.getCuil());
		 cst.setString(8, usuario.getSexo());
		 cst.setString(9, usuario.getNacionalidad());
		 cst.setDate(10, java.sql.Date.valueOf(fecha));
		 
		 cst.execute();
	  }
	  catch (Exception e) {
		e.printStackTrace();
	}
		
}

public void SPModificarDireccionUsuario(Direccion direccion)
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Connection cn = null;
	  try
	  {
		 cn = DriverManager.getConnection(host+dbName, user,pass);
		 CallableStatement cst = cn.prepareCall("CALL PRO_Alterar_direccion(?,?,?,?,?,?)");
		 cst.setString(1, direccion.getNombre_usuario());
		 cst.setString(2, direccion.getAltura());
		 cst.setString(3, direccion.getCalle());
		 cst.setString(4, direccion.getLocalidad());
		 cst.setString(5, direccion.getProvincia());
		 cst.setString(6, direccion.getPais());
		 cst.execute();
	
	  }
	  catch (Exception e) {
		e.printStackTrace();
	}
		
}

public void SPModificarContactoUsuario(Contacto contacto)
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Connection cn = null;
	  try
	  {
		 cn = DriverManager.getConnection(host+dbName, user,pass);
		 CallableStatement cst = cn.prepareCall("CALL PRO_Alterar_contacto(?,?,?)");
		 cst.setString(1, contacto.getNombre_usuario());
		 cst.setString(2, contacto.getEmail());
		 cst.setString(3, contacto.getTelefono());
	
		 cst.execute();
	  }
	  catch (Exception e) {
		e.printStackTrace();
	}
		
}





}

