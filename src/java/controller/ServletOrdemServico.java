package controller;

import dao.DaoOrdemServico;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelOrdemServico;

/**
 *
 * @author Anderson
 */
@WebServlet(name = "ServletOrdemServico", urlPatterns = {"/ServletOrdemServico"})
public class ServletOrdemServico extends ServletAbstrato {

    //CONSTANTES DAS PÁGINAS .JSP
    private static final String ADICIONAR_ORDEM_SERVICO = "adicionarOrdemServico.jsp";
    private static final String EDITAR_ORDEM_SERVICO = "editarOrdemServico.jsp";
    private static final String LISTAR_ORDEM_SERVICO = "listarOrdemServico.jsp";
    private final DaoOrdemServico dao;

    //CONSTRUTOR PRINCIPAL
    public ServletOrdemServico() {
        dao = new DaoOrdemServico();
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //CRIANDO OBJETO DA CLASSE MODELORDEMSERVICO
            ModelOrdemServico pro = new ModelOrdemServico();

            //RECEBE PARAMETRO VIA POST DO NAVEGADOR
            String acao = request.getParameter("acao");

            //INICIO DOS MÉTODOS DO BANCO DE DADOS
            if (acao.equalsIgnoreCase("inserir")) {

                //ARMAZENANDO PARAMETRO PREDEFINIDO NO BANCO DE DADOS
                pro.getRelacao_id_carro().setId_carro(request.getParameter("txtCarro"));
                pro.setData(new Date(System.currentTimeMillis()));
                pro.setSituacao(request.getParameter("txtSituacao"));
                pro.setValor(new Double("0.00"));
                pro.setDesconto(new Double("0.00"));

                //INCLUIR NO BANCO DE DADOS
                dao.incluir(pro);

                //ATRIBUTO COM MENSAGEM DE RETORNO
                request.setAttribute("mensagem", "Registro efetuado com sucesso.");

                //REDIRECIONAMENTO
                redirecionarPagina(request, response, ADICIONAR_ORDEM_SERVICO);

            } else if (acao.equalsIgnoreCase("editar")) {

                //PARAMETRO QUE OBTEM O ID PARA EDITAR
                pro.setId_ordem_Servico(Integer.parseInt(request.getParameter("txtDocumento")));
                pro.getRelacao_id_carro().setId_carro(request.getParameter("txtCarro"));
                pro.setSituacao(request.getParameter("txtSituacao"));
                pro.setValor(Double.parseDouble(request.getParameter("txtValor")));
                pro.setDesconto(Double.parseDouble(request.getParameter("txtDesconto")));

                //EDITANDO NO BANCO DE DADOS
                dao.editar(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_ORDEM_SERVICO);

            } else if (acao.equalsIgnoreCase("excluir")) {

                //PARAMETRO QUE OBTÉM O ID PARA EXCLUSÃO
                pro.setId_ordem_Servico(Integer.parseInt(request.getParameter("txtDocumento")));

                //EXCLUIDO DO BANCO DE DADOS
                dao.excluir(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_ORDEM_SERVICO);

            } else if (acao.equalsIgnoreCase("buscar")) {

                //PARAMETRO QUE OBTÉM O ID PARA BUSCAR REGISTRO
                pro.setId_ordem_Servico(Integer.parseInt(request.getParameter("txtDocumento")));

                //BUSCA PARA EDITAR
                pro = dao.buscar(pro);
                request.setAttribute("cliente", pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, this.EDITAR_ORDEM_SERVICO);

            } else if (acao.equalsIgnoreCase("listar")) {

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, this.LISTAR_ORDEM_SERVICO);
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