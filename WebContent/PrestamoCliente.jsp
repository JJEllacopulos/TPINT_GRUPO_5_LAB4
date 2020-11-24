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
 	 #inputMonto{
 	 	width: 50%;
 	 	margin: auto;
 	 	
 	 }
 	 #lblMonto{
 	     display: block;
    text-align: center;
 	
 	 }
</Style>
<title>Prestamo</title>
</head>
<body>
<jsp:include page="MenuCliente.jsp"></jsp:include>
<div class="container">
<h1 class="mt-3 text-center mb-1 text-info">Prestamo cliente</h1>
<form class="Alta">
  <div class="form-row">
           <div class="form-group col-md-6">
      <label for="inputState">Cuenta de destino</label>
      <select id="inputState" class="form-control">
        <option selected>Seleccionar...</option>
        <option>Opcion 1</option>
        <option>Opcion 2</option>
      </select>
    </div>
   <div class="form-group col-md-6">
      <label for="inputState">Cantidad de cuotas</label>
      <select id="inputState" class="form-control">
        <option selected>Seleccionar...</option>
        <option>Opcion 1</option>
        <option>Opcion 2</option>
      </select>
    </div>
  </div>
    <div class="form-row">
    <div class="form-group col-md-12">
      <label id="lblMonto" for="lblMonto">Monto total</label>
      <input type="text" class="form-control" id="inputMonto" pattern="[0-9.]{0,10000000}" title="Ingrese saldo valido" required>
    </div>
    
  </div>

  <button type="submit" class="btn btn-primary crear mt-2">Confirmar</button>
</form>
</div>
</body>
</html>