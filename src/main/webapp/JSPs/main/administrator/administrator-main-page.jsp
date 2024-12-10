<%@ page import="ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.SearchedUserDTO" %>
<%@ page import="ru.rsreu.lint.expertsandteams.Resource.ConfigurationManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Главная</title>
    <link href="styles/authentication/authentication-styles.css" rel="stylesheet" type="text/css">
    <link href="styles/main/user-main-styles.css" rel="stylesheet" type="text/css">
    <link rel="icon" href="D:tournament.png" type="image/png">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .header {
            display: flex;
            justify-content: space-around;
            width: 100%;
            margin-bottom: 20px;
        }

        .title {
            font-size: 24px;
            font-weight: bold;
            margin-top: 20px;
            text-align: center;
        }

        .new-form-group {
            margin-bottom: 15px;
        }

        .new-button-group {
            margin-top: 30px;
            display: flex;
            gap: 10px;
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
<% String errorMessage = (String) request.getAttribute("errorMessage"); %>
<% if (errorMessage != null && !errorMessage.isEmpty()) {
    String[] errorMessages = errorMessage.split("\\. ");
%>
<div class="modal">
    <div class="modal-content">
        <h3>Ошибка</h3>
        <p>Некорректный ввод:</p>
        <ul>
            <% for (String msg : errorMessages) { %>
            <li><%= msg.trim() %>
            </li>
            <% } %>
        </ul>
        <button class="button modal-button rounded-button" onclick="closeModal()">OK</button>
    </div>
</div>
<% } %>
<% Boolean isExists = (Boolean) request.getAttribute("isExists"); %>
<% if ((isExists != null) && (isExists)) { %>
<div class="modal">
    <div class="modal-content">
        <h3>Ошибка</h3>
        <p>Пользователь с таким логином уже существует.</p>
        <button class="button modal-button rounded-button"
                onclick="closeModal()">OK
        </button>
    </div>
</div>
<% } %>
<% if (request.getAttribute("isCreated") != null) { %>
<% Boolean isCreated = (Boolean) request.getAttribute("isCreated"); %>
<% if ((isCreated != null) && (isCreated)) { %>
<div class="modal">
    <div class="modal-content">
        <h3>Информация</h3>
        <p>Пользователь создан</p>
        <button class="button modal-button rounded-button"
                onclick="closeModal()">OK
        </button>
    </div>
</div>
<% } %>
<% } %>
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

<% SearchedUserDTO searchedUserDTO = (SearchedUserDTO) request.getAttribute("searchedUser"); %>
<div class="title">Работа с пользователями</div>
<% if (request.getAttribute(ConfigurationManager.getProperty("USER_LOGIN.CONST")) != null) {
    String login = (String) request.getAttribute(ConfigurationManager.getProperty("USER_LOGIN.CONST"));
%>
<div class="title-info">Ваш логин: <%= login %></div>
<% } %>
<form action="controller?command=search_user" method="GET">
    <div class="new-form-group">
        <label for="login" class="form-label">Логин:</label>
        <div class="form-input-wrapper">
            <input type="text" id="login" name="login" required class="form-input rounded">
            <input type="hidden" name="command" value="search_user">
            <button type="submit" class="button login-button rounded-button">Найти</button>
        </div>
    </div>
</form>

<div class="new-form-group">
    <label for="role-select" class="form-label">Роль нового пользователя:</label>
    <select id="role-select" name="role" class="form-input rounded">
        <option value="user">Пользователь</option>
        <option value="expert">Эксперт</option>
        <option value="moderator">Модератор</option>
        <option value="administrator">Администратор</option>
    </select>
</div>

<div class="new-form-group new-button-group">
    <form action="controller?command=create_user" method="GET" id="create-user-form">
        <input type="hidden" name="login" id="hidden-login-create">
        <input type="hidden" name="command" value="create_user">
        <input type="hidden" name="role" id="hidden-role-create">
        <button type="submit" class="button login-button rounded-button">Создать</button>
    </form>
    <form action="controller?command=delete_user" method="GET">
        <input type="hidden" name="login" id="hidden-login-delete">
        <input type="hidden" name="command" value="delete_user">
        <button type="submit" class="button login-button rounded-button">Удалить</button>
    </form>
</div>
<div class="table-container">
    <table>
        <thead>
        <tr>
            <th>Логин</th>
            <th>Роль</th>
        </tr>
        </thead>
        <tbody>
        <% if ((searchedUserDTO != null) && (searchedUserDTO.getAccountType() != null)) { %>
        <tr>
            <td><%= searchedUserDTO.getLogin() %>
            </td>
            <td><%= searchedUserDTO.getAccountType().toString() %>
            </td>
        </tr>
        <% } else { %>
        <tr>
            <td>Не найдено</td>
            <td>Не найдено</td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
<script>
    function closeModal() {
        var modal = document.querySelector(".modal");
        modal.style.display = "none";
    }

    document.addEventListener('DOMContentLoaded', function () {
        const loginInput = document.getElementById('login');
        const hiddenLoginCreate = document.getElementById('hidden-login-create');
        const hiddenLoginDelete = document.getElementById('hidden-login-delete');

        loginInput.addEventListener('input', function () {
            const loginValue = loginInput.value;
            hiddenLoginCreate.value = loginValue;
            hiddenLoginDelete.value = loginValue;
        });
    });

    document.addEventListener('DOMContentLoaded', function () {
        const roleSelect = document.getElementById('role-select');
        const hiddenRoleCreate = document.getElementById('hidden-role-create');
        const createUserForm = document.getElementById('create-user-form');

        roleSelect.addEventListener('change', function () {
            hiddenRoleCreate.value = roleSelect.value;
        });

        createUserForm.addEventListener('submit', function () {
            hiddenRoleCreate.value = roleSelect.value;
        });
    });
</script>
</body>
</html>