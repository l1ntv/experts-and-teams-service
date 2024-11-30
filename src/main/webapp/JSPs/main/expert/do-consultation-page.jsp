<%@ page import="ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.ConsultingTeamDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.rsreu.lint.expertsandteams.Datalayer.DTO.Expert.TeamConsultationRequestDTO" %>
<%@ page import="ru.rsreu.lint.expertsandteams.Datalayer.DTO.QuestionAnswerDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Консультируемые команды</title>
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

    .table-container {
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

    .title-info {
      font-size: 20px;
      font-weight: normal;
      margin-top: 30px;
      margin-bottom: 0px;
      text-align: left; /* Выравнивание текста по центру */
      margin-left: 50px;
    }

    .textarea-container {
      margin-top: 3px; /* Отступ сверху для текстового поля */
      text-align: center; /* Центрируем текстовое поле */
    }

    textarea {
      width: 80%; /* Ширина текстового поля */
      height: 80px; /* Высота текстового поля */
      padding: 10px; /* Отступ внутри текстового поля */
      border-radius: 5px; /* Скругление углов */
      border: 1px solid #ccc; /* Граница текстового поля */
      resize: none; /* Запрет на изменение размера текстового поля */
      font-size: 16px; /* Увеличенный размер шрифта */
    }
  </style>
</head>
<body>
<div class="new-header">
  <form action="controller?command=main" method="GET">
    <input type="hidden" name="command" value="main">
    <button type="submit" class="button login-button rounded-button">Консультируемые команды</button>
  </form>
  <form action="controller?command=consultations_requests" method="GET">
    <input type="hidden" name="command" value="consultations_requests">
    <button type="submit" class="button login-button rounded-button">Запросы на консультацию</button>
  </form>
  <form action="controller?command=logout" method="GET">
    <input type="hidden" name="command" value="logout">
    <button type="submit" class="button login-button rounded-button">Выйти</button>
  </form>
</div>

<div class="table-container">
  <table>
    <thead>
    <tr>
      <th>Вопрос команды</th>
      <th>Ваш ответ</th>
      <th>Ответить</th>
    </tr>
    </thead>
    <% if (request.getAttribute("questionsAnswers") != null) { %>
    <tbody>
    <% List<QuestionAnswerDTO> list = (ArrayList) request.getAttribute("questionsAnswers");%>
    <% for (int i = 0; i < list.size(); i++) { %>
    <tr>
      <td><%= list.get(i).getQuestion() %></td>
      <% if (list.get(i).getAnswer().equals(" ")) { %>
        <td>
          <div class="textarea-container">
            <textarea id="answerInput" placeholder="Введите ваш ответ..."></textarea>
          </div>
          <td>
            <form id="answerForm" action="controller?command=answer_to_question" method="GET">
              <input type="hidden" name="consultationId" value="<%= list.get(i).getConsultationId() %>">
              <input type="hidden" name="command" value="answer_to_question">
              <input type="hidden" name="question" value="<%= list.get(i).getQuestion() %>">
              <input type="hidden" name="answer" id="hiddenAnswer" value="">
              <button type="submit" class="leave-button">Ответить</button>
            </form>
          </td>
        </td>
      <% } else { %>
        <td><%= list.get(i).getAnswer() %></td>
        <td>Вы уже ответили на этот вопрос</td>
      <% } %>
    </tr>
    <% } %>
    </tbody>
    <% } %>
  </table>
</div>
<script>
  document.getElementById("answerForm").addEventListener("submit", function(event) {
    var question = document.getElementById("answerInput").value;
    document.getElementById("hiddenAnswer").value = question;
    if (!question) {
      event.preventDefault();
      alert("Пожалуйста, введите ответ.");
    }
  });
</script>
</body>
</html>
