
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Laboratorio"%>
<%@page import="java.util.Collection"%>
<%@page import="jakarta.*" %>
<%@page import= "jakarta.servlet.*"%>
<%@page import="jakarta.servlet.http.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%
Collection<Laboratorio> laboratorios = new ArrayList<Laboratorio>();
if(request.getAttribute("laboratorios") != null)
	laboratorios =
		(Collection<Laboratorio>) request.getAttribute("laboratorios");
%>


<form method="POST"
	  action="${pageContext.request.contextPath}/laboratorio/cadastrar">
	<p>
		<label for="txtRazaoSocial">Razão Social:</label>
		<input type="text" name="txtRazaoSocial">
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
	