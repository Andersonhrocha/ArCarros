package controller;

import dao.DaoCategoria;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelCategoria;

/**
 *
 * @author Anderson
 */
@WebServlet(name = "ServletCategoria", urlPatterns = {"/ServletCategoria"})
public class ServletCategoria extends ServletAbstrato {

    //CONSTANTES DAS PÁGINAS .JSP
    private static final String EDITAR_CATEGORIA = "editarCategoria.jsp";
    private static final String LISTAR_CATEGORIA = "listarCategoria.jsp";
    private final DaoCategoria dao;

    public ServletCategoria() {
        dao = new DaoCategoria();
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //CRIANDO OBJETO DA CLASSE ModelCategoria
            ModelCategoria pro = new ModelCategoria();

           //RECEBE PARAMETRO VIA POST DO FORMULÁRIO UTILIZANDO CAMPO hidden
            String acao = request.getParameter("acao");

            //INICIO DOS MÉTODOS DO BANCO DE DADOS
            if (acao.equalsIgnoreCase("inserir")) {

                //RECEBENDO OS VALORES DO FORMULÁRIO
                pro.setNome_categoria(request.getParameter("txtNome"));
                pro.setDescricao(request.getParameter("txtDescricao"));

                //INCLUIR NO BANCO DE DADOS
                this.dao.incluir(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_CATEGORIA);

            } else if (acao.equalsIgnoreCase("editar")) {

                //PARAMETRO QUE OBTÉM O ID PARA EDITAR
                pro.setId_categoria(Integer.parseInt(request.getParameter("txtDocumento")));
                pro.setNome_categoria(request.getParameter("txtNome"));
                pro.setDescricao(request.getParameter("txtDescricao"));

                //EDITANDO NO BANCO DE DADOS
                this.dao.editar(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_CATEGORIA);

            } else if (acao.equalsIgnoreCase("excluir")) {

                //PARAMETRO QUE OBTÉM O ID PARA EXCLUSÃO
                pro.setId_categoria(Integer.parseInt(request.getParameter("txtDocumento")));

                //EXCLUIDO DO BANCO DE DADOS
                this.dao.excluir(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_CATEGORIA);

            } else if (acao.equalsIgnoreCase("buscar")) {

                //PARAMETRO QUE OBTÉM O ID PARA BUSCAR REGISTRO
                pro.setId_categoria(Integer.parseInt(request.getParameter("txtDocumento")));

                //BUSCA PARA EDITAR
                pro = dao.buscar(pro);
                request.setAttribute("categoria", pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, EDITAR_CATEGORIA);

            } else if (acao.equalsIgnoreCase("listar")) {

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_CATEGORIA);
            }

        } catch (IOException | ServletException ex) {
            System.out.println("Erro na interação: " + ex.getMessage());
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executar(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executar(request, response);
    }

}
