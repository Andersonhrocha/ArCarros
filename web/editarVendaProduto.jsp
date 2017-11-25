<%@page import="dao.DaoVendaProduto"%>
<%@page import="model.ModelVendaProduto"%>
<%@page import="model.ModelProduto"%>
<%@page import="dao.DaoProduto"%>
<%@page import="model.ModelVenda"%>
<%@page import="dao.DaoVenda"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Atualizar Venda de Produto</title>

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
                        //RECEBE O ATRIBUTO DA OPÇÃO BUSCAR DO SERVLETVENDAPRODUTO
                        ModelVendaProduto registroQTD = (ModelVendaProduto) request.getAttribute("vendaproduto");
                    %>

                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="page-header"  style="text-align: center; margin-top: 5px">
                                    <h3>Atualizar Venda de Produto</h3>
                                </div>

                                <div style="text-align:right; font-size: 11px;" > * Campo Obrigatório </div>

                                <!-- INÍCIO DO FORMULÁRIO -->
                                <form role="form" class="form-horizontal" action="ServletVendaProduto" method="POST">
                                    <input type="hidden" name="acao" value="editar" />
                                    
                                    
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">ID: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-asterisk"></i></span>
                                                <input type="text" name="txtCodigo" class="form-control" 
                                                       value="<%=registroQTD.getId_venda_produto()%>" size="20" required="" readonly="readonly" />
                                            </div>
                                        </div>
                                    </div>  



                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Código Venda/Cliente:</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-link"></i></span>
                                                <select name="txtVenda" class="form-control" required="" /> 
                                                    <!--   <option>Selecione</option> -->

                                                    <%                                                        
                                                        //MÉTODO EXISTETE NA CLASSE DAOVENDA
                                                        DaoVenda dao = new DaoVenda();
                                                        List<ModelVenda> listar;
                                                        
                                                        listar = dao.listarTodos();
                                                        for (ModelVenda registro : listar) {
                                                    %>

                                                    <option value="<%=registro.getId_venda()%>"><%=registro.getId_venda()%> </option>

                                                    <%
                                                        }
                                                    %> 
                                                </select>  
                                            </div>
                                        </div>
                                    </div>  


                                    <div class="form-group"> 
                                        <label class="col-md-4 control-label">Produto: *</label>
                                        <div class="col-md-8 selectContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                                                <select name="txtProduto" class="form-control" required="" > 
                                                    <!--   <option>Selecione</option> -->

                                                    <%                                                        
                                                        //MÉTODO EXISTETE NA CLASSE DAOPRODUTO
                                                        DaoProduto daoPro = new DaoProduto();
                                                        List<ModelProduto> produtoLista;
                                                        
                                                        produtoLista = daoPro.listarTodos();
                                                        for (ModelProduto registro : produtoLista) {
                                                    %>

                                                    <option value="<%=registro.getId_produto()%>"><%=registro.getNome_produto()%> </option>

                                                    <%
                                                        }
                                                    %> 
                                                </select>  
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Quantidade: *</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-sort-by-order"></i></span>

                                                <input type="number" name="txtQuantidade" placeholder="Digite a quantidade" 
                                                       value="<%=registroQTD.getQuantidade()%>" class="form-control" size="11" required="" />
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Forma de Pagamento:</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                                                <select name="txtPagamento" class="form-control" required="">
                                                    <option value="CC">CARTÃO CRÉDITO</option>
                                                    <option value="CD">CARTÃO DÉDITO</option>
                                                    <option value="RS">DINHEIRO</option>
                                                    <option value="CQ">CHEQUE</option>
                                                </select> 
                                            </div>
                                        </div>
                                    </div>  


                                    <hr/>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label"></label>
                                        <div class="col-md-10 col-sm-offset-2" style="text-align: center">

                                            <button type="submit" class="btn btn-success" > <span class="glyphicon glyphicon-floppy-save"></span> Salvar </button>
                                            <a href="ServletVendaProduto?acao=listar" class="btn btn-primary">  <span class="glyphicon glyphicon-list-alt"></span> Consultar</a>     

                                        </div>
                                    </div>


                                    <%-- Mensagem de retorno vindo do ServletVendaProduto  --%>
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