<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Авторизация</title>
        <link href="styles/authentication/authentication-error-styles.css" rel="stylesheet" type="text/css">
        <link rel="icon" href="D:\tournament.png" type="image/png">
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
        <div class="container">
            <p class="centered title">Веб-сервис "Эксперты и команды"</p>
            <form action="controller" method="POST">
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
                <input type="hidden" name="command" value="login">
                <div class="button-group">
                    <p><button type="submit" class="button login-button rounded-button">Войти</button></p>
                </div>
            </form>
        </div>
        <script>
            function closeModal() {
                var modal = document.querySelector(".modal");
                modal.style.display = "none";
            }
        </script>
    </body>
</html>



