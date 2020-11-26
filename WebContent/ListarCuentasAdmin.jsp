<%@page import="Entidad.Cuenta"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<script type="text/javascript">

	$(document).ready(function() {
		$('#table_id').DataTable();
	});
	
	   function ConfirmDelete() 
	    { 
	     var x = confirm("¿Estás seguro que deseas eliminar?"); 
	     if (x) 
	      return true; 
	     else 
	     return false; 
	    } 
	    $('.alert').alert()
</script> 

</head>
<body>
<jsp:include page="MenuAdmin.jsp"></jsp:include>
<div style="position: relative;">

<div style="position: absolute; left: 900px; top: 0px; z-index: 2;">

</div>

<div style="position: absolute; left: 100px; top: 60px; z-index: 1;">
<h1>Listado de cuentas</h1>

<% 
if(request.getAttribute("filasA")!=null){
	
int filas = (int)request.getAttribute("filasA");	

if(filas > 0){%>
<div class="alert alert-success alert-dismissible fade show" role="alert">
  <strong>Hola!</strong> Se creó la cuenta correctamente.
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>

<% }}%>

<% 
if(request.getAttribute("filasM")!=null){
	
int filas = (int)request.getAttribute("filasM");	

if(filas > 0){%>
<div class="alert alert-primary alert-dismissible fade show" role="alert">
  <strong>Hola!</strong> Se modificó la cuenta correctamente.
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>

<% }}%>

<% 
if(request.getAttribute("filasE")!=null){
	
int filas = (int)request.getAttribute("filasE");
	
if(filas > 0){%>
<div class="alert alert-danger alert-dismissible fade show" role="alert">
  <strong>Hola!</strong> Se eliminó la cuenta correctamente.
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>

<% }}%>

<% 
if(request.getAttribute("Mensaje")!=null){
	
%>
<div class="alert alert-danger alert-dismissible fade show" role="alert">
  <strong>!!!<%=request.getAttribute("Mensaje") %> </strong> 
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>

<% } %>

     <form action="servletsCuentas" method="get"> 
	<table id="table_id" class="display"border="0" width="1000" align="center">
		<thead>
			<tr>
				<th>·</th>
				<th>CBU cuenta</th>			
				<th>Nombre Usuario</th>
				<th>Alias</th>
				<th>Tipo de cuenta</th>
				<th>Saldo</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<%
ArrayList<Cuenta> listaC = new ArrayList<Cuenta>();
Cuenta cuenta = new Cuenta();
listaC = (ArrayList<Cuenta>)request.getAttribute("listaC");									
     if(listaC!=null){
  		 for(Cuenta e : listaC)
		{ 
  			 if (e.getEstado()==true){
%>
      <tr>
      <td>·<input type="hidden" name="cbuCuenta" value="<%= e.getCbu_cuenta()%>"></td>
      <td><%= e.getCbu_cuenta()%></td>
      <td><%=e.getNombre_usuario() %> </td>
      <td><%=e.getAlias() %></td>
      <td><%=e.getTipo_Cuenta() %></td>
      <td><%=e.getSaldo() %> </td>
      
      
      <td><button type="submit"  class="btn btn-danger btnDD" name="btnEliminarCuenta">Eliminar</button></td>    
      <td><input type="submit" class= "btn btn-primary" value="Modificar" name="btnModificarCuenta" /></td>
       </tr>
   
    <% } } }%>
			
		</tbody>
	</table>
 </form>
 


</div>
<script>

 
</script>
</div>

</body>
</html>