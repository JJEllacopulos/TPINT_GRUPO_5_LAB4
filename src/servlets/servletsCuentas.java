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
		NegocioCuentas cuentaNegocio = new NegocioCuentas();
		
		if(request.getParameter("btnCrearCuenta")!=null) {
			double a = 50;
			Date myDate = new Date();
			String tipoCuenta = request.getParameter("ddl_tipo_cuenta");
			cuenta.setCbu_cuenta(request.getParameter("txtCBU"));
			cuenta.setNombre_usuario(request.getParameter("txtUsuario"));
			cuenta.setTipo_Cuenta(tipoCuenta);
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
		
		if(request.getParameter("btnAceptarModificar")!=null) {
			
			double a = 50;
				Date myDate = new Date();
				String tipoCuenta = request.getParameter("ddl_tipo_cuenta");
				cuenta.setCbu_cuenta(request.getParameter("txtCBU"));
				cuenta.setNombre_usuario(request.getParameter("txtUsuario"));
				cuenta.setTipo_Cuenta(tipoCuenta);
				cuenta.setSaldo(a); //
				cuenta.setFecha_creacion(new SimpleDateFormat("yyyy-MM-dd").format(myDate));  
				 
				cuentaNegocio.SPModificarCuenta(cuenta);
				
				ArrayList<Cuenta> lista = cuentaNegocio.Obtener_todasLasCuentas();  
				request.setAttribute("listaC", lista);
				
				RequestDispatcher rd = request.getRequestDispatcher("/ListarCuentasAdmin.jsp");   
				cuenta.setTipo_Cuenta(request.getParameter("txtUsuario"));
		        rd.forward(request, response);
			
			}
		if(request.getParameter("btnTransferirTerceros")!=null) {
				
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
			
			Movimiento movimiento = new Movimiento();
			
			movimiento.setCbu_cuenta(CuentaOrigen);  
			movimiento.setTipo_movimiento("Neg");  
			movimiento.setDetalles("Transferencia");   
			movimiento.setImporte(importe);  
			
			negocioMovimiento.SPAltaMovimiento(movimiento, "");
			
			
			Movimiento movimiento2 = new Movimiento();
			
			
			movimiento2.setCbu_cuenta(request.getParameter("CBUdestino"));  
			movimiento2.setTipo_movimiento("Pos");  
			movimiento2.setDetalles("Transferencia");   
			movimiento2.setImporte(importe);  
			
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
				// Mensaje de saldo insuficiente 
			}
		}
			else {
				// Mensaje cuenta incorrecta
			}
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoMovimientos.jsp");  
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
