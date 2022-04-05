<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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



<script src="js/usuarios.js" type="text/javascript"></script>





<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="position-absolute top-50 start-50 translate-middle">
		<div class="input-field col " id="">
			<!--  disabled-->


		</div>
		<div class="row center">
			<div class="input-field col s8">

				<input type="text" class="validate" value="" id="txtNanme">
				<label>Nombre</label>
			</div>
			<div class="input-field col s6">
				<input type="text" class="validate" value="" id="txtAp">
				<label>Apellido Paterno</label>
			</div>
			<div class="input-field col s6">
				<input type="text" class="validate" value="" id="txtAm">
				<label>Apellido Materno</label>
			</div>
		</div>

		<div class="row center">
			<div class="input-field col s8">

				<input type="text" class="validate" value="" id="txtUs">
				<label>Usuario</label>
			</div>
			<div class="input-field col s6">
				<input type="password" class="validate" value="" id="txtPass">
				<label>Password</label>
			</div>
			<div class="input-field col s6" 	>
				<input type="text" class="validate" value="" id="txtidper"  >
				<label>id</label>
			</div>
		<div class="row">
			<div class="input-field col s6">
				<button class="btn waves-effect waves-light" onclick="updateUsuarios();">
				Update <i class="material-icons right">update</i>
				</button>
			</div>
		</div>
		</div>
	</div>

</body>
</html>