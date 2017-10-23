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
    private static final String ADICIONAR_CLIENTE = "adicionarCliente.jsp";
    private static final String EDITAR_CLIENTE = "editarCliente.jsp";
    private static final String LISTAR_CLIENTE = "listarCliente.jsp";
    private final DaoCliente dao;

    //CONSTRUTOR PRINCIPAL
    public ServletCliente() {
        dao = new DaoCliente();
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //RECEBENDO OS VALORES DO FORMULÁRIO
            ModelCliente pro = new ModelCliente();
            pro.setCpf_cliente(request.getParameter("txtDocumento"));
            pro.setNome_cliente(request.getParameter("txtNome"));
            pro.setEndereco(request.getParameter("txtEndereco"));
            pro.setTelefone(request.getParameter("txtTelefone"));
            pro.setEmail(request.getParameter("txtEmail"));

            //RECEBE PARAMETRO VIA POST DO NAVEGADOR
            String acao = request.getParameter("acao");

            //INICIO DOS MÉTODOS DO BANCO DE DADOS
            if (acao.equalsIgnoreCase("inserir")) {

                //INCLUIR NO BANCO DE DADOS
                dao.incluir(pro);
                
               //REDIRECIONAMENTO
                redirecionarPagina(request, response, ADICIONAR_CLIENTE);

            } else if (acao.equalsIgnoreCase("editar")) {

                //EDITANDO NO BANCO DE DADOS
                dao.editar(pro);
               
                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_CLIENTE);

                
            } else if (acao.equalsIgnoreCase("excluir")) {

                //PARAMETRO QUE OBTEM O ID PARA EXCLUSÃO
                pro.setCpf_cliente(request.getParameter("txtDocumento"));

                //EXCLUIDO DO BANCO DE DADOS
                dao.excluir(pro);
                
                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_CLIENTE);

            } else if (acao.equalsIgnoreCase("buscar")) {

                //PARAMETRO QUE OBTEM O ID PARA EXCLUSÃO
                pro.setCpf_cliente(request.getParameter("txtDocumento"));

                //BUSCA PARA EDITAR
                pro = dao.buscar(pro);
                request.setAttribute("cliente", pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, this.EDITAR_CLIENTE);

            } else if (acao.equalsIgnoreCase("listar")) {

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, this.LISTAR_CLIENTE);
            }

        } catch (IOException | ServletException ex) {
            System.out.println("Erro na interação: " + ex.getMessage());
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executar(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executar(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
