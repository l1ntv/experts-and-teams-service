package ru.rsreu.lint.expertsandteams.Filter;

import ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
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

        // Получаем сессию
        HttpSession session = httpRequest.getSession(false);

        // Получаем команду из параметров запроса
        String command = httpRequest.getParameter("command");

        // Проверяем, является ли команда login или registration
        if ("login".equals(command) || "registration".equals(command) || "redirect_to_login".equals(command) || "redirect_to_registration".equals(command)) {
            // Если это команды, которые не требуют авторизации, пропускаем фильтр
            chain.doFilter(request, response);
        } else {
            // Проверяем, есть ли сессия и авторизован ли пользователь
            if (session == null || session.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) == null) {
                // Если сессия отсутствует или пользователь не авторизован, перенаправляем на страницу авторизации
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/controller?command=login");
            } else {
                // Если сессия существует и пользователь авторизован, продолжаем выполнение фильтра
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Инициализация фильтра, если необходимо
    }

    @Override
    public void destroy() {
        // Освобождение ресурсов, если необходимо
    }
}
