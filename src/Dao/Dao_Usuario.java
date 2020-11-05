package Dao;
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
	private String dbName = "dbBanco";
	
	public int agregarUsuario(Usuario usuario)
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		int filas=0;
		Connection cn = null;
		try
		{	String Usuario;
		String Nombre;
		String Apellido;
		String Dni;
		String Password;
		String Cuil;
		String Sexo;
		String Nacionalidad;
		Date Fecha;
		Contacto contacto;
		Direccion direccion;
		TipoUsuario tipoUsuario;
			cn = DriverManager.getConnection(host+dbName, user,pass);
			Statement st = cn.createStatement();
			String query = "Insert into Usuario(nombre,apellido,dni,password,cuil,sexo,nacionalidad,fecha,idContacto,idDireccion,idTipoUsuario) values ('"+usuario.getNombre()+"','"+usuario.getApellido()+
					"','"+usuario.getDni()+"','"+usuario.getPassword()+"', '"+ usuario.getCuil()+"','"+ usuario.getSexo()+"','"+ usuario.getNacionalidad()+"'"
					+ "'"+usuario.getFecha()+"','"+ usuario.getContacto().getId()+"','"+ usuario.g+"')";
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
	
	public ArrayList<TipoUsuario> obtenerTipoUsuario() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<TipoUsuario> lista = new ArrayList<TipoUsuario>();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select idTipo,descripcion from tiposeguros");
			
			while(rs.next()){
				
				TipoUsuario tipoSeguro = new TipoUsuario();
				tipoSeguro.setId(rs.getInt("idTipo"));
				tipoSeguro.setDescripcion(rs.getString("descripcion"));
				
				lista.add(tipoSeguro);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}

		return lista;
	}
	
	

	
	public ArrayList<Usuario> obtenerUsuarios() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("select s.idSeguro, s.descripcion, t.descripcion, t.idTipo, s.costoContratacion, s.costoAsegurado  from seguros as s inner join tiposeguros as t on t.idTipo = s.idTipo");
			
			while(rs.next()){
				TipoUsuario tipoUsuario = new TipoUsuario();
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("s.idSeguro"));
				usuario.setDescripcion(rs.getString("s.descripcion"));
				tipoUsuario.setDescripcion(rs.getString("t.descripcion"));
				tipoUsuario.setId(rs.getInt("t.idTipo"));
				seguro.setCosto_contratacion(rs.getDouble("s.costoContratacion"));
				seguro.setCosto_asegurado(rs.getDouble("s.costoAsegurado"));
				
			
				
				lista.add(seguro);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}

		return lista;
	}



}

