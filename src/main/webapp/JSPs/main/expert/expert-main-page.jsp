<%@ page import="ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.ConsultingTeamDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Главная</title>
    <link href="styles/main/user-main-styles.css" rel="stylesheet" type="text/css">
    <link rel="icon" href="D:\tournament.png" type="image/png">
    <style>
        .new-title {
            font-size: 24px;
            font-weight: bold;
            margin-top: 30px;
            margin-bottom: 30px;
            text-align: center;
        }

        .new-header {
            background-color: #4CAF50;
            color: white;
            padding: 15px;
            display: flex;
            justify-content: space-around;
            align-items: center;
        }

        .new-header a {
            color: white;
            text-decoration: none;
            font-weight: bold;
            padding: 10px 15px;
            margin: 0 5px;
            transition: background-color 0.3s ease;
        }

        .new-header a:hover {
            background-color: #45a049;
        }


        .table-container {
            max-height: 750px;
            overflow-y: auto;
            margin: 0 auto;
            width: 75%;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 12px;
            text-align: center;
            background-color: #f1f1f1;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        .title-info {
            font-size: 20px;
            font-weight: normal;
            margin-top: 30px;
            margin-bottom: 0px;
            text-align: left;
            margin-left: 50px;
        }
    </style>
</head>
<body>
<div class="new-header">
    <form action="controller?command=main" method="GET">
        <input type="hidden" name="command" value="main">
        <button type="submit" class="button login-button rounded-button">Консультируемые команды</button>
    </form>
    <form action="controller?command=consultations_requests" method="GET">
        <input type="hidden" name="command" value="consultations_requests">
        <button type="submit" class="button login-button rounded-button">Запросы на консультацию</button>
    </form>
    <form action="controller?command=logout" method="GET">
        <input type="hidden" name="command" value="logout">
        <button type="submit" class="button login-button rounded-button">Выйти</button>
    </form>
</div>

<div class="new-title">Список консультируемых команд</div>
<% if (request.getAttribute(ConfigurationManager.getProperty("USER_LOGIN.CONST")) != null) {
    String login = (String) request.getAttribute(ConfigurationManager.getProperty("USER_LOGIN.CONST"));
%>
<div class="title-info">Ваш логин: <%= login %></div>
<% } %>
<% if ((request.getAttribute("countTeams") != null) && (request.getAttribute("maxCountTeams") != null)) { %>
<% if (((int) request.getAttribute("countTeams") != -1) && ((int) request.getAttribute("maxCountTeams") != -1)) { %>
<div class="title-info">Количество консультируемых команд: <%= (int) request.getAttribute("countTeams") %>
</div>
<div class="title-info">Макс. количество консультируемых команд: <%= (int) request.getAttribute("maxCountTeams") %>
</div>
<% } %>
<% } %>
<%List<ConsultingTeamDTO> list = (ArrayList) request.getAttribute("listExpert"); %>
<% if (!list.isEmpty()) { %>
<div class="table-container">
    <table>
        <thead>
        <tr>
            <th>Название команды</th>
            <th>Капитан</th>
            <th>Количество участников</th>
            <th>Макс. количество участников</th>
            <th>Чат консультации</th>
            <th>Отказ от консультации</th>
        </tr>
        </thead>
        <tbody>
        <% for (int i = 0; i < list.size(); i++) { %>
        <tr>
            <td><%= list.get(i).getTeamName() %>
            </td>
            <td><%= list.get(i).getCaptainLogin() %>
            </td>
            <td><%= list.get(i).getCountMembers() %>
            </td>
            <td><%= list.get(i).getMaxCountMembers() %>
            </td>
            <td>
                <form action="controller?command=do_consultation" method="GET">
                    <input type="hidden" name="consultationTeam" value="<%= list.get(i).getTeamId() %>">
                    <input type="hidden" name="command" value="do_consultation">
                    <button type="submit" class="leave-button">Чат</button>
                </form>
            </td>
            <td>
                <form action="controller?command=cancel_consultation" method="GET">
                    <input type="hidden" name="cancelTeam" value="<%= list.get(i).getTeamId() %>">
                    <input type="hidden" name="command" value="cancel_consultation">
                    <button type="submit" class="leave-button">Отказаться</button>
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
<% } else { %>
<div class="title-info">У вас нет консультируемых команд</div>
<% } %>
</body>
</html>