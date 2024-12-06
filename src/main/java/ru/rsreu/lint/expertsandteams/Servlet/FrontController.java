package ru.rsreu.lint.expertsandteams.Servlet;

import ru.rsreu.lint.expertsandteams.Command.ActionCommand;
import ru.rsreu.lint.expertsandteams.Enums.DirectTypesEnum;
import ru.rsreu.lint.expertsandteams.Command.Factory.ActionFactory;
import ru.rsreu.lint.expertsandteams.Command.Page;
import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * The FrontController class is a servlet that acts as the central point for handling
 * incoming HTTP requests and directing them to the appropriate command for processing.
 * It extends the HttpServlet class and overrides the doGet and doPost methods to
 * handle GET and POST requests respectively.
 */
public class FrontController extends HttpServlet {

    /**
     * Handles the HTTP GET request by processing the request through the processRequest method.
     *
     * @param request  The HttpServletRequest object that contains the request made by the client.
     * @param response The HttpServletResponse object that contains the response to be sent to the client.
     * @throws IOException      If an input or output error occurs during the processing of the request.
     * @throws ServletException If the request could not be handled due to a servlet-specific error.
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            this.processRequest(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Handles the HTTP POST request by processing the request through the processRequest method.
     *
     * @param request  The HttpServletRequest object that contains the request made by the client.
     * @param response The HttpServletResponse object that contains the response to be sent to the client.
     * @throws IOException      If an input or output error occurs during the processing of the request.
     * @throws ServletException If the request could not be handled due to a servlet-specific error.
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            this.processRequest(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Processes incoming requests by determining the appropriate action command based on the request,
     * executing that command, and then directing the response based on the command's result.
     *
     * @param request  The HttpServletRequest object that contains the request made by the client.
     * @param response The HttpServletResponse object that contains the response to be sent to the client.
     * @throws IOException      If an input or output error occurs during the processing of the request.
     * @throws ServletException If a servlet-specific error occurs while handling the request.
     * @throws SQLException     If there is an error accessing the database during command execution.
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        Page page = command.execute(request);
        if (page != null) {
            HttpSession session = request.getSession(false);
            if (session != null)
                request.setAttribute(ConfigurationManager.getProperty("USER_ID.CONST"), session.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")));
            if (page.getDirectTypes().equals(DirectTypesEnum.REDIRECT)) {
                response.sendRedirect(request.getContextPath() + page.getUrl());

            } else {
                RequestDispatcher dispatcher =
                        request.getServletContext().getRequestDispatcher(page.getJsp());
                dispatcher.forward(request, response);
            }
        }
    }
}