<%@page import="model.Medicamento"%>
<%@page import="java.util.Collection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<form method="POST"
	  action="${pageContext.request.contextPath}/receita/cadastrar">
	<p>
		<label for="txtMedicamento">Medicamento:</label>
		<input type="text" name="txtMedicamento">
	</p>
	
	<p>
		<label for="txtStatus">Status:</label>
		<input type="text" name="txtStatus">
	</p>
	<p>
		<label for="txtDataReceita">Data da receita:</label>
		<input type="text" name="txtDataReceita">
	</p>
	<p>
		<label for="txtDadosPaciente">Dados do paciente:</label>
		<input type="text" name="txtDadosPaciente">
	</p>
	<p>
		<label for="txtDadosMedico">Dados do medico: </label>
		<input type="text" name="txtDadosMedico">
	</p>
	
	<p>
		<input type="submit" value="Enviar">
	</p>
</form>