<%@page import="Entidad.Usuario"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.RequestDispatcher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu cliente</title>

	<style type="text/css">
			
			* {
				margin:0px;
				padding:0px;
				
			}
			
			#header {
				margin-left: auto;
				width:20%;
				font-family:"Times New Roman", Times, serif;
				z-index: 2;
				
			}
			
			ul, ol {
				list-style:none;
				
			}
			
			.nav > li {
				float:left;
			}
			
			.nav li a {
				background-color:#006400;
				color:#fff;
				text-decoration:none;
				padding:10px 12px;
				display:block;
				
			}
			
			.nav li a:hover {
				background-color:#434343;
				
			}
			
			.nav li ul {
				display:none;
				position:absolute;
				min-width:140px;
				
			}
			
			.nav li:hover ul {
				display:block;
			}
			
			.nav li ul li {
				position:relative;
				
			}
			
			.nav li ul li ul {
				right:-140px;
				top:0px;
				
			}
			
			.boton{
			background-color:#006400;
				color:#fff;
				text-decoration:none;
				padding:10px 12px;
				display:block;
			}
			
		</style>

</head>
<body>
<%
Usuario aux = new Usuario();
aux = (Usuario)session.getAttribute("userSession");
if(!aux.getTipo_usuario().equals("user")){
	RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
	rd.forward(request, response);
	}
%>
 <nav class="navbar navbar-expand-lg navbar-light bg-dark">
  <a class="navbar-brand text-white" href="#">Cliente</a>
  
  <!-- 
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse">
    <div class="navbar-nav">
      <a class="nav-link active ml-5 text-white" href="#">Inicio <span class="sr-only">(current)</span></a>
      <a class="nav-link text-white" href="servletsCuentas?Param2=1">Cuentas</a>
       <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle text-white" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Transferencia</a>
    <div class="dropdown-menu">
    <a class="dropdown-item" href="TransferenciaTerceros.jsp">A Terceros</a>
     <a class="dropdown-item " href="#">Cuenta</a>
      
    </div>
  </li>
      <a class="nav-link text-white" href="#"> Mi Perfil</a>
      <a class="nav-link text-white" href="ServletsLogin?Param4=4">Cerrar Sesión</a>

      <a class="nav-link text-white" href="ServletsLogin?Param4=4" href="#">Cerrar Sesión</a>
      
    </div>
  </div>
  -->
  
  <a class="navbar-brand" href="#">Usuario: <%=aux.getNombre_usuario() %></a>
  <div id="header">
		<ul class="nav">
			<li><a href="">Menu</a>
				<ul>
					<li><a href="Servlet_Menu_clientes?link_1=1">Inicio <span class="sr-only">(current)</span></a></li>
					<li><a href="servletsCuentas?Param2=2">Mis cuentas</a></li>
					 
					<div class="btn-group dropright">
					
					  <a type="button" class=" boton dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					    Transferencias 
					  </a>
					  <div class="dropdown-menu">
					    <!-- Dropdown menu links -->
					     <li><a href="TransferenciaTerceros.jsp" >A terceros</a></li>
					    <li><a  href="TransferenciaCuentaPropia.jsp" >A cuenta propia</a></li>
					  </div>
					</div>
					
					<li><a href="Servlet_Menu_clientes?link_7=1">Solicitar prestamo</a></li>
					<li><a href="Servlet_Menu_clientes?link_8=1">Lista de prestamos</a></li>
					<li><a href="Servlet_Menu_clientes?link_9=1">Mis datos</a></li>
					<li><a href="Servlet_Menu_clientes?link_0=1">Cerrar Sesión</a></li>
				
				</ul>
			</li>
		</ul>
	</div>
  
</nav>
</body>
</html>