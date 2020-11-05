package Entidad;

public class TipoCuenta {
	
	int id;
	String Descripcion;
	
	public TipoCuenta() {
		id=0;
		Descripcion="";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	

}
