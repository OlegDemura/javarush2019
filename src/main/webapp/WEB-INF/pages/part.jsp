<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Олег Демура
  Date: 01.01.2019
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>" type="text/css"/>
    <title><c:if test="${!empty part.deviceTitle}">${part.deviceTitle}</c:if></title>
</head>
<body>
<p><a href="/parts/">Назад</a></p>
<c:url var="addAction" value="/parts/part/add"/>
<form:form action="${addAction}" modelAttribute="part">
    <table>
        <c:if test="${!empty part.id}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="deviceTitle">
                    <spring:message text="Название"/>
                </form:label>
            </td>
            <td>
                <form:input path="deviceTitle"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="deviceName">
                    <spring:message text="Комплектующее"/>
                </form:label>
            </td>
            <td>
                <form:input path="deviceName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="amount">
                    <spring:message text="Количество"/>
                </form:label>
            </td>
            <td>
                <form:input path="amount"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="nessesery">
                    <spring:message text="Необходимость при сборке"/>
                </form:label>
            </td>
            <td>
                <form:checkbox path="nessesery"/>
            </td>
        </tr>
        <tr>
            <td>
                <c:if test="${!empty part.deviceTitle}">
                    <input type="submit" value="<spring:message text="Редактировать"/>"/>
                </c:if>
                <c:if test="${empty part.deviceTitle}">
                    <input type="submit" value="<spring:message text="Добавить"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
    <form:errors path="deviceName" cssClass="errors"/>
    <form:errors path="deviceTitle" cssClass="errors"/>
    <form:errors path="amount" cssClass="errors"/>
</form:form>
</body>
</body>
</html>