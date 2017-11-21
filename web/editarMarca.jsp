<%@page import="model.ModelMarca"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Atualizar Fabricante de Veículos</title>

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
                        //RECEBE O ATRIBUTO DA OPÇÃO BUSCAR DO SERVLETMARCA
                        ModelMarca registro = (ModelMarca) request.getAttribute("fabricante");
                    %>


                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="page-header"  style="text-align: center; margin-top: 5px">
                                    <h3>Atualizar Fabricante de Veículos</h3>
                                </div>

                                <div style="text-align:right; font-size: 11px;" > * Campo Obrigatório </div>

                                <!-- INÍCIO DO FORMULÁRIO -->
                                <form role="form" class="form-horizontal" action="ServletMarca" method="POST">
                                    <input type="hidden" name="acao" value="editar" />

                                    <div class="form-group form-group-sm">
                                        <label class="control-label col-md-4">Código: *</label>
                                        <div class="col-md-8">									
                                            <input type="text" name="txtDocumento" placeholder="Digite o código" class="form-control" 
                                                   value="<%=registro.getId_marca()%>" size="20" readonly="readonly"/>    							
                                        </div>
                                    </div>

                                    <div class="form-group form-group-sm">
                                        <label class="control-label col-md-4">Nome: *</label>
                                        <div class="col-md-8">									
                                            <input type="text" name="txtNome" placeholder="Nome" class="form-control" autofocus="" 
                                                   value="<%=registro.getNome_marca()%>" size="50" required=""/>      							
                                        </div>
                                    </div>


                                    <hr/>
                                    
                                    
                                    <div class="form-group">
                                        <div class="col-md-10 col-sm-offset-2" style="text-align: center">

                                            <button type="submit" class="btn btn-success">Salvar</button>
                                            <a href="ServletMarca?acao=listar" class="btn btn-danger">Cancelar</a>       

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