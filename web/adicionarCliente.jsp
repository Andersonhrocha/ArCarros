<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cadastro de Cliente</title>

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
                                    <h3>Novo Contato</h3>
                                </div>

                                <div style="text-align:right; font-size: 11px;" > * Campo Obrigatório </div>

                                <!-- INÍCIO DO FORMULÁRIO -->
                                <form role="form" class="form-horizontal" action="ServletCliente" method="POST">
                                    <input type="hidden" name="acao" value="inserir" /> 


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Documento: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-sort-by-order"></i></span>
                                                <input type="text" name="txtDocumento" placeholder="Digite um CPF" 
                                                       class="form-control" size="20" required="" autofocus=""  />
                                            </div>
                                        </div>
                                    </div>   


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Nome: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                                <input type="text" name="txtNome" placeholder="Digite um nome" 
                                                       class="form-control" size="100" required="" />
                                            </div>
                                        </div>
                                    </div>   


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Endereço: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                                                <input type="text" name="txtEndereco" placeholder="Digite um endereço" 
                                                       class="form-control" size="200" required="" />
                                            </div>
                                        </div>
                                    </div>   


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Telefone: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                                                <input type="text" name="txtTelefone" placeholder="8199998888" 
                                                       class="form-control" size="12" required="" />
                                            </div>
                                        </div>
                                    </div>   


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">E-mail: </label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                                                <input type="email" name="txtEmail" placeholder="Digite um e-mail" 
                                                       class="form-control" size="50" />
                                            </div>
                                        </div>
                                    </div>  


                                    <hr/>
                                    

                                    <div class="form-group">
                                        <label class="col-md-4 control-label"></label>
                                        <div class="col-md-10 col-sm-offset-2" style="text-align: center">

                                            <button type="submit" class="btn btn-success" > <span class="glyphicon glyphicon-floppy-save"></span> Salvar </button>
                                            <a href="ServletCliente?acao=listar" class="btn btn-primary">  <span class="glyphicon glyphicon-list-alt"></span> Consultar</a>     

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