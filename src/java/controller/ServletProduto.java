package controller;

import dao.DaoProduto;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelProduto;

/**
 *
 * @author Anderson
 */
@WebServlet(name = "ServletProduto", urlPatterns = {"/ServletProduto"})
public class ServletProduto extends ServletAbstrato {

    //CONSTANTES DAS PÁGINAS .JSP
    private static final String EDITAR_PRODUTO = "editarProduto.jsp";
    private static final String LISTAR_PRODUTO = "listarProduto.jsp";
    private final DaoProduto dao;

    public ServletProduto() {
        dao = new DaoProduto();
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //CRIANDO OBJETO DA CLASSE ModelProduto
            ModelProduto pro = new ModelProduto();

            //RECEBE PARAMETRO VIA POST DO FORMULÁRIO UTILIZANDO CAMPO hidden
            String acao = request.getParameter("acao");

            //INICIO DOS MÉTODOS DO BANCO DE DADOS
            if (acao.equalsIgnoreCase("inserir")) {

                //RECEBENDO OS VALORES DO FORMULÁRIO
                pro.setId_produto(request.getParameter("txtDocumento"));
                pro.setNome_produto(request.getParameter("txtNomeProduto"));
                pro.setDescricao_produto(request.getParameter("txtDescricaoProduto"));
                pro.setValidade(Date.valueOf(request.getParameter("txtData")));
                pro.getCategoria().setId_categoria(Integer.parseInt(request.getParameter("txtCategoria")));
                pro.setValor_produto(Double.parseDouble(request.getParameter("txtValor")));
                pro.setQtd_estoque(Integer.parseInt(request.getParameter("txtEstoque")));

                //INCLUIR NO BANCO DE DADOS
                this.dao.incluir(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_PRODUTO);

            } else if (acao.equalsIgnoreCase("editar")) {

                //PARAMETRO QUE OBTEM O ID PARA EDITAR
                pro.setId_produto(request.getParameter("txtDocumento"));
                pro.setNome_produto(request.getParameter("txtNomeProduto"));
                pro.setDescricao_produto(request.getParameter("txtDescricaoProduto"));
                pro.setValidade(Date.valueOf(request.getParameter("txtData")));
                pro.getCategoria().setId_categoria(Integer.parseInt(request.getParameter("txtCategoria")));
                pro.setValor_produto(Double.parseDouble(request.getParameter("txtValor")));
                pro.setQtd_estoque(Integer.parseInt(request.getParameter("txtEstoque")));

                //EDITANDO NO BANCO DE DADOS
                this.dao.editar(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_PRODUTO);

            } else if (acao.equalsIgnoreCase("excluir")) {

                //PARAMETRO QUE OBTÉM O ID PARA EXCLUSÃO
                pro.setId_produto(request.getParameter("txtDocumento"));

                //EXCLUIDO DO BANCO DE DADOS
                this.dao.excluir(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_PRODUTO);

            } else if (acao.equalsIgnoreCase("buscar")) {

                //PARAMETRO QUE OBTÉM O ID PARA BUSCAR REGISTRO
                pro.setId_produto(request.getParameter("txtDocumento"));

                //BUSCA PARA EDITAR
                pro = dao.buscar(pro);
                request.setAttribute("produto", pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, EDITAR_PRODUTO);

            } else if (acao.equalsIgnoreCase("listar")) {

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_PRODUTO);
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
