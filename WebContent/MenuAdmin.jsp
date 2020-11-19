<%@page import="Entidad.Usuario"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.RequestDispatcher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu administrador</title>

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
			
		</style>
		
</head>
<body>
<%

Usuario usuario = new Usuario();
usuario = (Usuario)session.getAttribute("userSession");
if(!usuario.getTipo_usuario().equals("ADMIN")){
	RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
	rd.forward(request, response);
}

%>
 <nav class="navbar navbar-expand-lg navbar-light bg-success">
 
  <a class="navbar-brand" href="#">Administrador</a>
  
  <!-- 
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  
  
  <div class="collapse navbar-collapse">
    <div class="navbar-nav">
      <a class="nav-link active ml-5 text-white" href="#">Inicio <span class="sr-only">(current)</span></a>
      <a class="nav-link text-white" href="servletsCuentas?Param3=3">Cuentas</a>
      <a class="nav-link text-white" href="servletsCliente?Param1=1">Clientes</a>
      <a class="nav-link text-white" href="#">Reportes</a>
      <a class="nav-link text-white" href="ServletsLogin?Param4=4">Cerrar Sesión</a>
    </div>
  </div>
   -->
  
	
	<a class="navbar-brand" href="#">Usuario: <%=usuario.getNombre_usuario() %></a>
	 <div id="header">
		<ul class="nav">
			<li><a href="">Menu</a>
				<ul>
					<li><a href="Servlet_Menu_Administrador?link_1=1">Inicio <span class="sr-only">(current)</span></a></li>
					<li><a href="Servlet_Menu_Administrador?link_2=1">Cuentas</a></li>
					<li><a href="Servlet_Menu_Administrador?link_8=1">Alta Cuenta</a></li>
					<li><a href="Servlet_Menu_Administrador?link_10=1">Listar Cuentas</a></li>
					<li><a href="Servlet_Menu_Administrador?link_3=1">Clientes</a></li>
					<li><a href="Servlet_Menu_Administrador?link_7=1">Alta Cliente</a></li>
					<li><a href="Servlet_Menu_Administrador?link_4=1">Prestamos a aprobar</a></li>
					<li><a href="Servlet_Menu_Administrador?link_0=1">Cerrar Sesión</a></li>
				</ul>
			</li>
		</ul>
	</div>
  
</nav>
</body>
</html>