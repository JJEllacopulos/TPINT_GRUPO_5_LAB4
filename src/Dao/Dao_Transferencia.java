package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import Entidad.Movimiento;
import Entidad.Transferencias;

public class Dao_Transferencia {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "ROOT";
	private String dbName = "banco";
	

	public void SPAltaTransferencias(Transferencias transferencias, String fecha)
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
			 CallableStatement cst = cn.prepareCall("CALL PRO_ingresar_movimiento(?,?)");
			 
			 cst.setInt(1, transferencias.getId_movimiento());
			 cst.setString(2, transferencias.getCbu_cuenta_destino());
			 
			 cst.execute();
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	
	public Transferencias Obtener_Transferencias (int id_transferencias) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Transferencias aux = new Transferencias();
		
		Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(host+dbName, user,pass);
			CallableStatement st = cn.prepareCall("CALL PRO_Buscar_transferencia(?)");
			 st.setInt(1, id_transferencias);
			 
			
			ResultSet resultado = st.executeQuery();

			while(resultado.next()){
				
				aux.setId_transferencia(resultado.getInt("id_tranferencia"));
				aux.setId_movimiento(resultado.getInt("id_movimiento"));
				aux.setCbu_cuenta_destino(resultado.getString("cbu_cuenta_destino"));
				aux.setEstado(resultado.getBoolean("estado"));
				
			}
					
				
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return aux;
		
	}
	
	public void SPModificarTransferencias(Transferencias transferencias)
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
		 CallableStatement cst = cn.prepareCall("CALL PRO_Alterar_transferencia(?,?,?)");
		 
		 cst.setInt(1, transferencias.getId_transferencia());
		 cst.setInt(2, transferencias.getId_movimiento());
		 cst.setString(3, transferencias.getCbu_cuenta_destino());
		 
		 cst.execute();
	  }
	  catch (Exception e) {
		e.printStackTrace();
	  }
			
	}
	
	public void SPEliminarTransferencias(int id_transferencias)
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
			CallableStatement cst = cn.prepareCall("CALL PRO_Desabilitar_transferencia(?)");
			
			cst.setInt(1, id_transferencias);

			cst.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
}
