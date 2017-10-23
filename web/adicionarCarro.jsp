<%@page import="model.ModelModelo"%>
<%@page import="dao.DaoModelo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cadastro de Veículos</title>
        <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap-3.3.7-dist/css/estilo.css" rel="stylesheet">
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="bootstrap-3.3.7-dist/js/jquery-1.12.4.min.js"></script>
    </head>


    <body class="centralizar">

        <div class="container">

            <!-- INÍCIO DO FORMULÁRIO -->
            <form role="form" class="form-horizontal" action="ServletCarro" method="POST">
                <input type="hidden" name="acao" value="inserir" />

                <h2> Cadastro de Veículos </h2>
                <hr>
                <div style="text-align:center; font-size: 11px;" > * Campo Obrigatório </div>
                
                <div class="form-group">
                    <label class="col-xs-3 control-label"> Placa do Veículo: *</label>
                    <div class="col-xs-4">
                        <input type="text" name="txtDocumento" placeholder="Digite a placa do veículo" class="form-control" 
                               size="7" required="" autofocus=""/>                        
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-xs-3 control-label"> Ano de Fabricação: *</label>
                    <div class="col-xs-4">
                        <input type="text" name="txtAno" placeholder="Digite o ano de fabricação" class="form-control" 
                               size="4" required="" />                        
                    </div>
                </div>
                
                
                <div class="form-group">
                    <label class="col-xs-3 control-label"> Cor: *</label>
                    <div class="col-xs-4">
                        <input type="text" name="txtCor" placeholder="Digite a cor do veículo" class="form-control" 
                               size="10" required="" />                        
                    </div>
                </div>

                
                <div class="form-group">
                    <label class="col-xs-3 control-label"> CPF Cliente: *</label>
                    <div class="col-xs-4">
                        <input type="text" name="txtCliente" placeholder="Digite o CPF do cliente" class="form-control" 
                               size="20" required="" />                        
                    </div>
                </div>
                

                <div class="form-group">
                    <label class="col-xs-3 control-label"> Modelo: *</label>
                    <div class="col-xs-4">      

                        <select name="txtModelo" class="form-control" required=""> 
                            <option>Selecione</option>

                            <%
                                //MÉTODO EXISTETE NA CLASSE DAOMARCA
                                DaoModelo dao = new DaoModelo();
                                List<ModelModelo> listar;

                                listar = dao.listarModelos();
                                for (ModelModelo registro : listar) {
                            %>

                            <option value="<%=registro.getId_modelo()%>"><%=registro.getNome_modelo()%> </option>

                            <%
                                }
                            %> 
                        </select>
                    </div>
                </div>


                <div class="row" >                    
                    <button type="submit" class="btn btn-success">Salvar</button>
                    <a href="ServletCarro?acao=listar" class="btn btn-primary">Consultar</a>                   
                </div>

            </form>
            <!-- FINAL DO FORMULÁRIO -->

        </div>
    </body>
</html>
