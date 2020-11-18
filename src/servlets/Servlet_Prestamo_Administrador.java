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
import Entidad.Prestamo;
import Entidad.Usuario;
import Negocio.NegocioCuentas;
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
		
		
		
		if(request.getParameter("btn_Crear_Solisitar_Prestamo")!=null) {
			
			e_prestamo.setCbu_cuenta_deudor(Integer.parseInt(request.getParameter("ddl_cuenta")));
			e_prestamo.setInporte_pedido(Double.parseDouble(request.getParameter("txt_Prestamo_pedido")));
			Double pag_x_mes = Double.parseDouble(request.getParameter("txt_Prestamo_pedido"))/Integer.parseInt(request.getParameter("txt_Cuotas"));
			e_prestamo.setPago_x_mes(pag_x_mes);
			e_prestamo.setCantidad_cuotas(Integer.parseInt(request.getParameter("txt_Cuotas")));
			
			n_prestamo.SPNuevo_Prestamo(e_prestamo);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Prestamo_cliente_solisitud.jsp");   
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
