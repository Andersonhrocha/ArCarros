package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anderson
 */
public abstract class ServletAbstrato extends HttpServlet {

    public abstract void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    public void redirecionarPagina(HttpServletRequest request, HttpServletResponse response, String paginas)
            throws ServletException, IOException {
        RequestDispatcher mostrar = request.getRequestDispatcher(paginas);
        mostrar.forward(request, response);
    }

}