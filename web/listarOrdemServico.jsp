<%@page import="java.util.List"%>
<%@page import="model.ModelOrdemServico"%>
<%@page import="dao.DaoOrdemServico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Lista Ordens de Serviço</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="datatable/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <link href="datatable/dataTables.jqueryui.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body> 

        <div id="m_main">           

            <div id="m_body">
                <div id="container" style="margin:auto; width: 80%">

                    <h1 class="titulo">Lista das Ordens de Serviço</h1>

                    <th style="text-align: center"><u>
                            <a class="btn btn-primary" href="menu.jsp" >
                                <span class="glyphicon glyphicon-home"></span> HOME</a></u></th>

                    <th style="text-align: center"><u>
                            <a class="btn btn-success" href="RelatorioProdutoServlet?comando=imprimir_ordens_servico" target="_blank" />
                            <span class="glyphicon glyphicon-print"></span> IMPRIMIR TODOS</a></u></th>

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
                                    <td style="text-align: center"> <%=registro.getRelacao_id_carro().getId_carro()%> </td>
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
