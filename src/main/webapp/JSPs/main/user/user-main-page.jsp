<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.TeamDTO" %>
<%@ page import="ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager" %>
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
        <input type="hidden" name="userId" value="<%= request.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) != null ? request.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) : "" %>">
        <button type="submit" class="button login-button rounded-button">Cписок команд</button>
    </form>
    <form action="controller?command=my_team" method="GET">
        <input type="hidden" name="command" value="my_team">
        <input type="hidden" name="userId" value="<%= request.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) != null ? request.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) : "" %>">
        <button type="submit" class="button login-button rounded-button">Моя команда</button>
    </form>
    <form action="controller?command=create_team" method="GET">
        <input type="hidden" name="command" value="create_team">
        <input type="hidden" name="userId" value="<%= request.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) != null ? request.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) : "" %>">
        <button type="submit" class="button login-button rounded-button">Создать команду</button>
    </form>
    <form action="controller?command=consultations" method="GET">
        <input type="hidden" name="command" value="consultations">
        <input type="hidden" name="userId" value="<%= request.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) != null ? request.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) : "" %>">
        <button type="submit" class="button login-button rounded-button">Консультация</button>
    </form>
    <form action="controller?command=logout" method="GET">
        <input type="hidden" name="command" value="logout">
        <input type="hidden" name="userId" value="<%= request.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) != null ? request.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) : "" %>">
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

<c:if test="${not empty sessionScope.isUserInTeam}">
    <c:set var="isUserInTeam" value="${sessionScope.isUserInTeam}" />
    <c:if test="${isUserInTeam}">
        <div class="modal">
            <div class="modal-content">
                <h3>Ошибка</h3>
                <p>Вы уже находитесь в команде</p>
                <button class="button modal-button rounded-button" onclick="closeModal()">OK</button>
            </div>
        </div>
        <c:set value="false" var="isUserInTeam" />
        <c:set value="${isUserInTeam}" var="sessionScope.isUserInTeam" />
    </c:if>
</c:if>

<c:if test="${not empty sessionScope.noPlaces}">
    <c:set var="noPlaces" value="${sessionScope.noPlaces}" />
    <c:if test="${noPlaces}">
        <div class="modal">
            <div class="modal-content">
                <h3>Ошибка</h3>
                <p>В команде нет мест</p>
                <button class="button modal-button rounded-button" onclick="closeModal()">OK</button>
            </div>
        </div>
        <c:set value="false" var="sessionScope.noPlaces" />
    </c:if>
</c:if>

<div class="new-title">Список команд</div>
<% if (request.getAttribute(ConfigurationManager.getProperty("USER_LOGIN.CONST")) != null) {
    String login = (String) request.getAttribute(ConfigurationManager.getProperty("USER_LOGIN.CONST"));
%>
<div class="title-info">Ваш логин: <%= login %></div>
<% } %>
<c:set var="list" value="${requestScope.teams}" />

<ul>
    <c:if test="${not empty requestScope.teamFlag}">
        <c:set var="flag" value="${requestScope.teamFlag}" />
        <c:if test="${flag}">
            <div class="container">
                <div class="team-card">
                    <div>
                        <h2>Название: ${list[0].teamName}</h2>
                        <p>Капитан: ${list[0].captainName}</p>
                        <p>Эксперт: ${list[0].expertName}</p>
                        <p>Участников: ${list[0].membersCount} / ${list[0].maxMembersCount}</p>
                    </div>
                    <form action="controller?command=leave_team" method="GET">
                        <input type="hidden" name="teamName" value="${list[0].teamName}">
                        <input type="hidden" name="userId" value="<%= request.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) != null ? request.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) : "" %>">
                        <input type="hidden" name="command" value="leave_team">
                        <button type="submit" class="leave-button">Выйти</button>
                    </form>
                </div>
            </div>
        </c:if>

        <c:set var="iterator" value="${flag ? 1 : 0}" />
        <c:forEach var="team" items="${list}" begin="${iterator}">
            <div class="container">
                <div class="team-card">
                    <div>
                        <h2>Название: ${team.teamName}</h2>
                        <p>Капитан: ${team.captainName}</p>
                        <p>Эксперт: ${team.expertName}</p>
                        <p>Участников: ${team.membersCount} / ${team.maxMembersCount}</p>
                    </div>

                    <c:if test="${team.membersCount == team.maxMembersCount}">
                        <form action="controller?command=no_places" method="GET">
                            <input type="hidden" name="command" value="no_places">
                            <input type="hidden" name="userId" value="<%= request.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) != null ? request.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) : "" %>">
                            <button type="submit" class="leave-button">Мест нет</button>
                        </form>
                    </c:if>
                    <c:if test="${team.membersCount < team.maxMembersCount}">
                        <form action="controller?command=join_team" method="GET">
                            <input type="hidden" name="teamName" value="${team.teamName}">
                            <input type="hidden" name="command" value="join_team">
                            <input type="hidden" name="userId" value="<%= request.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) != null ? request.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) : "" %>">
                            <button type="submit" class="join-button">Войти</button>
                        </form>
                    </c:if>
                </div>
            </div>
        </c:forEach>
    </c:if>
</ul>
<script>
    function closeModal() {
        var modal = document.querySelector(".modal");
        modal.style.display = "none";
    }
</script>
</body>
</html>
