<%@page import="Entidad.Movimiento"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
 	margin: 50px;
 	}
 	 
</Style>
<body>
<jsp:include page="MenuCliente.jsp"></jsp:include>
	<%
	
	ArrayList<Movimiento> listaMovimiento = new ArrayList<Movimiento>();
	

	listaMovimiento = (ArrayList<Movimiento>)request.getAttribute("listaMovimientos");
	
	%>
<div class="container">
<table class="table ">
  <thead class="thead-light">
    <tr>
    <th scope="col">Movimiento</th>
      <th scope="col">Fecha</th>
      <th scope="col">Monto</th>
 <%  if(listaMovimiento!=null){
  		 for(Movimiento e : listaMovimiento)
		{
%>
      
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><%= e.getTipo_movimiento() %></td>
      <td><%= e.getFecha_creacion() %></td>
         <%if(e.getImporte()>0){ %>
      <td class="text-success"><b>$<%= e.getImporte()%></b></td>
       <% } else{%>
         <td class="text-danger"><b>$<%= e.getImporte()%></b></td>
         <% }%>
      <td></td> 
    </tr>

     <% } }%>
  </tbody>
</table>
</div>
</body>
</html>