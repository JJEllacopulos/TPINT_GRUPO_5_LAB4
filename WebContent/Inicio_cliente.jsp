<%@page import="Entidad.Usuario"%>
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
<% 
Usuario usuario = new Usuario();
usuario = (Usuario)session.getAttribute("userSession");
%>



<style>
.centrar {
  margin: auto;
  
  display: block;
	margin-top: 20px;
  margin-left: 20%;
}

	.titulo a{
		margin-left: auto;
		font-size: x-large;
		font-family:"Times New Roman", Times, serif;
		color: green;
		
	}
	
	.titulo h1 {
		  
	  left: 50px;
	  top: 20px;
	}
	
	.titulo h2 {
	  
	  left: 50px;
	  top: 10px;
	}
	
	.est1 > li {
		float:left;
		
	}
	
	.est1 li a {
		background-color:#02b802;
		color:#fff;
		text-decoration:none;
		padding:10px 12px;
		display:block;
		height: 40px; 
		width: 80%;
		
	}
	
	
</style>
</head>
<body>
<jsp:include page="MenuCliente.jsp"></jsp:include>


<div class="centrar">
	<div class="titulo" >
	<a class="navbar-brand"  href="#">Bienvenido <%=usuario.getNombre_usuario() %></a> <br>
	<a class="navbar-brand" href="#">Menu para clientes</a> <br>
	</div>
	<div class="est1" >
	<div style="float: left; height: 50px; width: 33%;">  
		<li><a href="Servlet_Menu_clientes?link_1=1">Inicio <span class="sr-only">(current)</span></a></li>
	</div>
	<div  style="float: left; height: 50px; width: 33%;">  
		<li><a href="servletsCuentas?Param2=2">Mis cuentas</a></li>
	</div>
	<div style="float: left; height: 50px; width: 34%;"></div>
	<br>
	
	<div style="float: left; height: 50px; width: 33%;">  
		<li><a href="TransferenciaTerceros.jsp" >Transferencia a terceros</a></li>
	</div>
	<div  style="float: left; height: 50px; width: 33%;">  
		<li><a  href="TransferenciaCuentaPropia.jsp" >Transferencia a cuenta propia</a></li>
	</div>
	<div style="float: left; height: 50px; width: 34%;"></div>
	<br>
	
	<div style="float: left; height: 50px; width: 33%;">  
		<li><a href="Servlet_Menu_clientes?link_7=1">Solicitar prestamo</a></li>
	</div>
	<div style="float: left; height: 50px; width: 33%;">  
		<li><a href="Servlet_Menu_clientes?link_8=1">Lista de prestamos</a></li>
	</div>
	<div style="float: left; height: 50px; width: 34%;"></div>
	<br>
	
	<div style="float: left; height: 50px; width: 33%;">  
		<li><a href="Servlet_Menu_clientes?link_9=1">Mis datos</a></li>
	</div>
	<div style="float: left; height: 50px; width: 33%;">  
		<li><a href="Servlet_Menu_clientes?link_0=1">Cerrar Sesi�n</a></li>
	</div>
	<div style="float: left; height: 50px; width: 34%;"></div>
	<br>
	
	</div>
	</div>
</body>
</html>