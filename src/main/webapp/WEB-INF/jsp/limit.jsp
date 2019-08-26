<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet">
    <title>Установка лимита заявок</title>
</head>
<body>
<h3>Лимит заявок в минуту для страны:</h3>
<div class="desc">
    Страна<br>
    Лимит<br>
</div>
<spring:form modelAttribute="country" method="post" action="/limit" class="form">
    <select name="countryName">
        <c:forEach var="country" items="${countries}">
            <option>${country.countryName}</option>
        </c:forEach>
    </select><br>
    <input name="ordersPerMinute" type="text"><br>
    <br>
    <input type="submit" value="Установить лимит">
</spring:form>
</body>
</html>
