<%@page import="model.Medicamento"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
Medicamento medicamento = (Medicamento) request.getAttribute("medicamento");
%>

<p>Tem certeza que deseja excluir o medicamento <%=medicamento.getNomeMedicamento()%>?</p>

<form action="${pageContext.request.contextPath}/medicamento/excluir"
	method="POST">
	<input type="hidden" name="numId" value="<%=medicamento.getId()%>">
	<p>
		<input type="submit" value="Sim">
	</p>
</form>