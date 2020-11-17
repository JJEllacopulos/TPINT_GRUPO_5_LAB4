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
		}
		
		
		
		a{
			margin-left: auto;
			font-size: x-large;
			font-family:"Times New Roman", Times, serif;
			color: green;
			
		}
		
		h1 {
		  position: relative;
		  left: 50px;
		  top: 20px;
		}
		
		h2 {
		  position: relative;
		  left: 50px;
		  top: 10px;
		}
		
		
		
		
	</style>


</head>
<body>
	
	<jsp:include page="MenuAdmin.jsp"></jsp:include>
	
	<h1> <b> <a class="Titulo_1" href="#">Bienvenido <%=usuario.getNombre_usuario() %></a> </b> </h1>
	<h2> <a class="navbar-brand" href="#">Menu para administradores</a> </h2>
	
</body>
</html>