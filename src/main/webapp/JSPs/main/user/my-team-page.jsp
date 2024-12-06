<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.rsreu.lint.expertsandteams.Datalayer.DTO.User.MyTeamDTO" %>
<%@ page import="ru.rsreu.lint.expertsandteams.Enums.TeamRoleEnum" %>
<%@ page import="ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Моя команда</title>

    <link href="styles/main/user-main-styles.css" rel="stylesheet" type="text/css">
    <link href="styles/main/administrator-auth-user-styles.css" rel="stylesheet" type="text/css">
    <link rel="icon" href="D:\tournament.png" type="image/png">
    <style>
        .new-title {
            font-size: 24px;
            font-weight: bold;
            margin-top: 30px;
            margin-bottom: 30px;
            text-align: center;
        }

        .team-info {
            font-size: 20px;
            font-weight: normal;
            margin-top: 30px;
            margin-bottom: 0px;
            text-align: left;
            margin-left: 50px;
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

        .button-container {
            display: flex;
            justify-content: center;
            gap: 10px;
            padding-top: 30px;
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
<c:set var="myTeamDTO" value="${requestScope.myTeam}" />

<div class="new-title">Моя команда</div>

<c:if test="${not empty myTeamDTO}">
    <div class="team-info">
        Название команды: ${myTeamDTO.name}
    </div>
    <div class="team-info">
        Количество участников: ${myTeamDTO.countMembers} / ${myTeamDTO.maxCountMembers}
    </div>
    <div class="table-container">
        <table>
            <thead>
            <tr>
                <th>Логин</th>
                <th>Роль</th>
                <th>Онлайн</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="member" items="${myTeamDTO.teamMembers}">
                <tr>
                    <td>${member.login}</td>
                    <td>${member.role == 'MEMBER' ? 'Участник' : 'Капитан'}</td>
                    <td>${member.isOnline ? '☑️' : '☒'}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>

<c:if test="${empty myTeamDTO}">
    <div class="title">У вас нет команды</div>
    <div class="button-container">
        <div class="form-input-wrapper">
            <form action="controller?command=main" method="GET">
                <input type="hidden" name="command" value="main">
                <input type="hidden" name="userId" value="<%= request.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) != null ? request.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) : "" %>">
                <button type="submit" class="button login-button rounded-button">Найти</button>
            </form>
        </div>
        <div class="form-input-wrapper">
            <form action="controller?command=create_team" method="GET">
                <input type="hidden" name="command" value="create_team">
                <input type="hidden" name="userId" value="<%= request.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) != null ? request.getAttribute(ConfigurationManager.getProperty("USER_ID.CONST")) : "" %>">
                <button type="submit" class="button login-button rounded-button">Создать</button>
            </form>
        </div>
    </div>
</c:if>
</body>
</html>
