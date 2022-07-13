<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Laboratorio"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
Laboratorio laboratorio = (Laboratorio) request.getAttribute("laboratorio");
%>

<form method="POST"
	  action="${pageContext.request.contextPath}/laboratorio/editar">
	
	<input type="hidden" name="numId" value="<%= laboratorio.getId() %>">
	<p>
		<label for="txtRazaoSocial">Razão Social:</label>
		<input type="text" name="txtRazaoSocial" value="<%= laboratorio.getRazaoSocial() %>">
	</p>
	<p>
		<label for="txtEndereco">Endereço</label>
		<input type="text" name="txtEndereco">
	</p>
	<p>
		<label for="txtTelefone">Telefone:</label>
		<input type="text" name="txtTelefone">
	</p>
	
	<p>
		<label for="txtCNPJ">CNPJ:</label>
		<input type="text" name="txtCNPJ">
	</p>

	<p>
		<input type="submit" value="Enviar">
	</p>
</form>