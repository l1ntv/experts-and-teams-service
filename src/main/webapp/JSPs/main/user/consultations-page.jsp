<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.rsreu.lint.expertsandteams.Datalayer.DTO.TeamDTO" %>
<%@ page import="ru.rsreu.lint.expertsandteams.Datalayer.DTO.MyTeamDTO" %>
<%@ page import="ru.rsreu.lint.expertsandteams.Enums.TeamRoleEnum" %>
<%@ page import="ru.rsreu.lint.expertsandteams.Datalayer.DTO.ExpertsStatisticsDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.rsreu.lint.expertsandteams.Datalayer.DTO.QuestionAnswerDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Команды</title>

    <link href="styles/main/user-main-styles.css" rel="stylesheet" type="text/css">
    <link href="styles/main/administrator-auth-user-styles.css" rel="stylesheet" type="text/css">
    <link rel="icon" href="D:\tournament.png" type="image/png">
    <style>
        .new-title {
            font-size: 24px;
            font-weight: bold;
            margin-top: 30px;
            margin-bottom: 30px;
            text-align: center; /* Выравнивание текста по центру */
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

        .button-container {
            display: flex; /* Используем flexbox */
            justify-content: center; /* Центрируем кнопки по горизонтали */
            gap: 10px; /* Задаем расстояние между кнопками */
            padding-top: 30px;
        }

        .expert-info {
            font-size: 20px;
            font-weight: normal;
            margin-top: 30px;
            margin-bottom: 0px;
            text-align: left; /* Выравнивание текста по центру */
            margin-left: 50px;
        }

        .textarea-container {
            margin-top: 20px; /* Отступ сверху для текстового поля */
            text-align: center; /* Центрируем текстовое поле */
        }

        textarea {
            width: 80%; /* Ширина текстового поля */
            height: 100px; /* Высота текстового поля */
            padding: 10px; /* Отступ внутри текстового поля */
            border-radius: 5px; /* Скругление углов */
            border: 1px solid #ccc; /* Граница текстового поля */
            resize: none; /* Запрет на изменение размера текстового поля */
            font-size: 20px; /* Увеличенный размер шрифта */
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

<% if (session.getAttribute("isTeamAlreadySentRequest") != null) {
    boolean isTeamAlreadySentRequest = (boolean) session.getAttribute("isTeamAlreadySentRequest");
    if (isTeamAlreadySentRequest) { %>
<div class="modal">
    <div class="modal-content">
        <h3>Ошибка</h3>
        <p>Ваша команда уже отправляла заявку на консультацию этому эксперту. Дождитесь его ответа</p>
        <button class="button modal-button rounded-button" onclick="closeModal()">OK</button>
    </div>
</div>
<% session.setAttribute("isTeamAlreadySentRequest", false); %>
<% }
} %>

<% if (session.getAttribute("isQuestionAsked") != null) {
    boolean isQuestionAsked = (boolean) session.getAttribute("isQuestionAsked");
    if (isQuestionAsked) { %>
<div class="modal">
    <div class="modal-content">
        <h3>Информация</h3>
        <p>Ваш вопрос успешно отправлен</p>
        <button class="button modal-button rounded-button" onclick="closeModal()">OK</button>
    </div>
</div>
<% session.setAttribute("isQuestionAsked", false); %>
<% }
} %>

<%boolean myTeam = (boolean) request.getAttribute("myTeam");%>
<div class="new-title">Консультации</div>
<% if (myTeam) { %>
    <%boolean isCaptain = (boolean) request.getAttribute("isCaptain");%>
    <%boolean isTeamHasExpert = (boolean) request.getAttribute("isTeamHasExpert");%>
    <% if (isCaptain) { %>
        <% if (isTeamHasExpert) { %>
            <%ExpertsStatisticsDTO expertsStatisticsDTO = (ExpertsStatisticsDTO) request.getAttribute("expertsStatisticsDTO"); %>
            <div class="new-title">Эксперт команды</div>
            <% if (expertsStatisticsDTO != null) { %>
            <div class="expert-info">
                Логин эксперта: <%= expertsStatisticsDTO.getLogin() %>
            </div>
            <div class="expert-info">
                Количество консультируемых команд: <%= expertsStatisticsDTO.getTeamCount() %>
            </div>
            <div class="expert-info">
                Максимальное количество консультируемых команд: <%= expertsStatisticsDTO.getMaxTeamCount() %>
            </div>
            <div class="textarea-container">
                <textarea id="questionInput" placeholder="Введите ваш вопрос..."></textarea>
            </div>
            <div class="button-container">
                <div class="form-input-wrapper">
                    <form id="questionForm" action="controller?command=ask_question" method="GET">
                        <input type="hidden" name="command" value="ask_question">
                        <input type="hidden" name="question" id="hiddenQuestion" value="">
                        <button type="submit" class="button login-button rounded-button" id="submit">Задать вопрос</button>
                    </form>
                </div>
                <div class="form-input-wrapper">
                    <form action="controller?command=user_cancel_consultation" method="GET">
                        <input type="hidden" name="command" value="user_cancel_consultation">
                        <button type="submit" class="button login-button rounded-button">Отказаться от эксперта</button>
                    </form>
                </div>
            </div>
            <div class="table-container">
                <table>
                    <thead>
                    <tr>
                        <th>Вопрос команды</th>
                        <th>Ответ эксперта</th>
                    </tr>
                    </thead>
                    <% if (request.getAttribute("questionsAnswers") != null) { %>
                        <tbody>
                        <% List<QuestionAnswerDTO> list = (ArrayList) request.getAttribute("questionsAnswers");%>
                        <% for (int i = 0; i < list.size(); i++) { %>
                            <tr>
                                <td><%= list.get(i).getQuestion() %></td>
                                <td><%= list.get(i).getAnswer() %></td>
                            </tr>
                        <% } %>
                        </tbody>
                    <% } %>
                </table>
            </div>
            <% } %>
        <% } else { %>
            <%List<ExpertsStatisticsDTO> list = (ArrayList) request.getAttribute("listAvailableExperts"); %>
            <div class="table-container">
                <table>
                    <thead>
                    <tr>
                        <th>Логин</th>
                        <th>Количество команд</th>
                        <th>Макс. количество команд</th>
                        <th>Запрос консультации</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% for (int i = 0; i < list.size(); i++) { %>
                    <tr>
                        <td><%= list.get(i).getLogin() %>
                        </td>
                        <td><%= list.get(i).getTeamCount() %>
                        </td>
                        <td><%= list.get(i).getMaxTeamCount() %>
                        </td>
                        <td>
                            <form action="controller?command=request_consultation" method="GET">
                                <input type="hidden" name="expertLogin" value="<%= list.get(i).getLogin() %>">
                                <input type="hidden" name="command" value="request_consultation">
                                <button type="submit" class="leave-button">Запросить</button>
                            </form>
                        </td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        <% } %>
    <% } else { %>
        <% if (isTeamHasExpert) { %>
            <%ExpertsStatisticsDTO expertsStatisticsDTO = (ExpertsStatisticsDTO) request.getAttribute("expertsStatisticsDTO"); %>
            <% if (expertsStatisticsDTO != null) { %>
            <div class="expert-info">
                Логин эксперта: <%= expertsStatisticsDTO.getLogin() %>
            </div>
            <div class="expert-info">
                Количество консультируемых команд: <%= expertsStatisticsDTO.getTeamCount() %>
            </div>
            <div class="expert-info">
                Максимальное количество консультируемых команд: <%= expertsStatisticsDTO.getMaxTeamCount() %>
            </div>
            <div class="table-container">
                <table>
                    <thead>
                    <tr>
                        <th>Вопрос команды</th>
                        <th>Ответ эксперта</th>
                    </tr>
                    </thead>
                    <% if (request.getAttribute("questionsAnswers") != null) { %>
                    <tbody>
                    <% List<QuestionAnswerDTO> list = (ArrayList) request.getAttribute("questionsAnswers");%>
                    <% for (int i = 0; i < list.size(); i++) { %>
                    <tr>
                        <td><%= list.get(i).getQuestion() %></td>
                        <td><%= list.get(i).getAnswer() %></td>
                    </tr>
                    <% } %>
                    </tbody>
                    <% } %>
                </table>
            </div>
            <% } %>
        <% } else { %>
            <div class="title">У вашей команды нет эксперта, дождитесь пока ваш капитан выберет его</div>
        <% } %>
    <% } %>
<% } else { %>
<div class="title">У вас нет команды</div>
<div class="button-container">
    <div class="form-input-wrapper">
        <form action="controller?command=main" method="GET">
            <input type="hidden" name="command" value="main">
            <button type="submit" class="button login-button rounded-button">Найти</button>
        </form>
    </div>
    <div class="form-input-wrapper">
        <form action="controller?command=create_team" method="GET">
            <input type="hidden" name="command" value="create_team">
            <button type="submit" class="button login-button rounded-button">Создать</button>
        </form>
    </div>
</div>
<% } %>
<script>
    function closeModal() {
        var modal = document.querySelector(".modal");
        modal.style.display = "none";
    }
    document.getElementById("questionForm").addEventListener("submit", function(event) {
        var question = document.getElementById("questionInput").value;
        document.getElementById("hiddenQuestion").value = question;
        if (!question) {
            event.preventDefault();
            alert("Пожалуйста, введите вопрос.");
        }
    });
</script>
</body>
</html>
