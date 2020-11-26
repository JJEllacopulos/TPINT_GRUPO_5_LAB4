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
import javax.servlet.http.HttpSession;

import Entidad.Cuenta;
import Entidad.TipoCuenta;
import Entidad.Usuario;
import Entidad.Movimiento;
import Entidad.Transferencias;
import Negocio.NegocioTransferencia;
import Negocio.NegocioCuentas;
import Negocio.NegocioUsuario;
import Negocio.NegocioMovimiento;

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
		Usuario usuario = new Usuario();
		NegocioUsuario usuarioNegocio = new NegocioUsuario();
		NegocioCuentas cuentaNegocio = new NegocioCuentas();
		NegocioMovimiento negMovimiento = new NegocioMovimiento();
		Movimiento movimiento = new Movimiento();
		
		if(request.getParameter("btnCrearCuenta")!=null) {
			double a = 50;
			String cbuCuenta = "0";
			long cbuCuenta1 = 0;
			long cbuCuenta2 = 0;
			boolean c = true;		
			
			usuario = usuarioNegocio.Obtener_usuario(request.getParameter("txtUsuario"));
			
			if (usuario.getNombre_usuario()!=null) {
				
			ArrayList<Cuenta> Us = cuentaNegocio.Obtener_Datos_Cuenta(request.getParameter("txtUsuario"));
				
			if (Us.size() < 3) {
			
				//cbuCuenta = (long) Math.floor(Math.random()*(99999999-9999999+1)+9999999);				
				cbuCuenta1 = (long) Math.floor(Math.random()*(99999999-9999999+1)+9999999);
				cbuCuenta2 = (long) Math.floor(Math.random()*(99999999-9999999+1)+9999999);
				
			cbuCuenta=String.valueOf(cbuCuenta1)+String.valueOf(cbuCuenta2);			
				
			Date myDate = new Date();
			String tipoCuenta = request.getParameter("ddl_tipo_cuenta");
			cuenta.setCbu_cuenta(cbuCuenta);
			cuenta.setNombre_usuario(request.getParameter("txtUsuario"));
			cuenta.setTipo_Cuenta(tipoCuenta);
			cuenta.setSaldo(10000.00); //
			cuenta.setFecha_creacion(new SimpleDateFormat("yyyy-MM-dd").format(myDate)); 
			cuenta.setAlias(request.getParameter("txtAlias"));
 
			int filas= 0;
			filas = cuentaNegocio.SPAltaCuenta(cuenta);
			movimiento.setCbu_cuenta(cuenta.getCbu_cuenta());
			movimiento.setDetalles("Monto inicial");
			movimiento.setImporte(cuenta.getSaldo());
			movimiento.setTipo_movimiento("Inici");
			negMovimiento.SPAltaMovimiento(movimiento, "");
			
			ArrayList<Cuenta> lista = cuentaNegocio.Obtener_todasLasCuentas();  
		
			request.setAttribute("filasA", filas);
			request.setAttribute("listaC", lista);
			
			//request.setAttribute("Mensaje", "Cuenta creada satisfactoriamente");
			}
			else {
				request.setAttribute("Mensaje", "ERROR: el usuario ya posee 3 cuentas");
			}
			}
			else {
				request.setAttribute("Mensaje", "ERROR: Usuario inexistente");
			}
			
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarCuentasAdmin.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("Param2")!=null) {
					   
			//request.getParameter("CBU");
			HttpSession session = request.getSession();
			Usuario usuario1 = new Usuario();
			usuario1 = (Usuario)session.getAttribute("userSession");
			
		    ArrayList<Cuenta> lista = cuentaNegocio.Obtener_Datos_Cuenta(usuario1.getNombre_usuario());
		    
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
		
		if(request.getParameter("link_4")!=null) {
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/Prestamo_admin_aprovacion.jsp");   
	        rd.forward(request, response);
			
		}
		
		if(request.getParameter("btnModificarCuenta")!=null) {
			String cbuCuenta;
			
			String s = (String)request.getQueryString() ;
			String[] parts = s.split("&btn");
			String s1 = parts[0]; 
			String part2 = parts[1]; 
			String s2= s1.substring(s1.length()-16, s1.length());
			
		//cbuCuenta = request.getParameter("cbuCuenta");
		//cuenta= cuentaNegocio.Obtener_cuenta(cbuCuenta);
		//request.setAttribute("cuenta", cuenta);
			
			request.setAttribute("Stringcuenta", s2 );
			RequestDispatcher rd = request.getRequestDispatcher("/ModificarCuenta.jsp"); 
	       rd.forward(request, response);
		}		
		
		if(request.getParameter("btnEliminarCuenta")!=null) {
			
			String s = (String)request.getQueryString() ;
			String[] parts = s.split("&btn");
			String s1 = parts[0]; 
			String part2 = parts[1]; 
			String s2= s1.substring(s1.length()-16, s1.length());
			
		String cbuCuenta;
		//cbuCuenta = request.getParameter("cbuCuenta");
		cbuCuenta =s2;
		int filas = 0;
		if (request.getParameter("cbuCuenta")!=null)
			
			filas = cuentaNegocio.Eliminar_cuenta(cbuCuenta);
			
			ArrayList<Cuenta> lista = cuentaNegocio.Obtener_todasLasCuentas ();
			request.setAttribute("filasE", filas);
			request.setAttribute("listaC", lista);	
				RequestDispatcher rd = request.getRequestDispatcher("Servlet_Menu_Administrador?link_10=1");   
		        rd.forward(request, response);
		}	
		
		if(request.getParameter("btnAceptarModificar")!=null) {			
			
			// cuenta original obtenida por CBU
			Cuenta cu = new Cuenta ();
			cu = cuentaNegocio.Obtener_cuenta(request.getParameter("cbuCuenta"));

			RequestDispatcher rd ;
			
			// si es valido el alias 
				if (cuentaNegocio.Existe_Alias_cuenta(cu.getCbu_cuenta(), request.getParameter("txtAlias")) == 0) {	
				Date myDate = new Date();
				
				cuenta.setCbu_cuenta(request.getParameter("cbuCuenta"));
				cuenta.setNombre_usuario(request.getParameter("txtUsuario"));
				cuenta.setTipo_Cuenta(request.getParameter("ddlTipoCuenta"));
				cuenta.setSaldo(Double.parseDouble(request.getParameter("txtSaldo")));
				cuenta.setFecha_creacion(new SimpleDateFormat("yyyy-MM-dd").format(myDate)); 
				cuenta.setAlias(request.getParameter("txtAlias"));
				int filas = 0; 
				filas = cuentaNegocio.SPModificarCuenta(cuenta);
				
				ArrayList<Cuenta> lista = cuentaNegocio.Obtener_todasLasCuentas(); 
				request.setAttribute("filasM", filas);
				request.setAttribute("listaC", lista);
				
				rd = request.getRequestDispatcher("Servlet_Menu_Administrador?link_2=1");
				
				}
				
				else { // Alias repetido  
					String mensaje = "Alias existente, por favor vuelva a cargar los datos"; 
					request.setAttribute("MensajeError", mensaje );
					request.setAttribute("Stringcuenta", cu.getCbu_cuenta() );					
					rd = request.getRequestDispatcher("/ModificarCuenta.jsp");   
				}				
												
		        rd.forward(request, response);											
}
		
		if(request.getParameter("btnFiltrar")!=null) {
			
			if (request.getParameter("chkBoxCC")!=null)request.setAttribute("chkBoxCC","CC");
			if (request.getParameter("chkBoxCA")!=null)request.setAttribute("chkBoxCC","CA");
			//request.setAttribute("chkBoxCA","CA");
			//request.setAttribute("chkBoxCC","CC");	
			RequestDispatcher rd = request.getRequestDispatcher("/Servlet_Menu_Administrador?link_10=1");   
	        rd.forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		HttpSession session = request.getSession();
		Usuario usuario1 = new Usuario();
		usuario1 = (Usuario)session.getAttribute("userSession");
		Cuenta cuenta = new Cuenta ();
		NegocioCuentas cuentaNegocio = new NegocioCuentas();
		
if(request.getParameter("btnConfirmarTransferencia")!=null) {
	
	RequestDispatcher rd = request.getRequestDispatcher("/ListadoCuentasDelCliente.jsp");   
	
			if (cuentaNegocio.Obtener_cuenta(request.getParameter("CBUdestino"))!=null) { // validar CBU destino 
				

			Cuenta cuenta1 = new Cuenta ();
			NegocioMovimiento negocioMovimiento = new NegocioMovimiento();
			
			String CuentaOrigen = request.getParameter("ddl_cuenta_origen");
			
			double importe = Double.parseDouble(request.getParameter("inputMonto"));
			double saldoCuenta = 0;
			double saldoFinal = 0;
			int idMovimiento = negocioMovimiento.SPObtenerUltimoId() + 1;
			
			cuenta1	= cuentaNegocio.Obtener_cuenta(CuentaOrigen);
			saldoCuenta = cuenta1.getSaldo();
			saldoFinal = saldoCuenta - importe; 
			
			if (importe<=saldoCuenta) {
			
			// alta del moviento 
			double importeNeg = 0;
			importeNeg = importe;
			Movimiento movimiento = new Movimiento();
			
			movimiento.setCbu_cuenta(CuentaOrigen);  
			movimiento.setTipo_movimiento("Trans");  
			movimiento.setDetalles("A terceros");   
			movimiento.setImporte(importeNeg*-1);   // transferencia negativa 
			Movimiento movimiento2 = new Movimiento();
			
			
			movimiento2.setCbu_cuenta(request.getParameter("CBUdestino"));  
			if (!movimiento.getCbu_cuenta().equals(movimiento2.getCbu_cuenta())) {	
				
			negocioMovimiento.SPAltaMovimiento(movimiento, "");
			
			movimiento2.setTipo_movimiento("Trans");  
			movimiento2.setDetalles("A terceros");   
			movimiento2.setImporte(importe);   // transferencia positiva 
			
			negocioMovimiento.SPAltaMovimiento(movimiento2, "");
			
			// alta de transferencia 
					
			Transferencias transferencia = new Transferencias(); 
			NegocioTransferencia negocioTransferencia = new NegocioTransferencia();
			
			transferencia.setId_movimiento(idMovimiento); 
			transferencia.setCbu_cuenta_destino(request.getParameter("CBUdestino")); 
			
			negocioTransferencia.SPAltaTransferencia(transferencia, "");
			
			// actualizacion de cuentas 
			
			
			cuenta1.setSaldo(saldoFinal);
			cuentaNegocio.SPModificarCuenta(cuenta1);
			
			Cuenta cuenta2 = new Cuenta ();
			
			double saldoCuentaDestino = 0;
			
			cuenta2	= cuentaNegocio.Obtener_cuenta(request.getParameter("CBUdestino"));
			saldoCuentaDestino = cuenta2.getSaldo();
			
			cuenta2.setSaldo(saldoCuentaDestino+importe);
			cuentaNegocio.SPModificarCuenta(cuenta2);
			
			}
			else {
				// No se puede transferir entre las mismas cuentas
				rd = request.getRequestDispatcher("TransferenciaCuentaPropia.jsp");  	
			}
			}
			else {
				// Mensaje de saldo insuficiente 
			}
		}
			else {
				// Mensaje cuenta incorrecta
			}
			
		    ArrayList<Cuenta> lista = cuentaNegocio.Obtener_Datos_Cuenta(usuario1.getNombre_usuario());
		    
			request.setAttribute("listaC", lista);
						
			
	       
			//RequestDispatcher rd = request.getRequestDispatcher("servletsCuentas?Param2=2");  
			rd.forward(request, response);
		}
		
		
		
		
	}

}
