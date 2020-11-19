package servlets;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class Servlet_Menu_Administrador
 */
@WebServlet("/Servlet_Menu_Administrador")
public class Servlet_Menu_Administrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_Menu_Administrador() {
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
		Usuario usuario = new Usuario();
		NegocioUsuario usuarioNegocio = new NegocioUsuario();
		
		if(request.getParameter("link_1")!=null) {
			RequestDispatcher rd = request.getRequestDispatcher("/Inicio_Administrador.jsp");   
	        rd.forward(request, response);
		}
		
		if(request.getParameter("link_2")!=null) {
			
			ArrayList<Cuenta> lista = cuentaNegocio.Obtener_todasLasCuentas();
			   
			request.setAttribute("listaC", lista);
						
			RequestDispatcher rd = request.getRequestDispatcher("/ListarCuentasAdmin.jsp");   
	        rd.forward(request, response);
	        
		}
		
		if(request.getParameter("link_3")!=null) {
		int usuariosXpagina = 10;
		
		ArrayList<Usuario> lista = usuarioNegocio.Obtener_lista_usuarios();
		int cantPag=1;
		
		if(lista!=null){
	    	int usuarios=0;
	  		 for(Usuario e : lista)
			{ usuarios++;
	  			if (usuarios == usuariosXpagina){
	  				usuarios = 0;
	  				cantPag = cantPag + 1;
	  			} } }	  			
		
		int usuarioFinal=  Integer.parseInt(request.getParameter("link_3"))*usuariosXpagina; 
		int usuarioInicio = usuarioFinal - usuariosXpagina;									
	
		ArrayList<Usuario> listaPaginada = new ArrayList<Usuario>();	
		
		for (int i=0;i<lista.size();i++) {		      
			if(i>=usuarioInicio && i< usuarioFinal) {	
			usuario = lista.get(i);
			listaPaginada.add(usuario);
			}  
		    }
		
			request.setAttribute("listaU", listaPaginada);
			request.setAttribute("cantPag", cantPag);
			request.setAttribute("pagActual", Integer.parseInt(request.getParameter("link_3")));	
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoClientesAdmin.jsp");   
	        rd.forward(request, response);
		}
			
		
		if(request.getParameter("link_4")!=null) {
			
			RequestDispatcher rd = request.getRequestDispatcher("/Servlet_Prestamo_Administrador?Param_1=1");   
	        rd.forward(request, response);
		}
		
		if(request.getParameter("link_5")!=null) {
			
		}
		
		if(request.getParameter("link_7")!=null) { ///----------------
			RequestDispatcher rd = request.getRequestDispatcher("/AltaCliente.jsp");   
	        rd.forward(request, response);
		}
		if(request.getParameter("link_8")!=null) { ///----------------
			RequestDispatcher rd = request.getRequestDispatcher("/AltaCuenta.jsp");   
	        rd.forward(request, response);
		}
		
		if(request.getParameter("link_10")!=null) {
			int cuentasXpagina = 10;
			
			ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
			lista = cuentaNegocio.Obtener_cuentas_activas("CC","CA");
			
			String cc = request.getParameter("chkBoxCC");
			String ca = request.getParameter("chkBoxCA");
			
			if (cc!=null)lista = cuentaNegocio.Obtener_cuentas_activas("CC","CC");
			if (ca!=null)lista = cuentaNegocio.Obtener_cuentas_activas("CA","CA");
			
			//if (request.getParameter("chkBoxCC")!=null) lista = cuentaNegocio.Obtener_cuentas_activas("CC","CC");
			//if (request.getParameter("chkBoxCA")!=null) lista = cuentaNegocio.Obtener_cuentas_activas("CA","CA");
			
			int cantPag=1;
			if(lista!=null){
		    	int usuarios=0;
		  		 for(Cuenta e : lista)
				{ usuarios++;
		  			if (usuarios == cuentasXpagina){
		  				usuarios = 0;
		  				cantPag = cantPag + 1;
		  			} } }	  			
			
			int usuarioFinal=  Integer.parseInt(request.getParameter("link_10"))*cuentasXpagina; 
			int usuarioInicio = usuarioFinal - cuentasXpagina;
			
			ArrayList<Cuenta> listaPaginada = new ArrayList<Cuenta>();	
			
			for (int i=0;i<lista.size();i++) {		      
				if(i>=usuarioInicio && i< usuarioFinal) {	
				cuenta = lista.get(i);
				listaPaginada.add(cuenta);
				}  
			    }
			
				request.setAttribute("listaC", listaPaginada);
				request.setAttribute("cantPag", cantPag);
				request.setAttribute("pagActual", Integer.parseInt(request.getParameter("link_10")));	
				
				RequestDispatcher rd = request.getRequestDispatcher("/ListarCuentasAdmin.jsp");   
		        rd.forward(request, response);
			}
		
		if(request.getParameter("link_0")!=null) {
			request.getSession().invalidate();
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
