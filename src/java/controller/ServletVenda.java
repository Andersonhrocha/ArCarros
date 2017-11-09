package controller;

import dao.DaoVenda;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelVenda;

/**
 *
 * @author Anderson
 */
@WebServlet(name = "ServletVenda", urlPatterns = {"/ServletVenda"})
public class ServletVenda extends ServletAbstrato {

    //CONSTANTES DAS PÁGINAS .JSP
    private static final String ADICIONAR_PRODUTO = "adicionarVenda.jsp";
    private static final String EDITAR_PRODUTO = "editarVenda.jsp";
    private static final String LISTAR_PRODUTO = "listarVenda.jsp";
    private final DaoVenda dao;

    //CONSTRUTOR PRINCIPAL
    public ServletVenda() {
        dao = new DaoVenda();
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //CRIANDO OBJETO DA CLASSE ModelVenda
            ModelVenda pro = new ModelVenda();

            //RECEBE PARAMETRO VIA POST DO FORMULÁRIO UTILIZANDO CAMPO hidden
            String acao = request.getParameter("acao");

            //INICIO DOS MÉTODOS DO BANCO DE DADOS
            if (acao.equalsIgnoreCase("inserir")) {

                //PARAMETRO QUE OBTÉM DADOS DO FORMULÁRIO PARA ADICIONAR NO BANCO DE DADOS
                pro.getRelacao_id_cliente().setCpf_cliente(request.getParameter("txtVenda"));
                pro.setData(Date.valueOf(request.getParameter("txtData")));

                //INCLUIR NO BANCO DE DADOS
                dao.incluir(pro);

                //ATRIBUTO COM MENSAGEM DE RETORNO
                request.setAttribute("mensagem", "Registro efetuado com sucesso.");

                //REDIRECIONAMENTO
                redirecionarPagina(request, response, ADICIONAR_PRODUTO);

            } else if (acao.equalsIgnoreCase("editar")) {

                //PARAMETRO QUE OBTEM O ID PARA EDITAR
                pro.setId_venda(Integer.parseInt(request.getParameter("txtVenda")));
                pro.setData(Date.valueOf(request.getParameter("txtData")));

                //EDITANDO NO BANCO DE DADOS
                dao.editar(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_PRODUTO);

            } else if (acao.equalsIgnoreCase("excluir")) {

                //PARAMETRO QUE OBTÉM O ID PARA EXCLUSÃO
                pro.setId_venda(Integer.parseInt(request.getParameter("txtDocumento")));

                //EXCLUIDO DO BANCO DE DADOS
                dao.excluir(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_PRODUTO);

            } else if (acao.equalsIgnoreCase("buscar")) {

                //PARAMETRO QUE OBTÉM O ID PARA BUSCAR REGISTRO
                pro.setId_venda(Integer.parseInt(request.getParameter("txtDocumento")));

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
