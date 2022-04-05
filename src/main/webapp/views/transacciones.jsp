<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<script src="js/cuentas.js" type="text/javascript"></script>
<script src="js/inicio.js" type="text/javascript"></script>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="row center">
		<form action="Cuenta" method="POST" class="col s12">
			<div class="row">


				<div class="row" style="float: left; margin: 10px; padding: 15px;">


					<div
						class="position-absolute  top-40 center start-50 translate-middle">



						<div class="row ">

							<div class="input-field col s6" hidden="hidden">
								<!-- 	<label>No Cuenta</label> -->
								<input type="text" class="validate" id="txtid" value=""
									disabled>
							</div>

							<div class="input-field col s6">
								<!-- 	<label>No Cuenta</label> -->
								<input type="text" class="validate" id="txtcnta" value=""
									disabled>
							</div>


							<div class="input-field col s6">
								<input type="text" class="validate" id="txtsaldo" disabled>

							</div>

							<div class="input-field col s6">
								<input type="text" class="validate" id="txtmoneda" disabled>

							</div>

							<div class="input-field col s6">
								<input type="text" class="validate" id="txttipo" disabled>

							</div>



							<div class="input-field col s8">

								<input type="text" class="validate" id="txtmonto"> <label>Monto</label>
							</div>

							<div class="input-field col s6 ">
								<select class="form-select" aria-label="Default select example"
									id="txtmonedatran">
									<option selected>Moneda</option>
									<option value="MXN">MXN</option>
									<option value="USD">USD</option>

								</select>
							</div>


						</div>

					</div>
				</div>
			</div>

		</form>
	</div>



	<div class="position-absolute start-50 center ">


		<div class="input-field col s6 ">
			<select class="form-select" aria-label="Default select example"
				id="accounts">
				<option selected>Selecciona tu numero de cuenta</option>

			</select>
		</div>


		<div class="input-field col s6">
			<button type="button" id="boton" class="btn waves-effect waves-light"
				onclick="retiro();">
				Retiro<i class="material-icons right"></i>
			</button>
		</div>


		<div class="input-field col s6">
			<button type="button" id="boton" class="btn waves-effect waves-light"
				onclick="deposito();">
				Deposito<i class="material-icons right"></i>
			</button>
		</div>

	</div>






</body>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

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

</html>