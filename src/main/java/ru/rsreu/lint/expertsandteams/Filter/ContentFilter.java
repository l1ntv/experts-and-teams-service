package ru.rsreu.lint.expertsandteams.Filter;

import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContentFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);
        String command = httpRequest.getParameter("command");
        Set<String> allowedCommands = new HashSet<>(Arrays.asList("login", "registration", "redirect_to_login", "redirect_to_registration"));
        if (allowedCommands.contains(command)) {
            if (session.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) == null) {
                chain.doFilter(request, response);
                return;
            } else {
                if (!httpResponse.isCommitted()) {
                    httpResponse.sendRedirect(httpRequest.getContextPath() + "/controller?command=main");
                    return;
                }
            }

        }
        if (session == null || session.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) == null) {
            if (!httpResponse.isCommitted()) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/controller?command=redirect_to_login");
                return;
            }
        } else {
            int groupTypeId = (int) session.getAttribute(ConfigurationManager.getProperty("GROUP_TYPE_ID.CONST"));
            Set<String> groupCommands = getGroupCommands(groupTypeId);

            if (groupCommands.contains(command)) {
                chain.doFilter(request, response);
            } else {
                if (!httpResponse.isCommitted()) {
                    httpResponse.sendRedirect(httpRequest.getContextPath() + "/controller?command=main");
                    return;
                }
            }
        }
    }

    private Set<String> getGroupCommands(int groupTypeId) {
        Set<String> commands = new HashSet<>();
        switch (groupTypeId) {
            case 0:
                commands.addAll(Arrays.asList("ask_question", "user_cancel_consultation", "consultations", "create_new_team", "create_team", "join_team", "leave_team", "my_team", "no_places", "request_consultation", "main", "logout"));
                break;
            case 1:
                commands.addAll(Arrays.asList("accept_consultation", "answer_to_question", "cancel_consultation", "consultations_requests", "do_consultation", "main", "logout"));
                break;
            case 2:
                commands.addAll(Arrays.asList("auth_users", "auth_users_moderator", "banned_users", "ban_user", "hide_message", "messages_users", "search_user_by_moderator", "unban_user", "main", "logout"));
                break;
            case 3:
                commands.addAll(Arrays.asList("auth_users", "create_user", "delete_user", "experts_statistics", "search_user", "teams_statistics", "main", "logout"));
                break;
        }
        return commands;
    }
}