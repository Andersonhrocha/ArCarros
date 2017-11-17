<%@page import="model.ModelServico"%>
<%@page import="dao.DaoServico"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Consultar Serviços</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="datatable/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <link href="datatable/dataTables.jqueryui.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body> 

        <div id="m_main">           

            <div id="m_body">
                <div id="container" style="margin:auto; width: 80%">

                    <h1 class="titulo">Consulta dos Serviços</h1>

                    <th style="text-align: center"><u>
                            <a class="btn btn-primary" href="menu.jsp" >
                                <span class="glyphicon glyphicon-home"></span> HOME</a></u></th>

                    <br><br> 

                    <div id="demo_jui">

                        <!-- INICIO DA TABELA -->
                        <table id="example" class="display table-responsive" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th style="text-align: center"><u>Código</u></th>
                                    <th style="text-align: center"><u>Nomes</u></th>
                                    <th style="text-align: center"><u>Descrição</u></th>
                                    <th style="text-align: center"><u>Preço</u></th>
                                    <th style="text-align: center"><u>
                                            <a class="btn btn-warning" href="adicionarServico.jsp" >
                                                Novo Registro</a></u></th>
                                    <th></th>
                                </tr>   
                            </thead>

                            <%
                                //CRIA INSTÂNCIA DA CLASSE DAO E CRIA A LISTA PARA OBTER TODOS OS REGISTROS
                                DaoServico dao = new DaoServico();
                                List<ModelServico> listar;

                                listar = dao.listarTodos();
                                for (ModelServico registro : listar) {
                            %>
                            <tr>                                    
                                <td style="text-align: center"> <%=registro.getId_servico()%> </td>
                                <td style="text-align: center"> <%=registro.getNome_servico()%> </td>
                                <td style="text-align: center"> <%=registro.getDescricao()%> </td>
                                <td style="text-align: center"> <%=registro.getValor_servico()%> </td>

                                <!-- BOTÃO EDITAR -->
                                <td style="text-align: center">                                        
                                    <a class="btn btn-info" href="ServletServico?acao=buscar&txtDocumento=<%=registro.getId_servico()%>" >
                                        <span class="glyphicon glyphicon-edit"></span> Alterar</a></td>  

                                <!-- BOTÃO EXLUIR -->
                                <td style="text-align: center">
                                    <a class="btn btn-danger" href="ServletServico?acao=excluir&txtDocumento=<%=registro.getId_servico()%>" >
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
