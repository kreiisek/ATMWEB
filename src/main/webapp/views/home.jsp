<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="web.atm.entity.Cliente"%>
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



<script src="js/menu.js" type="text/javascript"></script>
<script src="js/usuarios.js" type="text/javascript"></script>
<script src="js/logueo.js" type="text/javascript"></script>
<!--  <script src="js/inicio.js" type="text/javascript"></script> -->
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	Cliente cliper = (Cliente) session.getAttribute("usr");
	%>



	<div class="col s6 center">
		<div class="pure-menu pure-menu-horizontal pure-menu-scrollable">

			<ul class="pure-menu-list">
				<li class="pure-menu-item"><a onclick="cargarsession();"
					class="material-icons right">account_circle</a></li>
				<li class="pure-menu-item"><a onclick="cargafaddcnt();"
					class="pure-menu-link">Crear Nueva Cuenta</a></li>
				<li class="pure-menu-item"><a onclick="cargaraccs();"
					class="pure-menu-link">Mostrar Cuentas</a></li>
				<li class="pure-menu-item"><a onclick="cargartransac();"
					class="pure-menu-link">Transacciones</a></li>
				<li class="pure-menu-item"><a onclick="cargarmovs();"
					class="pure-menu-link">Movimientos</a></li>
				<li class="pure-menu-item"><a onclick="cargarupus();"
					class="pure-menu-link">Actualizar Informacion</a></li>
				<li class="pure-menu-item"><a href="Login" class="pure-menu-link">Cerrar
						Session</a></li>
			</ul>
		</div>
	</div>
	<div id="Datosp">

		<div class="input-field col " >
			<!--  disabled-->
			<input type="text" class="validate"
				value="<%out.print(cliper.getIdPersona());%>" id="idusuario"
				hidden="hidden">

		</div>
		<div class="row center">
			<div class="input-field col s8">

				<input type="text" class="validate"
					value="<%out.print(cliper.getNombre());%>" name="txtNanme" disabled>
				<label>Nombre</label>
			</div>
			<div class="input-field col s6">
				<input type="text" class="validate"
					value="<%out.print(cliper.getApPaterno());%>" name="txtAp" disabled>
				<label>Apellido Paterno</label>
			</div>
			<div class="input-field col s6">
				<input type="text" class="validate"
					value="<%out.print(cliper.getApMaterno());%>" name="txtAm" disabled>
				<label>Apellido Materno</label>
			</div>
		</div>
	</div>


	<div id="container" class="col s6 center">

		<div id="subcontainer" class="col s6 center"></div>
	</div>

</body>
</html>