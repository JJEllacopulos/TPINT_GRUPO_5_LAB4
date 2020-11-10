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
import Entidad.Direccion;
import Entidad.Contacto;

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
		Usuario usuario = new Usuario();
		NegocioUsuario usuarioNegocio = new NegocioUsuario();
		
		if(request.getParameter("Param1")!=null) {
						
						   
		    ArrayList<Usuario> lista = usuarioNegocio.Obtener_lista_usuarios();
		    
			request.setAttribute("listaU", lista);
						
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoClientesAdmin.jsp");   
	        rd.forward(request, response);
			
		}
		
		if(request.getParameter("btnAceptar")!=null)
		{
			
			Direccion direccion = new Direccion();
			Contacto contacto = new Contacto();
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
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
	        
	        contacto.setEmail(request.getParameter("txtEmail"));
	        contacto.setNombre_usuario(usuario.getNombre_usuario());
	        contacto.setTelefono(request.getParameter("txtTelefono"));
	        
	        direccion.setAltura(request.getParameter("txtAltura"));
	        direccion.setCalle(request.getParameter("txtCalle"));
	        direccion.setLocalidad(request.getParameter("txtLocalidad"));
	        direccion.setNombre_usuario(usuario.getNombre_usuario());
	        direccion.setPais(request.getParameter("txtPais"));
	        
	        direccion.setProvincia(request.getParameter("txtProvincia"));
	        
	       
	        usuarioNegocio.SPAltaUsuario(usuario,fecha);
	        usuarioNegocio.SPAltaDireccionUsuario(direccion);
	        usuarioNegocio.SPAltaContactoUsuario(contacto);
	        
	        
			RequestDispatcher rd = request.getRequestDispatcher("/AltaCliente.jsp");   
	        rd.forward(request, response);   
			 
		 }
		
		if(request.getParameter("btnModificar")!=null) {
			
			String nombreUsuario = request.getParameter("nombreUsuario");
			
			usuario = usuarioNegocio.Obtener_usuario(nombreUsuario);
			request.setAttribute("usuario", usuario);
			RequestDispatcher rd = request.getRequestDispatcher("/ModificarCliente.jsp");   
	        rd.forward(request, response);  
		}
		
		if(request.getParameter("btnModificarUsuario")!=null)
		{
			Direccion direccion = new Direccion();
			Contacto contacto = new Contacto();
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
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
	        
	        contacto.setEmail(request.getParameter("txtEmail"));
	        contacto.setNombre_usuario(usuario.getNombre_usuario());
	        contacto.setTelefono(request.getParameter("txtTelefono"));
	        
	        direccion.setAltura(request.getParameter("txtAltura"));
	        direccion.setCalle(request.getParameter("txtCalle"));
	        direccion.setLocalidad(request.getParameter("txtLocalidad"));
	        direccion.setNombre_usuario(usuario.getNombre_usuario());
	        direccion.setPais(request.getParameter("txtPais"));
	        
	        direccion.setProvincia(request.getParameter("txtProvincia"));
	        
	       
	        usuarioNegocio.SPModificarUsuario(usuario,fecha);
	        usuarioNegocio.SPModificarDireccionUsuario(direccion);
	        usuarioNegocio.SPModificarContactoUsuario(contacto);
	        
	        ArrayList<Usuario> lista = usuarioNegocio.Obtener_lista_usuarios();
			request.setAttribute("listaU", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoClientesAdmin.jsp");    
	        rd.forward(request, response); 
		}
		
		if(request.getParameter("btnEliminar")!=null) {
			String nombreUsuario = request.getParameter("nombreUsuario");
			
			usuarioNegocio.SPEliminarDireccionUsuario(nombreUsuario);
			usuarioNegocio.SPEliminarContactoUsuario(nombreUsuario);
			usuarioNegocio.SPEliminarUsuario(nombreUsuario);
			
	        ArrayList<Usuario> lista = usuarioNegocio.Obtener_lista_usuarios();
			request.setAttribute("listaU", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoClientesAdmin.jsp");    
	        rd.forward(request, response); 
			
		}
	}
		
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Usuario usuario = new Usuario();
		NegocioUsuario usuarioNegocio = new NegocioUsuario();
		

	}
}
