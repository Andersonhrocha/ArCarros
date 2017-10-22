<%@page import="dao.DaoModelo"%>
<%@page import="java.util.List"%>
<%@page import="model.ModelModelo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cadastro de Modelo</title>
        <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap-3.3.7-dist/css/estilo.css" rel="stylesheet">
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="bootstrap-3.3.7-dist/js/jquery-1.12.4.min.js"></script>
    </head>


    <body class="centralizar">

        <div class="container">

            <!-- INÍCIO DO FORMULÁRIO -->
            <form role="form" class="form-horizontal" action="ServletlModelo" method="POST">
                <input type="hidden" name="acao" value="inserir" />

                <h2> Cadastro de Modelos de Veículos </h2>
                <hr>
                <div style="text-align:center; font-size: 11px;" > * Campo Obrigatório </div>

                <div class="form-group">
                    <label class="col-xs-3 control-label"> Nome: *</label>
                    <div class="col-xs-4">
                        <input type="text" name="txtNome" placeholder="Digite uma modelo" class="form-control" 
                               size="50" required="" autofocus=""/>                        
                    </div>
                </div>


                <%
                    DaoModelo dao = new DaoModelo();
                    List<ModelModelo> listar;

                    listar = dao.listarTodos();
                    for (ModelModelo registro : listar) {
                %>



                <div class="form-group">
                    <label class="col-xs-3 control-label"> Fabrincate: *</label>
                    <div class="col-xs-4">      
                        <select name="txtFabricante" class="form-control">  

                            <%for (int i = 0; i < 10; i++) {%>
                            <option><%=registro.getRelacao_id_marca().getId_marca()%></option>
                            <%}%>

                        </select>  
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-xs-3 control-label"> Motorização: *</label>
                    <div class="col-xs-4">
                        <input type="text" name="txtMotorizacao" placeholder="Ex: 1.0, 1.4, 1.6 1.8 2.0" class="form-control" 
                               size="50" required="" />                        
                    </div>
                </div>



                <div class="row" >                    
                    <button type="submit" class="btn btn-success">Salvar</button>
                    <a href="ServletlModelo?acao=listar" class="btn btn-primary">Consultar</a>                   
                </div>

            </form>
            <!-- FINAL DO FORMULÁRIO -->

        </div>
    </body>
</html>
