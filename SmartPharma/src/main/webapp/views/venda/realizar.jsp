<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<form method="POST" action="${pageContext.request.contextPath}/venda/realizar">
	<p>
		<label for="nReceita">ID Receita:</label>
		<input type="number" name="nReceita">
	</p>
	<p>
		<label for="nMedicamento">ID Medicamento:</label>
		<input type="number" name="nMedicamento">
	</p>
	<p>
		<label for="txtDataVenda">Data da Venda:</label>
		<input type="text" name="txtDataVenda">
	</p>
    <p>
		<label for="nQuantidade">Quantidade:</label>
		<input type="number" name="nQuantidade">
	</p>

	<p>
		<input type="submit" value="Enviar">
	</p>
</form>