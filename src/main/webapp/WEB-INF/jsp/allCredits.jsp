<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet">
    <title>Список всех кредитов</title>
</head>
<body>
<table>
    <thead>
        <tr>
            <td>id</td>
            <td>Сумма</td>
            <td>Срок</td>
            <td>id клиента</td>
            <td>Имя клиента</td>
            <td>Фамилия клиента</td>
            <td>Страна подачи завки</td>
            <td>Лимит заявок в минуту</td>
        </tr>
    </thead>
    <for:forEach var="credit" items="${credits}">
        <tr>
            <td>${credit.idCredit}</td>
            <td>${credit.sum}</td>
            <td>${credit.term}</td>
            <td>${credit.client.idClient}</td>
            <td>${credit.client.name}</td>
            <td>${credit.client.surname}</td>
            <td>${credit.country.countryName}</td>
            <td>${credit.country.ordersPerMinute == 0 ? "" : credit.country.ordersPerMinute}</td>
        </tr>
    </for:forEach>
</table>
</body>
</html>
