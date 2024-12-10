<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Контент не найден</title>
  <link href="styles/registration/registration-styles.css" rel="stylesheet" type="text/css">
  <link rel="icon" href="D:\tournament.png" type="image/png">
</head>
<body>
<div class="container">
  <p class="centered title">Ошибка 404: страниц нет</p>
  <form action="controller?command=main" method="GET">
    <div class="form-group">
      <div class="button-group">
        <input type="hidden" name="command" value="main">
        <button type="submit" class="button register-button rounded-button">ОК</button>
      </div>
    </div>
  </form>
</div>
</body>
</html>
