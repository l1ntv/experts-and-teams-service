package ru.rsreu.lint.expertsandteams.Servlet;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Command.Factory.ActionFactory;
import ru.rsreu.lint.expertsandteams.Command.Page;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class FrontController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            request.setCharacterEncoding("UTF-8");
            this.processRequest(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            request.setCharacterEncoding("UTF-8");
            this.processRequest(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        request.setCharacterEncoding("UTF-8");
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        Page page = command.execute(request);
        if (page != null) {
            if (page.getDirectTypes().equals(DirectTypesEnum.REDIRECT)) {
                response.sendRedirect(request.getContextPath() + page.getUrl());

            } else {
                RequestDispatcher dispatcher =
                        request.getServletContext().getRequestDispatcher(page.getJsp());
                dispatcher.forward(request, response);
            }
        } else {
            // TO DO: redirect to error page with destroy session
        }
    }
}
