<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Medicamento"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
Medicamento medicamento = (Medicamento) request.getAttribute("receita");
%>

<form method="POST"
	  action="${pageContext.request.contextPath}/medicamento/cadastrar">
	<p>
		<label for="txtNomeMedicamento">Nome do Medicamento:</label>
		<input type="text" name="txtNomeMedicamento">
	</p>
	<p>
		<label for="txtStatus">Status</label>
		<input type="text" name="txtStatus">
	</p>
	<p>
		<label for="txtDataReceita">Data:</label>
		<input type="text" name="txtDataReceita">
	</p>
    <p>
		<label for="txtDadosPaciente">Status dos dados do paciente:</label>
		<input type="text" name="txtDadosPaciente">
	</p>
    <p>
		<label for="txtDadosMedico">Status dos dados do medico:</label>
		<input type="text" name="txtDadosMedico">
	</p>

	<p>
		<input type="submit" value="Enviar">
	</p>
</form>