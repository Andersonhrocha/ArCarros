<%@page import="model.ModelModelo"%>
<%@page import="dao.DaoModelo"%>
<%@page import="model.ModelCarro"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Atualizar Veículo</title>

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

                    <%
                        //RECEBE O ATRIBUTO DA OPÇÃO BUSCAR DO SERVLETCARRO
                        ModelCarro registro = (ModelCarro) request.getAttribute("carro");
                    %>

                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="page-header"  style="text-align: center; margin-top: 5px">
                                    <h3>Atualizar dados do Veículo</h3>
                                </div>

                                <div style="text-align:right; font-size: 11px;" > * Campo Obrigatório </div>

                                <!-- INÍCIO DO FORMULÁRIO -->
                                <form role="form" class="form-horizontal" action="ServletCarro" method="POST">
                                    <input type="hidden" name="acao" value="editar" />


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Placa do Veículo: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-asterisk"></i></span>
                                                <input type="text" name="txtDocumento" class="form-control" 
                                                       value="<%=registro.getId_carro()%>" readonly="readonly" />
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Ano de Fabricação: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-sort-by-order"></i></span>
                                                <input type="text" name="txtAno" class="form-control" 
                                                       value="<%=registro.getAno()%>" size="4" required="" autofocus=""  />
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Cor: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-sort-by-alphabet"></i></span>
                                                <input type="text" name="txtCor" class="form-control" 
                                                       value="<%=registro.getCor()%>" size="10" required="" />
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">CPF Cliente: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-asterisk"></i></span>
                                                <input type="text" name="txtCliente" class="form-control"
                                                       value="<%=registro.getCliente().getCpf_cliente()%>" size="20" readonly="readonly" />
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-group"> 
                                        <label class="col-md-4 control-label">Modelo do Veículo: *</label>
                                        <div class="col-md-8 selectContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                                                <select name="txtModelo" class="form-control selectpicker" required="" />
                                                    <!-- <option>Selecione</option> -->

                                                    <%
                                                        //MÉTODO EXISTETE NA CLASSE DAOMODELO
                                                        DaoModelo dao = new DaoModelo();
                                                        List<ModelModelo> listar;

                                                        listar = dao.listarModelos();
                                                        for (ModelModelo registros : listar) {
                                                    %>

                                                    <option value="<%=registros.getId_modelo()%>"><%=registros.getNome_modelo()%> </option>

                                                    <%
                                                        }
                                                    %> 
                                                </select>
                                            </div>
                                        </div>
                                    </div>


                                    <hr/>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label"></label>
                                        <div class="col-md-10 col-sm-offset-2" style="text-align: center">

                                            <button type="submit" class="btn btn-success" > <span class="glyphicon glyphicon-floppy-save"></span> Salvar </button>
                                            <a href="ServletCarro?acao=listar" class="btn btn-danger">  <span class="glyphicon glyphicon-list-alt"></span> Cancelar</a>     

                                        </div>
                                    </div>


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