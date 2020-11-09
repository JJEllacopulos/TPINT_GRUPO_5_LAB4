package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Negocio.NegocioUsuario;
import Entidad.Usuario;

/**
 * Servlet implementation class servletsCliente
 */
@WebServlet("/servletsCliente")
public class servletsCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletsCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		if(request.getParameter("btnAceptar")!=null)
		{
			Usuario usuario = new Usuario();
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
			NegocioUsuario usuarioNegocio = new NegocioUsuario();
			String sexo;
			String fecha  = request.getParameter("txtFechaNacimiento");
		
			if(Integer.parseInt(request.getParameter("ddlSexo"))==1) {
				sexo = "F";
			}
			else {sexo = "M";}
			
		    usuario.setSexo(sexo);
			usuario.setNombre_usuario(request.getParameter("txtUsuario"));
			usuario.setDni(request.getParameter("txtDni"));
	        usuario.setNombre_real(request.getParameter("txtNombre"));
	        usuario.setApellido_real(request.getParameter("txtApellido"));
	        usuario.setTipo_usuario("user");
	        usuario.setPassword(request.getParameter("txtPassword"));
	        usuario.setCuil(request.getParameter("txtCuil"));
	  
	        usuario.setNacionalidad(request.getParameter("txtNacionalidad"));
	        usuario.setEstado(true);
	        
	        usuarioNegocio.SPAltaUsuario(usuario,fecha);
			RequestDispatcher rd = request.getRequestDispatcher("/AltaCliente.jsp");   
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
