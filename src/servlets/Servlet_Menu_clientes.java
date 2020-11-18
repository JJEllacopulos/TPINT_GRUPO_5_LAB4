package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Cuenta;
import Negocio.NegocioCuentas;

/**
 * Servlet implementation class Servlet_Menu_clientes
 */
@WebServlet("/Servlet_Menu_clientes")
public class Servlet_Menu_clientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_Menu_clientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Cuenta cuenta = new Cuenta ();
		NegocioCuentas cuentaNegocio = new NegocioCuentas();
		
		if(request.getParameter("link_1")!=null) {
			RequestDispatcher rd = request.getRequestDispatcher("/Inicio_cliente.jsp");   
	        rd.forward(request, response);
		}
		
		if(request.getParameter("link_2")!=null) {
	        
		}
		
		if(request.getParameter("link_3")!=null) {
			
		}
		
		if(request.getParameter("link_4")!=null) {	
			
			ArrayList<Cuenta> lista = cuentaNegocio.Obtener_lista_CuentasCliente();
			request.setAttribute("listaC", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoCuentasDelCliente.jsp");   
	        rd.forward(request, response);
		}
		
		if(request.getParameter("link_5")!=null) {
			
		}
		
		if(request.getParameter("link_6")!=null) {
			
		}
		
		if(request.getParameter("link_7")!=null) {
			RequestDispatcher rd = request.getRequestDispatcher("/Prestamo_cliente_solisitud.jsp");   
	        rd.forward(request, response);
		}
		
		if(request.getParameter("link_8")!=null) {
			
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/Servlet_Prestamo_Cliente?Param_1=1");   
	        rd.forward(request, response);
		}
		
		
		
		if(request.getParameter("link_0")!=null) {
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");   
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
