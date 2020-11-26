package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Cuenta;
import Entidad.Movimiento;
import Entidad.Prestamo;
import Entidad.Usuario;
import Negocio.NegocioCuentas;
import Negocio.NegocioMovimiento;
import Negocio.Negocio_Prestamo;

import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_Prestamo_Administrador
 */
@WebServlet("/Servlet_Prestamo_Administrador")
public class Servlet_Prestamo_Administrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_Prestamo_Administrador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Prestamo e_prestamo = new Prestamo ();
		Negocio_Prestamo n_prestamo = new Negocio_Prestamo();
		NegocioCuentas n_cuentaNegocio = new NegocioCuentas();
		
		HttpSession misession = (HttpSession) request.getSession();
		Usuario e_usuario = (Usuario) misession.getAttribute("userSession");
		
		if(request.getParameter("Param_1")!=null)
		{			
			ArrayList<Prestamo> lista = n_prestamo.Listar_todos_prestamos();
			request.setAttribute("lista_prestamos", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Prestamo_admin_aprovacion.jsp");   
	        rd.forward(request, response);  		
		}
		
		
		if(request.getParameter("btn_Aceptar_prestamo")!=null) {
			
			Movimiento e_movimiento = new Movimiento();
			NegocioMovimiento n_movimiento = new NegocioMovimiento();
			Date myDate = new Date();
			Cuenta cuenta = new Cuenta();
			
			int id_prestamo = Integer.parseInt(request.getParameter("id_prestamo"));
			
			n_prestamo.SPAceptar_Prestamo(id_prestamo);
			 e_prestamo = n_prestamo.Obtener_Prestamo(id_prestamo);
			 
			 e_movimiento.setCbu_cuenta(e_prestamo.getCbu_cuenta_deudor());
				e_movimiento.setTipo_movimiento("Prest");
				e_movimiento.setDetalles("PrestNº "+e_prestamo.getId_prestamo()+" de "+ e_prestamo.getCantidad_cuotas() + " cuotas");
				//Double importe = Double.parseDouble(request.getParameter("pagoxmes_prestamo"));
				e_movimiento.setImporte(e_prestamo.getInporte_pedido());
				n_movimiento.SPAltaMovimiento(e_movimiento, new SimpleDateFormat("yyyy-MM-dd").format(myDate));	
				
			 // Actualiza saldo
				cuenta = n_cuentaNegocio.Obtener_cuenta(e_prestamo.getCbu_cuenta_deudor());
				Double saldo = cuenta.getSaldo() + e_prestamo.getInporte_pedido();
				cuenta.setSaldo(saldo);
				n_cuentaNegocio.SPModificarCuenta(cuenta);  
				
				
				ArrayList<Prestamo> lista = n_prestamo.Listar_todos_prestamos();
				request.setAttribute("lista_prestamos", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Prestamo_admin_aprovacion.jsp");   
	        rd.forward(request, response);
		}
		
		
		if(request.getParameter("btn_Rechasar_prestamo")!=null) {
			
			int id_prestamo = Integer.parseInt(request.getParameter("id_prestamo"));
			
			n_prestamo.SPEliminar_Prestamo(id_prestamo);
			
			ArrayList<Prestamo> lista = n_prestamo.Listar_todos_prestamos();
			request.setAttribute("lista_prestamos", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Prestamo_admin_aprovacion.jsp");   
	        rd.forward(request, response);
		}
		
		
		if(request.getParameter("btn_buscarXcbu")!=null) {
			ArrayList<Prestamo> lista = n_prestamo.Listar_todos_prestamos();
			ArrayList<Prestamo> listaux = new ArrayList();
			
			boolean busq=true; 
			
		 if(lista!=null)
		 for(Prestamo e : lista)
		{  Prestamo prestamoaux = new Prestamo ();
		
		boolean add = false; 
		
		//if (request.getParameter("txtCbuCuenta")!=null) {
			
			if (e.getCbu_cuenta_deudor().equals(request.getParameter("txtCbuCuenta"))) {
				boolean chk = false;
				busq=false;
				
				if (request.getParameter("cbox1")!=null && !add ) {
					if (!e.getAprobacion()&&!e.getEstado())add=true;
					chk=true;
				}
				
				if (request.getParameter("cbox2")!=null && !add) {
					if (!e.getAprobacion()&& e.getEstado())	add=true;
					chk=true;
				}
				if (request.getParameter("cbox3")!=null && !add) {
					if(!e.getEstado()&& e.getAprobacion()) add=true; 
					chk=true;
				}
				if (request.getParameter("cbox4")!=null  && !add ) {
					if (e.getMonto_actual()>0 && e.getAprobacion()) add=true;
					chk=true;
				}				
				
				if (!chk) add=true;	
			//}			
				
		} 
		if (busq) {	
		
		if (request.getParameter("cbox1")!=null && !add ) {  // rechazados 
			if (!e.getAprobacion()&&!e.getEstado())add=true;
		}
		
		if (request.getParameter("cbox2")!=null && !add) {  // a aprobar
			if (!e.getAprobacion()&& e.getEstado())	add=true;
		}
		if (request.getParameter("cbox3")!=null && !add) {  // pagos
			if(!e.getEstado()&& e.getAprobacion()) add=true; 
		}
		if (request.getParameter("cbox4")!=null && !add ) {  // con deuda
			if (e.getMonto_actual()>0 && e.getAprobacion()) add=true;
		}
		}
		
		if (add) {
			prestamoaux.setId_prestamo(e.getId_prestamo());
			prestamoaux.setCbu_cuenta_deudor(e.getCbu_cuenta_deudor());
			prestamoaux.setInporte_pedido(e.getInporte_pedido());
			prestamoaux.setInporte_con_intereses(e.getInporte_con_intereses());
			prestamoaux.setPlazo_de_pago(e.getPlazo_de_pago());
			prestamoaux.setPago_x_mes(e.getPago_x_mes());
			prestamoaux.setCantidad_cuotas(e.getCantidad_cuotas());
			prestamoaux.setCuotas_a_pagar(e.getCuotas_a_pagar());
			prestamoaux.setMonto_actual(e.getMonto_actual());
			prestamoaux.setAprobacion(e.getAprobacion());
			prestamoaux.setEstado(e.getEstado());
			listaux.add(prestamoaux);
		}		
		
		}

			
			request.setAttribute("lista_prestamos", listaux);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Prestamo_admin_aprovacion.jsp");   
	        rd.forward(request, response);
		}
		
		
		
		if(request.getParameter("btnLimpiarFiltros")!=null) {
			
			ArrayList<Prestamo> lista = n_prestamo.Listar_todos_prestamos();
			request.setAttribute("lista_prestamos", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Prestamo_admin_aprovacion.jsp");   
	        rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
