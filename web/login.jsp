<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login do Sistema</title>
        <link href="bootstrap-login/css/bootstrap.min.css" rel="stylesheet" />
        <link href="bootstrap-login/css/meu_estilo.css" rel="stylesheet" />

        <script src="bootstrap-login/js/jquery-1.12.4.min.js"></script>
        <script src="bootstrap-login/js/bootstrap.min.js"></script>
    </head>
    <body>      

        <!-- INICIO DO FORMULÁRIO -->
        <form action="ServletLogin" method="POST">

            <div class="container" >
                <div class="form-login">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div style="margin-top:10px; text-align: center; color: #000" class="panel-title">Login do Sistema</div>
                        </div>

                        <div style="padding-top:30px" class="panel-body">
                            <div style="display:none" id="result" class="alert alert-danger col-sm-12">

                            </div>

                            <div class="form-group">                                         
                                <input type="text" name="txtLogin" placeholder="Digite o seu login" class="form-control" 
                                       size="50" required="" autofocus=""/>                    
                            </div>   
                            <div class="form-group">                                            
                                <input type="password" name="txtSenha" placeholder="Digite sua senha" class="form-control" 
                                       size="50" required=""/>                    
                            </div>

                            <%-- Mensagem de retorno vindo do ServletCliente  --%>
                            <p style="text-align: center; font-size: 16px;">                                        
                                <% if (request.getAttribute("mensagem") != null) {%>
                                ${mensagem}
                                <%}%>
                            </p>
                            
                            <div style="margin-top:10px" class="form-group">                          
                                <div class="col-sm-12 controls">
                                    <input type="submit" value="Acessar" class="btn primary btn-group-lg" />
                                    <input type="reset" value="Cancelar" class="btn primary btn-group-lg" />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </form>
    <!-- FINAL DO FORMULÁRIO -->

</body>
</html>
