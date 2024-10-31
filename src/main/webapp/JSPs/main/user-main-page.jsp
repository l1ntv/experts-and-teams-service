<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.rsreu.lint.expertsandteams.Datalayer.DTO.TeamDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Команды</title>
    <link href="styles/main/user-main-styles.css" rel="stylesheet" type="text/css">
    <link rel="icon" href="D:\tournament.png" type="image/png">
</head>
<body>
    <div class="header">
        <form action="controller?command=main" method="GET">
            <input type="hidden" name="command" value="main">
            <button type="submit" class="button login-button rounded-button">Cписок команд</button>
        </form>
        <a href="my-team">Моя команда</a>
        <a href="profile">Профиль</a>
        <form action="controller?command=logout" method="GET">
            <input type="hidden" name="command" value="logout">
            <button type="submit" class="button login-button rounded-button">Выйти</button>
        </form>
    </div>
    <%ArrayList<TeamDTO> list = (ArrayList) request.getAttribute("teams");%>
    <ul>
        <% for (int i = 0; i < list.size(); i++) { %>
            <div class="container">
                <div class="team-card">
                    <div>
                        <h2>Название команды: <%= list.get(i).getTeamName()%></h2>
                        <p>Капитан: <%= list.get(i).getCaptainName()%></p>
                        <p>Эксперт: <%= list.get(i).getExpertName()%></p>
                        <p>Участников: <%= list.get(i).getMembersCount() %> / <%= list.get(i).getMaxMembersCount() %></p>
                    </div>
                    <button class="join-button">Войти</button>
                </div>
            </div>
        <% } %>
    </ul>
</body>
</html>
