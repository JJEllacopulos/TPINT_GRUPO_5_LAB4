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
import javax.servlet.http.HttpSession;

import Entidad.Cuenta;
import Entidad.Movimiento;
import Entidad.Movimiento_x_Prestamo;
import Entidad.Prestamo;
import Entidad.Usuario;
import Negocio.NegocioCuentas;
import Negocio.NegocioMovimiento;
import Negocio.Negocio_Movimiento_x_Prestamo;
import Negocio.Negocio_Prestamo;

/**
 * Servlet implementation class Servlet_Prestamo_Cliente
 */
@WebServlet("/Servlet_Prestamo_Cliente")
public class Servlet_Prestamo_Cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_Prestamo_Cliente() {
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
		Movimiento e_movimiento = new Movimiento();
		Movimiento_x_Prestamo e_movimiento_x_Prestamo = new Movimiento_x_Prestamo();
		Cuenta cuenta = new Cuenta();
		
		Negocio_Prestamo n_prestamo = new Negocio_Prestamo();
		NegocioCuentas n_cuentaNegocio = new NegocioCuentas();
		NegocioMovimiento n_movimiento = new NegocioMovimiento();
		Negocio_Movimiento_x_Prestamo n_movimiento_x_Prestamo = new Negocio_Movimiento_x_Prestamo();
		
		
		HttpSession misession = (HttpSession) request.getSession();
		Usuario e_usuario = (Usuario) misession.getAttribute("userSession");
		
		Date myDate = new Date();
		
		if(request.getParameter("btn_Crear_Solisitar_Prestamo")!=null) {
			
			e_prestamo.setCbu_cuenta_deudor(request.getParameter("ddl_cuenta"));
			e_prestamo.setInporte_pedido(Double.parseDouble(request.getParameter("ddl_Prestamo_pedido")));
			Double pag_x_mes = Double.parseDouble(request.getParameter("ddl_Prestamo_pedido"))/Integer.parseInt(request.getParameter("ddl_Cuotas"));
			e_prestamo.setPago_x_mes(pag_x_mes);
			e_prestamo.setCantidad_cuotas(Integer.parseInt(request.getParameter("ddl_Cuotas")));
			
			n_prestamo.SPNuevo_Prestamo(e_prestamo);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Prestamo_cliente_solisitud.jsp");   
	        rd.forward(request, response);
		}
		
		if(request.getParameter("Param_1")!=null)
		{
			
			ArrayList<Prestamo> lista = n_prestamo.Obtener_lista_Prestamo_cliente(e_usuario.getNombre_usuario());
			request.setAttribute("lista_prestamos", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Prestamo_cliente_listar.jsp");   
	        rd.forward(request, response);  
			
		}
		
		if(request.getParameter("btn_Pagar_prestamo")!=null)
		{
			// enviar nombre usuario para ddl   alias   deuda final
			String cbu = request.getParameter("cbu_prestamo");
			
			Double importe = Double.parseDouble(request.getParameter("pagoxmes_prestamo"));
			Double DeudaFinal = Double.parseDouble(request.getParameter("MontoActual"));
			int id_prestamo = Integer.parseInt(request.getParameter("id_prestamo"));
			
			cuenta = n_cuentaNegocio.Obtener_cuenta(cbu);
			
			request.setAttribute("Alias", cuenta.getAlias());
			request.setAttribute("nombre_usuario", cuenta.getNombre_usuario());
			
			request.setAttribute("cbu_prestamo", cbu);
			request.setAttribute("pagoxmes_prestamo", importe);
			request.setAttribute("id_prestamo", id_prestamo);
			
			request.setAttribute("DeudaFinal", DeudaFinal);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/Prestamo_cliente_pagar.jsp");   
	        rd.forward(request, response);  
			
		}
		
		
		if(request.getParameter("btnConfirmarPagoPrestamo")!=null)
		{
			Cuenta cuentaDDL = new Cuenta();
			
			String cbuPrestamo = request.getParameter("cbu_prestamo");
			
			Double importe = Double.parseDouble(request.getParameter("pagoxmes_prestamo"));
			Double DeudaFinal = Double.parseDouble(request.getParameter("DeudaFinal"));
			int id_prestamo = Integer.parseInt(request.getParameter("id_prestamo"));
			
			cuenta = n_cuentaNegocio.Obtener_cuenta(cbuPrestamo);

			String ddl = request.getParameter("ddlCuenta");
			cuentaDDL = n_cuentaNegocio.Obtener_cuenta(ddl);
						
			request.setAttribute("Alias", cuenta.getAlias());
			request.setAttribute("nombre_usuario", cuenta.getNombre_usuario());
			
			request.setAttribute("cbu_prestamo", cbuPrestamo);
			request.setAttribute("pagoxmes_prestamo", importe);
			request.setAttribute("id_prestamo", id_prestamo);
			
			request.setAttribute("DeudaFinal", DeudaFinal);

			
			if (cuentaDDL.getSaldo()>=importe) {				
						
			//String cbu = request.getParameter("cbu_prestamo");
			e_movimiento.setCbu_cuenta(cbuPrestamo);
			e_movimiento.setTipo_movimiento("Prest");
			e_movimiento.setDetalles(" ");
			//Double importe = Double.parseDouble(request.getParameter("pagoxmes_prestamo"));
			e_movimiento.setImporte(importe);
			n_movimiento.SPAltaMovimiento(e_movimiento, new SimpleDateFormat("yyyy-MM-dd").format(myDate));		
			int id_movimiento = n_movimiento.SPObtenerUltimoId();
			//int id_prestamo = Integer.parseInt(request.getParameter("id_prestamo"));
			
			e_movimiento_x_Prestamo.setId_movimiento(id_movimiento);
			e_movimiento_x_Prestamo.setId_prestamo(id_prestamo);
			
			n_movimiento_x_Prestamo.SPAlta_movimieto_x_prestamo(e_movimiento_x_Prestamo);
			
			e_prestamo = n_prestamo.Obtener_Prestamo(id_prestamo);
			
			Double Monto_actual = e_prestamo.getMonto_actual();
			Double Pago_x_mes = e_prestamo.getPago_x_mes();
			Double aux = Monto_actual - Pago_x_mes;
			
			int cuotas = (e_prestamo.getCuotas_a_pagar()) - 1;                     
			
			e_prestamo.setMonto_actual(aux);
			e_prestamo.setCuotas_a_pagar(cuotas);
			
			n_prestamo.SPModificar_Prestamo(e_prestamo);
			
			//Actualizar saldo
			cuenta = n_cuentaNegocio.Obtener_cuenta(cuentaDDL.getCbu_cuenta());
			Double saldo = (cuenta.getSaldo()) - Pago_x_mes;
			cuenta.setSaldo(saldo);
			n_cuentaNegocio.SPModificarCuenta(cuenta);
			
			if(aux <= 0) n_prestamo.SPEliminar_Prestamo(id_prestamo);	
			
			request.setAttribute("MensajeConfirmacion","Pago Exitoso");
       
			}
			 
			else request.setAttribute("MensajeError",cuentaDDL.getAlias());		
				
			RequestDispatcher rd = request.getRequestDispatcher("/Prestamo_cliente_pagar.jsp");   
	        rd.forward(request, response);			
		}
		
		if(request.getParameter("btnVolverListarPrestamo")!=null)
		{
			ArrayList<Prestamo> lista = n_prestamo.Obtener_lista_Prestamo_cliente(e_usuario.getNombre_usuario());
			request.setAttribute("lista_prestamos", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Prestamo_cliente_listar.jsp");   
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
