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
@WebServlet(name = "ServletlModelo", urlPatterns = {"/ServletlModelo"})
public class ServletlModelo extends ServletAbstrato {

    //CONSTANTES DAS PÁGINAS .JSP
    private static final String ADICIONAR_MODELO = "adicionarModelo.jsp";
    private static final String EDITAR_MODELO = "editarModelo.jsp";
    private static final String LISTAR_MODELO = "listarModelo.jsp";
    private final DaoModelo dao;

    //CONSTRUTOR PRINCIPAL
    public ServletlModelo() {
        dao = new DaoModelo();
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //RECEBENDO OS VALORES DO FORMULÁRIO
            ModelModelo pro = new ModelModelo();
            pro.setNome(request.getParameter("txtNome"));
            //   pro.getRelacao_id_marca().setId_marca(Integer.parseInt("txtFabricante"));
            pro.setMotorizacao(request.getParameter("txtMotorizacao"));

            //RECEBE PARAMETRO VIA GET DO NAVEGADOR
            String acao = request.getParameter("acao");

            //INICIO DOS MÉTODOS DO BANCO DE DADOS
            if (acao.equalsIgnoreCase("inserir")) {

                //INCLUIR NO BANCO DE DADOS
                dao.incluir(pro);

                //REDIRECIONAMENTO
                redirecionarPagina(request, response, ADICIONAR_MODELO);

            } else if (acao.equalsIgnoreCase("editar")) {

                //PARAMETRO QUE OBTEM O ID PARA EDITAR
                pro.setId_modelo(Integer.parseInt(request.getParameter("txtDocumento")));

                //EDITANDO NO BANCO DE DADOS
                dao.editar(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_MODELO);

            } else if (acao.equalsIgnoreCase("excluir")) {

                //PARAMETRO QUE OBTEM O ID PARA EXCLUSÃO
                pro.setId_modelo(Integer.parseInt(request.getParameter("txtDocumento")));

                //EXCLUIDO DO BANCO DE DADOS
                dao.excluir(pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, LISTAR_MODELO);

            } else if (acao.equalsIgnoreCase("buscar")) {

                //PARAMETRO QUE OBTEM O ID PARA EXCLUSÃO
                pro.setId_modelo(Integer.parseInt(request.getParameter("txtDocumento")));

                //BUSCA PARA EDITAR
                pro = dao.buscar(pro);
                request.setAttribute("cliente", pro);

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, this.EDITAR_MODELO);

            } else if (acao.equalsIgnoreCase("listar")) {

                //REDIRECIONAMENTO
                this.redirecionarPagina(request, response, this.LISTAR_MODELO);
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
