<%@page import="model.ModelCategoria"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Atualizar Categoria de Produtos</title>

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
                        //RECEBE O ATRIBUTO DA OPÇÃO BUSCAR DO SERVLETCATEGORIA
                        ModelCategoria registro = (ModelCategoria) request.getAttribute("categoria");
                    %>

                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="page-header"  style="text-align: center; margin-top: 5px">
                                    <h3>Atualizar Categoria de Produto</h3>
                                </div>

                                <div style="text-align:right; font-size: 11px;" > * Campo Obrigatório </div>

                                <!-- INÍCIO DO FORMULÁRIO -->
                                <form role="form" class="form-horizontal" action="ServletCategoria" method="POST">
                                    <input type="hidden" name="acao" value="editar" />


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Código: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-asterisk"></i></span>
                                                <input type="text" name="txtDocumento" class="form-control"
                                                       value="<%=registro.getId_categoria()%>" size="11" readonly="readonly" />
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Nome: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-sort-by-alphabet"></i></span>
                                                <input type="text" name="txtNome" class="form-control" 
                                                       value="<%=registro.getNome_categoria()%>" size="50" required="" autofocus="" />
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Descrição: *</label>
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
                                                <textarea name="txtDescricao" class="form-control" 
                                                          maxlength="100" required=""><%=registro.getDescricao()%></textarea>
                                            </div>
                                        </div>
                                    </div>

                                            
                                    <hr/>

                                    
                                    <div class="form-group">
                                        <label class="col-md-4 control-label"></label>
                                        <div class="col-md-10 col-sm-offset-2" style="text-align: center">

                                            <button type="submit" class="btn btn-success" > <span class="glyphicon glyphicon-floppy-save"></span> Salvar </button>
                                            <a href="ServletCategoria?acao=listar" class="btn btn-danger">  <span class="glyphicon glyphicon-list-alt"></span> Cancelar</a>     

                                        </div>                                        
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