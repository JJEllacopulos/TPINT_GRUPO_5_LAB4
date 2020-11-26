<%@page import="Entidad.Prestamo"%>
<%@page import="Entidad.Usuario"%>
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
		.table{
		 	width: 100%;
		    max-width: 40%;
		    padding: 15px;
		    margin: auto;
		    margin-top:15px;
	 	}
	 	
	 	#Filtrar{
	 		width: 20%;
	 	}
	 	
	 	.Mover{
			margin-right: 20px;
			margin-top: 5px;
	 	}
	 	
	 	.btnDD{
	 		width: 100%
	 	}]
	</Style>
	
	<title>Prestamos por aprobar</title>
	
</head>
<body>

	<jsp:include page="MenuAdmin.jsp"></jsp:include>
	
<form action="Servlet_Prestamo_Administrador" method="get">	    	
	<%
	
	ArrayList<Prestamo> lista_pre = new ArrayList<Prestamo>();
	Prestamo lista_prestamos = new Prestamo();
	// lista_prestamos = (Prestamo)request.getAttribute("lista_prestamos");
	lista_pre = (ArrayList<Prestamo>)request.getAttribute("lista_prestamos");
	
	%>
		<br><br>
		
	<div class="form-row mt-2" >
	<div class="col-3"> 
	&nbsp
	</div>
	
    <div class="col-3">  
    <h3>Filtros:</h3>
	<input type="checkbox" name="cbox1" value="Todos"> <label for="cbox1">Negados</label>
	<input type="checkbox" name="cbox2" value="aprobar"> <label for="cbox2">A aprobar</label>
	<input type="checkbox" name="cbox3" value="pagos"> <label for="cbox3">Pagos</label>	
	<input type="checkbox" name="cbox4" value="deuda"> <label for="cbox4">Con deuda</label> 
	<button type="submit" class="btn btn-danger btnDD" name="btnLimpiarFiltros" style="width: 32px; ">X</button>				
	
	</div>
	
	<div class="col-3"> 
	<input type="text" class="form-control" name="txtCbuCuenta" placeholder="CBU cuenta" title="Ingrese un CBU" >&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	<button type="submit" class="btn btn-primary btnDD" name="btn_buscarXcbu" style="width: 188px; ">Buscar</button>
	</div>
		</div>
		
	<div class="container">
		<table class="table ">
			<thead class="thead-light">
			    <tr>
			    	
			    	<th scope="col">ID</th>
					<th scope="col">CBU cuenta</th>
					<th scope="col">Importe pedido</th>
					<th scope="col">Cantidad de cuotas</th>
					<th scope="col">Pago por mes</th>
					<th scope="col">Estado: </th>
					<th scope="col"></th>
			
			    </tr>
		  	</thead>
		  	
		  	<tbody>
		  
		    <%if(lista_pre!=null){
		  		 for(Prestamo e : lista_pre)
				{%>
		
			    <tr>
									   
						<td><%=e.getId_prestamo()%> <input type="hidden" name="id_prestamo" value="<%= e.getId_prestamo() %>"></td>
						<td><%=e.getCbu_cuenta_deudor()%></td>
						<td><%=e.getInporte_pedido()%></td>
						<td><%=e.getCantidad_cuotas()%></td>
						<td><%=e.getPago_x_mes()%></td>

						<% if (!e.getAprobacion()&& e.getEstado()){  %>
						<td> <button type="submit" class="btn btn-primary btnDD" name="btn_Aceptar_prestamo" >Aceptar</button> </td>
						<td> <button type="submit" class="btn btn-primary btnDD" name="btn_Rechasar_prestamo" >Rechazar</button> </td>
						<%} 
						else if (!e.getEstado()&& e.getAprobacion()){
						%>
						<td> <button type="button" class="btn btn-success" name="btnPpago" >Prestamo pago</button> </td>
						<%} 
						if (!e.getAprobacion()&&!e.getEstado()){
						 %>
						 <td> <button type="button" class="btn btn-danger btnDD" name="btndene" >Prestamo rechazado</button> </td>
				<%}
				if ( e.getMonto_actual()>0 && e.getAprobacion() ){			
				 %>
				<td> <button type="button" class="btn btn-danger btnDD" name="btnPadeuda" >Adeuda: <%= e.getCuotas_a_pagar() %> cuotas</button> </td>
				<td> <button type="button" class="btn btn-danger btnDD" name="btnPadeuda2" >Total Deuda: $ <%=e.getMonto_actual() %></button> </td>
				<%} %>
					

						
						<td> <button type="submit" class="btn btn-success btnDD" name="btn_Aceptar_prestamo" >Aceptar</button> </td>
						<td> <button type="submit" class="btn btn-danger btnDD" name="btn_Rechasar_prestamo" >Rechazar</button> </td>
				
				
					</form>

			    </tr>
		    <%} 
		  	}%>
		    
			</tbody>
		</table>
	</div>
	</form>
</body>
</html>