package Entidad;

public class Contacto {
	
	int Id;
	String Email;
	String Telefono;
	
	public Contacto() {
		Id = 0;
		Email = "";
		Telefono = "";
		
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	
}
