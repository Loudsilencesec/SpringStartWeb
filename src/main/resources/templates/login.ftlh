<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>LoudSell</title>
</head>
<body>
<h1>LoudSell</h1>
<h4>Авторизация</h4>
<form action="/login" method="post">
    Эл.Почта: <input type="email" name="username"><br><br>
    Пароль: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" name="Вход"/>
</form>
<a href="/registration">Зарегистрироваться</a>
</body>
</html>