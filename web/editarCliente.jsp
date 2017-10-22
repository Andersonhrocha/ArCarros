<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.ModelCliente" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Editar Cliente</title>
        <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap-3.3.7-dist/css/estilo.css" rel="stylesheet">
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="bootstrap-3.3.7-dist/js/jquery-1.12.4.min.js"></script>
    </head>
    <body class="centralizar">

        <%
            ModelCliente registro = (ModelCliente) request.getAttribute("cliente");
        %>


        <div class="container">

            <!-- INÍCIO DO FORMULÁRIO -->
            <form role="form" class="form-horizontal" action="ServletCliente" method="POST">
                <input type="hidden" name="acao" value="editar" />

                <h2> Editar dados do cliente </h2>
                <hr>
                <div style="text-align:center; font-size: 11px;" > * Campo Obrigatório </div>

                <div class="form-group">
                    <label class="col-xs-3 control-label"> Documento: *</label>
                    <div class="col-xs-4">
                        <input type="text" name="txtDocumento" placeholder="Digite o CPF" class="form-control" 
                               value="<%=registro.getCpf_cliente()%>" size="20" readonly="readonly"/>                        
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-xs-3 control-label"> Nome: *</label>
                    <div class="col-xs-4">
                        <input type="text" name="txtNome" placeholder="Nome" class="form-control" autofocus="" 
                               value="<%=registro.getNome_cliente()%>" size="100" required=""/>                        
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-xs-3 control-label"> Endereço: *</label>
                    <div class="col-xs-4">
                        <input type="text" name="txtEndereco" placeholder="Endereço" class="form-control" 
                               value="<%=registro.getEndereco()%>" size="200" required=""/>                        
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-xs-3 control-label"> Telefone: *</label>
                    <div class="col-xs-4">
                        <input type="text" name="txtTelefone" placeholder="Telefone" class="form-control" 
                               value="<%=registro.getTelefone()%>" size="12" required=""/>                        
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-xs-3 control-label"> E-mail: </label>
                    <div class="col-xs-4">
                        <input type="email" name="txtEmail" placeholder="E-mail" class="form-control" 
                               value="<%=registro.getEmail()%>" size="50"/>                        
                    </div>
                </div>

                <div class="row">                 
                        <button type="submit" class="btn btn-success">Salvar</button>
                        <a href="ServletCliente?acao=listar" class="btn btn-danger">Cancelar</a>   
                </div>

            </form>
                    <!-- FINAL DO FORMULÁRIO -->

        </div>
    </body>
</html>
