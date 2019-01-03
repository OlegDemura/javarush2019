<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Олег Демура
  Date: 01.01.2019
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>" type="text/css"/>
    <title>Компьютерные комплектующие</title>
</head>
<body>
<p><a href="/parts/part/">Создать новую запись</a></p>
<p><a href="/parts/">Все детали</a>   <a href="/parts/sort/?parts=true">Детали для сборки</a>     <a href="/parts/sort/?parts=false">Опциональные детали</a></p>
<form action="/parts/search/">
    <input type="search" name="searchByName"/>
    <input type="submit" value="Искать">
</form>
<table>
    <thead>
    <tr>
        <td>Id</td>
        <td>Название</td>
        <td>Комплектующее</td>
        <td>Количество</td>
        <td>Необходимость</td>
        <td>Редактировать</td>
        <td>Удалить</td>
    </tr>
    </thead>
    <tbody>
    <c:if test="${!empty partList}">
        <c:forEach var="partList" items="${partList}">
            <tr>
                <td>${partList.id}</td>
                <td>${partList.deviceTitle}</td>
                <td>${partList.deviceName}</td>
                <td>${partList.amount}</td>
                <td><c:choose>
                    <c:when test="${partList.nessesery}">
                        <input type="checkbox" checked disabled>
                    </c:when>
                    <c:when test="${!partList.nessesery}">
                        <input type="checkbox" disabled>
                    </c:when>
                </c:choose></td>
                <td><a href="<c:url value="/parts/part/${partList.id}"/>">Редактировать</a></td>
                <td><a href="<c:url value="/parts/remove/${partList.id}"/>">Удалить</a></td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>

<p>Можно собрать ${count} компьютеров.</p>
<c:if test="${maxPages>1}">
    <div class="pagination">
        <c:forEach begin="0" end="${maxPages-1}" varStatus="maxPagesCount">
            <a href="<c:out value="/parts/?page=${maxPagesCount.count-1}"/>">${maxPagesCount.count}</a>
        </c:forEach>
    </div>
</c:if>
</body>
</html>