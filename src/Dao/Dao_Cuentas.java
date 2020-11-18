package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import Entidad.Contacto;
import Entidad.Cuenta;
import Entidad.TipoCuenta;
import Entidad.Direccion;
import Entidad.Usuario;



public class Dao_Cuentas {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "ROOT";
	private String dbName = "banco";

	public void SPAltaCuenta(Cuenta cuenta)
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

			 CallableStatement cst = cn.prepareCall("CALL PRO_ingresar_cuenta(?,?,?,?,?,?)");
			 cst.setString(1, cuenta.getCbu_cuenta() ); 
			 cst.setString(2,  cuenta.getNombre_usuario());
			 cst.setString(3, cuenta.getTipo_Cuenta() );//cuenta.getTipo_Cuenta()
			 cst.setString(4, cuenta.getFecha_creacion()); 
			 cst.setString(5, cuenta.getSaldo().toString() ); 
			 cst.setBoolean(6, true); 


			 cst.execute();
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	public void SPModificarCuenta(Cuenta cuenta)
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
			 CallableStatement cst = cn.prepareCall("CALL PRO_Alterar_cuenta(?,?,?,?,?)");
			 cst.setString(1, cuenta.getCbu_cuenta());
			 cst.setString(2, cuenta.getNombre_usuario());
			 cst.setString(3, cuenta.getTipo_Cuenta());
			 cst.setString(4, cuenta.getFecha_creacion().toString());
			 cst.setString(5, cuenta.getSaldo().toString());
		

			 cst.execute();
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	
	public ArrayList<Cuenta> Obtener_lista_CuentasCliente () {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Cuenta> x = new ArrayList<Cuenta>();
			
			Connection cn = null;
			
			try {
				
				cn = DriverManager.getConnection(host+dbName, user,pass);
				CallableStatement st = cn.prepareCall("CALL PRO_Listar_Cuenta");
							
				ResultSet resultado = st.executeQuery();
				/*  
	 c.cbu_cuenta, c.nombre_usuario, c.tipo_cuenta, c.fecha_creacion, c.saldo, c.estado 
				 */
				while(resultado.next()){
					
					Cuenta aux = new Cuenta();
					aux.setCbu_cuenta(resultado.getString("cbu_cuenta"));
					aux.setNombre_usuario(resultado.getString("nombre_usuario"));
					aux.setTipo_Cuenta(resultado.getString("tipo_cuenta"));
					aux.setFecha_creacion(resultado.getString("fecha_creacion"));
					aux.setSaldo(resultado.getDouble("saldo"));
					aux.setEstado(resultado.getBoolean("estado"));
					
					x.add(aux);
					
				}
				
			}
			catch(Exception e) {
				
				e.printStackTrace();
				
			}
			
			return x;	
		}
	
public ArrayList<Cuenta> Obtener_todasLasCuentas () {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Cuenta> x = new ArrayList<Cuenta>();
			
			Connection cn = null;
			
			try {
				
				cn = DriverManager.getConnection(host+dbName, user,pass);
				CallableStatement st = cn.prepareCall("CALL PRO_Listar_cuenta");
							
				ResultSet resultado = st.executeQuery();
				/*  
	 c.cbu_cuenta, c.nombre_usuario, c.tipo_cuenta, c.fecha_creacion, c.saldo, c.estado 
				 */
				while(resultado.next()){
					
					Cuenta aux = new Cuenta();
					aux.setCbu_cuenta(resultado.getString("cbu_cuenta"));
					aux.setNombre_usuario(resultado.getString("nombre_usuario"));
					aux.setTipo_Cuenta(resultado.getString("tipo_cuenta"));
					aux.setFecha_creacion(resultado.getString("fecha_creacion"));
					aux.setSaldo(resultado.getDouble("saldo"));
					aux.setEstado(resultado.getBoolean("estado"));
					
					x.add(aux);
					
				}
				
			}
			catch(Exception e) {
				
				e.printStackTrace();
				
			}
			
			return x;	
		}

public Cuenta Obtener_cuenta(String cbuCuenta) {
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Cuenta aux = new Cuenta();
		
		Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(host+dbName, user,pass);
			CallableStatement st = cn.prepareCall("CALL PRO_Buscar_cuenta(?)");
			 st.setString(1, cbuCuenta);
			 
			
			ResultSet resultado = st.executeQuery();

			while(resultado.next()){
	
				aux.setCbu_cuenta(resultado.getString("cbu_cuenta"));
				aux.setNombre_usuario(resultado.getString("nombre_usuario"));
				aux.setTipo_Cuenta(resultado.getString("tipo_cuenta"));
				aux.setFecha_creacion(resultado.getString("fecha_creacion"));
				aux.setSaldo(resultado.getDouble("saldo"));
				aux.setEstado(resultado.getBoolean("estado"));
				
				
			}
				
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return aux;
		
	}

public void SPEliminarCuenta(String CBUcuenta)
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
		 CallableStatement cst = cn.prepareCall("CALL PRO_Desabilitar_cuenta(?)");
		 cst.setString(1, CBUcuenta);
	
		 cst.execute();
	  }
	  catch (Exception e) {
		e.printStackTrace();
	}
		
}

public ArrayList<TipoCuenta> Obtener_TipoCuentas() {
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ArrayList<TipoCuenta> x = new ArrayList<TipoCuenta>();
		
		Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(host+dbName, user,pass);
			CallableStatement st = cn.prepareCall("CALL PRO_Listar_TipoCuenta");
						
			ResultSet resultado = st.executeQuery();
			/*  
 c.cbu_cuenta, c.nombre_usuario, c.tipo_cuenta, c.fecha_creacion, c.saldo, c.estado 
			 */
			while(resultado.next()){
				
				TipoCuenta aux = new TipoCuenta();
				aux.setTipo_cuenta(resultado.getString("tipo_cuenta"));
				aux.setDescripcion(resultado.getString("descripcion"));

				
				x.add(aux);
				
			}
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return x;	
	}

public ArrayList<Cuenta> Obtener_Datos_Cuenta (String nombre_usuario) {
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ArrayList<Cuenta> x = new ArrayList<Cuenta>();
		
		Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(host+dbName, user,pass);
			CallableStatement st = cn.prepareCall("CALL PRO_Buscar_Datos_cuenta(?)");
			 st.setString(1, nombre_usuario );
			ResultSet resultado = st.executeQuery();
			/*  
 c.cbu_cuenta, c.nombre_usuario, c.tipo_cuenta, c.fecha_creacion, c.saldo, c.estado 
			 */
			while(resultado.next()){
				
				Cuenta aux = new Cuenta();
				aux.setCbu_cuenta(resultado.getString("cbu_cuenta"));
				aux.setNombre_usuario(resultado.getString("nombre_usuario"));
				aux.setTipo_Cuenta(resultado.getString("tipo_cuenta"));
				aux.setFecha_creacion(resultado.getString("fecha_creacion"));
				aux.setSaldo(resultado.getDouble("saldo"));
				aux.setEstado(resultado.getBoolean("estado"));
				
				x.add(aux);
				
			}
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return x;	
	}



}
