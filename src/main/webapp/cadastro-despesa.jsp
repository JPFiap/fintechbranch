<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="HTML,CSS,XHTML,JavaScript">
<meta name="author" content="Bruna de Freitas">
<link rel="stylesheet" type="text/css"
	href="resources/css/cadastromovimentacoes.css"
	title="Estilos Movimentações">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css"
	rel="stylesheet">
<title>Cadastrar Despesas</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-xl-10">
				<div class="col"></div>
				<div class="card mt-50 mb-50">
					<div class="card-title mx-auto mb-3">Cadastrar Despesas</div>
					<form>
						<div>
							<label for="despesa">Despesa</label>
						</div>
						<div class="row row-1">
							<input id="despesa" name="despesa" type="text"
								placeholder="Despesa">
						</div>
						<div>
							<label for="valor">Valor</label>
						</div>
						<div class="row row-1">
							<input id="valor" name="valor" type="number" placeholder="Valor">
						</div>
						<div>
							<label for="qtdParcelas">Quantidade de Parcelas</label>
						</div>
						<div class="row row-1">
							<input id="qtdParcelas" name="qtdParcelas" type="number"
								placeholder="Parcelas">
						</div>
						<div class="mb-2">
							<label for="dsFixa">Despesa Fixa</label>
						</div>
						<div class="row">
							<input class="form-check-input mt-0" type="checkbox"
								value="dsFixa" name="dsFixa">
						</div>
						<div>
							<label for="despesa">Data Saida</label>
						</div>
						<div class="row row-1">
							<input id="despesa" name="dtSaida" type="text">
						</div>
						<button class="btn btn-success d-flex mx-auto">
							<b>Adicionar Despesa</b>
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>


	<script src="js/script.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous">
		
	</script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous">
		
	</script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous">
		
	</script>


</body>
</html>