<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Авторизация</title>
    <link href="styles/registration/registration-styles.css" rel="stylesheet" type="text/css">
    <link rel="icon" href="D:\tournament.png" type="image/png">
    <style>
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
<c:if test="${not empty requestScope.isBanned}">
    <c:set var="isBanned" value="${requestScope.isBanned}" />
    <c:if test="${isBanned}">
        <div class="modal">
            <div class="modal-content">
                <h3>Ошибка</h3>
                <p>Ваш аккаунт был заблокирован</p>
                <button class="button modal-button rounded-button"
                        onclick="closeModal()">OK
                </button>
            </div>
        </div>
    </c:if>
</c:if>
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
    <form action="controller?command=redirect_to_registration" method="GET">
        <div class="form-group">
            <div class="button-group">
                <input type="hidden" name="command" value="redirect_to_registration">
                <button type="submit" class="button register-button rounded-button">Регистрация</button>
            </div>
        </div>
    </form>
</div>
</body>
<script>
    function closeModal() {
        var modal = document.querySelector(".modal");
        modal.style.display = "none";
    }
</script>
</html>