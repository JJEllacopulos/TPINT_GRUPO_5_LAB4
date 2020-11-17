package Dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.Date;

import Entidad.Contacto;
import Entidad.Cuenta;
import Entidad.Direccion;
import Entidad.Movimiento;
import Entidad.TipoCuenta;
import Entidad.Usuario;

public class Dao_Movimiento {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "ROOT";
	private String dbName = "banco";
	

	public void SPAltaMovimiento(Movimiento movimiento, String fecha)
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
			 CallableStatement cst = cn.prepareCall("CALL PRO_ingresar_movimiento(?,?,?,?)");
			 
			 cst.setString(1, movimiento.getCbu_cuenta());
			 cst.setString(2, movimiento.getTipo_movimiento());
			 //cst.setDate(3, java.sql.Date.valueOf(fecha));
			 cst.setString(3, movimiento.getDetalles());
			 cst.setDouble(4, movimiento.getImporte());
			 
			 cst.execute();
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	
	public Movimiento Obtener_Movimiento (int id_movimiento) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Movimiento aux = new Movimiento();
		
		Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(host+dbName, user,pass);
			CallableStatement st = cn.prepareCall("CALL PRO_Buscar_movimiento(?)");
			 st.setInt(1, id_movimiento);
			 
			
			ResultSet resultado = st.executeQuery();

			while(resultado.next()){
				
				aux.setId_movimiento(resultado.getInt("id_movimiento"));
				aux.setCbu_cuenta(resultado.getString("cbu_cuenta"));
				aux.setTipo_movimiento(resultado.getString("tipo_movimiento"));
				aux.setFecha_creacion(resultado.getDate("fecha_creacion"));
				aux.setDetalles(resultado.getString("detalles"));
				aux.setImporte(resultado.getDouble("importe"));
				aux.setEstado(resultado.getBoolean("estado"));
				
			}
					
				
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return aux;
		
	}
	
	public void SPModificarMovimiento(Movimiento movimiento, String fecha)
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
		 CallableStatement cst = cn.prepareCall("CALL PRO_Alterar_movimiento(?,?,?,?,?,?)");
		 
		 cst.setInt(1, movimiento.getId_movimiento());
		 cst.setString(2, movimiento.getCbu_cuenta());
		 cst.setString(3, movimiento.getTipo_movimiento());
		 cst.setDate(4, java.sql.Date.valueOf(fecha));
		 cst.setString(5, movimiento.getDetalles());
		 cst.setDouble(6, movimiento.getImporte());
		 
		 cst.execute();
	  }
	  catch (Exception e) {
		e.printStackTrace();
	  }
			
	}
	
	public void SPEliminarMovimiento(int id_movimiento)
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
			CallableStatement cst = cn.prepareCall("CALL PRO_Desabilitar_movimiento(?)");
			
			cst.setInt(1, id_movimiento);

			cst.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
public int SPObtenerUltimoId () {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int aux = 0; 
		Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(host+dbName, user,pass);
			CallableStatement st = cn.prepareCall("CALL PRO_Obtener_Ultimo_Id_Movimiento");
			ResultSet resultado = st.executeQuery();
				
				while(resultado.next()){	
					aux=(resultado.getInt("id_movimiento"));
				}
				
		}
		catch(Exception e) {	
			e.printStackTrace();	
		}
		return aux;	
	}

public ArrayList<Movimiento> Obtener_Lista_Movimientos(String cbuNombre) {
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ArrayList<Movimiento> x = new ArrayList<Movimiento>();
	Movimiento aux = new Movimiento();
		
		Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(host+dbName, user,pass);
			CallableStatement st = cn.prepareCall("CALL PRO_Listar_movimiento(?)");
			 st.setString(1, cbuNombre);
			 
			
			ResultSet resultado = st.executeQuery();

			while(resultado.next()){

				
				aux.setId_movimiento(resultado.getInt("id_movimiento"));
				aux.setCbu_cuenta(resultado.getString("cbu_cuenta"));
				aux.setTipo_movimiento(resultado.getString("tipo_movimiento"));
				aux.setFecha_creacion(resultado.getDate("fecha_creacion"));
				aux.setDetalles(resultado.getString("detalles"));
				aux.setImporte(resultado.getDouble("importe"));
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


