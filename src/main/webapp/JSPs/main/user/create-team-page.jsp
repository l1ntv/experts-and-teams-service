<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Создание команды</title>
    <link href="styles/registration/registration-styles.css" rel="stylesheet" type="text/css">
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

        .new-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: flex-start; /* Изменено на flex-start для размещения элементов сверху */
            height: auto; /* Изменено на auto, чтобы контейнер не занимал всю высоту экрана */
            padding-top: 20px; /* Добавлено отступ сверху для размещения ниже шапки */
        }

        .new-form-group {
            margin-bottom: 20px;
            width: 300px; /* Ширина формы остается прежней */
        }

        .new-button-group {
            display: flex;
            justify-content: center;
            margin-top: 30px; /* Отступ сверху для размещения кнопки ниже формы */
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

<% boolean flag = (boolean) request.getAttribute("isJoinedFlag");
    boolean isExists = false;
    if (request.getAttribute("flagExists") != null) {
        isExists = (boolean) request.getAttribute("flagExists");
    }
%>

<% if (isExists) { %>
<div class="modal">
    <div class="modal-content">
        <h3>Ошибка</h3>
        <p>Команда с таким названием существует</p>
        <button class="button modal-button rounded-button" onclick="closeModal()">OK</button>
    </div>
</div>
<% } %>

<% if (!flag) { %>
<div class="new-title">
    Создание команды
</div>
<form action="controller?command=create_new_team" method="GET">
    <div class="new-container">
        <div class="new-form-group">
            <label for="name" class="form-label">Название:</label>
            <div class="form-input-wrapper">
                <input type="text" id="name" name="name" required class="form-input rounded">
            </div>
            <div class="new-button-group">
                <input type="hidden" name="command" value="create_new_team">
                <button type="submit" class="button register-button rounded-button">Создать</button>
            </div>
        </div>
    </div>
</form>
<% } else { %>
<div class="new-title">
    У вас уже есть команда. Покиньте её, если хотите создать новую.
</div>
<% } %>
<script>
    function closeModal() {
        var modal = document.querySelector(".modal");
        modal.style.display = "none";
    }
</script>
</body>
</html>