<jsp:include page="header.jsp"/>


<div class="navbar-wrapper">
    <div class="container-fluid">
        <nav class="navbar navbar-fixed-top">
            <div class="container">

                <!-- Menu HOME -->
                <a style="font-size: 15px;" class="navbar-brand" href="menu.jsp">Home</a> 

                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">

                        <%-- Menu Cliente--%>
                        <li class=" down"><a href="ServletProduto?acao=listar" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><img src="imagens/Burn 3.png" width="40" alt=""/>Clientes <span class="caret"></span></a>
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
                                    <a href="ServletCategoria?acao=listar">Cadastro de Categorias</a>                                            
                                </li>
                                <li class=" dropdown">
                                    <a href="ServletProduto?acao=listar">Cadastro de Produtos</a>
                                </li>
                            </ul>
                        </li>


                        <%-- Menu Carros--%>
                        <li class=" down"><a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><img src="imagens/Burn 3.png" width="40" alt=""/>Veículos<span class="caret"></span></a>
                            <ul class="dropdown-menu">                                        
                                <li class=" dropdown">
                                    <a href="ServletMarca?acao=listar">Cadastro de Fabricantes</a>
                                </li>
                                <li class=" dropdown">
                                    <a href="ServletModelo?acao=listar">Cadastro de Modelos</a>
                                </li>
                                <li class=" dropdown">
                                    <a href="ServletCarro?acao=listar" >Cadastro de Veículos</a>
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
                                    <a href="ServletOrdemServico?acao=listar">Cadastro Ordens de Serviço</a>
                                </li>
                                <li class=" dropdown">
                                    <a href="ServletItemOrdemServico?acao=listar">Gerar OS </a>
                                </li>
                            </ul>
                        </li>

                        <%-- Menu Venda--%>
                        <li class=" down"><a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><img src="imagens/Burn 3.png" width="40" alt=""/>Venda <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class=" dropdown">
                                    <a href="ServletVenda?acao=listar" >Cadastro de Venda</a>
                                </li>
                                <li class=" dropdown">
                                    <a href="ServletVendaProduto?acao=listar" >Venda de Produto</a>
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

                <!-- LINHA MENU -->
                <hr style="height:2px; border:none; background:rgba(255,255,255,0.25); margin-top: 0px; margin-bottom: 0px;"/>

            </div>
        </nav>
    </div>
</div>
<script type="text/javascript">
</script>

<jsp:include page="footer.jsp"/>
