<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Medicamento"%>
<%@page import="java.util.Collection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



    
<%
Collection<Medicamento> medicamentos = new ArrayList<Medicamento>();
if(request.getAttribute("medicamentos") != null)
	medicamentos =
		(Collection<Medicamento>) request.getAttribute("medicamentos");
%>

<nav>
	<a href="${pageContext.request.contextPath}/medicamento/cadastrar">
		Cadastrar novo medicamento
	</a>
</nav>

	
	<form method="POST"
	action="${pageContext.request.contextPath}/medicamento/cadastrar">
	<h2>medicamento</h2>
	

	<div class="form-group m-1">
		<label for="id">ID:</label> <input
			class="form-control m-1" type="text" name="id">
	</div>

	<div class="form-group m-1">
		<label for="txtNome">Medicamento:</label> <input class="form-control m-1"
			type="text" name="txtNome">
	</div>


	<div class="form-group m-1">
		<label for="valor">Preço:</label> <input class="form-control m-1"
			type="number" name="valor">
	</div>

	<div class="form-group m-1">
		<label for="estoque">Estoque:</label> <input
			class="form-control m-1" type="number" name="estoque">
	</div>

	<div class="form-group m-1">
		<label for="txtComponente">Componente:</label> <input class="form-control m-1"
			type="text" name="txtComponente">
	</div>

<div class="form-group m-1">
		<label for="Lote">Lote:</label> <input class="form-control m-1"
			type="number" name="Lote">
	</div>
	<div class="form-group m-1">
		<label for="Validade">Validade:</label> <input class="form-control m-1"
			type="datetime" name="Validade">
	</div>
	
	<div class="form-group m-1">
		<input type="submit" class="btn btn-primary" value="Enviar">
	</div>
</form>
<table>
		<tbody>
		<%
		for(Medicamento m : medicamentos)
		{
			out.write("<tr>");
			
			out.write("<td>" + m.getId() + "</td>");
			
			out.write("<td>" + m.getNomeMedicamento() + "</td>");
			
			out.write("<td>" + m.getPreco() + "</td>");
			
			out.write("<td>" + m.getEstoque() + "</td>");
			
			out.write("<td>" + m.getComponente() + "</td>");
			
			out.write("<td>" + m.getLaboratorio() + "</td>");
			
			out.write("<td>" + m.getLote() + "</td>");
			
			out.write("<td>" + m.getValidade() + "</td>");
			
			
			
			out.write("<td>");
			
			out.write("<a href=\"" + request.getContextPath() +
					"/medicamento/editar?id=" + m.getId() + "\">editar</a> ");
			
			out.write("<a href=\"" + request.getContextPath() +
					"/medicamento/excluir?id=" + m.getId() + "\">excluir</a>");
			
			out.write("</td>");
			
			out.write("</tr>");
		}
		%>
	</tbody>
</table>