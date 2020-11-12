package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import Entidad.Movimiento;
import Entidad.Movimiento_x_Prestamo;

public class Dao_Movimiento_x_Prestamo {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "ROOT";
	private String dbName = "banco";
	

	public void SPAltaMovimiento_x_Prestamo(Movimiento_x_Prestamo mov_x_pes)
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
			 CallableStatement cst = cn.prepareCall("CALL PRO_ingresar_movimiento_x_prestamo(?,?)");
			 
			 cst.setInt(1, mov_x_pes.getId_movimiento());
			 cst.setInt(2, mov_x_pes.getId_prestamo());
			 
			 cst.execute();
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	
}
