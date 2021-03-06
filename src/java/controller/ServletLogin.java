package controller;

import dao.DaoUsuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anderson
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends ServletAbstrato {

    //CONSTANTES DAS PÁGINAS .JSP
    private static final String MENU_PRINCIPAL = "menu.jsp";
    private static final String ERRO_LOGIN = "login.jsp";
    private final DaoUsuario dao;

    public ServletLogin() {
        dao = new DaoUsuario();
    }
    
    //VARIÁVEIS
    public Connection conexao;
    public String sql = "";

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //RECEBENDO OS VALORES DO FORMULÁRIO
        String loginUsuario = request.getParameter("txtLogin");
        String senhaUsuario = request.getParameter("txtSenha");

        try {

            if (loginUsuario != null) {

                //RECEBENDO A CONEXÃO
                this.conexao = dao.abrirConexao();

                sql = "SELECT * FROM usuario WHERE login=? AND senha=?";

                PreparedStatement pst = conexao.prepareStatement(sql);
                pst.setString(1, loginUsuario);
                pst.setString(2, senhaUsuario);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    //REDIRECIONAMENTO
                    this.redirecionarPagina(request, response, MENU_PRINCIPAL);
                    System.out.println("Login efetuado com sucesso.");

                } else {

                    //ATRIBUTO COM MENSAGEM DE RETORNO
                    request.setAttribute("mensagem", "Usuário e/ou senha incorreto(s).");
                    System.out.println("Usuário e/ou senha não existe no banco de dados.");

                    //REDIRECIONAMENTO
                    this.redirecionarPagina(request, response, ERRO_LOGIN);

                }
            }
        } catch (IOException | SQLException | ServletException ex) {
            System.out.println("Erro no login: " + ex.getMessage());
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
