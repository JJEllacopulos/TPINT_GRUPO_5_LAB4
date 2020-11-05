package Entidad;

public class Direccion {
	
	int id;
	String Localidad;
	String Provincia;
	String Pais;
	String Calle;
	
	public Direccion(int id, String localidad, String provincia, String pais, String calle, int altura) {
		super();
		this.id = id;
		Localidad = localidad;
		Provincia = provincia;
		Pais = pais;
		Calle = calle;
		Altura = altura;
	}
	
	public Direccion() {
		id = 0;
		Localidad = "";
		Provincia = "";
		Pais = "";
		Calle = "";
		Altura = 0;
	}

	int Altura;	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocalidad() {
		return Localidad;
	}
	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	public String getPais() {
		return Pais;
	}
	public void setPais(String pais) {
		Pais = pais;
	}
	public String getCalle() {
		return Calle;
	}
	public void setCalle(String calle) {
		Calle = calle;
	}
	public int getAltura() {
		return Altura;
	}
	public void setAltura(int altura) {
		Altura = altura;
	}

}
