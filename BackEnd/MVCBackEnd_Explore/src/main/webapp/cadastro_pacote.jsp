<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h3>Cadastro Pacote</h3>
		<form action="pacote-inserir" method="post" class="form-control">
			<fieldset>
				<legend>Dados do Pacote</legend>

				<p>
					<label for="id_cidade">Id da Cidade:</label> <input type="number"
						id="id_cidade" name="id_cidade" size="40" class="form-control"
						required>
				</p>

				<p>
					<label for="diaria">Diária:</label> <input type="number"
						id="diaria" name="diaria" size="15" class="form-control" required>
				</p>

				<p>
					<label for="preco">Preço:</label> <input type="text" id="preco"
						name="preco" size="40" class="form-control" required>
				</p>


				<p>
					<label for="cafe_manha">Café da Manha:</label><select
						id="cafe_manha" name="cafe_manha"><option value="false">false</option>
						<option value="true">true</option></select>
				</p>
				
				

				<p>
					<input type="submit" value="Cadastrar" class="btn btn-primary">
				</p>
			</fieldset>
		</form>
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Id da Cidade</th>
					<th>Diária</th>
					<th>Preço</th>
					<th>Café da Manha</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<jstl:forEach items="${pacotes}" var="pacote">
					<tr>
						<td>${pacote.id}</td>
						<td>${pacote.id_cidade}</td>
						<td>${pacote.diaria}</td>
						<td>${pacote.preco}</td>
						<td>${pacote.cafe_manha}</td>
						<td><a href="pacote-editar?id=${pacote.id}"
							class="btn btn-success">Editar</a> <a
							href="pacote-excluir?id=${pacote.id}"
							onclick="return confirm('Deseja Excluir?')"
							class="btn btn-danger">Excluir</a></td>
					</tr>
				</jstl:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>