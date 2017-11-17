package controller;

import dao.DaoMarca;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelMarca;

/**
 *
 * @author Anderson
 */
@WebServlet(name = "ServletMarca", urlPatterns = {"/ServletMarca"})
public class ServletMarca extends ServletAbstrato {

    //CONSTANTES DAS PÁGINAS .JSP
    private static final String ADICIONAR_MARCA = "adicionarMarca.jsp";
    private static final String EDITAR_MARCA = "editarMarca.jsp";
    private static final String LISTAR_MARCA = "listarMarca.jsp";
    private final DaoMarca dao;

    //CONSTRUTOR PRINCIPAL
    public ServletMarca() {
        dao = new DaoMarca();
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //CRIANDO OBJETO DA CLASSE ModelMarca
            ModelMarca pro = new ModelMarca();

            //RECEBE PARAMETRO VIA POST DO FORMULÁRIO UTILIZANDO CAMPO hidden
            String acao = request.getParameter("acao");

            //INICIO DOS MÉTODOS DO BANCO DE DADOS
            if (acao.equalsIgnoreCase("inserir")) {

                //RECEBENDO OS VALORES DO FORMULÁRIO
                pro.setNome_marca(request.getParameter("txtNome"));

                //INCLUIR NO BANCO DE DADOS
                dao.incluir(pro);

                //ATRIBUTO COM MENSAGEM DE RETORNO
                request.setAttribute("mensagem", "Registro efetuado com sucesso.");

                //REDIRECIONAMENTO
                redirecionarPagina(request, response, ADICIONAR_MARCA);

            } else if (acao.equalsIgnoreCase("editar")) {

                //PARAMETRO QUE OBTÉM O ID PARA ALTERAÇÃO
                pro.setId_marca(Integer.parseInt(request.getParameter("txtDocumento")));
                pro.setNome_marca(request.getParameter("txtNome"));

                //EDITANDO NO BANCO DE DADOS
                dao.editar(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_MARCA);

            } else if (acao.equalsIgnoreCase("excluir")) {

                //PARAMETRO QUE OBTÉM O ID PARA EXCLUSÃO
                pro.setId_marca(Integer.parseInt(request.getParameter("txtDocumento")));

                //EXCLUIDO DO BANCO DE DADOS
                dao.excluir(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_MARCA);

            } else if (acao.equalsIgnoreCase("buscar")) {

                //PARAMETRO QUE OBTÉM O ID PARA BUSCAR REGISTRO
                pro.setId_marca(Integer.parseInt(request.getParameter("txtDocumento")));

                //BUSCA PARA EDITAR
                pro = dao.buscar(pro);
                request.setAttribute("fabricante", pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, EDITAR_MARCA);

            } else if (acao.equalsIgnoreCase("listar")) {

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_MARCA);
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
