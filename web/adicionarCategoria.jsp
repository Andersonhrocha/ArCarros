<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cadastro de Categoria de Produtos</title>
        <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap-3.3.7-dist/css/estilo.css" rel="stylesheet">
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="bootstrap-3.3.7-dist/js/jquery-1.12.4.min.js"></script>
    </head>

    <body class="centralizar">

        <div class="container">


            <!-- INÍCIO DO FORMULÁRIO -->
            <form role="form" class="form-horizontal" action="ServletCategoria" method="POST">
                <input type="hidden" name="acao" value="inserir" />

                <h2> Cadastro de Categoria de Produtos </h2>
                <hr>
                <div style="text-align:center; font-size: 11px;" > * Campo Obrigatório </div>


                <div class="form-group">
                    <label class="col-xs-3 control-label"> Nome: *</label>
                    <div class="col-xs-4">
                        <input type="text" name="txtNome" placeholder="Digite um categoria" class="form-control" 
                               size="100" required=""/>                        
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-xs-3 control-label"> Descrição: *</label>
                    <div class="col-xs-4">
                        <input type="text" name="txtDescricao" placeholder="Digite uma descrição" class="form-control" 
                               size="200" required=""/>                        
                    </div>
                </div>


                <div class="row" >                    
                    <button type="submit" class="btn btn-success">Salvar</button>
                    <a href="ServletCategoria?acao=listar" class="btn btn-primary">Consultar</a>                   
                </div>

            </form>
            <!-- FINAL DO FORMULÁRIO -->

        </div>
    </body>
</html>
