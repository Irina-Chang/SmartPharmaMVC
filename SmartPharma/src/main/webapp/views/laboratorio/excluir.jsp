<%@page import="model.Laboratorio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
Laboratorio laboratorio = (Laboratorio) request.getAttribute("laboratorio");
%>

<p>Tem certeza que deseja excluir o laboratorio <%=laboratorio.getRazaoSocial()%>?</p>

<form action="${pageContext.request.contextPath}/laboratorio/excluir"
	method="POST">
	<input type="hidden" name="numId" value="<%=laboratorio.getId()%>">
	<p>
		<input type="submit" value="Sim">
	</p>
</form>