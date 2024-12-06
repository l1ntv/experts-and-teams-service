<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.ExpertsStatisticsDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Статистика экспертов</title>
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
    <form action="controller?command=auth_users" method="GET">
        <input type="hidden" name="command" value="auth_users">
        <button type="submit" class="button login-button rounded-button">Авторизованные пользователи</button>
    </form>
    <form action="controller?command=teams_statistics" method="GET">
        <input type="hidden" name="command" value="teams_statistics">
        <button type="submit" class="button login-button rounded-button">Статистика команд</button>
    </form>
    <form action="controller?command=experts_statistics" method="GET">
        <input type="hidden" name="command" value="experts_statistics">
        <button type="submit" class="button login-button rounded-button">Статистика экспертов</button>
    </form>
    <form action="controller?command=logout" method="GET">
        <input type="hidden" name="command" value="logout">
        <button type="submit" class="button login-button rounded-button">Выйти</button>
    </form>
</div>
<% ArrayList<ExpertsStatisticsDTO> list = (ArrayList) request.getAttribute("expertsStatistics"); %>
<div class="title">Статистика экспертов</div>
<div class="table-container">
    <table>
        <thead>
        <tr>
            <th>Логин эксперта</th>
            <th>Количество консультируемых команд</th>
            <th>Макс. количество консультируемых команд</th>
        </tr>
        </thead>
        <tbody>
        <% for (int i = 0; i < list.size(); i++) { %>
        <tr>
            <td><%= list.get(i).getLogin() %>
            </td>
            <td><%= list.get(i).getConsultingTeamCount() %>
            </td>
            <td><%= list.get(i).getMaxConsultingTeamCount() %>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>