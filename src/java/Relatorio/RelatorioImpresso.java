package Relatorio;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperRunManager;
import dao.ModuloConexao;
import java.sql.Connection;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Anderson
 */
@WebServlet(name = "RelatorioImpresso", urlPatterns = {"/RelatorioImpresso"})
public class RelatorioImpresso extends HttpServlet {

    //VARIÁVEIS
    public Connection conexao;
    byte[] bytes;

    //CRIANDO OBJETO DE CONEXÃO
    ModuloConexao conn = new ModuloConexao();

    protected void gerandoRelatorios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //RECEBE PARAMETRO VIA POST DO FORMULÁRIO UTILIZANDO CAMPO hidden
        String comando = request.getParameter("comando");

        if (comando.equalsIgnoreCase("imprimir_lista_produtos")) { //LISTA TODOS OS PRODUTOS PARA IMPRIMIR

            try {
                //ABRINDO CONEXÃO
                conexao = conn.abrirConexao();

                //VAVIÁVEL QUE RECEBE O CAMINHO DO ARQUIVO .JASPER
                File caminhoRelatorio = new File(getServletConfig().getServletContext().getRealPath("/WEB-INF/Relatorio/Produtos.jasper"));

                //GERENCIADOR DO JASPER PARA CRIA O RELATÓRIO EM PDF
                bytes = JasperRunManager.runReportToPdf(caminhoRelatorio.getPath(), null, conexao);

                //ESCREVENDO NA SAIDA DO RESPONSE
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ServletOutputStream ouputStream = response.getOutputStream();
                ouputStream.write(bytes, 0, bytes.length);

                //EVIANDO CONTEÚDO
                ouputStream.flush();

                System.out.println("Relatório de produtos gerado com Sucesso!");
            } catch (IOException | JRException ex) {
                System.out.println("Erro ao gerar relatório=>" + ex.getMessage());
            }
            
        } else if (comando.equalsIgnoreCase("imprimir_ordens_servico")) { //LISTA TODAS OS ORDENS DE SERVIÇO PARA IMPRIMIR

            try {
                //ABRINDO CONEXÃO
                conexao = conn.abrirConexao();

                //VAVIÁVEL QUE RECEBE O CAMINHO DO ARQUIVO .JASPER
                File caminhoRelatorio = new File(getServletConfig().getServletContext().getRealPath("/WEB-INF/Relatorio/OrdemServico.jasper"));

                //GERENCIADOR DO JASPER PARA CRIA O RELATÓRIO EM PDF
                bytes = JasperRunManager.runReportToPdf(caminhoRelatorio.getPath(), null, conexao);

                //ESCREVENDO NA SAIDA DO RESPONSE
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ServletOutputStream ouputStream = response.getOutputStream();
                ouputStream.write(bytes, 0, bytes.length);

                //EVIANDO CONTEÚDO
                ouputStream.flush();

                System.out.println("Relatório de ordem de serviço gerado com Sucesso!");
            } catch (IOException | JRException ex) {
                System.out.println("Erro ao gerar relatório=>" + ex.getMessage());
            }

        } else if (comando.equalsIgnoreCase("imprimir_item_ordens_servico")) { //IMPRIME ORDEM DE SERVIÇO UTILIZANDO O CÓDIGO DA 'OS'

            //RECEBE PARAMETRO VIA POST DO FORMULÁRIO UTILIZANDO CAMPO hidden
            String codigoProjeto = request.getParameter("codigoItemOrdemServico");

            //PARAMETRO QUE RECEBE O VALOR codigoItemOS DA SQL DO ARQUIVO COMPILADO .JASPER
            HashMap valorParametro = new HashMap();
            valorParametro.put("codigoItemOS", codigoProjeto);

            try {

                //ABRINDO CONEXÃO
                conexao = conn.abrirConexao();

                //VAVIÁVEL QUE RECEBE O CAMINHO DO ARQUIVO .JASPER
                File ComParametros = new File(getServletConfig().getServletContext().getRealPath("/WEB-INF/Relatorio/ItemOrdemServico.jasper"));

                //GERENCIADOR DO JASPER PARA CRIA O RELATÓRIO EM PDF
                bytes = JasperRunManager.runReportToPdf(ComParametros.getPath(), valorParametro, conexao);

                //ESCREVENDO NA SAIDA DO RESPONSE
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ServletOutputStream ouputStream = response.getOutputStream();
                ouputStream.write(bytes, 0, bytes.length);

                //EVIANDO CONTEÚDO
                ouputStream.flush();

                System.out.println("Relatório por item de ordem de serviço gerado com Sucesso!");
            } catch (IOException | JRException ex) {
                System.out.println("Erro ao gerar relatório=>" + ex.getMessage());
            }
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
        gerandoRelatorios(request, response);
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
        gerandoRelatorios(request, response);
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
