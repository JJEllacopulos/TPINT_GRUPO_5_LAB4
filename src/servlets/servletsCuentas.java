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
import Entidad.Usuario;
import Negocio.NegocioCuentas;
import Negocio.NegocioUsuario;

/**
 * Servlet implementation class servletsCuentas
 */
@WebServlet("/servletsCuentas")
public class servletsCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletsCuentas() {
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
		
		if(request.getParameter("btnCrearCuenta")!=null) {
			double a = 50;
			Date myDate = new Date();
				
			cuenta.setCbu_cuenta(request.getParameter("txtCBU"));
			cuenta.setNombre_usuario(request.getParameter("txtUsuario"));
			cuenta.setTipo_Cuenta("ca");  //request.getParameter("txtUsuario")
			cuenta.setSaldo(Double.parseDouble(request.getParameter("txtSaldo"))); //
			cuenta.setFecha_creacion(new SimpleDateFormat("yyyy-MM-dd").format(myDate));  
			 
			
			cuentaNegocio.SPAltaCuenta(cuenta);
			
			ArrayList<Cuenta> lista = cuentaNegocio.Obtener_todasLasCuentas();  
			request.setAttribute("listaC", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarCuentasAdmin.jsp");   
			cuenta.setTipo_Cuenta(request.getParameter("txtUsuario"));
			//cuenta.setSaldo(request.getParameter("txtSaldo"));
			//cuenta.setFecha_creacion(new SimpleDateFormat("yyyy-MM-dd").format(myDate));
			//cuenta.setEstado(true);
				
			//RequestDispatcher rd = request.getRequestDispatcher("/AltaCuenta.jsp");   

	        rd.forward(request, response);
		}
		
		if(request.getParameter("Param2")!=null) {
					   
			//request.getParameter("CBU");
		    ArrayList<Cuenta> lista = cuentaNegocio.Obtener_lista_CuentasCliente();
		    
			request.setAttribute("listaC", lista);
						
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoCuentasDelCliente.jsp");   
	        rd.forward(request, response);
			
		}
		
		if(request.getParameter("Param3")!=null) {
			
			ArrayList<Cuenta> lista = cuentaNegocio.Obtener_todasLasCuentas();
		    
			request.setAttribute("listaC", lista);
						
			RequestDispatcher rd = request.getRequestDispatcher("/ListarCuentasAdmin.jsp");   
	        rd.forward(request, response);
			
		}
		
		if(request.getParameter("btnModificarCuenta")!=null) {
			String cbuCuenta;
		cbuCuenta = request.getParameter("cbuCuenta");
		
		cuenta	= cuentaNegocio.Obtener_cuenta(cbuCuenta);
			request.setAttribute("cuenta", cuenta);
			RequestDispatcher rd = request.getRequestDispatcher("/ModificarCuenta.jsp");   
	        rd.forward(request, response);
		}
		
		if(request.getParameter("btnEliminarCuenta")!=null) {
		String cbuCuenta;
		cbuCuenta = request.getParameter("cbuCuenta");
			
		if (request.getParameter("cbuCuenta")!=null)
			
			cuentaNegocio.Eliminar_cuenta(cbuCuenta);
			
			ArrayList<Cuenta> lista = cuentaNegocio.Obtener_todasLasCuentas ();
			request.setAttribute("listaC", lista);
				
				RequestDispatcher rd = request.getRequestDispatcher("/ListarCuentasAdmin.jsp");   
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
