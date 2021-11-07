<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="Model.Native"%>
<%@ page import="java.util.ArrayList"%>

<%
ArrayList<Native> lista = (ArrayList<Native>) request.getAttribute("cafe");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Cadastro</title>
<link rel="icon" href="Imagem/Cafe.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Cadastro</h1>
	<a href="novo.html" Class="Botao1"> novo cadastro</a>
	
	<table id="tabela">
	<thead>
		<tr>
			<th>CPF</th>
			<th>Nome</th>
			<th>Comida</th>
			<th>Idade</th>
			<th>Opções</th>
			
		</tr>
	</thead>
	
	<tbody>
	<%for(int i= 0; i< lista.size(); i++){ %>
		<tr>
			<td><%=lista.get(i).getCpf() %></td>
			<td><%=lista.get(i).getNome() %></td>
			<td><%=lista.get(i).getComida() %></td>
			<td><%=lista.get(i).getIdade() %></td>
			<td><a href="select?cpf=<%=lista.get(i).getCpf() %>" class= "Botao1">Editar</a>
			
				<a href="javascript: confirmar(<%=lista.get(i).getCpf() %>)" class= "Botao1">Excluir</a>
			</td>
		
		</tr>
	
	
	<%} %>
	
	</tbody>
	
	
	
	
	</table>
	
	<script src="confirmador.js"></script>
	
</body>
</html>