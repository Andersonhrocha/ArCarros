package controller;

import dao.DaoVendaProduto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelVendaProduto;

/**
 *
 * @author Anderson
 */
@WebServlet(name = "ServletVendaProduto", urlPatterns = {"/ServletVendaProduto"})
public class ServletVendaProduto extends ServletAbstrato {

    //CONSTANTES DAS PÁGINAS .JSP
    private static final String ADICIONAR_PRODUTO = "adicionarVendaProduto.jsp";
    private static final String EDITAR_PRODUTO = "editarVendaProduto.jsp";
    private static final String LISTAR_PRODUTO = "listarVendaProduto.jsp";
    private final DaoVendaProduto dao;

    //CONSTRUTOR PRINCIPAL
    public ServletVendaProduto() {
        dao = new DaoVendaProduto();
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //CRIANDO OBJETO DA CLASSE ModelVendaProduto
            ModelVendaProduto pro = new ModelVendaProduto();

            //RECEBE PARAMETRO VIA POST DO FORMULÁRIO UTILIZANDO CAMPO hidden
            String acao = request.getParameter("acao");

            //INICIO DOS MÉTODOS DO BANCO DE DADOS
            if (acao.equalsIgnoreCase("inserir")) {

                //RECEBENDO OS VALORES DO FORMULÁRIO
                pro.getRelacao_id_venda().setId_venda(Integer.parseInt(request.getParameter("txtVenda")));
                pro.getRelacao_id_produto().setId_produto(request.getParameter("txtProduto"));
                pro.setQuantidade(Integer.parseInt(request.getParameter("txtQuantidade")));
                pro.setTipoPagamento(request.getParameter("txtPagamento"));

                //INCLUIR NO BANCO DE DADOS
                dao.incluir(pro);

                //ATRIBUTO COM MENSAGEM DE RETORNO
                request.setAttribute("mensagem", "Registro efetuado com sucesso.");

                //REDIRECIONAMENTO
                redirecionarPagina(request, response, ADICIONAR_PRODUTO);

            } else if (acao.equalsIgnoreCase("editar")) {

                //PARAMETRO QUE OBTEM O ID PARA EDITAR
                pro.setId_venda_produto(Integer.parseInt(request.getParameter("txtCodigo")));
                pro.getRelacao_id_produto().setId_produto(request.getParameter("txtProduto"));
                pro.setQuantidade(Integer.parseInt(request.getParameter("txtQuantidade")));
                pro.setTipoPagamento(request.getParameter("txtPagamento"));

                //EDITANDO NO BANCO DE DADOS
                dao.editar(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_PRODUTO);

            } else if (acao.equalsIgnoreCase("excluir")) {

                //PARAMETRO QUE OBTÉM O ID PARA EXCLUSÃO
                pro.setId_venda_produto(Integer.parseInt(request.getParameter("txtCodigo")));

                //EXCLUIDO DO BANCO DE DADOS
                dao.excluir(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_PRODUTO);

            } else if (acao.equalsIgnoreCase("buscar")) {

                //PARAMETRO QUE OBTÉM O ID PARA BUSCAR REGISTRO
                pro.setId_venda_produto(Integer.parseInt(request.getParameter("txtCodigo")));

                //BUSCA PARA EDITAR
                pro = dao.buscar(pro);
                request.setAttribute("cliente", pro);

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
