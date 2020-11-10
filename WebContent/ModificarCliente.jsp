<%@page import="Entidad.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<Style>
 	.Alta{
 	width: 100%;
    max-width: 600px;
    padding: 15px;
    margin: auto;
 	    }
 	 .crear{
 	  	width: 100%;
 
    margin: auto;
 	 }
</Style>
<title>Modificar de cliente</title>
</head>
<body>

<jsp:include page="MenuAdmin.html"></jsp:include>
<%

Usuario usuario = new Usuario();
usuario = (Usuario)request.getAttribute("usuario");

		%>
<div class="container">
<h1 class="mt-3 text-center mb-1 text-info">Modificar cliente</h1>
<form class="Alta">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Usuario</label>
      <input type="text" class="form-control" value="<%=usuario.getNombre_usuario()%>" name="txtUsuario" readonly>
    </div>
     <div class="form-group col-md-6">
      <label for="inputPassword4">Password</label>
      <input type="password" class="form-control" value="<%=usuario.getPassword()%>" name="txtPassword">
    </div>
  </div>
    <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Email</label>
      <input type="email" class="form-control" value="<%=usuario.getContacto().getEmail()%>" name="txtEmail">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Teléfono</label>
      <input type="text" class="form-control" value="<%=usuario.getContacto().getTelefono()%>" name="txtTelefono">
    </div>
  </div>
    <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Cuil</label>
      <input type="text" class="form-control" value="<%=usuario.getCuil()%>" name="txtCuil">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Dni</label>
      <input type="text" class="form-control" value="<%=usuario.getDni()%>" name="txtDni">
    </div>
  </div>
    <div class="form-row">
    <div class="form-group col-md-4">
      <label for="inputEmail4">Nombre</label>
      <input type="text" class="form-control" value="<%=usuario.getNombre_real()%>" name="txtNombre">
    </div>
    <div class="form-group col-md-4">
      <label for="inputPassword4">Apellido</label>
      <input type="text" class="form-control" value="<%=usuario.getApellido_real()%>" name="txtApellido">
        </div>
        <%if(usuario.getSexo()=="F") {%>
			          <div class="form-group col-md-4">
      <label for="inputState">Sexo</label>
      <select class="form-control" name="ddlSexo">
      
        <option selected value=1>Femenino</option>
        <option value=2>Masculino</option>
      </select>
    </div>
		<% }
		else {%>
	          <div class="form-group col-md-4">
<label for="inputState">Sexo</label>
<select class="form-control" name="ddlSexo">

<option value=1>Femenino</option>
<option selected value=2>Masculino</option>
</select>
</div>
			
	<%	} %>
        

      </div>
      
        <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputCity">Fecha de nacimiento</label>
      <input type="date" class="form-control" value="<%=usuario.getFecha_nacimiento()%>" name="txtFechaNacimiento">
    </div>
 <div class="form-group col-md-6">
      <label for="inputCity">Nacionalidad</label>
      <input type="text" class="form-control" value="<%=usuario.getNacionalidad()%>" name="txtNacionalidad">
    </div>

  </div>
      
  <div class="form-row">
  <div class="form-group col-md-6">
    <label for="inputAddress">Calle</label>
    <input type="text" class="form-control" id="inputAddress" value="<%=usuario.getDireccion().getCalle()%>"  name="txtCalle">
  </div>
    <div class="form-group col-md-6">
    <label for="inputAddress">Altura</label>
    <input type="text" class="form-control" id="inputAddress" value="<%=usuario.getDireccion().getAltura()%>" name="txtAltura">
  </div>
  </div>

  <div class="form-row">
    <div class="form-group col-md-4">
      <label for="inputCity">Provincia</label>
      <input type="text" class="form-control" value="<%=usuario.getDireccion().getProvincia()%>" name="txtProvincia">
    </div>
 <div class="form-group col-md-4">
      <label for="inputCity">Localidad</label>
      <input type="text" class="form-control" value="<%=usuario.getDireccion().getLocalidad()%>" name="txtLocalidad">
    </div>
     <div class="form-group col-md-4">
      <label for="inputCity">País</label>
      <input type="text" class="form-control" value="<%=usuario.getDireccion().getPais()%>" name="txtPais">
    </div>

  </div>
  
	<input type="submit" class="btn btn-primary crear" value="Modificar" name="btnModificarUsuario">
</form>
</div>
</body>
</html>