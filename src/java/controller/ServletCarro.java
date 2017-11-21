package controller;

import dao.DaoCarro;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelCarro;

/**
 *
 * @author Anderson
 */
@WebServlet(name = "ServletCarro", urlPatterns = {"/ServletCarro"})
public class ServletCarro extends ServletAbstrato {

    //CONSTANTES DAS PÁGINAS .JSP
    private static final String EDITAR_CARRO = "editarCarro.jsp";
    private static final String LISTAR_CARRO = "listarCarro.jsp";
    private final DaoCarro dao;

    public ServletCarro() {
        dao = new DaoCarro();
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //CRIANDO OBJETO DA CLASSE ModelCarro
            ModelCarro pro = new ModelCarro();

            //RECEBE PARAMETRO VIA POST DO FORMULÁRIO UTILIZANDO CAMPO hidden
            String acao = request.getParameter("acao");

            //INICIO DOS MÉTODOS DO BANCO DE DADOS
            if (acao.equalsIgnoreCase("inserir")) {

                //RECEBENDO OS VALORES DO FORMULÁRIO
                pro.setId_carro(request.getParameter("txtDocumento"));
                pro.setAno(request.getParameter("txtAno"));
                pro.setCor(request.getParameter("txtCor"));
                pro.getCliente().setCpf_cliente(request.getParameter("txtCliente"));
                pro.getModelo().setId_modelo(Integer.parseInt(request.getParameter("txtModelo")));

                //INCLUIR NO BANCO DE DADOS
                this.dao.incluir(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_CARRO);

            } else if (acao.equalsIgnoreCase("editar")) {

                //PARAMETRO QUE OBTÉM O ID PARA EDITAR
                pro.setId_carro(request.getParameter("txtDocumento"));
                pro.setAno(request.getParameter("txtAno"));
                pro.setCor(request.getParameter("txtCor"));
                pro.getCliente().setCpf_cliente(request.getParameter("txtCliente"));
                pro.getModelo().setId_modelo(Integer.parseInt(request.getParameter("txtModelo")));

                //EDITANDO NO BANCO DE DADOS
                this.dao.editar(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_CARRO);

            } else if (acao.equalsIgnoreCase("excluir")) {

                //PARAMETRO QUE OBTÉM O ID PARA EXCLUSÃO
                pro.setId_carro(request.getParameter("txtDocumento"));

                //EXCLUIDO DO BANCO DE DADOS
                this.dao.excluir(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_CARRO);

            } else if (acao.equalsIgnoreCase("buscar")) {

                //PARAMETRO QUE OBTÉM O ID PARA BUSCAR REGISTRO
                pro.setId_carro(request.getParameter("txtDocumento"));

                //BUSCA PARA EDITAR
                pro = dao.buscar(pro);
                request.setAttribute("carro", pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, EDITAR_CARRO);

            } else if (acao.equalsIgnoreCase("listar")) {

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_CARRO);
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
