<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<%
String tituloPagina = "Home";
String pathView = "/home";

if(request.getAttribute("tituloPagina") != null)
	tituloPagina = (String) request.getAttribute("tituloPagina");

if(request.getAttribute("pathView") != null)
	pathView = (String) request.getAttribute("pathView");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title><%=(String) request.getAttribute("tituloPagina")%></title>

<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs4/dt-1.10.23/datatables.min.css" />
	
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
		
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/custom.css" />
</head>
<body>
	

<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
		<a class="navbar-brand" href="#">SmartPharma</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="${pageContext.request.contextPath}/home">Início <span
						class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/laboratorio">Laboratorios</a></li>
					
				<li class="nav-item"><a class="nav-link" 
				href="${pageContext.request.contextPath}/medicamento">Medicamentos</a></li>
					
				<li class="nav-item"><a class="nav-link" 
				href="${pageContext.request.contextPath}/receita">Receitas</a></li>
					
				<li class="nav-item"><a class="nav-link" 
				href="${pageContext.request.contextPath}/venda">Vendas</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="text" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>

	<main role="main" class="container">
		<div class="container-template">
			<h1><%=(String) request.getAttribute("tituloPagina")%></h1>
			<%
			if ((String) request.getAttribute("subtituloPagina") != null)
			{
				out.print("<p class=\"lead\">");
				out.print((String) request.getAttribute("subtituloPagina"));
				out.println("</p>");
			}
			%>
		</div>


		

		<jsp:include page="${pathView}" />
	</main>

	<footer class="footer mt-auto py-3">
		<div class="container">
			<span class="text-muted">Copyright (C) 2022.</span>
		</div>
	</footer>

	<!-- Scripts do jQuery -->

	<script type="text/javascript"
		src="http://code.jquery.com/jquery-3.5.1.min.js"
		integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
		crossorigin="anonymous"></script>

	<!-- Scripts do Bootstrap -->

	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
		crossorigin="anonymous"></script>

	<!-- Scripts do DataTables -->

	<script type="text/javascript"
		src="https://cdn.datatables.net/v/bs4/dt-1.10.23/datatables.min.js"></script>

	<!-- Scripts de Customização -->

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/custom.js"></script>
</body>
</html>