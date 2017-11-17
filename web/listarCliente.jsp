<%@page import="java.util.List"%>
<%@page import="model.ModelCliente"%>
<%@page import="dao.DaoCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Consultar Clientes</title>

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

                    <h1 class="titulo">Consultar Clientes</h1> 
                    
                    <div id="demo_jui">

                        <!-- INICIO DA TABELA -->
                        <table id="example" class="display table-responsive" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th style="text-align: center"><u>Código</u></th>
                                    <th style="text-align: center"><u>Nomes</u></th>
                                    <th style="text-align: center"><u>Endereço</u></th>
                                    <th style="text-align: center"><u>Telefone</u></th>
                                    <th style="text-align: center"><u>E-mail</u></th>
                                    <th style="text-align: center"><u>
                                            <a class="btn btn-warning" href="adicionarCliente.jsp" >
                                                Novo Registro</a></u></th>
                                    <th></th>
                                </tr>   
                            </thead>

                            <tbody>
                                <%
                                    //CRIA INSTÂNCIA DA CLASSE DAO E CRIA A LISTA PARA OBTER TODOS OS REGISTROS
                                    DaoCliente dao = new DaoCliente();
                                    List<ModelCliente> listar;

                                    listar = dao.listarTodos();
                                    //FOR -> APRIMORADO
                                    for (ModelCliente registro : listar) {
                                %>
                                <tr>                                    
                                    <td style="text-align: center"> <%=registro.getCpf_cliente()%> </td>
                                    <td style="text-align: center"> <%=registro.getNome_cliente()%> </td>
                                    <td style="text-align: center"> <%=registro.getEndereco()%> </td>
                                    <td style="text-align: center"> <%=registro.getTelefone()%> </td>
                                    <td style="text-align: center"> <%=registro.getEmail()%> </td> 

                                    <!-- BOTÃO EDITAR -->
                                    <td style="text-align: center">
                                        <a class="btn btn-info" href="ServletCliente?acao=buscar&txtDocumento=<%=registro.getCpf_cliente()%>" >
                                            <span class="glyphicon glyphicon-edit"></span> Alterar</a></td>  

                                    <!-- BOTÃO EXLUIR -->
                                    <td style="text-align: center">
                                        <a class="btn btn-danger" href="ServletCliente?acao=excluir&txtDocumento=<%=registro.getCpf_cliente()%>" >
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
