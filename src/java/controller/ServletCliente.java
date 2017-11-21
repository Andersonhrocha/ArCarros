package controller;

import dao.DaoCliente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelCliente;

/**
 *
 * @author Anderson
 */
@WebServlet(name = "ServletCliente", urlPatterns = {"/ServletCliente"})
public class ServletCliente extends ServletAbstrato {

    //CONSTANTES DAS PÁGINAS .JSP
    private static final String EDITAR_CLIENTE = "editarCliente.jsp";
    private static final String LISTAR_CLIENTE = "listarCliente.jsp";
    private final DaoCliente dao;

    public ServletCliente() {
        dao = new DaoCliente();
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //CRIANDO OBJETO DA CLASSE ModelCategoria
            ModelCliente pro = new ModelCliente();

           //RECEBE PARAMETRO VIA POST DO FORMULÁRIO UTILIZANDO CAMPO hidden
            String acao = request.getParameter("acao");

            //INICIO DOS MÉTODOS DO BANCO DE DADOS
            if (acao.equalsIgnoreCase("inserir")) {

                //RECEBENDO OS VALORES DO FORMULÁRIO
                pro.setCpf_cliente(request.getParameter("txtDocumento"));
                pro.setNome_cliente(request.getParameter("txtNome"));
                pro.setEndereco(request.getParameter("txtEndereco"));
                pro.setTelefone(request.getParameter("txtTelefone"));
                pro.setEmail(request.getParameter("txtEmail"));

                //INCLUIR NO BANCO DE DADOS
                this.dao.incluir(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_CLIENTE);

            } else if (acao.equalsIgnoreCase("editar")) {

                //RECEBENDO OS VALORES DO FORMULÁRIO
                pro.setCpf_cliente(request.getParameter("txtDocumento"));
                pro.setNome_cliente(request.getParameter("txtNome"));
                pro.setEndereco(request.getParameter("txtEndereco"));
                pro.setTelefone(request.getParameter("txtTelefone"));
                pro.setEmail(request.getParameter("txtEmail"));

                //EDITANDO NO BANCO DE DADOS
                this.dao.editar(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_CLIENTE);

            } else if (acao.equalsIgnoreCase("excluir")) {

                //PARAMETRO QUE OBTÉM O ID PARA EXCLUSÃO
                pro.setCpf_cliente(request.getParameter("txtDocumento"));

                //EXCLUIDO DO BANCO DE DADOS
                this.dao.excluir(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_CLIENTE);

            } else if (acao.equalsIgnoreCase("buscar")) {

                //PARAMETRO QUE OBTÉM O ID PARA BUSCAR REGISTRO
                pro.setCpf_cliente(request.getParameter("txtDocumento"));

                //BUSCA PARA EDITAR
                pro = dao.buscar(pro);
                request.setAttribute("cliente", pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, EDITAR_CLIENTE);

            } else if (acao.equalsIgnoreCase("listar")) {

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_CLIENTE);
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
