<%@ page import="ru.rsreu.lint.expertsandteams.Logic.Administrator.SearchUserLogic" %>
<%@ page import="ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.SearchedUserDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Команды</title>
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
            text-align: center; /* Центрирование заголовка */
        }
        .new-form-group {
            margin-bottom: 15px; /* Уменьшаем отступ между формами */
        }
        .new-button-group {
            margin-top: 30px;
            display: flex; /* Используем Flexbox для расположения кнопок в ряд */
            gap: 10px; /* Промежуток между кнопками */
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
            <li><%= msg.trim() %></li>
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
                    onclick="closeModal()">OK</button>
        </div>
    </div>
<% } %>
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
<% SearchedUserDTO searchedUserDTO = (SearchedUserDTO) request.getAttribute("searchedUser"); %>
<div class="title">Работа с пользователями</div>
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

<div class="new-form-group new-button-group">
    <form action="controller?command=create_user" method="GET">
        <!-- Скрытое поле для передачи логина -->
        <input type="hidden" name="login" id="hidden-login-create">
        <input type="hidden" name="command" value="create_user">
        <button type="submit" class="button login-button rounded-button">Заблокировать</button>
    </form>
    <form action="controller?command=delete_user" method="GET">
        <!-- Скрытое поле для передачи логина -->
        <input type="hidden" name="login" id="hidden-login-delete">
        <input type="hidden" name="command" value="delete_user">
        <button type="submit" class="button login-button rounded-button">Разблокировать</button>
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
        <td><%= searchedUserDTO.getLogin() %></td>
        <td><%= searchedUserDTO.getAccountType().toString() %></td>
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

    document.addEventListener('DOMContentLoaded', function() {
        const loginInput = document.getElementById('login');
        const hiddenLogins = [
            document.getElementById('hidden-login-role'),
            document.getElementById('hidden-login-create'),
            document.getElementById('hidden-login-delete')
        ];

        loginInput.addEventListener('input', function() {
            hiddenLogins.forEach(hiddenLogin => {
                hiddenLogin.value = loginInput.value;
            });
        });
    });
</script>
</body>
</html>
