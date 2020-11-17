<%@page import="Entidad.Usuario"%>
<%@page import="Entidad.TipoCuenta"%>
<%@page import="Negocio.NegocioCuentas"%>
<%@page import="java.util.ArrayList"%>
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
<Style>

</Style>
<title>Alta de cuenta</title>
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
<div class="container">
<form action="servletsCuentas" method="get" class="Alta">

 <div class="form-row mt-4">
    <div class="col-6">
    <input type="text" class="form-control" name="txtUsuario" placeholder="Nombre de usuario">
    </div>
    <div class="col-6">
      <select name="ddl_tipo_cuenta" class="form-control" name="ddlTipoCuenta">
<option selected>Seleccionar...</option>
	 <%
	 NegocioCuentas cuentaNegocio = new NegocioCuentas();
		 	ArrayList<TipoCuenta> listaTipoCuenta =  new ArrayList<TipoCuenta>();
		listaTipoCuenta =  cuentaNegocio.Obtener_TipoCuentas();
		
		 if(listaTipoCuenta!=null)
		 for(TipoCuenta e : listaTipoCuenta)
		{		
	%>	
	<option value="<%=e.getTipo_cuenta()%>"><%=e.getDescripcion()%></option>
		<%  } %>
		
		
		</select>
    </div>
      </div>
       <div class="form-row mt-4">
    <div class="col-6">
    <input type="text" class="form-control" name="txtSaldo" placeholder="Saldo">
    </div>
    <div class="col-6">
      
      <input type="submit"  class="btn btn-success" value="Confirmar" name="btnCrearCuenta">
	
    </div>
      </div>
</form>
</div>
</body>
</html>