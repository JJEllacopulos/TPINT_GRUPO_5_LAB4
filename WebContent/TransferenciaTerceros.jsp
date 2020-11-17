<%@page import="Entidad.Cuenta"%>
<%@page import="Entidad.Usuario"%>
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
 	.Alta{
 	width: 100%;
    max-width: 600px;
    padding: 15px;
    margin: auto;
 	    }
 	 .crear{
 	  	width: 100%;
 
    margin: auto;
 	 }
 	 #inputMonto{
 	 	width: 50%;
 	 	margin: auto;
 	 	
 	 }
 	 #lblMonto{
 	     display: block;
    text-align: center;
 	
 	 }
</Style>
<title>Transferencia a terceros</title>
</head>
<body>
	
	<jsp:include page="MenuCliente.jsp"></jsp:include>
	
	<div class="container">
	<h1 class="mt-3 text-center mb-1 text-info">Transferencia a terceros</h1>
	<form action="servletsCuentas" method="get" class="Alta">
	  <div class="form-row">
	           <div class="form-group col-md-6">
	      <label for="inputState">Cuenta de origen</label>
	      <select  name="ddl_cuenta_origen" class="form-control">
	       <option selected>Seleccionar...</option>
	       <%

Usuario usuario = new Usuario();
usuario = (Usuario)session.getAttribute("userSession");
NegocioCuentas cuentaNegocio = new NegocioCuentas();
	 
		 	ArrayList<Cuenta> listaCuenta =  new ArrayList<Cuenta>();
		listaCuenta =  cuentaNegocio.Obtener_Datos_Cuenta(usuario.getNombre_usuario()); 
		
		 if(listaCuenta!=null)
		 for(Cuenta e : listaCuenta)
		{		
	%>	
	<option value= "<%=e.getCbu_cuenta() %>" ><%= e.getTipo_Cuenta() +" Saldo: $"+ e.getSaldo()  %></option>
		<%  } %>
		
		
	      </select>
	    </div>
	    <div class="form-group col-md-6">
	      <label for="inputEmail4">CBU (Destino)</label>
	      <input type="text" class="form-control" name="CBUdestino">
	    </div>
	  </div>
	    <div class="form-row">
	    <div class="form-group col-md-12">
	      <label id="lblMonto" for="lblMonto">Monto</label>
	      <input type="text" class="form-control" name="inputMonto">
	    </div>
	    
	  </div>
	
	  <input type="submit"  class="btn btn-success" value="Transferir" name="btnTransferirTerceros">
	</form>
	</div>
	
</body>
</html>