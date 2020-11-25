<%@page import="Entidad.Usuario"%>
<%@page import="Entidad.TipoCuenta"%>
<%@page import="Entidad.Cuenta"%>	
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
	
	<title>Pagar prestamos</title>
	
</head>
<body>
	<jsp:include page="MenuCliente.jsp"></jsp:include>

<div class="container">
<form action="Servlet_Prestamo_Cliente" method="get" >
<input type="hidden" name="id_prestamo" value="<%=(int)request.getAttribute("id_prestamo")%>">
 <div class="form-row mt-4">
    <div class="col-6">
    <h4>CBU cuenta prestamo:</h4>
    <input type="text" class="form-control" value="<%=(String)request.getAttribute("cbu_prestamo")%>" name="cbu_prestamo" placeholder="Nombre de usuario" title="Usuario prestamo" readonly="true" required>
    
    </div>
    <div class="col-6">
    <h4>Alias cuenta:</h4>
    <input type="text" class="form-control" value="<%=(String)request.getAttribute("Alias")%>" name="txtAlias" placeholder="Alias" title="Alias cuenta prestamo"  readonly="true" required>
    </div>
    
    <div class="col-6">      
    </div>
      </div>
       <div class="form-row mt-4">
    <div class="col-6">
    <h4>Total a pagar:</h4>
    <input type="text" class="form-control" value="<%=request.getAttribute("pagoxmes_prestamo")%>" name="pagoxmes_prestamo" placeholder="Saldo" title="Total a pagar" readonly="true" required>
    </div>
    <div class="col-6">
    	<h4>Deuda Final:</h4>
   <input type="text" class="form-control" value="<%=request.getAttribute("DeudaFinal")%>" name="DeudaFinal" placeholder="Saldo"  title="Deuda" readonly="true" required>
    </div>
    </div>
    
    <div class="form-row mt-4">
    
    <div class="col-6">  
    <h4>Cuenta con la cual va a pagar:</h4>
     <select  class="form-control" name="ddlCuenta" >
	
	 <% 
	 NegocioCuentas cuentaNegocio = new NegocioCuentas();
		 	ArrayList<Cuenta> listaCuenta =  new ArrayList<Cuenta>();
		listaCuenta =  cuentaNegocio.Obtener_Datos_Cuenta(String.valueOf(request.getAttribute("nombre_usuario")));

		 if(listaCuenta!=null)
		 for(Cuenta e : listaCuenta)
		{		
	%>	
	<option value="<%= e.getCbu_cuenta() %>">Alias: <%=e.getAlias()%> - Saldo: <%= e.getSaldo() %></option>	
		<% } %>
		
		</select>
    </div>    
    <div class="col-6">  
    <br> <br>
    &nbsp&nbsp&nbsp <input type="submit"  class="btn btn-success" value="PAGAR CUOTA" name="btnConfirmarPagoPrestamo">
    &nbsp<input type="submit"  class="btn btn-primary btnDD" value="VOLVER" name="btnVolverListarPrestamo">
    <br> <br>
         <% 
if(request.getAttribute("MensajeError")!=null){%>
<div class="alert alert-danger alert-dismissible fade show" role="alert">
  <strong>ERROR:</strong> La cuenta <%=(String)request.getAttribute("MensajeError")%> no posee el saldo suficiente, seleccione otra cuenta.
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
<% } 
if(request.getAttribute("MensajeConfirmacion")!=null){%>
<div class="alert alert-success alert-dismissible fade show" role="alert">
  <strong>+</strong> <%=(String)request.getAttribute("MensajeConfirmacion")%> 
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
<% }%>


    </div>  
    </div>
    
     
</form>
</div>
  
<script>$('.alert').alert()</script>

</body>
</html>