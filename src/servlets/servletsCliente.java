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

import Dao.Dao_Usuario;
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
			Dao_Usuario daoUsuario = new Dao_Usuario();
/*		tipoS.setId(idTipo);
		seguro.setTipo(tipoS);
		seguro.setDescripcion(request.getParameter("txt_Descripcion"));
		seguro.setCosto_asegurado(Double.parseDouble(request.getParameter("txt_cost_max_asignado")));
		seguro.setCosto_contratacion(Double.parseDouble(request.getParameter("txt_cost_contratacion")));
		
		// int filas =DaoSeguro.agregarSeguro(seguro);
			ArrayList<Seguro> listaSeguro = DaoSeguro.obtenerSeguros();
			idSeguro =listaSeguro.get(listaSeguro.size() -1 );
			int id = idSeguro.getId_seguro()+1;
			ArrayList<Tipo_seguro> lista = DaoSeguro.obtenerTipoSeguro();
			request.setAttribute("listaT", lista);
			request.setAttribute("id", id);
			//REQUESTDISPATCHER
			request.setAttribute("cantFilas", filas);
		
	        Dni_usuario VARCHAR(8),
	        Nombre_real VARCHAR(50),
	        Apellido_real VARCHAR(50),
	        Tipo_usuario VARCHAR(5),
	        Contraseña_usuario VARCHAR(25),
	        Cuil_usuario VARCHAR(11),
	        Sexo VARCHAR(4),
	        Nacionalidad VARCHAR(50),
	        Fecha_nacimiento DATE,
	        estado bit*/
	
			String fecha  = request.getParameter("txtFechaNacimiento");
		
			usuario.setNombre_usuario(request.getParameter("txtUsuario"));
			usuario.setDni(request.getParameter("txtDni"));
	        usuario.setNombre_real(request.getParameter("txtNombre"));
	        usuario.setApellido_real(request.getParameter("txtApellido"));
	        usuario.setTipo_usuario("user");
	        usuario.setPassword(request.getParameter("txtPassword"));
	        usuario.setCuil(request.getParameter("txtCuil"));
	        usuario.setSexo("man");
	        usuario.setNacionalidad(request.getParameter("txtNacionalidad"));
	        usuario.setEstado(true);
	        
	        daoUsuario.SPAltaUsuario(usuario,fecha);
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
