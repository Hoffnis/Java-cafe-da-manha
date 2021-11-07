<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Café da manhã</title>
<link rel="icon" href="Imagem/Cafe.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar Funcionário</h1>
	<form name="frmContato" action="update">
		<table>
			<tr>
				<td><input type="text" name="nome" 
					class=Caixa1 value="<%out.print(request.getAttribute("nome")); %>"></td>
			</tr>
			<tr>
				<td><input type="text" name="cpf" value="<%out.print(request.getAttribute("cpf")); %>"></td>
			</tr>
			<tr>
				<td><input type="text" name="comida" value="<%out.print(request.getAttribute("comida")); %>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1"
			onclick="validar()">
	</form>

	<script src="validador.js"></script>
</body>
</html>