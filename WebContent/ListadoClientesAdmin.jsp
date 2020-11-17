<%@page import="Entidad.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.RequestDispatcher"%>
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
    max-width: 40%;
    padding: 15px;
    margin: auto;
    margin-top:15px;
 	}
 	#Filtrar
 	{
 	
 	width: 20%;
 	}
 	.Mover
 	{
 	
		margin-right: 20px;
		margin-top: 5px;
 	}
 	
 	.btnDD{
 	width: 100%
 	}]
 	 
</Style>
</head>

<body>

	<jsp:include page="MenuAdmin.jsp"></jsp:include>
	
	<div class="container Mover  ">
	<form action="servletsCliente" method="get">
	<div class="row mt-5  ">
		<div class="col">
		
	      <input type="text" name="txtBuscarCliente" class="form-control" placeholder="Ingrese un nombre de usuario...">
	      <% 	String usuarioInvalido;
	usuarioInvalido = (String)request.getAttribute("usuarioInvalido");
	if(usuarioInvalido!= null){
	%>
	      <label class="text-danger"> <%=usuarioInvalido %></label>
	      <% }%>
	      </div>
	      <div class="col">
	      <button type="submit" name="btnBuscarCliente" class="btn btn-primary ml-2">Buscar</button>
	      </div>
	         
	      
	      <div class="col">
	      <a class="btn btn-success" href="AltaCliente.jsp">Nuevo cliente</a>
	       </div>
	    </div>
	     </form>
	    </div>
	    
	
	    	
	<%
	
	ArrayList<Usuario> listaU = new ArrayList<Usuario>();
	Usuario usuarioFiltrado = new Usuario();
	usuarioFiltrado = (Usuario)request.getAttribute("usuarioFiltrado");
	listaU = (ArrayList<Usuario>)request.getAttribute("listaU");
	
	%>
	
	<div class="container">
	<table class="table ">
	  <thead class="thead-light">
	    <tr>
	      <th scope="col">Usuario</th>
	      <th scope="col">Nombre</th>
	      <th scope="col">Apellido</th>
	      <th scope="col">DNI</th>
	      <th scope="col">Email</th>
	      <th scope="col">Teléfono</th>
	      <th scope="col">Provincia</th>
	      <th scope="col"></th>
	
	     
	    </tr>
	  </thead>
	  <tbody>
	    <%  if(listaU!=null){
	  		 for(Usuario e : listaU)
			{
	%>
	
	    <tr>
	      <form action="servletsCliente" method="get">
	      <td><%=e.getNombre_usuario() %> <input type="hidden" name="nombreUsuario" value="<%=e.getNombre_usuario() %>"></td>
	      <td><%=e.getNombre_real() %></td>
	      <td><%=e.getApellido_real()%></td>
	      <td><%=e.getDni()%></td>
	      <td><%=e.getContacto().getEmail()%></td>
	      <td><%=e.getContacto().getTelefono()%></td>
	      <td><%=e.getDireccion().getProvincia()%></td>
	
	
	
	<td>

    <div class="btn-group dropright">
  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Opciones
  </button>
  <div class="dropdown-menu">
    <!-- Dropdown menu links -->
     <li><button type="submit" class="btn btn-primary btnDD" name="btnModificar" >Modificar</button></li>
    <li><button type="submit" class="btn btn-danger btnDD" name="btnEliminar">Eliminar</button></li>
    <li><button type="submit" class="btn btn-success btnDD" name="btnDetalles">Ver detalles</button></li>
  </div>
</div>

</td>
	
   </form>
	    </tr>
	    
	    <%} } else if(usuarioFiltrado.getNombre_usuario()!=null){%>	

	
	    <tr>
	      <form action="servletsCliente" method="get">
	      <td><%=usuarioFiltrado.getNombre_usuario() %> <input type="hidden" name="nombreUsuario" value="<%=usuarioFiltrado.getNombre_usuario() %>"></td>
	      <td><%=usuarioFiltrado.getNombre_real() %></td>
	      <td><%=usuarioFiltrado.getApellido_real()%></td>
	      <td><%=usuarioFiltrado.getDni()%></td>
	      <td><%=usuarioFiltrado.getContacto().getEmail()%></td>
	      <td><%=usuarioFiltrado.getContacto().getTelefono()%></td>
	      <td><%=usuarioFiltrado.getDireccion().getProvincia()%></td>
	
	
	
	<td>

    <div class="btn-group dropright">
  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Opciones
  </button>
  <div class="dropdown-menu">
    <!-- Dropdown menu links -->
     <li><button type="submit" class="btn btn-primary btnDD" name="btnModificar" >Modificar</button></li>
    <li><button type="submit" class="btn btn-danger btnDD" name="btnEliminar">Eliminar</button></li>
    <li><button type="submit" class="btn btn-success btnDD" name="btnDetalles">Ver detalles</button></li>
  </div>
</div>

</td>
	
   </form>
	    </tr>
	    
	    <%  }%>	
	  </tbody>
	</table>
	</div>
	
</body>
</html>