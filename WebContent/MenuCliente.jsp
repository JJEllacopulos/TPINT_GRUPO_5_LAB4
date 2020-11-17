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
    <a class="dropdown-item" href="#">A Terceros</a>
     <a class="dropdown-item " href="#">Cuenta</a>
      
    </div>
  </li>
      <a class="nav-link text-white" href="#"> Mi Perfil</a>
      <a class="nav-link text-white" href="ServletsLogin?Param4=4">Cerrar Sesión</a>
      <a class="nav-link text-white" href="#">Usuario: <%=aux.getNombre_usuario() %></a>
    </div>
  </div>
</nav>
</body>
</html>