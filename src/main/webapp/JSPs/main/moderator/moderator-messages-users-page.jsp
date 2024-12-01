<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.rsreu.lint.expertsandteams.Datalayer.DTO.Moderator.ConsultationMessageDTO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Сообщения пользователей</title>
    <link href="styles/authentication/authentication-styles.css" rel="stylesheet" type="text/css">
    <link href="styles/main/administrator-auth-user-styles.css" rel="stylesheet" type="text/css">
    <link href="styles/main/user-main-styles.css" rel="stylesheet" type="text/css">
    <link href="styles/main/authUsers.css" rel="stylesheet" type="text/css">
    <link rel="icon" href="D:\tournament.png" type="image/png">
</head>
<body>
<div class="header">
    <form action="controller?command=main" method="GET">
        <input type="hidden" name="command" value="main">
        <button type="submit" class="button login-button rounded-button">Действия с пользователем</button>
    </form>
    <form action="controller?command=messages_users" method="GET">
        <input type="hidden" name="command" value="messages_users">
        <button type="submit" class="button login-button rounded-button">Просмотр сообщений пользователей</button>
    </form>
    <form action="controller?command=auth_users_moderator" method="GET">
        <input type="hidden" name="command" value="auth_users_moderator">
        <button type="submit" class="button login-button rounded-button">Авторизованные пользователи</button>
    </form>
    <form action="controller?command=banned_users" method="GET">
        <input type="hidden" name="command" value="banned_users">
        <button type="submit" class="button login-button rounded-button">Заблокированные пользователи</button>
    </form>
    <form action="controller?command=logout" method="GET">
        <input type="hidden" name="command" value="logout">
        <button type="submit" class="button login-button rounded-button">Выйти</button>
    </form>
</div>
<div class="title">Список сообщений пользователей</div>
<div class="table-container">
    <table>
        <thead>
        <tr>
            <th>Логин</th>
            <th>Сообщение из консультации</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
        <% if (request.getAttribute("messagesByExperts") != null) { %>
        <% List<ConsultationMessageDTO> messagesByExperts = (ArrayList) request.getAttribute("messagesByExperts");%>
        <% for (int i = 0; i < messagesByExperts.size(); i++) { %>
        <% if (!messagesByExperts.get(i).getMessage().equals(" ") && !messagesByExperts.get(i).getMessage().equals("hidden by moderator")) {%>
        <tr>
            <td><%= messagesByExperts.get(i).getAuthorLogin() %>
            </td>
            <td><%= messagesByExperts.get(i).getMessage() %>
            </td>
            <td>
                <form action="controller?command=hide_message" method="GET" accept-charset="UTF-8">
                    <%
                        request.setCharacterEncoding("UTF-8");
                    %>
                    <input type="hidden" name="userId" value="<%= messagesByExperts.get(i).getAuthorId() %>">
                    <input type="hidden" name="consultationId"
                           value="<%= messagesByExperts.get(i).getConsultationId() %>">
                    <input type="hidden" name="login" value="<%= messagesByExperts.get(i).getAuthorLogin() %>">
                    <input type="hidden" name="message" value="<%= messagesByExperts.get(i).getMessage() %>">
                    <input type="hidden" name="command" value="hide_message">
                    <button type="submit" class="leave-button">Скрыть сообщение</button>
                </form>
            </td>
        </tr>
        <% } %>
        <% } %>
        <% } %>
        <% if (request.getAttribute("messagesByUsers") != null) { %>
        <% List<ConsultationMessageDTO> messagesByUsers = (ArrayList) request.getAttribute("messagesByUsers");%>
        <% for (int i = 0; i < messagesByUsers.size(); i++) { %>
        <% if (!messagesByUsers.get(i).getMessage().trim().equals(" ") && !messagesByUsers.get(i).getMessage().equals("hidden by moderator")) { %>
        <tr>
            <td><%= messagesByUsers.get(i).getAuthorLogin() %>
            </td>
            <td><%= messagesByUsers.get(i).getMessage() %>
            </td>
            <td>
                <form action="controller?command=hide_message" method="GET" accept-charset="UTF-8">
                    <%
                        request.setCharacterEncoding("UTF-8");
                    %>
                    <input type="hidden" name="userId" value="<%= messagesByUsers.get(i).getAuthorId() %>">
                    <input type="hidden" name="consultationId"
                           value="<%= messagesByUsers.get(i).getConsultationId() %>">
                    <input type="hidden" name="login" value="<%= messagesByUsers.get(i).getAuthorLogin() %>">
                    <input type="hidden" name="message" value="<%= messagesByUsers.get(i).getMessage() %>">
                    <input type="hidden" name="command" value="hide_message">
                    <button type="submit" class="leave-button">Скрыть сообщение</button>
                </form>
            </td>
        </tr>
        <% } %>
        <% } %>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>