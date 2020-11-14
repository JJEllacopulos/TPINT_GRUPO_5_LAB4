<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
 	margin: 50px;
 	}
 	 
</Style>
<body>
<jsp:include page="MenuCliente.jsp"></jsp:include>
<div class="container">
<table class="table ">
  <thead class="thead-light">
    <tr>

      <th scope="col">Descripción</th>
      <th scope="col">Cuotas impagas</th>
      <th scope="col">Cuotas totales</th>
      <th><th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Falabella compra</td>
      <td>2</td>
      <td>6</td>
      <td><button type="submit" class="btn btn-success boton ">Pagar</button></td>  
    </tr>
       <tr>
      <td>MercadoPago compra</td>
      <td>1</td>
      <td>3</td>
      <td><button type="submit" class="btn btn-success boton ">Pagar</button></td> 
    </tr>
  </tbody>
</table>
</div>
</body>
</html>