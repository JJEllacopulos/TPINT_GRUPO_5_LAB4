package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Negocio.NegocioUsuario;

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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Boolean a = false;
		NegocioUsuario n_usuario = new NegocioUsuario();
		if(request.getParameter("btnAceptar")!=null){
			
			a = n_usuario.Verificar_usuario(request.getParameter("txtName"), request.getParameter("txtpass"));
			
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");   
	        rd.forward(request, response);
			
		}
		
	}

}