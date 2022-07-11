<%@page import="model.Receita"%>
<%@ page language="jakarta" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
Receita receita = (Receita) request.getAttribute("receita");
%>

<p>Tem certeza que deseja excluir a receita <%=receita.getId()%>?</p>

<form action="${pageContext.request.contextPath}/receita/excluir"
	method="POST">
	<input type="hidden" name="numId" value="<%=receita.getId()%>">
	<p>
		<input type="submit" value="Sim">
	</p>
</form>