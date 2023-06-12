<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="HTML,CSS,XHTML,JavaScript">
<link rel="stylesheet" href="resources/css/style.css">
<title>Login</title>
</head>
<body>
	<div class="main-login">
		<div class="left-login">
			<h1 class="texto-principal">Esteja no controle das suas finanças
				e alcance seus objetivos</h1>
			<img src="resources/img/financa.svg" class="left-login-image"
				alt="Finança animação">
		</div>
		<div class="right-login">
			<div class="card-login">
				<h1>LOGIN</h1>
				<form action="login" method="post">
					<div class="textfield">
						<label for="cpf">CPF</label> <input type="text"
							name="cpf" placeholder="cpf" required>
					</div>
					<div class="textfield">
						<label for="senha">Senha</label> <input type="password"
							name="senha" placeholder="Senha" required>
					</div>
				</form>
				<div></div>
				<button class="btn-login">Login</button>
				<p>
					Não tem conta? <a href="cadastro-usuario.jsp"
						class="text-primary ml-1">Cadastre-se aqui</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>
