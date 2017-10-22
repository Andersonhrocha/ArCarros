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
@WebServlet(name = "ServletServico", urlPatterns = {"/ServletServico"})
public class ServletServico extends ServletAbstrato {

    //CONSTANTES DAS PÁGINAS .JSP
    private static final String ADICIONAR_SERVICO = "adicionarServico.jsp";
    private static final String EDITAR_SERVICO = "editarServico.jsp";
    private static final String LISTAR_SERVICO = "listarServico.jsp";
    private final DaoServico dao;

    //CONSTRUTOR PRINCIPAL
    public ServletServico() {
        dao = new DaoServico();
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //RECEBENDO OS VALORES DO FORMULÁRIO
            ModelServico pro = new ModelServico();
            pro.setNome_servico(request.getParameter("txtNome"));
            pro.setDescricao(request.getParameter("txtDescricao"));

            //RECEBE PARAMETRO VIA GET DO NAVEGADOR
            String acao = request.getParameter("acao");

            //INICIO DOS MÉTODOS DO BANCO DE DADOS
            if (acao.equalsIgnoreCase("inserir")) {

                //PARAMETRO QUE OBTEM VALOR DO FORMULÁRIO PARA ADICIONAR NO BANCO DE DADOS
                pro.setValor(Double.parseDouble(request.getParameter("txtValor")));
                
                //INCLUIR NO BANCO DE DADOS
                dao.incluir(pro);

                //REDIRECIONAMENTO
                redirecionarPagina(request, response, ADICIONAR_SERVICO);

            } else if (acao.equalsIgnoreCase("editar")) {

                //PARAMETRO QUE OBTEM O ID PARA ALTERAÇÃO
                pro.setId_servico(Integer.parseInt(request.getParameter("txtDocumento")));
                pro.setValor(Double.parseDouble(request.getParameter("txtValor")));

                //EDITANDO NO BANCO DE DADOS
                dao.editar(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_SERVICO);

            } else if (acao.equalsIgnoreCase("excluir")) {

                //PARAMETRO QUE OBTEM O ID PARA EXCLUSÃO
                pro.setId_servico(Integer.parseInt(request.getParameter("txtDocumento")));

                //EXCLUIDO DO BANCO DE DADOS
                dao.excluir(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_SERVICO);

            } else if (acao.equalsIgnoreCase("buscar")) {

                //PARAMETRO QUE OBTEM O ID PARA EXCLUSÃO
                pro.setId_servico(Integer.parseInt(request.getParameter("txtDocumento")));

                //BUSCA PARA EDITAR
                pro = dao.buscar(pro);
                request.setAttribute("cliente", pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, this.EDITAR_SERVICO);

            } else if (acao.equalsIgnoreCase("listar")) {

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, this.LISTAR_SERVICO);
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
