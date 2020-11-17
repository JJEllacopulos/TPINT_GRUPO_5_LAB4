package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Movimiento;
import Entidad.Usuario;
import Negocio.NegocioMovimiento;

/**
 * Servlet implementation class ServletsMovimientos
 */
@WebServlet("/ServletsMovimientos")
public class ServletsMovimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletsMovimientos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Movimiento movimiento = new Movimiento();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if(request.getParameter("btnVerMovimientos")!=null) {
			NegocioMovimiento nMovimiento = new NegocioMovimiento();
			String cbu = request.getParameter("cbuUsuario");
			ArrayList<Movimiento> listaMovimientos = new ArrayList<Movimiento>();
			
			listaMovimientos = nMovimiento.Obtener_Lista_Movimientos(cbu);
			
	 		request.setAttribute("listaMovimientos", listaMovimientos);
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoMovimientos.jsp");    
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
