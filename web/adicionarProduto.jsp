<%@page import="model.ModelCategoria"%>
<%@page import="dao.DaoCategoria"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cadastro de Produtos Para Veículos</title>

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
                                    <h3>Novo Produto</h3>
                                </div>

                                <div style="text-align:right; font-size: 11px;" > * Campo Obrigatório </div>

                                <!-- INÍCIO DO FORMULÁRIO -->
                                <form role="form" class="form-horizontal" action="ServletProduto" method="POST">
                                    <input type="hidden" name="acao" value="inserir" />


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Código: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-sort-by-alphabet"></i></span>
                                                <input type="text" name="txtDocumento" placeholder="Digite um código" 
                                                       class="form-control" size="13" required="" autofocus=""  />
                                            </div>
                                        </div>
                                    </div>  


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Nome: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-sort-by-alphabet"></i></span>
                                                <input type="text" name="txtNomeProduto" placeholder="Digite um nome" 
                                                       class="form-control" size="100" required="" />
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Descrição: *</label>
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
                                                <textarea class="form-control" name="txtDescricaoProduto" placeholder="Descrção da categoria" maxlength="200" required=""></textarea>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Validade: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                                <input type="date" name="txtData" class="form-control" required="" />
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-group"> 
                                        <label class="col-md-4 control-label">Categoria: *</label>
                                        <div class="col-md-8 selectContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                                                <select name="txtCategoria" class="form-control" required=""> 
                                                    <!--   <option>Selecione</option> -->

                                                    <%
                                                        //MÉTODO EXISTETE NA CLASSE DAOCATEGORIA
                                                        DaoCategoria dao = new DaoCategoria();
                                                        List<ModelCategoria> listar;

                                                        listar = dao.listarCategoria();
                                                        for (ModelCategoria registro : listar) {
                                                    %>

                                                    <option value="<%=registro.getId_categoria()%>"><%=registro.getNome_categoria()%> </option>

                                                    <%
                                                        }
                                                    %> 
                                                </select>  
                                                
                                                <!-- BOTÃO PARA ADICIONAR NOVA CATEGORIA -->                                   
                                                <a class="btn btn-primary" href="adicionarCategoria.jsp" >
                                                    <span class="glyphicon glyphicon-plus"></span> </a>  
                                                    
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


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Estoque: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-sort-by-order"></i></span>
                                                <input type="number" name="txtEstoque" placeholder="Digite a quantidade" 
                                                       class="form-control" size="11" required="" />
                                            </div>
                                        </div>
                                    </div>


                                    <hr/>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label"></label>
                                        <div class="col-md-10 col-sm-offset-2" style="text-align: center">

                                            <button type="submit" class="btn btn-success" > <span class="glyphicon glyphicon-floppy-save"></span> Salvar </button>
                                            <a href="ServletProduto?acao=listar" class="btn btn-primary">  <span class="glyphicon glyphicon-list-alt"></span> Consultar</a>     

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