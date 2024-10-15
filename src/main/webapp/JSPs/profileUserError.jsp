<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Редактирование</title>
<link href="styles/styles.css" rel="stylesheet" type="text/css">
<link rel="icon" href="D:\tournament.png" type="image/png">
</head>
<body>
	<div class="modal">
		<div class="modal-content">
			<h3>Ошибка</h3>
			<p>Данный email занят.</p>
			<button class="button modal-button rounded-button"
				onclick="closeModal()">OK</button>
		</div>
	</div>
	<div class="container">
		<p class="centered title">Редактирование профиля</p>

		<form action="settings" method="POST">
			<div class="form-group">
				<label for="name" class="form-label">Имя:</label>
				<div class="form-input-wrapper">
					<input type="text" id="name" name="name" required
						class="form-input rounded">
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="form-label">Email:</label>
				<div class="form-input-wrapper">
					<input type="email" id="email" name="email" required
						class="form-input rounded">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="form-label">Пароль:</label>
				<div class="form-input-wrapper">
					<input type="password" id="password" name="password" required
						class="form-input rounded">
				</div>
			</div>
			<div class="button-group">
				<button type="submit" class="button register-button rounded-button">Сохранить
					изменения</button>
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