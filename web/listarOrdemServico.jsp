<%@page import="java.util.List"%>
<%@page import="model.ModelOrdemServico"%>
<%@page import="dao.DaoOrdemServico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Consultar Ordens de Serviço</title>

        <!-- BOOTSTRAP -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="datatable/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <link href="datatable/dataTables.jqueryui.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>

        <!-- MENU -->
        <link href="bootstrap-Menu/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap-Menu/css/estilo.css" rel="stylesheet">
        <script src="bootstrap-Menu/js/jquery-1.11.1.min.js"></script>
        <script src="bootstrap-Menu/js/bootstrap.min.js"></script>
    </head>
    <body> 

        <div id="m_main">

            <div id="m_body">
                <div id="container" style="margin:auto; width: 80%">

                    <!-- MENU INCLUDE -->
                    <jsp:include page="menu.jsp"/>

                    <br><br><br>

                    <h1 class="titulo">Consultar OS e Orçamento</h1>

                    <!-- INÍCIO DO FORMULÁRIO -->
                    <form role="form" class="form-horizontal" action="RelatorioImpresso" method="POST" target="_blank">
                        <input type="hidden" name="comando" value="imprimir_ordens_servico" />

                        <div style="float: right; size: 20px;">                                              
                            <input type="text" name="codigoOrcamento" placeholder="Digite o cod. do orçamento" class="form-control" 
                                   size="10" autofocus=""  />
                            <p></p>
                            <span class="glyphicon glyphicon-print"></span> 
                            <input type="submit" value="IMPRIMIR POR CÓDIGO" class="btn btn-primary" />                           
                            <p></p>
                        </div>   

                    </form>
                    <!-- FINAL DO FORMULÁRIO -->

                    <br><br>
                    
                    <div id="demo_jui">

                        <!-- INICIO DA TABELA -->
                        <table id="example" class="display table-responsive" width="100%" cellspacing="0">
                            <thead>
                                <tr>                                 
                                    <th style="text-align: center"><u>Código</u></th>
                                    <th style="text-align: center"><u>Placa Veículo</u></th>
                                    <th style="text-align: center"><u>Data</u></th>
                                    <th style="text-align: center"><u>Situação</u></th>
                                    <th style="text-align: center"><u>Valor Atual</u></th>
                                    <th style="text-align: center"><u>
                                            <a class="btn btn-warning" href="adicionarOrdemServico.jsp" >
                                                Novo Registro</a></u></th>
                                    <th></th>
                                </tr>   
                            </thead>

                            <tbody>
                                <%
                                    //CRIA INSTÂNCIA DA CLASSE DAO E CRIA A LISTA PARA OBTER TODOS OS REGISTROS
                                    DaoOrdemServico dao = new DaoOrdemServico();
                                    List<ModelOrdemServico> listar;

                                    listar = dao.listarTodos();
                                    for (ModelOrdemServico registro : listar) {

                                %>
                                <tr>                                    
                                    <td style="text-align: center"> <%=registro.getId_ordem_Servico()%> </td>
                                    <td style="text-align: center"> <%=registro.getCarro().getId_carro()%> </td>
                                    <td style="text-align: center"> <%=registro.getData()%> </td>
                                    <td style="text-align: center"> <%=registro.getSituacao()%> </td>
                                    <td style="text-align: center"> <%=registro.getValor()%> </td>


                                    <!-- BOTÃO ITEM -->
                                    <td style="text-align: center">
                                        <a class="btn btn-success" href="listarItemOrdemServico.jsp" >
                                            <span class="glyphicon glyphicon-plus"></span> Item</a></td>



                                    <!-- BOTÃO EDITAR -->
                                    <td style="text-align: center">
                                        <a class="btn btn-info" href="ServletOrdemServico?acao=buscar&txtDocumento=<%=registro.getId_ordem_Servico()%>" >
                                            <span class="glyphicon glyphicon-edit"></span> Alterar</a></td>  


                                    <!-- BOTÃO EXLUIR -->
                                    <!--  <td style="text-align: center">
                                          <a class="btn btn-danger" href="ServletOrdemServico?acao=excluir&txtDocumento=<%=registro.getId_ordem_Servico()%>" >
                                              <span class="glyphicon glyphicon-trash"></span> Excluir</a></td>
                                    -->
                                </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                        <!-- FINAL DA TABELA -->
                    </div>
                </div>
                <br/>
            </div>
            <!--/div-->
        </div>

        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="datatable/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="datatable/dataTables.jqueryui.min.js" type="text/javascript"></script>


        <script type="text/javascript">
            $(document).ready(function () {
                $('#example').dataTable({
                    "lengthMenu": [5, 10, 25, 50, 75, 100],
                    "language": {
                        "lengthMenu": 'Mostrar <select>' +
                                '<option value="5">5</option>' +
                                '<option value="10">10</option>' +
                                '<option value="25">25</option>' +
                                '<option value="50">50</option>' +
                                '<option value="75">75</option>' +
                                '<option value="100">100</option>' +
                                '<option value="-1">Todo</option>' +
                                '</select>',
                        "search": "Buscar:",
                        "info": "Mostrando Página _PAGE_ de _PAGES_ ",
                        "paginate": {
                            "previous": "Anterior",
                            "next": "Próximo"
                        }
                    }
                });
            });
        </script>
    </body>
</html>
