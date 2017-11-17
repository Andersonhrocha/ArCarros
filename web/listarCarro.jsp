<%@page import="model.ModelCarro"%>
<%@page import="dao.DaoCarro"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Consultar Veículos</title>
        
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

                    <h1 class="titulo">Consultar Veículos</h1>

                    <div id="demo_jui">

                        <!-- INICIO DA TABELA -->
                        <table id="example" class="display table-responsive" width="100%" cellspacing="0">
                            <thead>
                                <tr>                                 
                                    <th style="text-align: center"><u>Placa</u></th>
                                    <th style="text-align: center"><u>Ano</u></th>
                                    <th style="text-align: center"><u>Cor</u></th>
                                    <th style="text-align: center"><u>CPF Cliente</u></th>
                                    <th style="text-align: center"><u>Modelo Veículo</u></th>
                                    <th style="text-align: center"><u>
                                            <a class="btn btn-warning" href="adicionarCarro.jsp" >
                                                Novo Registro</a></u></th>
                                    <th></th>
                                </tr>   
                            </thead>

                            <tbody>
                                <%
                                    //CRIA INSTÂNCIA DA CLASSE DAO E CRIA A LISTA PARA OBTER TODOS OS REGISTROS
                                    DaoCarro dao = new DaoCarro();
                                    List<ModelCarro> listar;

                                    listar = dao.listarTodos();
                                    for (ModelCarro registro : listar) {

                                %>
                                <tr>                                    
                                    <td style="text-align: center"> <%=registro.getId_carro()%> </td>
                                    <td style="text-align: center"> <%=registro.getAno()%> </td>
                                    <td style="text-align: center"> <%=registro.getCor()%> </td>
                                    <td style="text-align: center"> <%=registro.getCliente().getCpf_cliente()%> </td>
                                    <td style="text-align: center"> <%=registro.getModelo().getNome_modelo()%> </td>

                                    <!-- BOTÃO EDITAR -->
                                    <td style="text-align: center">
                                        <a class="btn btn-info" href="ServletCarro?acao=buscar&txtDocumento=<%=registro.getId_carro()%>" >
                                            <span class="glyphicon glyphicon-edit"></span> Alterar</a></td>  

                                    <!-- BOTÃO EXLUIR -->
                                    <td style="text-align: center">
                                        <a class="btn btn-danger" href="ServletCarro?acao=excluir&txtDocumento=<%=registro.getId_carro()%>" >
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
