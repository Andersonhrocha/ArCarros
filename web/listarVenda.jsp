<%@page import="model.ModelVenda"%>
<%@page import="dao.DaoVenda"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Lista Cadastro Venda</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="datatable/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <link href="datatable/dataTables.jqueryui.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body> 

        <div id="m_main">           

            <div id="m_body">
                <div id="container" style="margin:auto; width: 80%">

                    <h1 class="titulo">Consultar Cadastro Para Venda</h1>

                    <th style="text-align: center"><u>
                            <a class="btn btn-primary" href="menu.jsp" >
                                <span class="glyphicon glyphicon-home"></span> HOME</a></u></th>

                    <br><br> 

                    <div id="demo_jui">

                        <!-- INICIO DA TABELA -->
                        <table id="example" class="display table-responsive" width="100%" cellspacing="0">
                            <thead>
                                <tr>                                 
                                    <th style="text-align: center"><u>Código da Venda</u></th>
                                    <th style="text-align: center"><u>CPF do Cliente</u></th>
                                    <th style="text-align: center"><u>Data Cadastro</u></th>
                                    <th style="text-align: center"><u>
                                            <a class="btn btn-warning" href="adicionarVenda.jsp" >
                                                Novo Registro</a></u></th>
                                    <th></th>
                                </tr>   
                            </thead>

                            <tbody>
                                <%
                                    //CRIA INSTÂNCIA DA CLASSE DAO E CRIA A LISTA PARA OBTER TODOS OS REGISTROS
                                    DaoVenda dao = new DaoVenda();
                                    List<ModelVenda> listar;

                                    listar = dao.listarTodos();
                                    for (ModelVenda registro : listar) {

                                %>
                                <tr>                                    
                                    <td style="text-align: center"> <%=registro.getId_venda()%> </td>
                                    <td style="text-align: center"> <%=registro.getCliente().getCpf_cliente()%> </td>
                                    <td style="text-align: center"> <%=registro.getData()%> </td>


                                    <!-- BOTÃO ADICIONAR PRODUTOS -->
                                    <td style="text-align: center">
                                        <a class="btn btn-success" href="adicionarVendaProduto.jsp" >
                                            <span class="glyphicon glyphicon-plus"></span> Comprar</a></td> 


                                    <!-- BOTÃO INFORMAÇÕES -->
                                    <td style="text-align: center">
                                        <a class="btn btn-info" href="ServletVenda?acao=buscar&txtDocumento=<%=registro.getId_venda()%>" >
                                            <span class="glyphicon glyphicon-edit"></span> Informações</a></td>  


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
