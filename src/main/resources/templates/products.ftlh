<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="../static/css/style.css" th:href="@{/css/style.css}">
    <title>LOudi</title>
</head>
<body>
<div class="page-header">
    <div>1</div>
    <h1>Хуй</h1>
    <#if user.email??>
        <div>
            <h3>Имя пользователя: <i>${user.name}</i></h3>
            <form action="/logout" method="post">
                <div><input type="hidden" name="_csrf" value="${_csrf.token}"></div>
                <div><input type="submit" value="Выйти"/></div>
            </form>
            <#if user.isAdmin()>
                <a href="/admin">Панель Администратора</a>
            </#if>
        </div>
    <#else>
        <a href="/login">Войти</a> </h1><hr>
    </#if>
</div>
<h4>Товары со всей России</h4>
<div>
    <form action="/" method="get">
        <div>Поиск по название Обявления: <input type="text" name="title"></div>
        <input type="submit" value="Поиск"/>
    </form>
</div>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} руб. | <a href="/product/${product.id}">Подробнее...</a></p>
    </div>
    <#else>
    <h3>Товаров нет</h3>
</#list>
<#if user.email??>
<hr>
<h3>Создать новый товар</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
    <div class="form-control">
        <label for="title">Название Объявления:</label>
        <input type="text" id="title" name="title"/>
    </div>
    <div class="form-control">
        <label for="description">Описание объявления:</label>
        <input type="text" id="description" name="description"/>
    </div>
    <div class="form-control">
        <label for="description">Описание объявления:</label>
        <input type="text" id="description" name="description"/>
    </div>
    <div class="form-control">
        <label for="price">Цена:</label>
        <input type="number" id="price" name="price"/>
    </div>
    <div class="form-control">
        <label for="city">Город:</label>
        <input type="text" id="city" name="city"/>
    </div>
    <div class="form-control">
        <label for="file1">Первая фотограя: </label>
        <input type="file" id="file1" name="file1"/>
    </div>
    <div class="form-control">
        <label for="file2">Вторая фотограя: </label>
        <input type="file" id="file2" name="file2"/>
    </div>
    <div class="form-control">
        <label for="file3">Третья фотограя: </label>
        <input type="file" id="file3" name="file3"/>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить товар"/>
</form>
</#if>
</body>
</html>