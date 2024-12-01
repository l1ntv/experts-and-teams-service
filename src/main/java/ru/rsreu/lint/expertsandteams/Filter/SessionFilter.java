package ru.rsreu.lint.expertsandteams.Filter;

import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);
        String command = httpRequest.getParameter("command");
        if ("login".equals(command) || "registration".equals(command) ||
                "redirect_to_login".equals(command) || "redirect_to_registration".equals(command)) {
            chain.doFilter(request, response);
        } else {
            if (session == null || session.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) == null) {
                if (!httpResponse.isCommitted()) {
                    httpResponse.sendRedirect(httpRequest.getContextPath() + "/controller?command=login");
                    return;
                }
            } else {
                chain.doFilter(request, response);
            }
        }
    }
}

