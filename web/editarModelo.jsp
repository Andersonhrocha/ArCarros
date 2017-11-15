<%@page import="model.ModelMarca"%>
<%@page import="java.util.List"%>
<%@page import="dao.DaoMarca"%>
<%@page import="model.ModelModelo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Alterar Modelo</title>
        <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap-3.3.7-dist/css/estilo.css" rel="stylesheet">
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="bootstrap-3.3.7-dist/js/jquery-1.12.4.min.js"></script>
    </head>
    <body class="centralizar">

        <%
            //RECEBE O ATRIBUTO DA OPÇÃO BUSCAR DO SERVLETMODELO
            ModelModelo registro = (ModelModelo) request.getAttribute("modelo");
        %>


        <div class="container">

            <!-- INÍCIO DO FORMULÁRIO -->
            <form role="form" class="form-horizontal" action="ServletModelo" method="POST">
                <input type="hidden" name="acao" value="editar" />

                <h2> Alterar dados do Modelo </h2>
                <hr>
                <div style="text-align:center; font-size: 11px;" > * Campo Obrigatório </div>

                <div class="form-group">
                    <label class="col-xs-3 control-label"> Código: *</label>
                    <div class="col-xs-4">
                        <input type="text" name="txtDocumento" placeholder="Digite o código" class="form-control" 
                               value="<%=registro.getId_modelo()%>" size="20" readonly="readonly"/>                        
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-xs-3 control-label"> Nome: *</label>
                    <div class="col-xs-4">
                        <input type="text" name="txtNome" placeholder="Digite uma modelo" class="form-control" 
                               value="<%=registro.getNome_modelo()%>" size="50" required="" autofocus=""/>                        
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-xs-3 control-label"> Fabrincante: *</label>
                    <div class="col-xs-4">      

                        <select name="txtFabricante" class="form-control"> 
                            <option>Selecione</option>

                             <%
                                //MÉTODO EXISTENTE NA CLASSE DAOMARCA
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
                    

                <div class="form-group">
                    <label class="col-xs-3 control-label"> Motorização: *</label>
                    <div class="col-xs-4">
                        <input type="text" name="txtMotorizacao" placeholder="Ex: 1.0, 1.4, 1.6 1.8 2.0" class="form-control" 
                               value="<%=registro.getMotorizacao()%>" size="4" required="" />                        
                    </div>
                </div>


                <div class="row">
                    <button type="submit" class="btn btn-success">Salvar</button>
                    <a href="ServletModelo?acao=listar" class="btn btn-danger">Cancelar</a>   
                </div>

            </form>
            <!-- FINAL DO FORMULÁRIO -->

        </div>
    </body>
</html>
