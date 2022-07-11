<%@page import="model.Venda"%>
<%@ page language="jakarta" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
Venda venda = (Venda) request.getAttribute("venda");
%>

<p>Tem certeza que deseja excluir os dados da venda <%=venda.getId()%>?</p>

<form action="${pageContext.request.contextPath}/venda/excluir"
	method="POST">
	<input type="hidden" name="numId" value="<%=venda.getId()%>">
	<p>
		<input type="submit" value="Sim">
	</p>
</form>