<%@page import="model.Medicamento"%>
<%@page import="java.util.Collection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%
Collection<Medicamento> medicamentos =
	(Collection<Medicamento>) request.getAttribute("medicamentos");
%>
<form method="POST"
	  action="${pageContext.request.contextPath}/receita/cadastrar">
	<p>
		<label for="Medicamento">Medicamento:</label>
		<select name="Medicamento" required>
			<%
			for(Medicamento pf : medicamentos)
			{
				out.print("<option value=\"");
				
				out.print(pf.getId());
				
				out.print("\">"); // <option value="XX">
				
				out.print("Medicamento: ");
				
				out.print(pf.getId()); 
				
				out.print(" Nome: R$ "+pf.getNomeMedicamento()); 
				
				out.print("</option>");
			}
			%>
		</select>
	</p>
	<p>
		<label for="txtStatus">Status</label>
		<select name="txtStatus" required>
			<option value="" selected>- Selecione -</option>
			<option value="Valida">A</option>
			<option value="Invalida">B</option>
		</select>
	</p>
	<p>
		<label for="txtDataReceita">Data da receita:</label>
		<input type="text" name="txtDataReceita">
	</p>
	<p>
		<label for="txtDadosPaciente">Dados do paciente:</label>
		<select name="txtDadosPaciente" required>
			<option value="" selected>- Selecione -</option>
			<option value="Validos">A</option>
			<option value="Invalidos">B</option>
		</select>
	</p>
	<p>
		<label for="txtDadosMedico">Dados do medico: </label>
		<select name="txtDadosMedico" required>
			<option value="" selected>- Selecione -</option>
			<option value="Validos">A</option>
			<option value="Invalidos">B</option>
		</select>
	</p>
	
	
	<p>
		<input type="submit" value="Enviar">
	</p>
</form>