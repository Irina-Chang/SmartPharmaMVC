<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Medicamento"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
Medicamento medicamento = (Medicamento) request.getAttribute("medicamento");
%>

<form method="POST"
	  action="${pageContext.request.contextPath}/medicamento/editar">
	<input type="hidden" name="numId" value="<%= medicamento.getId() %>">
	<p>
	<p>
		<label for="txtMedicamento">Medicamento:</label>
		<input type="text" name="txtMedicamento" value="<%= medicamento.getNomeMedicamento() %>">
	</p>
	
	<p>
		<label for="preco">Preço (R$):</label>
		<input type="number" name="preco" step=".01">
	</p>
	
	<p>
		<label for="estoque">Estoque:</label>
		<input type="number" name="estoque">
	</p>
	
	<p>
		<label for="txtComponente">Componente</label>
		<input type="text" name="txtComponente">
	</p>
	<p>
		<label for="laboratorio">Laboratorio</label>
		<input type="number" name="laboratorio">
	</p>
	
	<p>
		<label for="lote">Lote:</label>
		<input type="number" name="lote">
	</p>
	
	<p>
		<label for="validade">Validade:</label>
		<input type="date" name="validade">
	</p>	
	
	<p>
		<input type="submit" value="Enviar">
	</p>
</form>