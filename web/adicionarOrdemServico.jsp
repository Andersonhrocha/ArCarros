<%@page import="model.ModelCarro"%>
<%@page import="java.util.List"%>
<%@page import="dao.DaoCarro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cadastro Ordem de Serviço</title>

        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body> 
        <br/>
        <br/>
        <br/>
        <div id="m_main">   

            <div id="m_body" >
                <div class="container">

                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="page-header"  style="text-align: center; margin-top: 5px">
                                    <h3>Nova Ordem de Serviço</h3>
                                </div>

                                <div style="text-align:right; font-size: 11px;" > * Campo Obrigatório </div>

                                <!-- INÍCIO DO FORMULÁRIO -->
                                <form role="form" class="form-horizontal" action="ServletOrdemServico" method="POST">
                                    <input type="hidden" name="acao" value="inserir" />

                                    <div class="form-group"> 
                                        <label class="col-md-4 control-label">Placa do Veículo: *</label>
                                        <div class="col-md-8 selectContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                                                <select name="txtCarro" class="form-control" required=""> 
                                                    <!-- <option>Selecione</option> -->

                                                    <%
                                                        //MÉTODO EXISTETE NA CLASSE DAOCARRO
                                                        DaoCarro dao = new DaoCarro();
                                                        List<ModelCarro> listar;

                                                        listar = dao.listarVeiculos();
                                                        for (ModelCarro registro : listar) {
                                                    %>

                                                    <option value="<%=registro.getId_carro()%>"><%=registro.getId_carro()%> </option>

                                                    <%
                                                        }
                                                    %> 
                                                </select> 
                                            </div>
                                        </div>
                                    </div>

                                   
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Situação: *</label>
                                        <div class="col-md-4">
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="txtSituacao" value="Orcamento" /> Orçamento
                                                </label>
                                            </div>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="txtSituacao" value="Ordem de Servico" checked=""/> Ordem de Serviço
                                                </label>
                                            </div>
                                        </div>
                                    </div>


                                    <hr/>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label"></label>
                                        <div class="col-md-10 col-sm-offset-2" style="text-align: center">

                                            <button type="submit" class="btn btn-success" > <span class="glyphicon glyphicon-floppy-save"></span> Salvar </button>
                                            <a href="ServletOrdemServico?acao=listar" class="btn btn-primary">  <span class="glyphicon glyphicon-list-alt"></span> Consultar</a>     

                                        </div>
                                    </div>


                                    <%-- Mensagem de retorno vindo do ServletOrdemServico  --%>
                                    <p style="text-align: center; font-size: 16px;">                                        
                                        <% if (request.getAttribute("mensagem") != null) {%>
                                        ${mensagem}
                                        <%}%>
                                    </p>

                                </form>
                                <!-- FINAL DO FORMULÁRIO -->

                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <script src="../js/jquery.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/contactos.js" type="text/javascript"></script>

    </body>
</html>