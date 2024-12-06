package ru.rsreu.lint.expertsandteams.Filter;

import ru.rsreu.lint.expertsandteams.Logic.Common.LogoutLogic;
import ru.rsreu.lint.expertsandteams.Logic.Common.SessionFilterLogic;
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
import java.sql.SQLException;

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
                // Сделать еще проверку на Null user_id, если он не null, то завершить сессию в БД
                if (httpRequest.getParameter(ConfigurationManager.getProperty("USER_ID.CONST")) != null) {
                    int userId = Integer.parseInt(httpRequest.getParameter(ConfigurationManager.getProperty("USER_ID.CONST")));
                    try {
                        LogoutLogic.setOfflineStatusByUserId(userId);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (!httpResponse.isCommitted()) {
                    httpResponse.sendRedirect(httpRequest.getContextPath() + "/controller?command=redirect_to_login");
                    return;
                }
            } else {
                String userIdParam = httpRequest.getParameter(ConfigurationManager.getProperty("USER_ID.CONST"));
                if (userIdParam != null) {
                    try {
                        int userId = Integer.parseInt(userIdParam);
                        if (SessionFilterLogic.isUserBannedByUserId(userId)) {
                            session.invalidate();
                            request.setAttribute(ConfigurationManager.getProperty("IS_BANNED_FLAG.CONST"), true);
                            httpResponse.sendRedirect(httpRequest.getContextPath() + "/controller?command=redirect_to_login");
                            return;
                        }
                    } catch (NumberFormatException e) {
                        // Логирование ошибки парсинга userId
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                chain.doFilter(request, response);
            }
        }
    }
}

