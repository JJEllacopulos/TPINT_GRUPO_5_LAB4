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
 	
 	 .paginacion {
	margin:20px 0;
}
 
.paginacion ul {
	list-style:none;
	text-align: center;
}
 
.paginacion ul li {
	display:inline-block;
	margin-right:10px;
}
 
.paginacion ul li a {
	display:block;
	padding:10px 20px;
	color:#fff;
	background:#024959;
	text-decoration: none;
}
 
.paginacion ul li a:hover {
	background:#037E8C;
}
 
.paginacion ul li .active {
	background:#037E8C;
	font-weight:bold;
}
 	
 	.boton{
 	width: 100%;
 	}
</Style>
</head>
<body>
<jsp:include page="MenuAdmin.jsp"></jsp:include>
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
    <form action="servletsCuentas" method="get">
    <a> Filtrar por tipo de cuenta: </a>      
     <input type="radio"  name="chkBoxCC" value="CC"> CC </label>
<input type="radio"  name="chkBoxCA" value="CA"> CA </label>
      <input type="submit"  class="btn btn-success mt-5 centrar" value="Filtrar" name="btnFiltrar">
      </form>
  <section class="paginacion">
			<ul>
			<li><a href="Servlet_Menu_Administrador?link_10=1">PAGINAS:</a></li>
				<%
				for (int i=1; i<=(int)request.getAttribute("cantPag"); i++){
				%>
				<li><a href="Servlet_Menu_Administrador?link_10=<%=i%>"<%if((int)request.getAttribute("pagActual")==i){%>class="active"<%}%>><%=i%></a></li>
				<% 
				}
				%>
			</ul>
		</section>
    </tr>
       
  </tbody>
</table>
</div>
<script>$('.alert').alert()</script>
</body>
</html>