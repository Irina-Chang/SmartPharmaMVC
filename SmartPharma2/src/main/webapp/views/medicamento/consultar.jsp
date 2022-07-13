<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Medicamento"%>
<%@page import="java.util.Collection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



    
<%
Collection<Medicamento> medicamentos = new ArrayList<Medicamento>();
if(request.getAttribute("medicamentoCadastrados") != null)
	medicamentos =
		(Collection<Medicamento>) request.getAttribute("medicamentoCadastrados");
%>

<nav>
	<a href="${pageContext.request.contextPath}/medicamento/cadastrar">
		Cadastrar novo medicamento
	</a>
</nav>

	
	<form method="POST"
	action="${pageContext.request.contextPath}/medicamento/cadastrar">
	<h2>medicamento</h2>
	
</form>
<table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
  <thead>
    <tr>
      <th class="th-sm">ID
      </th>
      <th class="th-sm">NomeMedicamento
      </th>
      <th class="th-sm">Preço
      </th>
      <th class="th-sm">Estoque
      </th>
      <th class="th-sm">Componente
      </th>
<th class="th-sm">Laboratorio
      </th>

<th class="th-sm">Lote </th>
<th class="th-sm">Validade </th>
    </tr>
  </thead>

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
			
			out.write("<td>" + m.getLaboratorio().getRazaoSocial() + "</td>");
			
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