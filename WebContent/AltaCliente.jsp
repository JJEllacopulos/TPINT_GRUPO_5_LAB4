<%@page import="Entidad.Usuario"%>
<%@page import="Entidad.Localidad"%>
<%@page import="Entidad.Provincias"%>
<%@page import="Negocio.NegocioUsuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.RequestDispatcher"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.1.1.min.js">
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
if(request.getAttribute("filas")!=null){
	

int filas = (int)request.getAttribute("filas");

	

if(filas > 0){%>
<div id="hola" class="alert alert-primary alert-dismissible fade show" role="alert">
  <strong>Hola!</strong> Se cre� el usuario correctamente.
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
<% }}%>
<div class="container mt-5">
<form action="servletsCliente" method="post">
 <div class="form-row mt-4">

    <div class="col-6">

    	      <input type="text" class="form-control" name="txtUsuario" placeholder="Nombre de usuario" maxlength="20" title="Ingrese un usuario valido" required>
    	
    </div>
    <div class="col-6">
      <input type="password" class="form-control" name="txtPassword" placeholder="Contrase�a" minlength="4" maxlength="20" title="Ingrese una contrase�a valida" required>
    </div>
  </div>
   <div class="form-row mt-4">
    <div class="col-6">
      <input type="email" class="form-control" name="txtEmail" placeholder="Email" required>
    </div>
    <div class="col-6">
      <input type="text" class="form-control" name="txtTelefono" placeholder="Tel�fono" pattern="[0-9]{6,15}" title="Ingrese un telefono valido " required>
    </div>
  </div>

   <div class="form-row mt-4">
    <div class="col-6">
      <input type="text" class="form-control" name="txtCuil" placeholder="Cuil" pattern="[0-9]{9,11}" title="Ingrese un Cuil valido " required>
    </div>
    <div class="col-6">
      <input type="text" title="Ingrese un DNI valido " class="form-control" name="txtDni" placeholder="Dni" pattern="[0-9]{6,8}" required>
    </div>
      </div>
    <div class="form-row mt-4">
    <div class="col-5">
      <input type="text" class="form-control" name="txtApellido" placeholder="Apellido" title="Ingrese un apellido valido" pattern="[a-zA-Z�����,. '-]{2,49}" required>
    </div>
    <div class="col-5">
      <input type="text" class="form-control" name="txtNombre" placeholder="Nombre" title="Ingrese un nombre valido" pattern="[a-zA-Z�����,. '-]{2,49}" required>
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
      <input type="text" class="form-control" placeholder="Seleccionar Fecha de nacimiento" onfocus="(this.type='date')" onblur="(this.type='text')" name="txtFechaNacimiento" required>
    </div>
    
      </div>
          <div class="form-row mt-4">
    <div class="col-6">
    <input type="text" class="form-control" name="txtCalle" placeholder="Calle" title="Ingrese una calle valida" pattern="[a-zA-Z�����,. '-]{2,49}" required>
    </div>
    <div class="col-6">
      <input type="text" class="form-control" name="txtAltura" placeholder="Altura" title="Ingrese una altura valida" pattern="[0-9]{1,5}" required>
    </div>
      </div>
                <div class="form-row mt-4">
    <div class="col-4">
    <input type="text" readonly="true" class="form-control" name="txtPais" placeholder="Pais" value="Argentina" title="Ingrese un pais valido" pattern="[a-zA-Z�����,. '-]{2,49}" required>
    </div>
    <div class="col-4">
          <select  class="form-control" name="ddlProvincia">
<option selected>Seleccionar provincia</option>
	 <%
	 NegocioUsuario usuarioNegocio = new NegocioUsuario();
		 	ArrayList<Provincias> listaProvincias =  usuarioNegocio.Listar_Provincias();
			
		
		 if(listaProvincias!=null)
		 for(Provincias e : listaProvincias)
		{		
	%>	
	<option value="<%=e.getNombreProvincia()%>"><%=e.getNombreProvincia()%></option>
		<%  } %>
		
		
		</select>
    </div>
       <div class="col-4">
      <input type="text" class="form-control" name="txtLocalidad" placeholder="Localidad" title="Ingrese una localidad valida" required>
    </div>
      </div>
      <input type="submit"  class="btn btn-success mt-5 centrar" value="Confirmar" name="btnAceptar">
  
</form>

   <script>
   $('.alert').alert()

 </script>

</div>
</body>
</html>