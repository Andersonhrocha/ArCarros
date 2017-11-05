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
    private static final String ADICIONAR_PRODUTO = "adicionarProduto.jsp";
    private static final String EDITAR_PRODUTO = "editarProduto.jsp";
    private static final String LISTAR_PRODUTO = "listarProduto.jsp";
    private final DaoProduto dao;

    //CONSTRUTOR PRINCIPAL
    public ServletProduto() {
        dao = new DaoProduto();
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //RECEBENDO OS VALORES DO FORMULÁRIO
            ModelProduto pro = new ModelProduto();
            pro.setId_produto(request.getParameter("txtDocumento"));
            pro.setNome_produto(request.getParameter("txtNomeProduto"));
            pro.setDescricao_produto(request.getParameter("txtDescricaoProduto"));

            //RECEBE PARAMETRO VIA POST DO NAVEGADOR
            String acao = request.getParameter("acao");

            //INICIO DOS MÉTODOS DO BANCO DE DADOS
            if (acao.equalsIgnoreCase("inserir")) {

                //PARAMETRO QUE OBTÉM DADOS DO FORMULÁRIO PARA ADICIONAR NO BANCO DE DADOS
                pro.setValidade(Date.valueOf(request.getParameter("txtData")));
                pro.getRelacao_id_categoria().setId_categoria(Integer.parseInt(request.getParameter("txtCategoria")));
                pro.setValor_produto(Double.parseDouble(request.getParameter("txtValor")));
                pro.setQtd_estoque(Integer.parseInt(request.getParameter("txtEstoque")));

                //INCLUIR NO BANCO DE DADOS
                dao.incluir(pro);

                //ATRIBUTO COM MENSAGEM DE RETORNO
                request.setAttribute("mensagem", "Registro efetuado com sucesso.");

                //REDIRECIONAMENTO
                redirecionarPagina(request, response, ADICIONAR_PRODUTO);

            } else if (acao.equalsIgnoreCase("editar")) {

                //PARAMETRO QUE OBTEM O ID PARA EDITAR
                pro.setId_produto(request.getParameter("txtDocumento"));
                pro.setValidade(Date.valueOf(request.getParameter("txtData")));
                pro.getRelacao_id_categoria().setId_categoria(Integer.parseInt(request.getParameter("txtCategoria")));
                pro.setValor_produto(Double.parseDouble(request.getParameter("txtValor")));
                pro.setQtd_estoque(Integer.parseInt(request.getParameter("txtEstoque")));

                //EDITANDO NO BANCO DE DADOS
                dao.editar(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_PRODUTO);

            } else if (acao.equalsIgnoreCase("excluir")) {

                //PARAMETRO QUE OBTÉM O ID PARA EXCLUSÃO
                pro.setId_produto(request.getParameter("txtDocumento"));

                //EXCLUIDO DO BANCO DE DADOS
                dao.excluir(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_PRODUTO);

            } else if (acao.equalsIgnoreCase("buscar")) {

                //PARAMETRO QUE OBTÉM O ID PARA BUSCAR REGISTRO
                pro.setId_produto(request.getParameter("txtDocumento"));

                //BUSCA PARA EDITAR
                pro = dao.buscar(pro);
                request.setAttribute("cliente", pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, this.EDITAR_PRODUTO);

            } else if (acao.equalsIgnoreCase("listar")) {

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, this.LISTAR_PRODUTO);
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
