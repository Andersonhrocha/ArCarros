<%@page import="dao.DaoMarca"%>
<%@page import="java.util.List"%>
<%@page import="model.ModelMarca"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cadastro de Modelos de Veículos</title>

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
                                    <h3>Novo Modelo de Veículo</h3>
                                </div>

                                <div style="text-align:right; font-size: 11px;" > * Campo Obrigatório </div>

                                <!-- INÍCIO DO FORMULÁRIO -->
                                <form role="form" class="form-horizontal" action="ServletModelo" method="POST">
                                    <input type="hidden" name="acao" value="inserir" />


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Nome: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-sort-by-alphabet"></i></span>
                                                <input type="text" name="txtNome" placeholder="Digite uma modelo" class="form-control" 
                                                       size="50" required="" autofocus=""  >
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-group"> 
                                        <label class="col-md-4 control-label">Fabrincante: *</label>
                                        <div class="col-md-8 selectContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                                                <select name="txtFabricante" class="form-control" required="" /> 
                                                <!-- <option>Selecione</option> -->

                                                <%
                                                    //MÉTODO EXISTETE NA CLASSE DAOMARCA
                                                    DaoMarca dao = new DaoMarca();
                                                    List<ModelMarca> listar;

                                                    listar = dao.listarFabricantes();
                                                    for (ModelMarca registro : listar) {
                                                %>

                                                <option value="<%=registro.getId_marca()%>"><%=registro.getNome_marca()%> </option>

                                                <%
                                                    }
                                                %> 
                                                </select> 

                                                <!-- BOTÃO PARA ADICIONAR NOVO FABRICANTE -->                                   
                                                <a class="btn btn-primary" href="adicionarMarca.jsp" >
                                                    <span class="glyphicon glyphicon-plus"></span> </a>                                                            
                                            </div> 
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Motorização: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-sort-by-order"></i></span>
                                                <input type="text" name="txtMotorizacao" placeholder="Ex: 1.0, 1.4, 1.6, 1.8, 2.0"
                                                       class="form-control" size="4" required=""  />
                                            </div>
                                        </div>
                                    </div>

                                    <hr/>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label"></label>
                                        <div class="col-md-10 col-sm-offset-2" style="text-align: center">

                                            <button type="submit" class="btn btn-success" > <span class="glyphicon glyphicon-floppy-save"></span> Salvar </button>
                                            <a href="ServletModelo?acao=listar" class="btn btn-primary">  <span class="glyphicon glyphicon-list-alt"></span> Consultar</a>     

                                        </div>
                                    </div>


                                    <%-- Mensagem de retorno vindo do ServletModelo  --%>
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