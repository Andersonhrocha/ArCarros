<%@page import="model.ModelServico"%>
<%@page import="dao.DaoServico"%>
<%@page import="model.ModelProduto"%>
<%@page import="dao.DaoProduto"%>
<%@page import="model.ModelOrdemServico"%>
<%@page import="dao.DaoOrdemServico"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Novo Item Ordem Serviço</title>

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
                                    <h3>Novo Item Ordem Serviço</h3>
                                </div>

                                <div style="text-align:right; font-size: 11px;" > * Campo Obrigatório </div>

                                <!-- INÍCIO DO FORMULÁRIO -->
                                <form role="form" class="form-horizontal" action="ServletItemOrdemServico" method="POST">
                                    <input type="hidden" name="acao" value="inserir" />


                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Código Ordem Serviço:</label>  
                                        <div class="col-md-8 inputGroupContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-link"></i></span>
                                                <select name="txtOrdemServico" class="form-control" required=""> 
                                                    <!--   <option>Selecione</option> -->

                                                    <%                                                        //MÉTODO EXISTETE NA CLASSE DAOCATEGORIA
                                                        DaoOrdemServico dao = new DaoOrdemServico();
                                                        List<ModelOrdemServico> listar;
                                                        listar = dao.listarTodos();
                                                        for (ModelOrdemServico registro : listar) {
                                                    %>

                                                    <option value="<%=registro.getId_ordem_Servico()%>"><%=registro.getId_ordem_Servico()%> </option>

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
                                                <select name="txtProduto" class="form-control" required=""> 
                                                    <!--   <option>Selecione</option> -->

                                                    <%                                                        //MÉTODO EXISTETE NA CLASSE DAOCATEGORIA
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
                                        <label class="col-md-4 control-label">Serviço: *</label>
                                        <div class="col-md-8 selectContainer">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                                                <select name="txtServico" class="form-control" required=""> 
                                                    <!--   <option>Selecione</option> -->

                                                    <%                                                        //MÉTODO EXISTETE NA CLASSE DAOCATEGORIA
                                                        DaoServico daoServ = new DaoServico();
                                                        List<ModelServico> servicoLista;
                                                        servicoLista = daoServ.listarTodos();
                                                        for (ModelServico registro : servicoLista) {
                                                    %>

                                                    <option value="<%=registro.getId_servico()%>"><%=registro.getNome_servico()%> </option>

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
                                                <input type="number" name="txtQtdPro" placeholder="Digite a quantidade" 
                                                       class="form-control" size="11" required="" />
                                            </div>
                                        </div>
                                    </div>

                                                
                                    <hr/>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label"></label>
                                        <div class="col-md-10 col-sm-offset-2" style="text-align: center">

                                            <button type="submit" class="btn btn-success" > <span class="glyphicon glyphicon-floppy-save"></span> Salvar </button>
                                            <a href="ServletItemOrdemServico?acao=listar" class="btn btn-primary">  <span class="glyphicon glyphicon-list-alt"></span> Consultar</a>     

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