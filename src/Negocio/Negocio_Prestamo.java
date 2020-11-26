package Negocio;

import java.util.ArrayList;

import Dao.Dao_Prestamo;
import Entidad.Cuenta;
import Entidad.Prestamo;

public class Negocio_Prestamo {
	
	private Dao_Prestamo dao_prestamo = new Dao_Prestamo();
	
	public void SPNuevo_Prestamo(Prestamo prestamo) {
		dao_prestamo.SPNuevoPrestamo(prestamo);
	}
	
	public ArrayList<Prestamo> Obtener_lista_Prestamo() {
		ArrayList<Prestamo> lista = dao_prestamo.Obtener_lista_Prestamo();
		return lista;
	}
	
	public ArrayList<Prestamo> Listar_todos_prestamos() {
		ArrayList<Prestamo> lista = dao_prestamo.Listar_todos_prestamos();
		return lista;
	}
	
	public void SPEliminar_Prestamo(int id_prestamo) {
		dao_prestamo.SPEliminarPrestamo(id_prestamo);
	}
	
	public void SPAceptar_Prestamo(int id_prestamo) {
		dao_prestamo.SPAceptar_Prestamo(id_prestamo);
	}
	
	public ArrayList<Prestamo> Obtener_lista_Prestamo_cliente(String Nombre_usuario) {
		ArrayList<Prestamo> lista = dao_prestamo.Obtener_lista_Prestamo_cliente(Nombre_usuario);
		return lista;
	}
	
	public Prestamo Obtener_Prestamo(int id_prestamo) {
		Prestamo prestamo = dao_prestamo.Obtener_Prestamo(id_prestamo);
		return prestamo;
	}
	
	public void SPModificar_Prestamo(Prestamo prestamo) {
		dao_prestamo.SPModificarPrestamo(prestamo, prestamo.getPlazo_de_pago().toString());
	}
	
}
