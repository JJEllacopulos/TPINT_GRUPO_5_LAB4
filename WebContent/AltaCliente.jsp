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
<jsp:include page="MenuAdmin.jsp"></jsp:include>
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
<form action="servletsCliente" method="get">
 <div class="form-row mt-4">
    <div class="col-6">
      <input type="text" class="form-control" name="txtUsuario" placeholder="Nombre de usuario" maxlength="20" title="Ingrese un usuario valido" required>
    </div>
    <div class="col-6">
      <input type="password" class="form-control" name="txtPassword" placeholder="Contraseña" minlength="4" maxlength="20" title="Ingrese una contraseña valida" required>
    </div>
  </div>
   <div class="form-row mt-4">
    <div class="col-6">
      <input type="email" class="form-control" name="txtEmail" placeholder="Email">
    </div>
    <div class="col-6">
      <input type="text" pattern="[0-9]{6,15}" title="Ingrese un telefono valido " class="form-control" name="txtTelefono" placeholder="Teléfono" required>
    </div>
  </div>
   <div class="form-row mt-4">
    <div class="col-6">
      <input type="text" pattern="[0-9]{9,11}" title="Ingrese un Cuil valido " class="form-control" name="txtCuil" placeholder="Cuil" required>
    </div>
    <div class="col-6">
      <input type="text" pattern="[0-9]{6,8}" title="Ingrese un DNI valido " class="form-control" name="txtDni" placeholder="Dni" required>
    </div>
      </div>
    <div class="form-row mt-4">
    <div class="col-5">
      <input type="text" class="form-control" name="txtApellido" placeholder="Apellido" title="Ingrese un apellido valido" pattern="[a-zA-Záéíóú,.'-]{2,49}"required>
    </div>
    <div class="col-5">
      <input type="text" class="form-control" name="txtNombre" placeholder="Nombre" title="Ingrese un nombre valido" pattern="[a-zA-Záéíóú,.'-]{2,49} "required>
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
      <input type="text" class="form-control" name="txtNacionalidad" placeholder="Nacionalidad" title="Ingrese una nacionalidad valida" pattern="[a-zA-Záéíóú,.'-]{2,49} "required>
    </div>
      </div>
          <div class="form-row mt-4">
    <div class="col-6">
    <input type="text" class="form-control" name="txtCalle" placeholder="Calle" title="Ingrese una calle valida" pattern="[a-zA-Záéíóú,.'-]{2,49} "required>
    </div>
    <div class="col-6">
      <input type="text" pattern="[0-9]{1,5}"  title="Ingrese una altura valida" class="form-control" name="txtAltura" placeholder="Altura" required>
    </div>
      </div>
                <div class="form-row mt-4">
    <div class="col-4">
    <input type="text" class="form-control" name="txtPais" placeholder="Pais" title="Ingrese un pais valido" pattern="[a-zA-Záéíóú,.'-]{2,29} "required>
    </div>
    <div class="col-4">
      <input type="text" class="form-control" name="txtProvincia" placeholder="Provincia" title="Ingrese una provincia valida" pattern="[a-zA-Záéíóú,.'-]{2,29} "required>>
    </div>
       <div class="col-4">
      <input type="text" class="form-control" name="txtLocalidad" placeholder="Localidad" title="Ingrese una localidad valida" required>>
    </div>
      </div>
      <input type="submit"  class="btn btn-success mt-5 centrar" value="Confirmar" name="btnAceptar">
  
</form>
</div>
</body>
</html>