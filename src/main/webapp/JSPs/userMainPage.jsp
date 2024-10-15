<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Команды</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 20px;
        }

        .header {
            background-color: #4CAF50;
            color: white;
            padding: 15px;
            display: flex;
            justify-content: space-around;
            align-items: center;
        }

        .header a {
            color: white;
            text-decoration: none;
            font-weight: bold;
            padding: 10px 15px;
            margin: 0 5px;
            transition: background-color 0.3s ease;
        }

        .header a:hover {
            background-color: #45a049;
        }

        .team-card {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin: 20px auto;
            width: 800px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .team-card h2 {
            margin: 0 0 10px;
        }

        .team-card p {
            margin: 5px 0;
        }

        .team-card button {
            padding: 20px 30px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .team-card .join-button {
            background-color: #4CAF50;
            color: white;
            border: none;
        }

        .team-card .leave-button {
            background-color: red;
            color: white;
            border: none;
        }

        .team-card button:hover {
            opacity: 0.9;
        }
    </style>
</head>
<body>

<div class="header">
    <a href="main">Список команд</a>
    <a href="my-team">Моя команда</a>
    <a href="profile">Профиль</a>
    <a href="logout">Выйти</a>
</div>

<div class="container">
    <div class="team-card">
        <div>
            <h2>Название команды</h2>
            <p>Капитан: логин</p>
            <p>Эксперт: логин</p>
            <p>Участников: 1/n</p>
        </div>
        <button class="join-button">Войти</button>
    </div>

    <div class="team-card">
        <div>
            <h2>Название команды</h2>
            <p>Капитан: логин</p>
            <p>Эксперт: логин</p>
            <p>Участников: 1/n</p>
        </div>
        <button class="leave-button">Выйти</button>
    </div>
</div>

</body>
</html>
