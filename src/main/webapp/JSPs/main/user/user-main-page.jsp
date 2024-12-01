<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.TeamDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
    </style>
</head>
<body>
<div class="new-header">
    <form action="controller?command=main" method="GET">
        <input type="hidden" name="command" value="main">
        <button type="submit" class="button login-button rounded-button">Cписок команд</button>
    </form>
    <form action="controller?command=my_team" method="GET">
        <input type="hidden" name="command" value="my_team">
        <button type="submit" class="button login-button rounded-button">Моя команда</button>
    </form>
    <form action="controller?command=create_team" method="GET">
        <input type="hidden" name="command" value="create_team">
        <button type="submit" class="button login-button rounded-button">Создать команду</button>
    </form>
    <form action="controller?command=consultations" method="GET">
        <input type="hidden" name="command" value="consultations">
        <button type="submit" class="button login-button rounded-button">Консультация</button>
    </form>
    <form action="controller?command=logout" method="GET">
        <input type="hidden" name="command" value="logout">
        <button type="submit" class="button login-button rounded-button">Выйти</button>
    </form>
</div>

<% if (session.getAttribute("isCaptainLeaving") != null) {
    boolean isCaptainLeaving = (boolean) session.getAttribute("isCaptainLeaving");
    if (isCaptainLeaving) { %>
<div class="modal">
    <div class="modal-content">
        <h3>Ошибка</h3>
        <p>Вы не можете покинуть свою команду будучи капитаном</p>
        <button class="button modal-button rounded-button" onclick="closeModal()">OK</button>
    </div>
</div>
<% session.setAttribute("isCaptainLeaving", false); %>
<% }
} %>

<% if (session.getAttribute("isUserInTeam") != null) {
    boolean isUserInTeam = (boolean) session.getAttribute("isUserInTeam");
    if (isUserInTeam) { %>
<div class="modal">
    <div class="modal-content">
        <h3>Ошибка</h3>
        <p>Вы уже находитесь в команде</p>
        <button class="button modal-button rounded-button" onclick="closeModal()">OK</button>
    </div>
</div>
<% session.setAttribute("isUserInTeam", false); %>
<% }
} %>

<% if (session.getAttribute("noPlaces") != null) {
    boolean noPlaces = (boolean) session.getAttribute("noPlaces");
    if (noPlaces) { %>
<div class="modal">
    <div class="modal-content">
        <h3>Ошибка</h3>
        <p>В команде нет мест</p>
        <button class="button modal-button rounded-button" onclick="closeModal()">OK</button>
    </div>
</div>
<% session.setAttribute("noPlaces", false); %>
<% }
} %>

<div class="new-title">Список команд</div>
<% ArrayList<TeamDTO> list = (ArrayList) request.getAttribute("teams"); %>
<ul>
    <% if (request.getAttribute("teamFlag") != null) { %>
    <% boolean flag = (boolean) request.getAttribute("teamFlag"); %>
    <% if (flag) { %>
    <div class="container">
        <div class="team-card">
            <div>
                <h2>Название: <%= list.get(0).getTeamName() %>
                </h2>
                <p>Капитан: <%= list.get(0).getCaptainName() %>
                </p>
                <p>Эксперт: <%= list.get(0).getExpertName() %>
                </p>
                <p>Участников: <%= list.get(0).getMembersCount() %> / <%= list.get(0).getMaxMembersCount() %>
                </p>
            </div>
            <form action="controller?command=leave_team" method="GET">
                <input type="hidden" name="teamName" value="<%= list.get(0).getTeamName() %>">
                <input type="hidden" name="command" value="leave_team">
                <button type="submit" class="leave-button">Выйти</button>
            </form>
        </div>
    </div>
    <% } %>


    <% int iterator = (flag ? 1 : 0); %>
    <% for (int i = iterator; i < list.size(); i++) { %>
    <div class="container">
        <div class="team-card">
            <div>
                <h2>Название: <%= list.get(i).getTeamName() %>
                </h2>
                <p>Капитан: <%= list.get(i).getCaptainName() %>
                </p>
                <p>Эксперт: <%= list.get(i).getExpertName() %>
                </p>
                <p>Участников: <%= list.get(i).getMembersCount() %> / <%= list.get(i).getMaxMembersCount() %>
                </p>
            </div>

            <% if (list.get(i).getMembersCount() == list.get(i).getMaxMembersCount()) { %>
            <form action="controller?command=no_places" method="GET">
                <input type="hidden" name="command" value="no_places">
                <button type="submit" class="leave-button">Мест нет</button>
            </form>
            <% } else { %>
            <form action="controller?command=join_team" method="GET">
                <input type="hidden" name="teamName" value="<%= list.get(i).getTeamName() %>">
                <input type="hidden" name="command" value="join_team">
                <button type="submit" class="join-button">Войти</button>
            </form>
            <% } %>
        </div>
    </div>
    <% } %>
    <% } %>
</ul>
<script>
    function closeModal() {
        var modal = document.querySelector(".modal");
        modal.style.display = "none";
    }
</script>
</body>
</html>
