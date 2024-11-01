<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Авторизация</title>
    <link href="styles/registration/registration-styles.css" rel="stylesheet" type="text/css">
    <link rel="icon" href="styles/icon.png" type="image/png">
</head>
<body>
<div class="container">
    <p class="centered title">Веб-сервис "Эксперты и команды"</p>
    <form action="controller?command=login" method="GET">
        <div class="form-group">
            <label for="login" class="form-label">Логин:</label>
            <div class="form-input-wrapper">
                <input type="text" id="login" name="login" required class="form-input rounded">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="form-label">Пароль:</label>
            <div class="form-input-wrapper">
                <input type="password" id="password" name="password" required class="form-input rounded">
            </div>
        </div>
        <div class="form-group">
            <div class="button-group">
                <input type="hidden" name="command" value="login">
                <button type="submit" class="button register-button rounded-button">Авторизация</button>
            </div>
        </div>
    </form>
    <form action="controller?command=login_to_registration" method="GET">
        <div class="button-new-group">
            <p>
                <input type="hidden" name="command" value="login_to_registration">
                <button type="submit" class="button login-button rounded-button">Регистрация</button>
                <label>Нет учётной записи?</label>
            </p>
        </div>
    </form>
</div>
</body>
</html>

