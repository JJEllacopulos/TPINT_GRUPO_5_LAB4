<%@page import="Entidad.Usuario"%>
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

<title>Datos de usuario</title>
<style>
.centrar {
  margin: auto;
  margin-top:5%;
	margin-left:40%;
  display: block;
ml-2
}
</style>
</head>
<body>

<jsp:include page="MenuCliente.jsp"></jsp:include>
<%Usuario usuario = new Usuario();
usuario = (Usuario)request.getAttribute("usuario"); %>
	<div class="container centrar">
    <div class="row">
      <label class="text-dark">Nombre de usuario: </label><label class="text-success ml-2"><%= usuario.getNombre_usuario()%></label>
    </div>
    <div class="row">
         <label class="text-dark">Email: </label><label class="text-success ml-2"><%= usuario.getContacto().getEmail()%></label>
   
    </div>
    <div class="row">
       <label class="text-dark">Teléfono: </label><label class="text-success ml-2"><%=usuario.getContacto().getTelefono()%></label>
     
    </div>
    <div class="row">
       <label class="text-dark">Cuil: </label><label class="text-success ml-2"><%=usuario.getCuil()%></label>
    </div>

    <div class="row">
       <label class="text-dark">Dni: </label><label class="text-success ml-2"><%=usuario.getDni()%></label>
    
    </div>
    <div class="row">
<label class="text-dark">Apellido: </label><label class="text-success ml-2"><%=usuario.getApellido_real()%></label>
			
    </div>

   <div class="row">
   <label class="text-dark">Nombre: </label><label class="text-success ml-2"><%=usuario.getNombre_real()%></label>
   
    </div>
    <div class="row">
       <label class="text-dark">Género: </label><label class="text-success ml-2"><%=usuario.getSexo()%></label>
   
   </div>
 
    <div class="row">
       <label class="text-dark">Fecha nacimiento: </label><label class="text-success ml-2"><%=usuario.getFecha_nacimiento()%></label>
    </div>
    <div class="row">
       <label class="text-dark">Nacionalidad: </label><label class="text-success ml-2"><%=usuario.getNacionalidad()%></label>
    </div>

    <div class="row">
       <label class="text-dark">Calle: </label><label class="text-success ml-2"><%=usuario.getDireccion().getCalle()%></label>
    </div>
    <div class="row">
       <label class="text-dark">Altura: </label><label class="text-success ml-2"><%=usuario.getDireccion().getAltura()%></label>
    </div>
      <div class="row">
       <label class="text-dark">Calle: </label><label class="text-success ml-2"><%=usuario.getDireccion().getPais()%></label>
    </div>
    <div class="row">
           <label class="text-dark">Provincia: </label><label class="text-success ml-2"><%=usuario.getDireccion().getProvincia()%></label>
      </div>
       <div class="row">
       <label class="text-dark">Localidad: </label><label class="text-success ml-2"><%=usuario.getDireccion().getLocalidad()%></label>
    </div>

  </div>
</body>
</html>