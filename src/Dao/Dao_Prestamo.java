package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entidad.Cuenta;
import Entidad.Movimiento;
import Entidad.Prestamo;

public class Dao_Prestamo {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "ROOT";
	private String dbName = "banco";
	

	public void SPAltaPrestamo(Prestamo prestamo, String fecha)
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
			 CallableStatement cst = cn.prepareCall("CALL PRO_ingresar_prestamo(?,?,?,?,?,?)");
			 
			 cst.setString(1, prestamo.getCbu_cuenta_deudor());
			 cst.setDouble(2, prestamo.getInporte_pedido());
			 cst.setDouble(3, prestamo.getInporte_con_intereses());
			 cst.setDate(4, java.sql.Date.valueOf(fecha));
			 cst.setDouble(5, prestamo.getPago_x_mes());
			 cst.setInt(6, prestamo.getCantidad_cuotas());
			 
			 cst.execute();
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	
	public Prestamo Obtener_Prestamo (int id_prestamo) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Prestamo aux = new Prestamo();
		
		Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(host+dbName, user,pass);
			CallableStatement st = cn.prepareCall("CALL PRO_Buscar_movimiento(?)");
			 st.setInt(1, id_prestamo);
			 
			
			ResultSet resultado = st.executeQuery();

			while(resultado.next()){
				
				aux.setId_prestamo(resultado.getInt("id_prestamo"));
				aux.setCbu_cuenta_deudor(resultado.getString("cbu_cuenta_deudor"));
				aux.setInporte_pedido(resultado.getDouble("importe_pedido"));
				aux.setInporte_con_intereses(resultado.getDouble("importe_con_intereses"));
				aux.setPlazo_de_pago(resultado.getDate("plazo_de_pago"));
				aux.setPago_x_mes(resultado.getDouble("pago_x_mes"));
				aux.setCantidad_cuotas(resultado.getInt("cantidad_cuotas"));
				aux.setEstado(resultado.getBoolean("estado"));
				
			}
					
				
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return aux;
		
	}
	
	public void SPModificarPrestamo(Prestamo prestamo, String fecha)
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
		 CallableStatement cst = cn.prepareCall("CALL PRO_Alterar_prestamo(?,?,?,?,?,?,?)");
		 
		 cst.setInt(1, prestamo.getId_prestamo());
		 cst.setString(2, prestamo.getCbu_cuenta_deudor());
		 cst.setDouble(3, prestamo.getInporte_pedido());
		 cst.setDouble(4, prestamo.getInporte_con_intereses());
		 cst.setDate(5, java.sql.Date.valueOf(fecha));
		 cst.setDouble(6, prestamo.getPago_x_mes());
		 cst.setInt(7, prestamo.getCantidad_cuotas());
		 
		 cst.execute();
	  }
	  catch (Exception e) {
		e.printStackTrace();
	  }
			
	}
	
	public void SPEliminarPrestamo(int id_prestamo)
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
			CallableStatement cst = cn.prepareCall("CALL PRO_Desabilitar_prestamo(?)");
			
			cst.setInt(1, id_prestamo);

			cst.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public void SPNuevoPrestamo(Prestamo prestamo)
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
			 CallableStatement cst = cn.prepareCall("CALL PRO_Nuevo_prestamo(?,?,?,?)");
			 
			 cst.setString(1, prestamo.getCbu_cuenta_deudor());
			 cst.setDouble(2, prestamo.getInporte_pedido());
			 cst.setDouble(3, prestamo.getPago_x_mes());
			 cst.setInt(4, prestamo.getCantidad_cuotas());
			 
			 cst.execute();
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public ArrayList<Prestamo> Obtener_lista_Prestamo() {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Prestamo> x = new ArrayList<Prestamo>();
		
		Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(host+dbName, user,pass);
			CallableStatement st = cn.prepareCall("CALL PRO_Listar_prestamos_administradores()");
			
			ResultSet resultado = st.executeQuery();
			
			/*  c.cbu_cuenta, c.nombre_usuario, c.tipo_cuenta, c.fecha_creacion, c.saldo, c.estado */
			
			while(resultado.next()){
				
				Prestamo aux = new Prestamo();
				aux.setId_prestamo(resultado.getInt("id_prestamo"));
				aux.setCbu_cuenta_deudor(resultado.getString("cbu_cuenta_deudor"));
				aux.setInporte_pedido(resultado.getDouble("importe_pedido"));
				aux.setInporte_con_intereses(resultado.getDouble("importe_con_intereses"));
				aux.setPlazo_de_pago(resultado.getDate("plazo_de_pago"));
				aux.setPago_x_mes(resultado.getDouble("pago_x_mes"));
				aux.setCantidad_cuotas(resultado.getInt("cantidad_cuotas"));
				aux.setEstado(resultado.getBoolean("estado"));
				
				x.add(aux);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return x;	
	}
	
	public void SPAceptar_Prestamo(int id_prestamo)
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
			CallableStatement cst = cn.prepareCall("CALL PRO_abilitar_prestamo(?)");
			
			cst.setInt(1, id_prestamo);

			cst.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
}
