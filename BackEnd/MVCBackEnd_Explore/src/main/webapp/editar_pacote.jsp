
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Alteração do Pacote ${pacote.id}</title>

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
		<h5>Alteração do Pacote ${pacote.id}</h5>
		<form action="pacote-editar" method="post" class="form-control">

			<input type="hidden" name="id" value="${pacote.id}">
				<p>
					<label for="id_cidade">Id da Cidade:</label> <input type="number" value="${pacote.id_cidade}"
						id="id_cidade" name="id_cidade" size="40" class="form-control"
						required>
				</p>

				<p>
					<label for="diaria">Diária:</label> <input type="number" value="${pacote.diaria}"
						id="diaria" name="diaria" size="15" class="form-control" required>
				</p>

				<p>
					<label for="preco">Preço:</label> <input type="text" id="preco" value="${pacote.preco}"
						name="preco" size="40" class="form-control" required>
				</p>


				<p>
					<label for="cafe_manha">Café da Manha:</label><select
						id="cafe_manha" name="cafe_manha"><option value="false">false</option>
						<option value="true">true</option></select>
				</p>
				
				
			<button type="submit" class="btn btn-success">Atualizar</button>
		</form>
	</div>
</body>
</html>