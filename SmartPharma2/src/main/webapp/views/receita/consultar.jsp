<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>
<%@page import="model.Receita"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%

Collection<Receita> receitas = new ArrayList<Receita>();
if(request.getAttribute("receitas") != null)
	receitas =
			(Collection<Receita>) request.getAttribute("receitas");
%>

<div class="container">
	<div class="row">
		<div class="col-xl-12 d-flex flex-row">
			<a class="btn btn-primary"
				href="${pageContext.request.contextPath}/receita/cadastrar"
				role="button">Cadastrar nova receita</a>
		</div>
	</div>
</div>
<table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
  <thead>
      <tr>
        <th class="th-sm">Id</th>
		<th class="th-sm">Nome</th>
		<th class="th-sm">Status</th>
		<th class="th-sm">Data</th>
		<th class="th-sm">Dados do Paciente</th>
		<th class="th-sm">Dados do Medico</th>
    </tr>
  </thead>
  <tbody>
  	<%
  		for(Receita r: receitas)
  		{
  			out.println("<tr>");
            out.println("<td>" + r.getId() + "</td>");
            out.println("<td>" + r.getMedicamento() + "</td>");
            out.println("<td>" + r.getStatus() + "</td>" );		
            out.println("<td>" + r.getDataReceita() + "</td>");
			out.println("<td>" + r.getDadosPacienteValidos() + "</td>");	
			out.println("<td>" + r.getDadosMedicoValidos() + "</td>");
  			
  			out.println("<td>");
  			out.println("<a role=\"button\" class=\"btn btn-secondary\" ");
  			out.print("href=\"");
  			out.print(request.getContextPath());
  			out.print("/receita/editar?id=");
  			out.print(r.getId());
  			out.print("\" >");
  			out.println("<i class=\"bi bi-pencil-square\"></i>");
  			out.println("</a>");
  			
  			out.println("<td>");
  			out.println("<a role=\"button\" class=\"btn btn-secondary\" ");
  			out.print("href=\"");
  			out.print(request.getContextPath());
  			out.print("/receita/excluir?id=");
  			out.print(r.getId());
  			out.print("\" >");
  			out.println("<i class=\"bi bi-x-square\"></i>");
  			out.println("</a>");
  			out.println("</tr>");
  			
  			out.println("</tr>");
  			
  		}
  	%>
  </tbody>
</table>
