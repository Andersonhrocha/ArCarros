package controller;

import dao.DaoModelo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelModelo;

/**
 *
 * @author Anderson
 */
@WebServlet(name = "ServletModelo", urlPatterns = {"/ServletModelo"})
public class ServletModelo extends ServletAbstrato {

    //CONSTANTES DAS PÁGINAS .JSP
    private static final String EDITAR_MODELO = "editarModelo.jsp";
    private static final String LISTAR_MODELO = "listarModelo.jsp";
    private final DaoModelo dao;

    public ServletModelo() {
        dao = new DaoModelo();
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //CRIANDO OBJETO DA CLASSE ModelModelo
            ModelModelo pro = new ModelModelo();

            //RECEBE PARAMETRO VIA POST DO FORMULÁRIO UTILIZANDO CAMPO hidden
            String acao = request.getParameter("acao");

            //INICIO DOS MÉTODOS DO BANCO DE DADOS
            if (acao.equalsIgnoreCase("inserir")) {

                //RECEBENDO OS VALORES DO FORMULÁRIO
                pro.setNome_modelo(request.getParameter("txtNome"));
                pro.getMarca().setId_marca(Integer.parseInt(request.getParameter("txtFabricante")));
                pro.setMotorizacao(request.getParameter("txtMotorizacao"));

                //INCLUIR NO BANCO DE DADOS
                this.dao.incluir(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_MODELO);

            } else if (acao.equalsIgnoreCase("editar")) {

                //PARAMETRO QUE OBTÉM O ID PARA EDITAR
                pro.setId_modelo(Integer.parseInt(request.getParameter("txtDocumento")));
                pro.setNome_modelo(request.getParameter("txtNome"));
                pro.getMarca().setId_marca(Integer.parseInt(request.getParameter("txtFabricante")));
                pro.setMotorizacao(request.getParameter("txtMotorizacao"));

                //EDITANDO NO BANCO DE DADOS
                this.dao.editar(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_MODELO);

            } else if (acao.equalsIgnoreCase("excluir")) {

                //PARAMETRO QUE OBTÉM O ID PARA EXCLUSÃO
                pro.setId_modelo(Integer.parseInt(request.getParameter("txtDocumento")));

                //EXCLUIDO DO BANCO DE DADOS
                this.dao.excluir(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_MODELO);

            } else if (acao.equalsIgnoreCase("buscar")) {

                //PARAMETRO QUE OBTÉM O ID PARA BUSCAR REGISTRO
                pro.setId_modelo(Integer.parseInt(request.getParameter("txtDocumento")));

                //BUSCA PARA EDITAR
                pro = dao.buscar(pro);
                request.setAttribute("modelo", pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, EDITAR_MODELO);

            } else if (acao.equalsIgnoreCase("listar")) {

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_MODELO);
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
