<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.rsreu.lint.expertsandteams.Datalayer.DTO.User.QuestionAnswerDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Консультация</title>
    <link href="styles/main/user-main-styles.css" rel="stylesheet" type="text/css">
    <link rel="icon" href="D:\tournament.png" type="image/png">
    <style>

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

        .table-container {
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

        .textarea-container {
            margin-top: 3px;
            text-align: center;
        }

        textarea {
            width: 80%;
            height: 80px;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            resize: none;
            font-size: 16px;
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
            <td><%= list.get(i).getQuestion() %>
            </td>
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
            <td><%= list.get(i).getAnswer() %>
            </td>
            <td>Вы уже ответили на этот вопрос</td>
            <% } %>
        </tr>
        <% } %>
        </tbody>
        <% } %>
    </table>
</div>
<script>
    document.getElementById("answerForm").addEventListener("submit", function (event) {
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