<!DOCTYPE html>
<html>
<head>
    <title>LOudi</title>
</head>
<body>
<h1>ПИТЕРСКИЙ АУКЦИОН ИССКУСТВ</h1><hr>
<h4>Подробная информация о товаре</h4>
<#list image as img>
    <img src="/images/${img.id}" height="300px"/><br><br>
</#list>
<b>Название товара: </b>${product.title}<br>
<b>Описание товара: </b>${product.description}<br>
<b>Цена: </b>${product.price}<br>
<b>Город: </b>${product.city}<br>
<b>Автор: </b>${product.user.name}<br>
<b>Номер телефона продавца: </b>${product.user.phoneNumber}<br>
</body>
</html>