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

String mensagemAlerta, classeDivAlerta = "";
mensagemAlerta = (String) request.getAttribute("mensagemAlerta");

if(mensagemAlerta == null) {
	mensagemAlerta = "";
	classeDivAlerta = "div-oculta";
}
String mensagemErro, classeDivErro = "";
mensagemErro = (String) request.getAttribute("mensagemErro");

if(mensagemErro == null) {
	mensagemErro = "";
	classeDivErro = "div-oculta";
}
%>

<!-- Bootstrap Alerts -->
<!-- https://getbootstrap.com/docs/4.6/components/alerts/ -->
<div class="alert alert-primary alert-dismissible fade show <%= classeDivAlerta %>" role="alert">
	<h4 class="alert-heading">Feito!</h4>
	<%= mensagemAlerta %>
	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
</div>
<div class="alert alert-danger <%= classeDivErro %>" role="alert">
	<h4 class="alert-heading">Erro!</h4>
	<%= mensagemErro %>
	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
</div>

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
            out.println("<td>" + (r.isStatus() == true ? "Valida" : "Invalida") + "</td>" );		
            out.println("<td>" + r.getDataReceita() + "</td>");
			out.println("<td>" + (r.isDadosPacienteValidos() == true ? "Validos" : "Invalidos") + "</td>");	
			out.println("<td>" + (r.isDadosMedicoValidos() == true ? "Validos" : "Invalidos") + "</td>");
  			
  			out.println("<td>");
  			out.println("<a role=\"button\" class=\"btn btn-secondary\" ");
  			out.print("href=\"");
  			out.print(request.getContextPath());
  			out.print("/quarto/editar?id=");
  			out.print(r.getId());
  			out.print("\" >");
  			out.println("<i class=\"bi bi-pencil-square\"></i>");
  			out.println("</a>");
  			
  			out.println("<td>");
  			out.println("<a role=\"button\" class=\"btn btn-secondary\" ");
  			out.print("href=\"");
  			out.print(request.getContextPath());
  			out.print("/quarto/excluir?id=");
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
