<%@page import="java.util.List"%>
<%@page import="model.ModelCliente"%>
<%@page import="dao.DaoCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Consulta de Cliente</title>
        <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap-3.3.7-dist/css/estilo.css" rel="stylesheet">
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="bootstrap-3.3.7-dist/js/jquery-1.12.4.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h2 class="centralizar"> Consulta de Clientes </h2>
            <th style="text-align: center"><u>
                                 <a class="btn btn-success" href="menu.jsp" role="button">HOME</a></u></th>
            <hr>

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
                                <a class="btn btn-warning" href="adicionarCliente.jsp" role="button">Novo Registro</a></u></th>

                    </tr>
                </thead>

                <%
                    //CRIA INSTÂNCIA DA CLASSE DAO E CRIA A LISTA PARA OBTER TODOS OS REGISTROS
                    DaoCliente dao = new DaoCliente();
                    List<ModelCliente> listar;

                    listar = dao.listarTodos();
                    for (ModelCliente registro : listar) {
                %>

                <tbody>
                    <tr>                                    
                        <td style="text-align: center"> <%=registro.getCpf_cliente()%> </td>
                        <td style="text-align: center"> <%=registro.getNome_cliente()%> </td>
                        <td style="text-align: center"> <%=registro.getEndereco()%> </td>
                        <td style="text-align: center"> <%=registro.getTelefone()%> </td>
                        <td style="text-align: center"> <%=registro.getEmail()%> </td>                      

                        <!-- BOTÃO EDITAR -->
                        <td> <a href="ServletCliente?acao=buscar&txtDocumento=<%=registro.getCpf_cliente()%>" class="btn btn-info">ALTERAR</a></td>

                        <!-- BOTÃO EXLUIR -->
                        <td> <a href="ServletCliente?acao=excluir&txtDocumento=<%=registro.getCpf_cliente()%>" class="btn btn-danger">EXCLUIR</a></td>
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
