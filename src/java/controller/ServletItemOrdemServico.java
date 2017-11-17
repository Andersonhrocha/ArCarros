package controller;

import dao.DaoItemOrdemServico;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelItemOrdemServico;

/**
 *
 * @author Anderson
 */
@WebServlet(name = "ServletItemOrdemServico", urlPatterns = {"/ServletItemOrdemServico"})
public class ServletItemOrdemServico extends ServletAbstrato {

    //CONSTANTES DAS PÁGINAS .JSP
    private static final String ADICIONAR_ITEM_ORDEM_SERVICO = "adicionarItemOrdemServico.jsp";
    private static final String EDITAR_ITEM_ORDEM_SERVICO = "editarOrdemServico.jsp";
    private static final String LISTAR_ITEM_ORDEM_SERVICO = "listarItemOrdemServico.jsp";
    private final DaoItemOrdemServico dao;

    //CONSTRUTOR PRINCIPAL
    public ServletItemOrdemServico() {
        dao = new DaoItemOrdemServico();
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

             //CRIANDO OBJETO DA CLASSE ModelItemOrdemServico
            ModelItemOrdemServico pro = new ModelItemOrdemServico();

            //RECEBE PARAMETRO VIA POST DO FORMULÁRIO UTILIZANDO CAMPO hidden
            String acao = request.getParameter("acao");

            //INICIO DOS MÉTODOS DO BANCO DE DADOS
            if (acao.equalsIgnoreCase("inserir")) {

                //RECEBENDO OS VALORES DO FORMULÁRIO
                pro.getOrdem_servico().setId_ordem_Servico(Integer.parseInt(request.getParameter("txtOrdemServico")));
                pro.getProduto().setId_produto(request.getParameter("txtProduto"));
                pro.getServico().setId_servico(Integer.parseInt(request.getParameter("txtServico")));
                pro.setQtd_prod_utilizado(Integer.parseInt(request.getParameter("txtQtdPro")));

                //INCLUIR NO BANCO DE DADOS
                dao.incluir(pro);

                //ATRIBUTO COM MENSAGEM DE RETORNO
                request.setAttribute("mensagem", "Registro efetuado com sucesso.");

                //REDIRECIONAMENTO
                redirecionarPagina(request, response, ADICIONAR_ITEM_ORDEM_SERVICO);

            } else if (acao.equalsIgnoreCase("editar")) {

                //PARAMETRO QUE OBTEM O ID PARA EDITAR
                pro.getOrdem_servico().setId_ordem_Servico(Integer.parseInt(request.getParameter("txtOrdemServico")));
                pro.getProduto().setId_produto(request.getParameter("txtProduto"));
                pro.getServico().setId_servico(Integer.parseInt(request.getParameter("txtServico")));
                pro.setQtd_prod_utilizado(Integer.parseInt(request.getParameter("txtQtdPro")));

                //EDITANDO NO BANCO DE DADOS
                dao.editar(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_ITEM_ORDEM_SERVICO);

            } else if (acao.equalsIgnoreCase("excluir")) {

                //PARAMETRO QUE OBTÉM O ID PARA EXCLUSÃO
                 pro.setId_item_ordem_servico(Integer.parseInt(request.getParameter("txtItemOrdemServico")));

                //EXCLUIDO DO BANCO DE DADOS
                dao.excluir(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_ITEM_ORDEM_SERVICO);

            } else if (acao.equalsIgnoreCase("buscar")) {

                //PARAMETRO QUE OBTÉM O ID PARA BUSCAR REGISTRO
                pro.getOrdem_servico().setId_ordem_Servico(Integer.parseInt(request.getParameter("txtOrdemServico")));

                //BUSCA PARA EDITAR
                pro = dao.buscar(pro);
                request.setAttribute("itemordemservico", pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, ADICIONAR_ITEM_ORDEM_SERVICO);

            } else if (acao.equalsIgnoreCase("listar")) {

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_ITEM_ORDEM_SERVICO);
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
