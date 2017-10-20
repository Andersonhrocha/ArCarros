package controller;

import dao.DaoServico;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelServico;

/**
 *
 * @author Anderson
 */
@WebServlet(name = "ServletCategoria", urlPatterns = {"/ServletCategoria"})
public class ServletCategoria extends ServletAbstrato {

    //CONSTANTES DAS PÁGINAS .JSP
    private static final String ADICIONAR_CLIENTE = "adicionarCliente.jsp";
    private static final String EDITAR_CLIENTE = "editarCliente.jsp";
    private static final String LISTAR_CLIENTE = "listarCliente.jsp";
    private final DaoServico dao;

    //CONSTRUTOR PRINCIPAL
    public ServletCategoria() {
        dao = new DaoServico();
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //RECEBENDO OS VALORES DO FORMULÁRIO
            ModelServico pro = new ModelServico();
            pro.setNome(request.getParameter("txtNome"));
            pro.setDescricao(request.getParameter("txtDescricao"));

            //RECEBE PARAMETRO VIA GET DO NAVEGADOR
            String acao = request.getParameter("acao");

            //INICIO DOS MÉTODOS DO BANCO DE DADOS
            if (acao.equalsIgnoreCase("inserir")) {

                //INCLUIR NO BANCO DE DADOS
                dao.incluir(pro);
                
               //REDIRECIONAMENTO
                redirecionarPagina(request, response, ADICIONAR_CLIENTE);

            } else if (acao.equalsIgnoreCase("editar")) {
                
                 //PARAMETRO QUE OBTEM O ID PARA EDITAR
                pro.setId_servico(Integer.parseInt(request.getParameter("txtDocumento")));

                //EDITANDO NO BANCO DE DADOS
                dao.editar(pro);
               
                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_CLIENTE);

                
            } else if (acao.equalsIgnoreCase("excluir")) {

                //PARAMETRO QUE OBTEM O ID PARA EXCLUSÃO
                pro.setId_servico(Integer.parseInt(request.getParameter("txtDocumento")));

                //EXCLUIDO DO BANCO DE DADOS
                dao.excluir(pro);
                
                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_CLIENTE);

            } else if (acao.equalsIgnoreCase("buscar")) {

                //PARAMETRO QUE OBTEM O ID PARA EXCLUSÃO
                pro.setId_servico(Integer.parseInt(request.getParameter("txtDocumento")));

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
