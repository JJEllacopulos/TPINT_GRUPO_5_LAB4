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

<title>Modificar cliente</title>

<style>
.centrar {
  margin: auto;
  display: block;
}
</style>
</head>
<body>
<jsp:include page="MenuAdmin.html"></jsp:include>
<%
/*
Usuario aux = new Usuario();
aux = (Usuario)session.getAttribute("userSession");
if(!aux.getTipo_usuario().equals("ADMIN")){
	RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
	rd.forward(request, response);
	
}*/
Usuario usuario = new Usuario();
usuario = (Usuario)request.getAttribute("usuario");
%>


<div class="container mt-5">
<form action="servletsCliente" method="get">
 <div class="form-row mt-4">
    <div class="col-6">
      <input type="text" class="form-control" value="<%=usuario.getNombre_usuario()%>" name="txtUsuario" placeholder="Nombre de usuario">
    </div>
    <div class="col-6">
      <input type="password" class="form-control" value="<%=usuario.getPassword()%>" name="txtPassword" placeholder="Contraseña">
    </div>
  </div>
   <div class="form-row mt-4">
    <div class="col-6">
      <input type="email" class="form-control" value="<%=usuario.getContacto().getEmail()%>" name="txtEmail" placeholder="Email">
    </div>
    <div class="col-6">
      <input type="text" class="form-control" value="<%=usuario.getContacto().getTelefono()%>" name="txtTelefono" placeholder="Teléfono">
    </div>
  </div>
   <div class="form-row mt-4">
    <div class="col-6">
      <input type="text" class="form-control" value="<%=usuario.getCuil()%>"  name="txtCuil" placeholder="Cuil">
    </div>
    <div class="col-6">
      <input type="text" class="form-control" value="<%=usuario.getDni()%>" name="txtDni" placeholder="Dni">
    </div>
      </div>
    <div class="form-row mt-4">
    <div class="col-5">
      <input type="text" class="form-control" value="<%=usuario.getApellido_real()%>" name="txtApellido" placeholder="Apellido">
    </div>
    <div class="col-5">
      <input type="text" class="form-control"  value="<%=usuario.getNombre_real()%>" name="txtNombre" placeholder="Nombre">
    </div>
                <%if(usuario.getSexo()=="F") {%>
			          <div class="col">
          <select class="form-control" name="ddlSexo">
      
        <option selected value=1>Femenino</option>
        <option value=2>Masculino</option>
      </select>
    </div>
		<% }
		else {%>
	          <div class="col">
<select class="form-control" name="ddlSexo">
<option value=1>Femenino</option>
<option selected value=2>Masculino</option>
</select>
</div>
			
	<%	} %>
      </div>
      

    <div class="form-row mt-4">
    <div class="col-6">
      <input type="date" class="form-control" value="<%=usuario.getFecha_nacimiento()%>"  name="txtFechaNacimiento" >
    </div>
    <div class="col-6">
      <input type="text" class="form-control" value="<%=usuario.getNacionalidad()%>" name="txtNacionalidad" placeholder="Nacionalidad">
    </div>
      </div>
          <div class="form-row mt-4">
    <div class="col-6">
    <input type="text" class="form-control" value="<%=usuario.getDireccion().getCalle()%>" name="txtCalle" placeholder="Calle">
    </div>
    <div class="col-6">
      <input type="text" class="form-control" value="<%=usuario.getDireccion().getAltura()%>" name="txtAltura" placeholder="Altura">
    </div>
      </div>
                <div class="form-row mt-4">
    <div class="col-4">
    <input type="text" class="form-control" value="<%=usuario.getDireccion().getPais()%>" name="txtPais" placeholder="Pais">
    </div>
    <div class="col-4">
      <input type="text" class="form-control" value="<%=usuario.getDireccion().getProvincia()%>" name="txtProvincia" placeholder="Provincia">
    </div>
       <div class="col-4">
      <input type="text" class="form-control" value="<%=usuario.getDireccion().getLocalidad()%>" name="txtLocalidad" placeholder="Localidad">
    </div>
      </div>
      <input type="submit"  class="btn btn-success mt-5 centrar" value="Confirmar" name="btnModificarUsuario">
      
</form>
</div>
</body>
</html>