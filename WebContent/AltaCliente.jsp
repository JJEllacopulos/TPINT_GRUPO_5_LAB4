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

<title>Alta de cliente</title>

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

/*Usuario usuario = new Usuario();
usuario = (Usuario)session.getAttribute("userSession");
if(!usuario.getTipo_usuario().equals("ADMIN")){
	RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
	rd.forward(request, response);
}
*/
%>
<div class="container mt-5">
<form action="servletsCliente" method="get" class="Alta">
 <div class="form-row mt-4">
    <div class="col-6">
      <input type="text" class="form-control" name="txtUsuario" placeholder="Nombre de usuario">
    </div>
    <div class="col-6">
      <input type="password" class="form-control" name="txtPassword" placeholder="Contraseña">
    </div>
  </div>
   <div class="form-row mt-4">
    <div class="col-6">
      <input type="email" class="form-control" name="txtEmail" placeholder="Email">
    </div>
    <div class="col-6">
      <input type="text" class="form-control" name="txtTelefono" placeholder="Teléfono">
    </div>
  </div>
   <div class="form-row mt-4">
    <div class="col-6">
      <input type="text" class="form-control" name="txtCuil" placeholder="Cuil">
    </div>
    <div class="col-6">
      <input type="text" class="form-control" name="txtDni" placeholder="Dni">
    </div>
      </div>
    <div class="form-row mt-4">
    <div class="col-5">
      <input type="text" class="form-control" name="txtApellido" placeholder="Apellido">
    </div>
    <div class="col-5">
      <input type="text" class="form-control" name="txtNombre" placeholder="Nombre">
    </div>
      <div class="col">
      <select class="form-control" name="ddlSexo">
        <option selected>Seleccionar...</option>
        <option value=2>Masculino</option>
        <option value=1>Femenino</option>
      </select>
      </div>
    </div>
    <div class="form-row mt-4">
    <div class="col-6">
      <input type="text" class="form-control" placeholder="Seleccionar Fecha de nacimiento" onfocus="(this.type='date')" onblur="(this.type='text')" name="txtFechaNacimiento" >
    </div>
    <div class="col-6">
      <input type="text" class="form-control" name="txtNacionalidad" placeholder="Nacionalidad">
    </div>
      </div>
          <div class="form-row mt-4">
    <div class="col-6">
    <input type="text" class="form-control" name="txtCalle" placeholder="Calle">
    </div>
    <div class="col-6">
      <input type="text" class="form-control" name="txtAltura" placeholder="Altura">
    </div>
      </div>
                <div class="form-row mt-4">
    <div class="col-4">
    <input type="text" class="form-control" name="txtPais" placeholder="Pais">
    </div>
    <div class="col-4">
      <input type="text" class="form-control" name="txtProvincia" placeholder="Provincia">
    </div>
       <div class="col-4">
      <input type="text" class="form-control" name="txtLocalidad" placeholder="Localidad">
    </div>
      </div>
      <input type="submit"  class="btn btn-success mt-5 centrar" value="Confirmar" name="btnAceptar">
  
</form>
</div>
</body>
</html>