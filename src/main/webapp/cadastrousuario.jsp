<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="HTML,CSS,XHTML,JavaScript">
<meta name="author" content="Bruna de Freitas">
<link rel="stylesheet" type="text/css" href="resources/css/cadastro.css"
	title="cadastro">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">

<title>Cadastro Usuário</title>

</head>
<body>
	<main>
	<div id="main-wrapper" class="container">
		<div class="row justify-content-center">
			<div class="col-xl-10">
				<div class="card border-0">
					<div class="card-body p-0">
						<div class="row no-gutters">
							<div class="col-lg-6">
								<div class="p-5">
									<div class="mb-5">
										<h3 class="h4 font-weight-bold text-white">Cadastre-se</h3>
										<c:if test="${not empty msg }">
											<div class="alert alert-success">${msg}</div>
										</c:if>
										<c:if test="${not empty erro }">
											<div class="alert alert-danger">${erro}</div>
										</c:if>
									</div>

									<form action="usuario" method="post" class="formCadastro">
										<!--  Name -->
										<div class="form-group mb-5">
											<label for="name">Nome completo</label> <input id="name"
												type="text" name="name"
												placeholder="Insira seu nome completo" class="form-control"
												required>
										</div>

										<!-- Email Address -->
										<div class="form-group mb-5">
											<label for="email">E-mail</label> <input id="email"
												type="email" name="email" placeholder="Insira seu e-mail"
												class="form-control" required>
										</div>

										<!-- Phone Number -->
										<div class="form-group mb-5">
											<label for="phoneNumber">Telefone</label> <input
												id="phoneNumber" type="tel" name="phone"
												placeholder="Informe seu telefone com ddd"
												class="form-control">
										</div>

										<!-- CPF -->
										<div class="form-group mb-5">
											<label for="cpf">CPF</label> <input id="cpf" type="text"
												name="cpf" placeholder="Informe seu cpf somente números"
												class="form-control" required>
										</div>

										<!-- Birth Date -->
										<div class="form-group mb-5">
											<label for="birthDate">Data nascimento</label> <input
												id="birthDate" type="date" name="birthDate"
												placeholder="Data Nascimento" class="form-control" required>
										</div>

										<!--  Nationality-->
										<div class="form-group mb-5">
											<label for="nationality">Nacionalidade</label> <input
												id="nationality" type="text" name="nationality"
												placeholder="Informe sua nacionalidade" class="form-control">
										</div>


										<!-- Password -->
										<div class="form-group mb-5">
											<label for="password">Senha</label> <input id="password"
												type="password" name="password" placeholder="Crie sua senha"
												class="form-control" required>
										</div>

										<!-- Password Confirmation -->
										<div class="form-group mb-5">
											<label for="passwordConfirmation">Confirme sua senha</label>
											<input id="passwordConfirmation" type="text"
												name="passwordConfirmation" placeholder="Confirme a senha"
												class="form-control " required>
										</div>
										
										<button type="submit" class="btn btn-success">Cadastrar</button>
										<a href="#l" class="forgot-link float-right text-primary">Esqueceu
											a senha?</a>

										<p class="text-white text-center mt-3 mb-0">
											Já tem conta? <a href="" class="text-primary ml-1">Clique
												aqui</a>
										</p>
									</form>
								</div>
							</div>

							<div class="col-lg-6 d-none d-lg-inline-block">
								<div class="account-block rounded-right">
									<div class="overlay rounded-right"></div>
									<div class="account-testimonial">
										<img src="resources/img/investment-data-animate.svg" alt=""
											class="img-fluid mb-3 d-none d-md-block">
										<p class="lead text-white">Cadastre-se e descubra uma nova
											forma de organizar suas finanças</p>

									</div>
								</div>
							</div>
						</div>

					</div>
					<!-- end card-body -->
				</div>
				<!-- end card -->

				<!-- end row -->

			</div>
			<!-- end col -->
		</div>
		<!-- Row -->
	</div>

	</main>
</body>
</html>