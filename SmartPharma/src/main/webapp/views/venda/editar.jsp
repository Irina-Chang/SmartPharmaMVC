<%@page import="model.Venda"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%
Venda venda = (Venda) request.getAttribute("venda");
%>

<form method="POST"
	  action="${pageContext.request.contextPath}/venda/editar">
	<input type="hidden" name="numId" id="numId"
	value="<%=venda.getId()%>">
	<p>
		<label for="nReceita">ID Receita:</label>
		<input type="number" name="nReceita value="<%=venda.getReceita()%>">
	</p>
	<p>
		<label for="nMedicamento">ID Medicamento:</label>
		<input type="number" name="nMedicamento value="<%=venda.getMedicamento()%>">
	</p>
	<p>
		<label for="txtDataVenda">Data da Venda:</label>
		<input type="text" name="txtDataVenda value="<%=venda.getDataVenda()%>">
	</p>
    <p>
		<label for="nQuantidade">Quantidade:</label>
		<input type="number" name="nQuantidade value="<%=venda.getQuantidade()%>">
	</p>

	<p>
		<input type="submit" value="Enviar">
	</p>
</form>