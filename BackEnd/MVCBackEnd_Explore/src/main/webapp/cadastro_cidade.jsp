<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>


</head>
<body>
	<div class="container">
		<h3>Cadastro Cidade</h3>
		<form action="cidade-inserir" method="post" class="form-control">
			<fieldset>
				<legend>Dados da Cidade</legend>

				<p>
					<label for="nome">Nome:</label> <input type="text" id="nome"
						name="nome" size="40" class="form-control" required>
				</p>

				<p>
					<label for="estado">Estado:</label> <input type="text" maxlength="2"
						id="estado" name="estado" size="15" class="form-control" required>
				</p>
				
				<p>
					<label for="pais">País:</label> <input type="text" id="pais"
						name="pais" size="40" class="form-control" required>
				</p>
				
				
				<p>
					<label for="continente">Continente:</label> <input type="text" id="continente"
						name="continente" size="40" class="form-control" required>
				</p>

				<p>
					<input type="submit" value="Cadastrar"
						class="btn btn-primary">
				</p>
			</fieldset>
		</form>
		<table class="table">
			<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Estado</th>
				<th>País</th>
				<th>Continente</th>
				<th>Ações</th>
			</tr>
			</thead>
			<tbody>
			<jstl:forEach items="${cidades}" var="cidade">
				<tr>
					<td>${cidade.id}</td>
					<td>${cidade.nome}</td>
					<td>${cidade.estado}</td>
					<td>${cidade.pais}</td>
					<td>${cidade.continente}</td>
					<td>
						<a href="cidade-editar?id=${cidade.id}" class="btn btn-success">Editar</a>
						<a href="cidade-excluir?id=${cidade.id}" onclick="return confirm('Deseja Excluir?')" class="btn btn-danger">Excluir</a>
					</td>
				</tr>
			</jstl:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>