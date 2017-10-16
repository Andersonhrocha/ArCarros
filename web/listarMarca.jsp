<%@page import="model.ModelMarca"%>
<%@page import="dao.DaoMarca"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Marcas de Carro</title>
        <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap-3.3.7-dist/css/estilo.css" rel="stylesheet">
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="bootstrap-3.3.7-dist/js/jquery-1.12.4.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h2 class="centralizar"> Lista de Marcas </h2>
            <th style="text-align: center"><u>
                                 <a class="btn btn-success" href="menu.jsp" role="button">HOME</a></u></th>
            <hr>

            <!-- INICIO DA TABELA -->
            <table id="example" class="display table-responsive" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th style="text-align: center"><u>Código</u></th>
                        <th style="text-align: center"><u>Nomes</u></th>
                        <th ><u><a class="btn btn-warning" href="adicionarMarca.jsp" role="button">Novo Registro</a></u></th>

                    </tr>
                </thead>

                <%
                    DaoMarca dao = new DaoMarca();
                    List<ModelMarca> listar;

                    listar = dao.listarTodos();
                    for (ModelMarca registro : listar) {
                %>

                <tbody>
                    <tr>                                    
                        <td style="text-align: center"> <%=registro.getId_marca()%> </td>
                        <td style="text-align: center"> <%=registro.getNome()%> </td>
                                     

                        <!-- BOTÃO EDITAR -->
                        <td> <a href="ServletMarca?acao=buscar&txtDocumento=<%=registro.getId_marca()%>" class="btn btn-info">ALTERAR</a>

                        <!-- BOTÃO EXLUIR -->
                        <a href="ServletMarca?acao=excluir&txtDocumento=<%=registro.getId_marca()%>" class="btn btn-danger">EXCLUIR</a></td>
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