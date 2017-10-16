<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Adicionar Cliente</title>
        <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap-3.3.7-dist/css/estilo.css" rel="stylesheet">
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="bootstrap-3.3.7-dist/js/jquery-1.12.4.min.js"></script>
    </head>
    
    <body class="centralizar">

        <div class="container">
             
            <!-- INÍCIO DO FORMULÁRIO -->
            <form role="form" class="form-horizontal" action="ServletCliente" method="POST">
                <input type="hidden" name="acao" value="inserir" />
                
                <h2> Cadastro de Cliente </h2>
                <hr>
                 <div style="text-align:center; font-size: 11px;" > * Campo Obrigatório </div>
                
                <div class="form-group">
                    <label class="col-xs-3 control-label"> Documento: *</label>
                    <div class="col-xs-4">
                        <input type="text" name="txtDocumento" placeholder="Digite o CPF" class="form-control" autofocus=""
                               size="20" required=""/>                        
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-xs-3 control-label"> Nome: *</label>
                    <div class="col-xs-4">
                        <input type="text" name="txtNome" placeholder="Nome" class="form-control" 
                               size="100" required=""/>                        
                    </div>
                </div>
                
                 <div class="form-group">
                    <label class="col-xs-3 control-label"> Endereço: *</label>
                    <div class="col-xs-4">
                        <input type="text" name="txtEndereco" placeholder="Endereço" class="form-control" 
                               size="200" required=""/>                        
                    </div>
                </div>
                
                 <div class="form-group">
                    <label class="col-xs-3 control-label"> Telefone: *</label>
                    <div class="col-xs-4">
                        <input type="text" name="txtTelefone" placeholder="Telefone" class="form-control" 
                               size="12" required=""/>                        
                    </div>
                </div>
                
                 <div class="form-group">
                    <label class="col-xs-3 control-label"> E-mail: </label>
                    <div class="col-xs-4">
                        <input type="email" name="txtEmail" placeholder="E-mail" class="form-control" 
                               size="50" />                        
                    </div>
                </div>
                
                <div class="row" >                    
                        <button type="submit" class="btn btn-success">Salvar</button>
                        <a href="ServletCliente?acao=listar" class="btn btn-primary">Consultar</a>                   
                </div>

            </form>
            <!-- FINAL DO FORMULÁRIO -->

            </div>
    </body>
</html>
