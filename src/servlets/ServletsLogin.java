package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Negocio.NegocioUsuario;
import Entidad.Usuario;

/**
 * Servlet implementation class ServletsLogin
 */
@WebServlet("/ServletsLogin")
public class ServletsLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletsLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if(request.getParameter("Param4")!=null) {
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
		
		NegocioUsuario n_usuario = new NegocioUsuario();
		
		RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
		
		

		HttpSession session = request.getSession();
		
		
		//String txtname = request.getParameter("txtName");
		//String txtpass = request.getParameter("txtpass");
		
		if(request.getParameter("btnAceptar")!=null){
			String usuarioNombre = request.getParameter("txtNombreUsuario");
			String password = request.getParameter("txtPassword");
			Usuario usuario = new Usuario();
			usuario = n_usuario.Obtener_usuario(usuarioNombre);
			
			
			if(usuario.getPassword() != null) {
				if(usuario.getPassword().equals(password)) {
					
					
					if(usuario.getTipo_usuario().equals("user")) {
						
						rd = request.getRequestDispatcher("/Inicio_cliente.jsp"); 
						
						
					}else if(usuario.getTipo_usuario().equals("ADMIN")) {
						
						rd = request.getRequestDispatcher("/Inicio_Administrador.jsp");
						
						
					}
					
				
				
			}
			}
			//request.setAttribute("user", usuario);
			//rd = request.getRequestDispatcher("/AltaCuenta.jsp");
				
			session.setAttribute("userSession", usuario);	
			rd.forward(request, response);
			
			
		}
	
		
	
	}

}
