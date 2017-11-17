<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cadastro de Fabricantes de Veículos</title>

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
                                    <h3>Novo Fabricante de Veículo</h3>
                                </div>

                                <div style="text-align:right; font-size: 11px;" > * Campo Obrigatório </div>

                                <!-- INÍCIO DO FORMULÁRIO -->
                                <form role="form" class="form-horizontal" action="ServletMarca" method="POST">
                                    <input type="hidden" name="acao" value="inserir" />

                                    <div class="form-group form-group-sm">
                                        <label class="control-label col-md-4">Nome: *</label>
                                        <div class="col-md-8">									
                                            <input type="text" name="txtNome" placeholder="Digite uma marca" class="form-control" 
                                                   size="50" required="" autofocus=""/>      							
                                        </div>
                                    </div>


                                    <hr/>
                                    <div class="form-group">
                                        <div class="col-md-10 col-sm-offset-2" style="text-align: center">

                                            <button type="submit" class="btn btn-success">Salvar</button>
                                            <a href="ServletMarca?acao=listar" class="btn btn-primary">Consultar</a>        

                                        </div>	
                                    </div>

                                    <%-- Mensagem de retorno vindo do ServletCliente  --%>
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