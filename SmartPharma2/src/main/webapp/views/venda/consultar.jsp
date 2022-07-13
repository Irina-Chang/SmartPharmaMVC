<%@page import="model.Venda"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Collection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
Collection<Venda> vendas = (Collection<Venda>) request.getAttribute("vendas");
%>

<nav>
	<a class="btn btn-primary mt-5" href="${pageContext.request.contextPath}/venda/realizar">
		Cadastrar nova venda
	</a>
</nav>
 
<table id="dtVendas" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
	<thead>
        <th class="th-sm">Id</th>
		<th class="th-sm">Receita</th>
		<th class="th-sm">Medicamento</th>
		<th class="th-sm">Data da Venda</th>
		<th class="th-sm">Quantidade</th>
		<th class="th-sm">Valor Total</th>
		<th></th>
	</thead>
	<tbody>
		<%
		for(Venda v : vendas)
		{
			out.println("<tr>");
			
			out.println("<td>" + v.getId() + "</td>");
            out.println("<td>" + v.getReceita() + "</td>");
            out.println("<td>" + v.getMedicamento() + "</td>");		
            out.println("<td>" + v.getDataVenda() + "</td>");
            out.println("<td>" + v.getQuantidade() + "</td>");	
            out.println("<td>" + v.getValorTotal() + "</td>");	
			out.println("</td>");
			
			out.println("<a role=\"button\" class\"btn btn-secondary\" ");
			out.println("href=\"");
			out.println(request.getContextPath());
			out.println("/venda/editar?idvenda=");
			out.println(v.getId());
			out.println("\" >");
			out.println("<i class=\"bi bi-pencil-square\"></i>");
			out.println("</a>");
			
			out.println("<a role=\"button\" class\"btn btn-secondary\" ");
			out.println("href=\"");
			out.println(request.getContextPath());
			out.println("/venda/excluir?idvenda=");
			out.println(v.getId());
			out.println("\" >");
			out.println("<i class=\"bi bi-x-square\"></i>");
			out.println("</a>");
			
			out.println("</tr>");
		}
		%>
	</tbody>
</table>