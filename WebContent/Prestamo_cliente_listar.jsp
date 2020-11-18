<%@page import="Entidad.Usuario"%>
<%@page import="Entidad.Prestamo"%>
<%@page import="Entidad.TipoCuenta"%>
<%@page import="Negocio.NegocioCuentas"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.RequestDispatcher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	
	<Style>
	</Style>
	
	<title>Listar prestamos</title>
	
</head>
<body>

	<jsp:include page="MenuCliente.jsp"></jsp:include>

	<%
	
	ArrayList<Prestamo> lista_pre = new ArrayList<Prestamo>();
	Prestamo lista_prestamos = new Prestamo();
	// lista_prestamos = (Prestamo)request.getAttribute("lista_prestamos");
	lista_pre = (ArrayList<Prestamo>)request.getAttribute("lista_prestamos");
	
	%>
		
	<div class="container">
		<table class="table ">
			<thead class="thead-light">
			    <tr>
			    	
			    	<th scope="col">ID</th>
					<th scope="col">CBU</th>
					<th scope="col">Importe pedido</th>
					<th scope="col">Importe con intereses</th>
					<th scope="col">Cantidad de cuotas</th>
					<th scope="col">Pago por mes</th>
					<th scope="col">Monto actual</th>
					<th scope="col"></th>
			
			    </tr>
		  	</thead>
		  	
		  	<tbody>
		  
		    <%if(lista_pre!=null){
		  		 for(Prestamo e : lista_pre)
				{%>
		
			    <tr>
					<form action="Servlet_Prestamo_Cliente" method="get">
				   
						<td><%=e.getId_prestamo()%> <input type="hidden" name="id_prestamo" value="<%= e.getId_prestamo() %>"></td>
						<td><%=e.getCbu_cuenta_deudor()%></td>
						<td><%=e.getInporte_pedido()%></td>
						<td><%=e.getInporte_con_intereses()%></td>
						<td><%=e.getCantidad_cuotas()%></td>
						<td><%=e.getPago_x_mes()%></td>
						<td><%=e.getMonto_actual()%></td>
						
						<td> <button type="submit" class="btn btn-primary btnDD" name="btn_Pagar_prestamo" >Aceptar</button> </td>
				
				
					</form>
			    </tr>
		    <%} 
		  	}%>
		    
			</tbody>
		</table>
	</div>

</body>
</html>