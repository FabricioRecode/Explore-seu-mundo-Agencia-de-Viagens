<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Alteração da cidade ${cidade.nome}</title>

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
		<h5>Alteração da cidade ${cidade.nome}</h5>
		<form action="cidade-editar" method="post" class="form-control">

			<input type="hidden" name="id" value="${cidade.id}">
				<p>
					<label for="nome">Nome:</label> <input type="text" id="nome"
						name="nome" size="40" class="form-control" value="${cidade.nome}" required> 
				</p>

				<p>
					<label for="estado">Estado:</label> <input type="text" maxlength="2"
						id="estado" name="estado" size="15" class="form-control" value="${cidade.estado}" required>
				</p>
				
				<p>
					<label for="pais">País:</label> <input type="text" id="pais"
						name="pais" size="40" class="form-control" value="${cidade.pais}" required>
				</p>
				
				
				<p>
					<label for="continente">Continente:</label> <input type="text" id="continente"
						name="continente" size="40" class="form-control" value="${cidade.continente}" required>
				</p>
			<button type="submit" class="btn btn-success">Atualizar</button>
		</form>
	</div>
</body>
</html>