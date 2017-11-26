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

@WebServlet(name = "RelatorioImpresso", urlPatterns = {"/RelatorioImpresso"})
public class RelatorioImpresso extends HttpServlet {

    //VARIÁVEIS
    public Connection conexao;
    File caminhoRelatorio;
    ServletOutputStream ouputStream;
    byte[] bytes;

    //CRIANDO OBJETO DE CONEXÃO
    ModuloConexao conn = new ModuloConexao();

    protected void gerandoRelatorios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //RECEBE PARAMETRO VIA POST DO FORMULÁRIO UTILIZANDO CAMPO hidden
        String comando = request.getParameter("comando");

        if (comando.equalsIgnoreCase("imprimir_lista_produtos")) { //LISTA TODOS OS PRODUTOS PARA IMPRIMIR

            try {
                //RECEBENDO CONEXÃO
                this.conexao = conn.abrirConexao();

                //VAVIÁVEL QUE RECEBE O CAMINHO DO ARQUIVO .JASPER
                this.caminhoRelatorio = new File(getServletContext().getRealPath("/WEB-INF/Relatorio/Produtos.jasper"));

                //GERENCIADOR DO JASPER PARA CRIA O RELATÓRIO EM PDF
                this.bytes = JasperRunManager.runReportToPdf(caminhoRelatorio.getPath(), null, conexao);

                //ESCREVENDO NA SAIDA DO RESPONSE
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ouputStream = response.getOutputStream();
                ouputStream.write(bytes, 0, bytes.length);
                ouputStream.flush();

                System.out.println("Relatório de produtos gerado com Sucesso!");
            } catch (IOException | JRException ex) {
                System.out.println("Erro ao gerar relatório=>" + ex.getMessage());
            }

        } else if (comando.equalsIgnoreCase("imprimir_ordens_servico")) { //IMPRIMIR ORDEM DE SERVIÇO OU ORÇAMENTO UTILIZANDO O CÓDIGO

            //RECEBE PARAMETRO VIA POST DO FORMULÁRIO UTILIZANDO CAMPO hidden
            String codigoProjeto = request.getParameter("codigoOrcamento");

            //PARAMETRO QUE RECEBE O VALOR codigoItemOS DA SQL DO ARQUIVO COMPILADO .JASPER
            HashMap valorParametro = new HashMap();
            valorParametro.put("codigoOS", codigoProjeto);
            
            try {
                //RECEBENDO CONEXÃO
                this.conexao = conn.abrirConexao();

                //VAVIÁVEL QUE RECEBE O CAMINHO DO ARQUIVO .JASPER
                this.caminhoRelatorio = new File(getServletContext().getRealPath("/WEB-INF/Relatorio/OrdemServico.jasper"));

                //GERENCIADOR DO JASPER PARA CRIA O RELATÓRIO EM PDF
                this.bytes = JasperRunManager.runReportToPdf(caminhoRelatorio.getPath(), valorParametro, conexao);

                //ESCREVENDO NA SAIDA DO RESPONSE
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ouputStream = response.getOutputStream();
                ouputStream.write(bytes, 0, bytes.length);
                ouputStream.flush();

                System.out.println("Relatório de ordem de serviço gerado com Sucesso!");
            } catch (IOException | JRException ex) {
                System.out.println("Erro ao gerar relatório=>" + ex.getMessage());
            }

        } else if (comando.equalsIgnoreCase("imprimir_item_ordens_servico")) { //IMPRIME ORDEM DE SERVIÇO UTILIZANDO O CÓDIGO 'ID'

            //RECEBE PARAMETRO VIA POST DO FORMULÁRIO UTILIZANDO CAMPO hidden
            String codigoProjeto = request.getParameter("codigoItemOrdemServico");

            //PARAMETRO QUE RECEBE O VALOR codigoItemOS DA SQL DO ARQUIVO COMPILADO .JASPER
            HashMap valorParametro = new HashMap();
            valorParametro.put("codigoItemOS", codigoProjeto);

            try {

                //RECEBENDO CONEXÃO
                this.conexao = conn.abrirConexao();

                //VAVIÁVEL QUE RECEBE O CAMINHO DO ARQUIVO .JASPER
               this.caminhoRelatorio = new File(getServletContext().getRealPath("/WEB-INF/Relatorio/ItemOrdemServico.jasper"));

                //GERENCIADOR DO JASPER PARA CRIA O RELATÓRIO EM PDF
                this.bytes = JasperRunManager.runReportToPdf(caminhoRelatorio.getPath(), valorParametro, conexao);

                //ESCREVENDO NA SAIDA DO RESPONSE
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ouputStream = response.getOutputStream();
                ouputStream.write(bytes, 0, bytes.length);
                ouputStream.flush();

                System.out.println("Relatório por item de ordem de serviço gerado com Sucesso!");
            } catch (IOException | JRException ex) {
                System.out.println("Erro ao gerar relatório=>" + ex.getMessage());
            }

        } else if (comando.equalsIgnoreCase("imprimir_venda_produto")) {  //IMPRIME VENDA DE PRODUTOS UTILIZANDO O CÓDIGO DO 'CLIENTE'

            //RECEBE PARAMETRO VIA POST DO FORMULÁRIO UTILIZANDO CAMPO hidden
            String codigoVendaProduto = request.getParameter("codigoVendaProduto");

            //PARAMETRO QUE RECEBE O VALOR codVenPro DA SQL DO ARQUIVO COMPILADO .JASPER
            HashMap valorParametro = new HashMap();
            valorParametro.put("codVenPro", codigoVendaProduto);

            try {

                //RECEBENDO CONEXÃO
                this.conexao = conn.abrirConexao();

                //VAVIÁVEL QUE RECEBE O CAMINHO DO ARQUIVO .JASPER
                this.caminhoRelatorio = new File(getServletContext().getRealPath("/WEB-INF/Relatorio/VendaProduto.jasper"));

                //GERENCIADOR DO JASPER PARA CRIA O RELATÓRIO EM PDF
                this.bytes = JasperRunManager.runReportToPdf(caminhoRelatorio.getPath(), valorParametro, conexao);

                //ESCREVENDO NA SAIDA DO RESPONSE
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ouputStream = response.getOutputStream();
                ouputStream.write(bytes, 0, bytes.length);
                ouputStream.flush();

                System.out.println("Relatório de venda de produto gerado com Sucesso!");
            } catch (IOException | JRException ex) {
                System.out.println("Erro ao gerar relatório=>" + ex.getMessage());
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        gerandoRelatorios(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        gerandoRelatorios(request, response);
    }

}
