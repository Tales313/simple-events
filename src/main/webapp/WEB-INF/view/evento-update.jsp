<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Novo Evento</title>
<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
<style>
	body {background-color: #F8F8F8 ;}

    .i-circle.md-login{
      margin-left: 50px;
      margin-top: 50%;
      font-weight:900;
      padding: 10px;
      padding-right: 15px;
      padding-left: 15px;
      border-radius: 50%;
      color:black;
    }

</style>
</head>
<body>
<!--menu-->
	<!-- Dropdown Structure -->
	<ul id="dropdown1" class="dropdown-content">
		<li> </li>
		<li><a href="${pageContext.request.contextPath }/login/logout">Sair</a></li>
	</ul>
	<nav class="teal lighten-2" >
		<div class="nav-wrapper">
			<a href="#!" class="brand-logo">Simple event</a>
			<ul class="right hide-on-med-and-down">
				<li><a href="${pageContext.request.contextPath }/eventos"><i class="material-icons left">home</i>Home</a></li>
				<li><a href="${pageContext.request.contextPath }/eventos/add"><i class="material-icons left">event</i>Cadastrar eventos</a></li>
				<!-- Dropdown Trigger -->
				<li><a class="dropdown-trigger" href="#!"
					data-target="dropdown1"><span class="i-circle md-login center white ">${fn:toUpperCase(fn:substring(user.email, -1, 1))}</span><i class="material-icons right">arrow_drop_down</i></a></li>
			</ul>
		</div>
	</nav>
	
<!-- Formulario de Cadastro -->
<div class="row container">
    <p>&nbsp;</p>
    <form:form action="${pageContext.request.contextPath }/eventos/update/${evento.id}" method="post" class="col s12 white " modelAttribute="evento">
        <fieldset class="formulario">
            <legend> <i class="material-icons prefix " style="font-size: 70px">event_available</i></legend>
            <h5 class="light center">Atualizar Evento </h5>
            
            <!--Campo Descricao -->
            <div class="input-field col s12">
                <i class="material-icons prefix">event_note</i>
				<form:input path="descricao"/><form:errors path="descricao" />
					<form:errors path="descricao">
					<c:if test="${not empty evento}">
					${evento.descricao}
				</c:if>
			  </form:errors>
				<label for="descricao">Descricao</label>
            </div>

            <!--Campo Data -->
            <div class="input-field col s12">
                <i class="material-icons prefix">calendar_today</i>
 				<form:input path="data" type="date"/><form:errors path="data" />
				<form:errors path="data">
					<c:if test="${not empty evento}">
					${evento.data}
				</c:if>
			  </form:errors>
				<label for="data">Data</label>
            </div>

            <!--Campo Local -->
            <div class="input-field col s12">
                <i class="material-icons prefix">location_on</i>
				<form:input path="local"/><form:errors path="local" />
				<form:errors path="local">
					<c:if test="${not empty evento}">
					${evento.local}
				</c:if>
				</form:errors>
				<label for="local">Local</label>
            </div>

            <!--Botões-->
            <div class="input-field col s12">
                <input type="submit" value="atualizar" class="btn blue">
                <a href="${pageContext.request.contextPath }/eventos" class="btn red">cancelar</a>
            </div>
        </fieldset>
    </form:form>
</div>

</body>
</html>