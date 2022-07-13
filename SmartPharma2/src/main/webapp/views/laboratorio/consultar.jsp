<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Laboratorio"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.HashSet" %>
<%@page import="model.Medicamento" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



    
<%
Collection<Laboratorio> laboratorios = new ArrayList<Laboratorio>();
if(request.getAttribute("laboratorios") != null)
	laboratorios =
		(Collection<Laboratorio>) request.getAttribute("laboratorios");
%>

<div class="container">
	<div class="row">
		<div class="col-xl-12 d-flex flex-row">
			<a class="btn btn-primary" href="${pageContext.request.contextPath}/laboratorio/cadastrar" role="button">Cadastrar novo laboratorio</a>
		</div>
	</div>
</div>

<table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
  <thead>
    <tr>
      <th class="th-sm">ID
      </th>
      <th class="th-sm">Nome
      </th>
      <th class="th-sm">Endereço
      </th>
      <th class="th-sm">Telefone
      </th>
      <th class="th-sm">CNPJ
      </th>
      <!--  
      <th class="th-sm">Medicamento
      </th>
      
      -->
    </tr>
  </thead>
  <tbody>
  	<%
  		for(Laboratorio l: laboratorios)
  		{
  			out.println("<tr>");
  			out.println("<td>" + l.getId() + "</td>");
  			out.println("<td>" + l.getRazaoSocial() + "</td>");
  			out.println("<td>" + l.getEndereco() + "</td>");
  			out.println("<td>" + l.getTelefone() + "</td>");
  			out.println("<td>" +l.getCNPJ() + "</td>");
  	
  			out.println("<td>");
  			out.println("<a role=\"button\" class=\"btn btn-secondary\" ");
  			out.print("href=\"");
  			out.print(request.getContextPath());
  			out.print("/laboratorio/editar?id=");
  			out.print(l.getId());
  			out.print("\" >");
  			out.println("<i class=\"bi bi-pencil-square\"></i>");
  			out.println("</a>");
  			
  			out.println("<td>");
  			out.println("<a role=\"button\" class=\"btn btn-secondary\" ");
  			out.print("href=\"");
  			out.print(request.getContextPath());
  			out.print("/laboratorio/excluir?id=");
  			out.print(l.getId());
  			out.print("\" >");
  			out.println("<i class=\"bi bi-x-square\"></i>");
  			out.println("</a>");
  			out.println("</tr>");
  			
  			out.println("</tr>");
  			
  		}
  	%>
  </tbody>
</table>