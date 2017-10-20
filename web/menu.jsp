<%-- 
    Document   : menu
    Created on : Oct 6, 2017, 12:22:48 PM
    Author     : Anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Principal</title>
        <link href="bootstrap-Menu/css/bootstrap.min.css" rel="stylesheet">
        <style type="text/css">
            body{
                background: #8999A8;
            }
            .navbar, .dropdown-menu{
                background:rgba(255,255,255,0.25);
                border: none;

            }

            .nav>li>a, .dropdown-menu>li>a:focus, .dropdown-menu>li>a:hover, .dropdown-menu>li>a, .dropdown-menu>li{
                border-bottom: 3px solid transparent;
            }
            .nav>li>a:focus, .nav>li>a:hover,.nav .open>a, .nav .open>a:focus, .nav .open>a:hover, .dropdown-menu>li>a:focus, .dropdown-menu>li>a:hover{
                border-bottom: 3px solid transparent;
                background: none;
            }
            .navbar a, .dropdown-menu>li>a, .dropdown-menu>li>a:focus, .dropdown-menu>li>a:hover, .navbar-toggle{
                color: #fff;
            }
            .dropdown-menu{

            }

            .nav li:hover:nth-child(8n+1), .nav li.active:nth-child(8n+1){
                border-bottom: #C4E17F 3px solid;
            }
            .nav li:hover:nth-child(8n+2), .nav li.active:nth-child(8n+2){
                border-bottom: #F7FDCA 3px solid;
            }
            .nav li:hover:nth-child(8n+3), .nav li.active:nth-child(8n+3){
                border-bottom: #FECF71 3px solid;
            }
            .nav li:hover:nth-child(8n+4), .nav li.active:nth-child(8n+4){
                border-bottom: #F0776C 3px solid;
            }
            .nav li:hover:nth-child(8n+5), .nav li.active:nth-child(8n+5){
                border-bottom: #DB9DBE 3px solid;
            }
            .nav li:hover:nth-child(8n+6), .nav li.active:nth-child(8n+6){
                border-bottom: #C49CDE 3px solid;
            }
            .nav li:hover:nth-child(8n+7), .nav li.active:nth-child(8n+7){
                border-bottom: #669AE1 3px solid;
            }
            .nav li:hover:nth-child(8n+8), .nav li.active:nth-child(8n+8){
                border-bottom: #62C2E4 3px solid;
            }

            .navbar-toggle .icon-bar{
                color: #fff;
                background: #fff;
            }
        </style>
        <script src="bootstrap-Menu/js/jquery-1.11.1.min.js"></script>
        <script src="bootstrap-Menu/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="navbar-wrapper">
            <div class="container-fluid">
                <nav class="navbar navbar-fixed-top">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>

                 <!--           <a class="navbar-brand" href="menu.jsp">Home</a> -->
                        </div>

                        <div id="navbar" class="navbar-collapse collapse">
                            <ul class="nav navbar-nav">

                                <%-- Menu Cliente--%>
                                <li class=" down"><a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><img src="imagens/Burn 3.png" width="40" alt=""/>Clientes <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li class=" dropdown">
                                            <a href="ServletCliente?acao=listar" >Cadastro de Clientes</a>
                                        </li>                                 
                                    </ul>
                                </li>


                                <%-- Menu Produtos--%>
                                <li class=" dropdown">
                                    <a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><img src="imagens/pic_3.png" width="40" alt=""/>Produtos <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li class=" dropdown">
                                            <a href="#">Cadastro de Produtos</a>
                                        </li>
                                        <li class=" dropdown">
                                            <a href="#">Cadastro de Categorias</a>
                                        </li>
                                    </ul>
                                </li>


                                <%-- Menu Carros--%>
                                <li class=" down"><a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><img src="imagens/Burn 3.png" width="40" alt=""/>Carros <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li class=" dropdown">
                                            <a href="#" >Cadastro de Carros</a>
                                        </li>
                                        <li class=" dropdown">
                                            <a href="ServletMarca?acao=listar">Cadastro de Marcas</a>
                                        </li>
                                        <li class=" dropdown">
                                            <a href="#">Cadastro de Modelos</a>
                                        </li>
                                    </ul>
                                </li>

                                <%-- Menu Serviços--%>
                                <li class=" down"><a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><img src="imagens/Burn 3.png" width="40" alt=""/>Serviços <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li class=" dropdown">
                                            <a href="ServletServico?acao=listar" >Cadastro de Serviços</a>
                                        </li>
                                        <li class=" dropdown">
                                            <a href="#">Ordens de Serviço</a>
                                        </li>
                                    </ul>
                                </li>
                                
                                 <%-- Menu Usuário--%>
                                <li class=" down"><a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><img src="imagens/Burn 3.png" width="40" alt=""/>Usuários <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li class=" dropdown">
                                            <a href="ServletUsuario?acao=listar" >Cadastro de Usuários</a>
                                        </li>                                     
                                    </ul>
                                </li>
                                
                                
                                
                                
                            </ul>

                            <%-- Menu Sair--%>
                            <ul class="nav navbar-nav pull-right">
                                <li class=""><a href="index.jsp">Sair</a></li>
                            </ul>

                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <script type="text/javascript">

        </script>
    </body>
</html>
