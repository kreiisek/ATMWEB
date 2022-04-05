<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="web.atm.model.ClienteDAO"
	import="web.atm.entity.Cliente"%>
<!DOCTYPE html>
<html>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.0.6/build/pure-min.css"
	integrity="sha384-Uu6IeWbM+gzNVXJcM9XV3SohHtmWE+3VGi496jvgX1jyvDTXfdK+rfZc8C1Aehk5"
	crossorigin="anonymous">

<script src="js/cuentas.js" type="text/javascript"></script>


<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<%
	Cliente cliper = (Cliente) session.getAttribute("usr");
	%>
	<div class="row center">
		<form action="Cuenta" method="POST" class="col s12">
			<div class="row">


				<div class="row" style="float: left; margin: 10px; padding: 15px;">

					<div
						class="position-absolute  top-40 center start-50 translate-middle">

					</div>
				</div>

				<div class="input-field col " id="txtoculto" hidden="hidden">
					<!--  disabled-->
					<input type="text" class="validate"
						value="<%out.print(cliper.getIdCliente());%>" id="idclnt">
					<label>ID</label>
				</div>

				<div class="row " style="float: left; padding: 15px;">
					<div class="input-field col s6">
						<input type="text" class="validate" id="txtcnta"> <label>No
							Cuenta</label>
					</div>

					<div class="input-field col s6">
						<input type="text" class="validate" id="txtsaldo"> <label>Saldo
							Inicial</label>
					</div>

					<!--  	<div class="input-field col s6">
						<input type="text" class="validate" id="txtmoneda"> <label>Moneda</label>
					</div> -->

					<div class="input-field col s6 ">
						<select class="form-select" aria-label="Default select example"
							id="txtmoneda">
							<option selected>Moneda</option>
							<option value="MXN">MXN</option>
							<option value="USD">USD</option>

						</select>
					</div>



				<!--  <div class="input-field col s6">
						<input type="text" class="validate" id="txttipo"> <label>Tipo
							De cuenta</label>
					</div> -->


					<div class="input-field col s6 ">
						<select class="form-select" aria-label="Default select example"
							id="txttipo">
							<option selected>Tipo Cuenta</option>
							<option value="Credito">CREDITO</option>
							<option value="Debito">DEBITO</option>
							<option value="Nomina">NOMINA</option>

						</select>
					</div>


				</div>

			</div>

			<div class="row">
				<div class="input-field col s6">
					<button type="button" class="btn waves-effect waves-light"
						onclick="insertCuenta();">
						Agregar<i class="material-icons right">add_circle_outline</i>
					</button>
				</div>
			</div>

		</form>
	</div>



</body>
</html>