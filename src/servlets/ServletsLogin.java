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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Boolean flag = false;
		NegocioUsuario n_usuario = new NegocioUsuario();
		
		RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
		
		Usuario e_usuario = new Usuario();
		
		HttpSession session = request.getSession();
		
		String txtname = request.getParameter("txtName");
		String txtpass = request.getParameter("txtpass");
		
		if(request.getParameter("btnAceptar")!=null){
			
			flag = n_usuario.Verificar_usuario(txtname, txtpass);
			
			if (flag) {
				
				e_usuario = n_usuario.Obtener_usuario(txtname);
				
				
				//Si es administrador:
				if("ADMIN".equals(e_usuario.getTipo_usuario())) {
					rd = request.getRequestDispatcher("/AltaCliente.jsp"); 
				}
				//Si es cliente:
				else if("USUAR".equals(e_usuario.getTipo_usuario())) {
					rd = request.getRequestDispatcher("/ModificarCuenta.jsp"); 
				}
				
				
				session.setAttribute("Usuario_ingresado", e_usuario);
			}
			
	        rd.forward(request, response);
			
		}
		
	}

}
