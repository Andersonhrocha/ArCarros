<%@page import="model.ModelCarro"%>
<%@page import="dao.DaoCarro"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Consulta de Automóveis</title>
        <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap-3.3.7-dist/css/estilo.css" rel="stylesheet">
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="bootstrap-3.3.7-dist/js/jquery-1.12.4.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h2 class="centralizar"> Consultar Veículos </h2>
            <th style="text-align: center"><u>
                    <a class="btn btn-success" href="menu.jsp" role="button">HOME</a></u></th>
            <hr>

            <!-- INICIO DA TABELA -->
            <table id="example" class="display table-responsive" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th style="text-align: center"><u>Placa</u></th>
                        <th style="text-align: center"><u>Ano</u></th>
                        <th style="text-align: center"><u>Cor</u></th>
                        <th style="text-align: center"><u>CPF Cliente</u></th>
                         <th style="text-align: center"><u>Modelo Veículo</u></th>
                        <th ><u><a class="btn btn-warning" href="adicionarCarro.jsp" role="button">Novo Registro</a></u></th>

                    </tr>
                </thead>

                <%
                    //CRIA INSTÂNCIA DA CLASSE DAO E CRIA A LISTA PARA OBTER TODOS OS REGISTROS
                    DaoCarro dao = new DaoCarro();
                    List<ModelCarro> listar;

                    listar = dao.listarTodos();
                    for (ModelCarro registro : listar) {
                      
                %>

                <tbody>
                    <tr> 
                        <td style="text-align: center"> <%=registro.getId_carro()%> </td>
                        <td style="text-align: center"> <%=registro.getAno()%> </td>
                        <td style="text-align: center"> <%=registro.getCor()%> </td>
                        <td style="text-align: center"> <%=registro.getRelacao_id_cliente().getCpf_cliente()%> </td>
                       <td style="text-align: center"> <%=registro.getRelacao_id_modelo().getNome_modelo()%> </td>
                       
                        <!-- BOTÃO EDITAR -->
                        <td> <a href="ServletCarro?acao=buscar&txtDocumento=<%=registro.getId_carro()%>" class="btn btn-info">ALTERAR</a>

                            <!-- BOTÃO EXLUIR -->
                            <a href="ServletCarro?acao=excluir&txtDocumento=<%=registro.getId_carro()%>" class="btn btn-danger">EXCLUIR</a></td>
                    </tr>
                </tbody>
                <%
                    }
                %>
                
            </table>
            <!-- FINAL DA TABELA -->

        </div>
    </body>
</html>
