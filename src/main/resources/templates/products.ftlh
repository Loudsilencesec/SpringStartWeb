<!DOCTYPE html>
<html>
<head>
    <title>LOudi</title>
</head>
<body>
<h1>ПИТЕРСКИЙ АУКЦИОН ИССКУСТВ</h1><hr>
<h4>Товары со всей России</h4>
<form action="/" method="get">
    Поиск по название Обявления: <input type="text" name="title"><br>
    <input type="submit" value="Поиск"/>
</form>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} руб. | <a href="/product/${product.id}">Подробнее...</a></p>
    </div>
    <#else>
    <h3>Товаров нет</h3>
</#list>
<hr>
<h3>Создать новый товар</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
    Название объявления: <input type="text" name="title"/><br><br>
    Описание объявления: <input type="text" name="description"/><br><br>
    Цена: <input type="number" name="price"/><br><br>
    Город: <input type="text" name="city"/><br><br>
    Имя: <input type="text" name="author"/><br><br>
    Первая фотограя: <input type="file" name="file1"><br><br>
    Вторая фотограя: <input type="file" name="file2"><br><br>
    Третья фотограя: <input type="file" name="file3"><br><br>
    <input type="submit" value="Добавить товар"/>
</form>
</body>
</html>