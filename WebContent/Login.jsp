

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 	<Style>
.centrar {
  margin: auto;
  
  display: block;
	margin-top: 20px;
  margin-left: 45%;
}
 	.form-signin{
 	width: 100%;
    max-width: 420px;
    padding: 15px;
    margin: auto;
 	    }
 	.container{
 	margin-top: 130px;}
 	</Style>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<title>Login</title>
</head>
<body>

<jsp:include page="MenuVacio.html"></jsp:include>

<div class="container">
<form method="post" action="ServletsLogin">

  <div class="form-label-group">
    <label for="inputEmail">Nombre del usuario</label>
    <input type="text" class="form-control" name="txtNombreUsuario">
  
  </div>

  <div class="form-label-group">
   <label class="mb-2 mt-2" for="inputPassword">Contrase�a</label>
    <input type="password" class="form-control" name="txtPassword">
   
  </div>
 <input type="submit" class="btn btn-success centrar" value="Aceptar" name="btnAceptar">
  <p class="mt-5 mb-3 text-muted text-center">� Grupo 5 - Turno Ma�ana - Programaci�n IV 2020</p>
</form>
</div>


</body>
</html>