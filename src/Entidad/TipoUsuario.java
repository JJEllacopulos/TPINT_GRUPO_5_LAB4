package Entidad;

public class TipoUsuario {

		int id;
		String Descripcion;
public TipoUsuario(){
		id = 0;
		Descripcion = "";
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
