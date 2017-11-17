<%@page import="model.ModelMarca"%>
<%@page import="java.util.List"%>
<%@page import="dao.DaoMarca"%>
<%@page import="model.ModelModelo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Atualizar de Modelo de Veículo</title>

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
                        //RECEBE O ATRIBUTO DA OPÇÃO BUSCAR DO SERVLETMODELO
                        ModelModelo registro = (ModelModelo) request.getAttribute("modelo");
                    %>

                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="page-header"  style="text-align: center; margin-top: 5px">
                                    <h3>Atualizar de Modelo de Veículo</h3>
                                </div>

                                <div style="text-align:right; font-size: 11px;" > * Campo Obrigatório </div>

                                <!-- INÍCIO DO FORMULÁRIO -->
                                <form role="form" class="form-horizontal" action="ServletModelo" method="POST">
                                    <input type="hidden" name="acao" value="editar" />


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Código: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-asterisk"></i></span>
                                                <input type="text" name="txtDocumento" class="form-control" 
                                                       value="<%=registro.getId_modelo()%>" readonly="readonly" />
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Nome: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-sort-by-alphabet"></i></span>
                                                <input type="text" name="txtNome" placeholder="Digite uma modelo" class="form-control" 
                                                       value="<%=registro.getNome_modelo()%>" size="50" required="" autofocus=""  >
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-group"> 
                                        <label class="col-md-4 control-label">Fabrincante: *</label>
                                        <div class="col-md-8 selectContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                                                <select name="txtFabricante" class="form-control" required=""> 
                                                    <!-- <option>Selecione</option> -->

                                                    <%
                                                        //MÉTODO EXISTETE NA CLASSE DAOMARCA
                                                        DaoMarca dao = new DaoMarca();
                                                        List<ModelMarca> listar;

                                                        listar = dao.listarFabricantes();
                                                        for (ModelMarca registros : listar) {
                                                    %>

                                                    <option value="<%=registros.getId_marca()%>"><%=registros.getNome_marca()%> </option>

                                                    <%
                                                        }
                                                    %> 
                                                </select> 
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Motorização: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-sort-by-order"></i></span>
                                                <input type="text" name="txtMotorizacao" placeholder="Ex: 1.0, 1.4, 1.6, 1.8, 2.0"
                                                       value="<%=registro.getMotorizacao()%>" class="form-control" size="4" required=""  >
                                            </div>
                                        </div>
                                    </div>


                                    <hr/>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label"></label>
                                        <div class="col-md-10 col-sm-offset-2" style="text-align: center">

                                            <button type="submit" class="btn btn-success" > <span class="glyphicon glyphicon-floppy-save"></span> Salvar </button>
                                            <a href="ServletModelo?acao=listar" class="btn btn-danger">  <span class="glyphicon glyphicon-list-alt"></span> Cancelar</a>     

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