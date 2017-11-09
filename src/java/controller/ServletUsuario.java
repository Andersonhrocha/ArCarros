package controller;

import dao.DaoUsuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelUsuario;

/**
 *
 * @author Anderson
 */
@WebServlet(name = "ServletUsuario", urlPatterns = {"/ServletUsuario"})
public class ServletUsuario extends ServletAbstrato {

    //CONSTANTES DAS PÁGINAS .JSP
    private static final String ADICIONAR_USUARIO = "adicionarUsuario.jsp";
    private static final String EDITAR_USUARIO = "editarUsuario.jsp";
    private static final String LISTAR_USUARIO = "listarUsuario.jsp";
    private final DaoUsuario dao;

    //CONSTRUTOR PRINCIPAL
    public ServletUsuario() {
        dao = new DaoUsuario();
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //CRIANDO OBJETO DA CLASSE ModelUsuario
            ModelUsuario pro = new ModelUsuario();

            //RECEBE PARAMETRO VIA POST DO FORMULÁRIO UTILIZANDO CAMPO hidden
            String acao = request.getParameter("acao");

            //INICIO DOS MÉTODOS DO BANCO DE DADOS
            if (acao.equalsIgnoreCase("inserir")) {

                //RECEBENDO OS VALORES DO FORMULÁRIO
                pro.setNome(request.getParameter("txtNome"));
                pro.setLogin(request.getParameter("txtLogin"));
                pro.setSenha(request.getParameter("txtSenha"));

                //INCLUIR NO BANCO DE DADOS
                dao.incluir(pro);

                //ATRIBUTO COM MENSAGEM DE RETORNO
                request.setAttribute("mensagem", "Registro efetuado com sucesso.");

                //REDIRECIONAMENTO
                redirecionarPagina(request, response, ADICIONAR_USUARIO);

            } else if (acao.equalsIgnoreCase("editar")) {

                //PARAMETRO QUE OBTÉM O ID PARA ALTERAÇÃO
                pro.setId_usuario(Integer.parseInt(request.getParameter("txtDocumento")));
                pro.setNome(request.getParameter("txtNome"));
                pro.setLogin(request.getParameter("txtLogin"));
                pro.setSenha(request.getParameter("txtSenha"));

                //EDITANDO NO BANCO DE DADOS
                dao.editar(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_USUARIO);

            } else if (acao.equalsIgnoreCase("excluir")) {

                //PARAMETRO QUE OBTÉM O ID PARA EXCLUSÃO
                pro.setId_usuario(Integer.parseInt(request.getParameter("txtDocumento")));

                //EXCLUIDO DO BANCO DE DADOS
                dao.excluir(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_USUARIO);

            } else if (acao.equalsIgnoreCase("buscar")) {

                //PARAMETRO QUE OBTÉM O ID PARA BUSCAR REGISTRO
                pro.setId_usuario(Integer.parseInt(request.getParameter("txtDocumento")));

                //BUSCA PARA EDITAR
                pro = dao.buscar(pro);
                request.setAttribute("cliente", pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, EDITAR_USUARIO);

            } else if (acao.equalsIgnoreCase("listar")) {

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_USUARIO);
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
