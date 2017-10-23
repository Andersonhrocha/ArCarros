<%@page import="model.ModelUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Alterar Usuário</title>
        <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap-3.3.7-dist/css/estilo.css" rel="stylesheet">
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="bootstrap-3.3.7-dist/js/jquery-1.12.4.min.js"></script>
    </head>
    <body class="centralizar">

        <%
            //RECEBE O ATRIBUTO DA OPÇÃO BUSCAR DO SERVLETUSUARIO
            ModelUsuario registro = (ModelUsuario) request.getAttribute("cliente");
        %>


        <div class="container">

            <!-- INÍCIO DO FORMULÁRIO -->
            <form role="form" class="form-horizontal" action="ServletUsuario" method="POST">
                <input type="hidden" name="acao" value="editar" />

                <h2> Alterar Usuário do Sistema </h2>
                <hr>
                <div style="text-align:center; font-size: 11px;" > * Campo Obrigatório </div>

                <div class="form-group">
                    <label class="col-xs-3 control-label"> Código: *</label>
                    <div class="col-xs-4">
                        <input type="text" name="txtDocumento" placeholder="Digite o código" class="form-control" 
                               value="<%=registro.getId_usuario()%>" size="20" readonly="readonly"/>                        
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-xs-3 control-label"> Nome: *</label>
                    <div class="col-xs-4">
                        <input type="text" name="txtNome" placeholder="Nome" class="form-control" autofocus="" 
                               value="<%=registro.getNome()%>" size="45" required=""/>                        
                    </div>
                </div> 
                    
                    <div class="form-group">
                    <label class="col-xs-3 control-label"> Login: *</label>
                    <div class="col-xs-4">
                        <input type="text" name="txtLogin" placeholder="Login" class="form-control"
                               value="<%=registro.getLogin()%>" size="45" />                        
                    </div>
                </div>  
                    
                    <div class="form-group">
                    <label class="col-xs-3 control-label"> Senha: *</label>
                    <div class="col-xs-4">
                        <input type="password" name="txtSenha" placeholder="Senha" class="form-control"
                               value="<%=registro.getSenha()%>" size="32" />                        
                    </div>
                </div>  
                    
                    

                <div class="row">                   
                        <button type="submit" class="btn btn-success">Salvar</button>
                        <a href="ServletUsuario?acao=listar" class="btn btn-danger">Cancelar</a>   
                </div>

            </form>
                    <!-- FINAL DO FORMULÁRIO -->

        </div>
    </body>
</html>
