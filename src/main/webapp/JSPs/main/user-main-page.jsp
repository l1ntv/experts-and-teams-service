<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Команды</title>
    <link href="styles/main/user-main-styles.css" rel="stylesheet" type="text/css">
    <link rel="icon" href="D:\tournament.png" type="image/png">
</head>
<body>
    <div class="header">
        <form action="controller" method="POST">
            <input type="hidden" name="command" value="main">
            <button type="submit" class="button login-button rounded-button">Cписок команд</button>
        </form>
        <a href="my-team">Моя команда</a>
        <a href="profile">Профиль</a>
        <form action="controller" method="POST">
            <input type="hidden" name="command" value="logout">
            <button type="submit" class="button login-button rounded-button">Выйти</button>
        </form>
    </div>
</body>
</html>
