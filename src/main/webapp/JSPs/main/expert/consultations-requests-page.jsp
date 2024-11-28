<%@ page import="ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.ConsultingTeamDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.TeamConsultationRequestDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Консультируемые команды</title>
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

        .modal {
            display: block;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.4);
        }

        .modal-content {
            background-color: #fefefe;
            margin: 15% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 30%;
        }

        .modal-button {
            display: block;
            margin: 0 auto;
        }

        .table-container {
            max-height: 750px; /* Максимальная высота контейнера */
            overflow-y: auto; /* Прокрутка по вертикали */
            margin: 0 auto; /* Центрируем контейнер по горизонтали */
            width: 75%; /* Ограничиваем ширину контейнера */
        }

        table {
            width: 100%; /* Устанавливаем ширину таблицы в 100% относительно контейнера */
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
            text-align: left; /* Выравнивание текста по центру */
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

<div class="new-title">Запросы на консультацию от команд</div>
<% if ((request.getAttribute("countTeams") != null) && (request.getAttribute("maxCountTeams") != null)) { %>
    <% if (((int)request.getAttribute("countTeams") != -1) && ((int)request.getAttribute("maxCountTeams") != -1)) { %>
        <div class="title-info">Количество консультируемых команд: <%= (int) request.getAttribute("countTeams") %></div>
        <div class="title-info">Макс. количество консультируемых команд: <%= (int) request.getAttribute("maxCountTeams") %></div>
    <% } %>
<% } %>
<%List<TeamConsultationRequestDTO> list = (ArrayList) request.getAttribute("consultationsRequests"); %>
<% if (!list.isEmpty()) { %>
<div class="table-container">
    <table>
        <thead>
        <tr>
            <th>Название команды</th>
            <th>Капитан</th>
            <th>Количество участников</th>
            <th>Макс. количество участников</th>
            <th>Принять на консультацию</th>
        </tr>
        </thead>
        <tbody>
        <% for (int i = 0; i < list.size(); i++) { %>
        <tr>
            <td><%= list.get(i).getTeamName() %>
            </td>
            <td><%= list.get(i).getCaptainName() %>
            </td>
            <td><%= list.get(i).getMembersCount() %>
            </td>
            <td><%= list.get(i).getMaxMembersCount() %>
            </td>
            <td>
                <form action="controller?command=accept_consultation" method="GET">
                    <input type="hidden" name="acceptTeam" value="<%= list.get(i).getTeamId() %>">
                    <input type="hidden" name="command" value="accept_consultation">
                    <button type="submit" class="leave-button">Принять</button>
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
<% } else { %>
<div class="title-info">У вас нет запросов на консультацию от команд</div>
<% } %>
</body>
</html>
