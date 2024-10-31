<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Команды</title>
    <link href="styles/authentication/authentication-styles.css" rel="stylesheet" type="text/css">
    <link href="styles/main/user-main-styles.css" rel="stylesheet" type="text/css">
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
        <form action="controller?command=teams-statistic" method="GET">
            <input type="hidden" name="command" value="teams-statistic">
            <button type="submit" class="button login-button rounded-button">Статистика команд</button>
        </form>
        <form action="controller?command=experts-statistic" method="GET">
            <input type="hidden" name="command" value="experts-statistic">
            <button type="submit" class="button login-button rounded-button">Статистика экспертов</button>
        </form>
        <form action="controller?command=logout" method="GET">
            <input type="hidden" name="command" value="logout">
            <button type="submit" class="button login-button rounded-button">Выйти</button>
        </form>
    </div>
    <div class="container">
        <p class="centered title">Действия с пользователями:</p>


        <form action="controller?command=create-user" method="GET">
            <p class="centered title">Действия с пользователями:</p>
            <div class="form-group">
                <label for="login" class="form-label">Логин:</label>
                <div class="form-input-wrapper">
                    <input type="text" id="login" name="login" required class="form-input rounded">
                </div>
            </div>
            <input type="hidden" name="command" value="create-user">
            <div class="button-group">
                <button type="submit" class="button login-button rounded-button">Создать</button>
            </div>
        </form>
    </div>
</body>
</html>
