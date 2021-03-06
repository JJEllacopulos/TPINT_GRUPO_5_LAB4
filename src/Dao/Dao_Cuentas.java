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

	public int SPAltaCuenta(Cuenta cuenta)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	int	filas = 0;
		Connection cn = null;
		  try
		  {
			 cn = DriverManager.getConnection(host+dbName, user,pass);

			 CallableStatement cst = cn.prepareCall("CALL PRO_ingresar_cuenta(?,?,?,?,?,?)");
			 cst.setString(1, cuenta.getCbu_cuenta() ); 
			 cst.setString(2,  cuenta.getNombre_usuario());
			 cst.setString(3, cuenta.getTipo_Cuenta() );//cuenta.getTipo_Cuenta()
			 cst.setString(4, cuenta.getFecha_creacion()); 
			 cst.setDouble(5, cuenta.getSaldo()); 
			 cst.setString(6, cuenta.getAlias()); 
			 


			 filas=cst.executeUpdate();
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}
			return filas;
	}
	public int SPModificarCuenta(Cuenta cuenta)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int filas = 0;
		Connection cn = null;
		  try
		  {
			 cn = DriverManager.getConnection(host+dbName, user,pass);
			 CallableStatement cst = cn.prepareCall("CALL PRO_Alterar_cuenta(?,?,?,?,?,?)");
			 cst.setString(1, cuenta.getCbu_cuenta());
			 cst.setString(2, cuenta.getNombre_usuario());
			 cst.setString(3, cuenta.getTipo_Cuenta());
			 cst.setString(4, cuenta.getFecha_creacion().toString());
			 cst.setString(5, cuenta.getSaldo().toString());
			 cst.setString(6, cuenta.getAlias()); 
		

			 filas=cst.executeUpdate();
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}
			return filas;
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
					aux.setAlias(resultado.getString("alias"));
					
					x.add(aux);
					
				}
				
			}
			catch(Exception e) {
				
				e.printStackTrace();
				
			}
			
			return x;	
		}
	
public ArrayList<Cuenta> Obtener_cuentas_activas (String tipoCuenta1, String tipoCuenta2) {
		
		
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
				if (resultado.getBoolean("estado")) {
					
			   if (!tipoCuenta1.equals(tipoCuenta2)) {
				   Cuenta aux = new Cuenta();
					aux.setCbu_cuenta(resultado.getString("cbu_cuenta"));
					aux.setNombre_usuario(resultado.getString("nombre_usuario"));
					aux.setTipo_Cuenta(resultado.getString("tipo_cuenta"));
					aux.setFecha_creacion(resultado.getString("fecha_creacion"));
					aux.setSaldo(resultado.getDouble("saldo"));
					aux.setEstado(resultado.getBoolean("estado"));
					aux.setAlias(resultado.getString("alias"));
					x.add(aux); 
			   }	
					
			   else if (tipoCuenta1.equals(resultado.getString("tipo_cuenta"))) {
					Cuenta aux = new Cuenta();
					aux.setCbu_cuenta(resultado.getString("cbu_cuenta"));
					aux.setNombre_usuario(resultado.getString("nombre_usuario"));
					aux.setTipo_Cuenta(resultado.getString("tipo_cuenta"));
					aux.setFecha_creacion(resultado.getString("fecha_creacion"));
					aux.setSaldo(resultado.getDouble("saldo"));
					aux.setEstado(resultado.getBoolean("estado"));
					aux.setAlias(resultado.getString("alias"));
					x.add(aux);
				}}
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
					aux.setAlias(resultado.getString("alias"));
					
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
				aux.setAlias(resultado.getString("alias"));
								
			}				
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return aux;
		
	}

public int Existe_Alias_cuenta(String cbuCuenta,String alias) {
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int filas = 0;
	Connection cn = null;
	  try
	  {
		  cn = DriverManager.getConnection(host+dbName, user,pass);
			CallableStatement st = cn.prepareCall("CALL PRO_Existe_Alias_cuenta(?,?)");
			 st.setString(1, cbuCuenta);
			 st.setString(2, alias);
			 
			ResultSet resultado = st.executeQuery();

			while(resultado.next()){
				filas++;
			}			
	  }
	  catch (Exception e) {
		e.printStackTrace();
	}
		return filas;		
	}


public int SPEliminarCuenta(String CBUcuenta)
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int filas = 0;
	Connection cn = null;
	  try
	  {
		 cn = DriverManager.getConnection(host+dbName, user,pass);
		 CallableStatement cst = cn.prepareCall("CALL PRO_Desabilitar_cuenta(?)");
		 cst.setString(1, CBUcuenta);
	
		 filas=cst.executeUpdate();
	  }
	  catch (Exception e) {
		e.printStackTrace();
	}
	  return filas;
		
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
				aux.setAlias(resultado.getString("alias"));
				
				x.add(aux);
				
			}
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return x;	
	}



}
