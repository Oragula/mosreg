<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet">
    <title>Заявка на кредит</title>
</head>
<body>
    <h3>Заявка на кредит:</h3>
    <div class="desc">
        Сумма кредита, рубли<br>
        Срок кредита, месяцы<br>
        Имя<br>
        Фамилия<br>
        Личный идентификатор<br>
        Страна<br>
    </div>
    <div class="form">
    <spring:form modelAttribute="order; client; country" method="post" action="/">
        <input name="sum" type="text"><br>
        <input name="term" type="text"><br>
        <input name="name" type="text"><br>
        <input name="surname" type="text"><br>
        <input name="idClient" type="text"><br>
        <select name="countryName">
            <c:forEach var="country" items="${countries}">
                <option>${country.countryName}</option>
            </c:forEach>
        </select><br>
        <br>
        <input type="submit" value="Запросить кредит">
    </spring:form>

    </div>
</body>
</html>
