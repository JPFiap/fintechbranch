<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="keywords" content="HTML,CSS,XHTML,JavaScript">
    <meta name="author" content="Bruna de Freitas">
    <link rel="stylesheet" type="text/css" href="css/principal.css" title="Estilos principais">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <title>Fincheck</title>
</head>
<header>
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light">
            <a class="navbar-brand" href="index.html"><img src="resources/img/logofintech.png" alt="Fincheck" width="100px"></a>

            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#fincheckMainNav"
                aria-controls="collapsibleNavId" aria-expanded="false" aria-label="Alterna navegação">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="fincheckMainNav">
                <ul class="navbar-nav mx-auto mt-2 mt-lg-0 justify-content-center">
                    <li class="nav-item active">
                        <a class="nav-link" href="">Quem Somos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">Recursos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">Contato</a>
                    </li>
                </ul>
                <ul class="navbar-nav mt-2 mt-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp"><span
                                class="flag-icon flag-icon-squared rounded-circle flag-icon-gb"></span>Login</a>
                    </li>
                    <li class="nav-item">
                       <a href="cadastro-usuario.jsp"> <button type="button" class="btn btn-success"> Comece já </button></a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>

    <section class="edica-landing-section edica-landing-about">
        <div class="container">
            <div class="row">
                <div class="col-md-6" data-aos="fade-up-right">
                    <h1 class="fincheck-landing-section-title">Controlar seu dinheiro nunca foi tão fácil!</h1>
                </div>
                <div class="col-md-6" data-aos="fade-up-left">
                    <img src="resources/img/imgindex.svg" width="480px" alt="about"
                        class="img-fluid fincheck-landing-section-title">
                </div>
            </div>
        </div>
    </section>
</header>
<main>
    <section class="edica-landing-section edica-landing-services">
        <div class="container">
            <h2 class="edica-landing-section-title">O caminho para uma vida financeira saudável</h2>
            <p>
                Bem-vindo à Fincheck, onde você pode assumir o controle total das suas
                finanças de forma simples e eficiente.
            </p>
            <p>Aqui na nossa plataforma, priorizamos a sua experiência e o seu
                sucesso financeiro, oferecendo uma interface intuitiva e recursos poderosos para ajudá-lo a atingir seus
                objetivos financeiros.</p>
        </div>
    </section>

    <section>
        <div class="container testimonials">
            <div class="row">
                <div class="col-md-4 testimonial">
                    <div class="row">
                        <div class="avatar col-md-5">
                            <a href="#">
                                <img class="img-circle" src="https://bootdey.com/img/Content/user_3.jpg"
                                    alt="Taylor Otwell">
                            </a>
                        </div>

                        <div class="testimonial-main col-md-7">
                            <h4 class="media-heading">Owenl Ollyt</h4>
                            <p class="testimony-body"> Antes, eu tinha
                                dificuldade em acompanhar minhas despesas, definir metas e economizar. Mas, desde que
                                comecei a utilizar o aplicativo, tudo mudou. A interface intuitiva e amigável facilitou
                                o acompanhamento das minhas finanças diárias, o que me permitiu ter uma visão clara dos
                                meus gastos. </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 testimonial">
                    <div class="row">
                        <div class="avatar col-md-5">
                            <a href="#">
                                <img class="img-circle" src="https://bootdey.com/img/Content/user_2.jpg"
                                    alt="Taylor Otwell">
                            </a>
                        </div>

                        <div class="testimonial-main col-md-7">
                            <h4 class="media-heading">Darla Marty</h4>
                            <p class="testimony-body"> Saber que minhas informações pessoais e financeiras são
                                protegidas por medidas avançadas de segurança me dá tranquilidade para utilizar a
                                plataforma sem preocupações. A transparência da equipe em relação
                                às práticas de segurança e privacidade me tranquiliza, mostrando que eles levam a
                                proteção dos dados a sério.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 testimonial">
                    <div class="row">
                        <div class="avatar col-md-5">
                            <a href="#">
                                <img class="img-circle" src="https://bootdey.com/img/Content/user_1.jpg"
                                    alt="Taylor Otwell">
                            </a>
                        </div>

                        <div class="testimonial-main col-md-7">
                            <h4 class="media-heading">Maryou Mcjouin</h4>
                            <p class="testimony-body">A fincheck se tornou uma parte
                                essencial da minha vida diária. Eu confio nela porque ele me mantém organizado e me
                                ajuda a alcançar minhas metas financeiras de forma eficiente. A possibilidade de
                                centralizar todas as informações financeiras em um só lugar facilita o acompanhamento de
                                tudo e evita que eu perca tempo alternando entre diferentes aplicativos e serviços.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<%@ include file="footer.jsp" %>

<body>


    <script src="js/script.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous">
    </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous">
    </script>
</body>

</html>