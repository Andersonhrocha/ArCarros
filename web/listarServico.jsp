<%@page import="model.ModelServico"%>
<%@page import="dao.DaoServico"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Consultar Serviços</title>
        <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap-3.3.7-dist/css/estilo.css" rel="stylesheet">
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="bootstrap-3.3.7-dist/js/jquery-1.12.4.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h2 class="centralizar"> Consulta dos Serviços </h2>
            <th style="text-align: center"><u>
                                 <a class="btn btn-success" href="menu.jsp" role="button">HOME</a></u></th>
            <hr>

            <!-- INICIO DA TABELA -->
            <table id="example" class="display table-responsive" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th style="text-align: center"><u>Código</u></th>
                        <th style="text-align: center"><u>Nomes</u></th>
                        <th style="text-align: center"><u>Descrição</u></th>
                        <th style="text-align: center"><u>Valor</u></th>
                        <th style="text-align: center"><u>
                                <a class="btn btn-warning" href="adicionarServico.jsp" role="button">Novo Registro</a></u></th>

                    </tr>
                </thead>

                <%
                    //CRIA INSTÂNCIA DA CLASSE DAO E CRIA A LISTA PARA OBTER TODOS OS REGISTROS
                    DaoServico dao = new DaoServico();
                    List<ModelServico> listar;

                    listar = dao.listarTodos();
                    for (ModelServico registro : listar) {
                %>

                <tbody>
                    <tr>                                    
                        <td style="text-align: center"> <%=registro.getId_servico()%> </td>
                        <td style="text-align: center"> <%=registro.getNome_servico()%> </td>
                        <td style="text-align: center"> <%=registro.getDescricao()%> </td>
                        <td style="text-align: center"> <%=registro.getValor_servico()%> </td>
              

                        <!-- BOTÃO EDITAR -->
                        <td> <a href="ServletServico?acao=buscar&txtDocumento=<%=registro.getId_servico()%>" class="btn btn-info">ALTERAR</a></td>

                        <!-- BOTÃO EXLUIR -->
                        <td> <a href="ServletServico?acao=excluir&txtDocumento=<%=registro.getId_servico()%>" class="btn btn-danger">EXCLUIR</a></td>
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
