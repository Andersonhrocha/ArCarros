<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>cadastro de Serviço</title>

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
                                    <h3>Novo Cadastro de Serviço</h3>
                                </div>

                                <div style="text-align:right; font-size: 11px;" > * Campo Obrigatório </div>

                                <!-- INÍCIO DO FORMULÁRIO -->
                                <form role="form" class="form-horizontal" action="ServletServico" method="POST">
                                    <input type="hidden" name="acao" value="inserir" />


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Nome: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-sort-by-alphabet"></i></span>
                                                <input type="text" name="txtNome" placeholder="Digite o nome do serviço" class="form-control" 
                                                       size="100" required="" autofocus=""  />
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Descrição: *</label>
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
                                                <textarea class="form-control" name="txtDescricao" 
                                                          placeholder="Descrção do serviço" maxlength="200" required=""></textarea>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Preço: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-usd"></i></span>
                                                <input type="text" name="txtValor" placeholder="EX: 10.00" 
                                                       class="form-control" size="20" required="" />
                                            </div>
                                        </div>
                                    </div>


                                    <hr/>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label"></label>
                                        <div class="col-md-10 col-sm-offset-2" style="text-align: center">

                                            <button type="submit" class="btn btn-success" > <span class="glyphicon glyphicon-floppy-save"></span> Salvar </button>
                                            <a href="ServletServico?acao=listar" class="btn btn-primary">  <span class="glyphicon glyphicon-list-alt"></span> Consultar</a>     

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