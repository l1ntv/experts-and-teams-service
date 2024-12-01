<%@ page import="ru.rsreu.lint.expertsandteams.Datalayer.DTO.Administrator.UserDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Команды</title>
  <link href="styles/authentication/authentication-styles.css" rel="stylesheet" type="text/css">
  <link href="styles/main/administrator-auth-user-styles.css" rel="stylesheet" type="text/css">
  <link href="styles/main/user-main-styles.css" rel="stylesheet" type="text/css">
  <link href="styles/main/authUsers.css" rel="stylesheet" type="text/css"> <!-- Подключаем новый CSS файл -->
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
<% Boolean isUserBanned = (Boolean) request.getAttribute("isUserBanned"); %>
<% if ((isUserBanned != null) && (isUserBanned)) { %>
<div class="modal">
  <div class="modal-content">
    <h3>Информация</h3>
    <p>Пользователь заблокирован</p>
    <button class="button modal-button rounded-button"
            onclick="closeModal()">OK</button>
  </div>
</div>
<% } %>
<% Boolean isUserUnbanned = (Boolean) request.getAttribute("isUserUnbanned"); %>
<% if ((isUserUnbanned != null) && (isUserUnbanned)) { %>
<div class="modal">
  <div class="modal-content">
    <h3>Информация</h3>
    <p>Пользователь разблокирован</p>
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
<div class="title">Список заблокированных пользователей</div>
<div class="table-container">
  <table>
    <thead>
    <tr>
      <th>Логин</th>
      <th>Тип аккаунта</th>
    </tr>
    </thead>
    <tbody>
      <% if (request.getAttribute("bannedUsers") != null) { %>
      <% List<UserDTO> list = (ArrayList) request.getAttribute("bannedUsers");%>
      <% for (int i = 0; i < list.size(); i++) { %>
      <tr>
        <td><%= list.get(i).getLogin() %></td>
        <td><%= list.get(i).getAccountType().toString() %></td>
      </tr>
      <% } %>
      <% } %>
    </tbody>
  </table>
</div>
<script>
  function closeModal() {
    var modal = document.querySelector(".modal");
    modal.style.display = "none";
  }
</script>
</body>
</html>
