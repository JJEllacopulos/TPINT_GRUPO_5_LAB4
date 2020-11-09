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
<title>Alta de cliente</title>
</head>
<body>
<jsp:include page="MenuAdmin.html"></jsp:include>
<div class="container">
<h1 class="mt-3 text-center mb-1 text-info">Alta de cliente</h1>
<form action="servletsCliente" method="get" class="Alta">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Usuario</label>
      <input type="text" class="form-control" name="txtUsuario">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Password</label>
      <input type="password" class="form-control" name="txtPassword">
    </div>
  </div>
    <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Email</label>
      <input type="email" class="form-control" name="txtEmail">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Teléfono</label>
      <input type="text" class="form-control" name="txtTelefono">
    </div>
  </div>
    <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Cuil</label>
      <input type="text" class="form-control" name="txtCuil">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Dni</label>
      <input type="text" class="form-control" name="txtDni">
    </div>
  </div>
    <div class="form-row">
    <div class="form-group col-md-4">
      <label for="inputEmail4">Nombre</label>
      <input type="text" class="form-control" name="txtNombre">
    </div>
    <div class="form-group col-md-4">
      <label for="inputPassword4">Apellido</label>
      <input type="text" class="form-control" name="txtApellido">
        </div>
          <div class="form-group col-md-4">
      <label for="inputState">Sexo</label>
      <select class="form-control" name="ddlSexo">
        <option selected>Seleccionar...</option>
        <option value=1>Femenino</option>
        <option value=2>Masculino</option>
      </select>
    </div>
      </div>
      
        <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputCity">Fecha de nacimiento</label>
      <input type="date" class="form-control" name="txtFechaNacimiento">
    </div>
 <div class="form-group col-md-6">
      <label for="inputCity">Nacionalidad</label>
      <input type="text" class="form-control" name="txtNacionalidad">
    </div>

  </div>
      
  <div class="form-row">
  <div class="form-group col-md-6">
    <label for="inputAddress">Calle</label>
    <input type="text" class="form-control" id="inputAddress"  name="txtCalle">
  </div>
    <div class="form-group col-md-6">
    <label for="inputAddress">Altura</label>
    <input type="text" class="form-control" id="inputAddress" name="txtAltura">
  </div>
  </div>

  <div class="form-row">
    <div class="form-group col-md-4">
      <label for="inputCity">Provincia</label>
      <input type="text" class="form-control" name="txtProvincia">
    </div>
 <div class="form-group col-md-4">
      <label for="inputCity">Localidad</label>
      <input type="text" class="form-control" name="txtLocalidad">
    </div>
     <div class="form-group col-md-4">
      <label for="inputCity">País</label>
      <input type="text" class="form-control" name="txtPais">
    </div>

  </div>
  
	<input type="submit" class="btn btn-primary crear" value="Crear cliente" name="btnAceptar">
  
</form>
</div>
</body>
</html>