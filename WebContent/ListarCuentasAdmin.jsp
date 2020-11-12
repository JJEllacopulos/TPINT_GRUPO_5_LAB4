<%@page import="Entidad.Cuenta"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<Style>
 	.table
 	{
 		width: 100%;
    max-width: 60%;
    padding: 15px;
    margin: auto;
 	}
 	.fila{
 	width: 30%;
 	}
 	.boton{
 	width: 100%;
 	}
</Style>
</head>
<body>
<jsp:include page="MenuAdmin.html"></jsp:include>
<h1 class="mt-3 text-center mb-4 text-info">Cuentas</h1>
<div class="container">
<table class="table ">
  <thead class="thead-light">
    <tr>

      <th scope="col">CBU de cuenta </th>
      <th scope="col">Tipo de cuenta  </th>   
      <th scope="col">Nombre y Apellido </th>
      <th scope="col">Estado </th>
      <th class="fila" scope="col"></th>
      <th class="fila" scope="col"></th>
    </tr>
  </thead>
  <tbody>
    <tr>
 
  <%
ArrayList<Cuenta> listaC = new ArrayList<Cuenta>();
Cuenta cuenta = new Cuenta();
listaC = (ArrayList<Cuenta>)request.getAttribute("listaC");

		%>
    
    <%  if(listaC!=null){
  		 for(Cuenta e : listaC)
		{ 
  			 if (e.getEstado()==true){
%>

    <tr>
      <form action="servletsCuentas" method="get">
      <td><%= e.getCbu_cuenta() %><input type="hidden" name="cbuCuenta" value="<%=e.getCbu_cuenta() %>"></td>
      <td><%=e.getTipo_Cuenta() %></td>
      <td><%=e.getNombre_usuario() %> </td>
    <td><%= e.getEstado() %> </td>
      
      <td><input type="submit" class="btn btn-danger boton" value="Eliminar" name="btnEliminarCuenta"></td> 
   <td><input type="submit" class= "btn btn-primary" value="Modificar" name="btnModificarCuenta"></td> 
   
    </form>
    <% } } }%>
 
    </tr>
       
  </tbody>
</table>
</div>
</body>
</html>