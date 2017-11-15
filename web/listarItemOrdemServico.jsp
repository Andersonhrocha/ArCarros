<%@page import="model.ModelItemOrdemServico"%>
<%@page import="dao.DaoItemOrdemServico"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Consulta Item Ordem de Serviço</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="datatable/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <link href="datatable/dataTables.jqueryui.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body> 

        <div id="m_main">           

            <div id="m_body">
                <div id="container" style="margin:auto; width: 80%">

                    <h1 class="titulo">Consulta dos Itens</h1>

                    <th style="text-align: center"><u>
                            <a class="btn btn-primary" href="menu.jsp" >
                                <span class="glyphicon glyphicon-home"></span> HOME</a></u></th>


                    <!-- INÍCIO DO FORMULÁRIO -->
                    <form role="form" class="form-horizontal" action="RelatorioImpresso" method="POST" target="_blank">
                        <input type="hidden" name="comando" value="imprimir_item_ordens_servico" />

                        <label class="col-md-4 control-label"></label>  
                        <div class="col-md-4 inputGroupContainer">                                               
                            <input type="text" name="codigoItemOrdemServico" placeholder="Digite o Código da Ordem de Serviço" class="form-control" 
                                   size="10" autofocus=""  />
                            <span class="glyphicon glyphicon-print"></span> <input type="submit" value="IMPRIMIR POR CÓDIGO" class="btn btn-success" />                           
                        </div>                        
                    </form>
                    <!-- FINAL DO FORMULÁRIO -->
                    

                    <br><br> 

                    <div id="demo_jui">

                        <!-- INICIO DA TABELA -->
                        <table id="example" class="display table-responsive" width="100%" cellspacing="0">
                            <thead>
                                <tr> 
                                    <th style="text-align: center"><u>ID</u></th>
                                    <th style="text-align: center"><u>Código Ordem Serviço</u></th>
                                    <th style="text-align: center"><u>Produto</u></th>
                                    <th style="text-align: center"><u>Serviço</u></th>
                                    <th style="text-align: center"><u>Qtd Produto Utilizado</u></th>

                                    <th style="text-align: center"><u>
                                            <a class="btn btn-warning" href="adicionarItemOrdemServico.jsp" >
                                                Novo Registro</a></u></th>
                                    <th></th>
                                </tr>   
                            </thead>

                            <tbody>
                                <%
                                    //CRIA INSTÂNCIA DA CLASSE DAO E CRIA A LISTA PARA OBTER TODOS OS REGISTROS
                                    DaoItemOrdemServico dao = new DaoItemOrdemServico();
                                    List<ModelItemOrdemServico> listar;

                                    listar = dao.listarTodos();
                                    for (ModelItemOrdemServico registro : listar) {

                                %>
                                <tr> 
                                    <td style="text-align: center"> <%=registro.getId_item_ordem_servico()%> </td>
                                    <td style="text-align: center"> <%=registro.getRelacao_id_ordem_servico().getId_ordem_Servico()%> </td>
                                    <td style="text-align: center"> <%=registro.getRelacao_id_produto().getNome_produto()%> </td>
                                    <td style="text-align: center"> <%=registro.getRelacao_id_servico().getNome_servico()%> </td>
                                    <td style="text-align: center"> <%=registro.getQtd_prod_utilizado()%> </td>


                                    <!-- BOTÃO EDITAR -->
                                    <td style="text-align: center">
                                        <a class="btn btn-info" href="#" >
                                            <span class="glyphicon glyphicon-edit"></span></a></td>  


                                    <!-- BOTÃO EXLUIR -->
                                    <td style="text-align: center">
                                        <a class="btn btn-danger" href="ServletItemOrdemServico?acao=excluir&txtItemOrdemServico=<%=registro.getId_item_ordem_servico()%>" >
                                            <span class="glyphicon glyphicon-trash"></span> Excluir</a></td>

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
