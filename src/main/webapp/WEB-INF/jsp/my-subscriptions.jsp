<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<body>

<h2>${locale.yourSubscriptions}</h2>

<table border="1">
    <tr>
        <th>${locale.bookId}</th>
        <th>${locale.bookTitle}</th>
        <th>${locale.bookAuthor}</th>
        <th>${locale.startOfThePeriod}</th>
        <th>${locale.endOfThePeriod}</th>
        <th>${locale.isExpired}</th>
        <th></th>
    </tr>

    <c:forEach var="subscription" items="${userSubscriptionList}">

        <c:url var="returnBookButton" value="/returnBook">
            <c:param name="subscriptionId" value="${subscription.subscriptionId}"/>
        </c:url>

        <tr>
            <td>${subscription.bookId}</td>
            <td>${subscription.title}</td>
            <td>${subscription.author}</td>
            <td>${subscription.startOfThePeriod}</td>
            <td>${subscription.endOfThePeriod}</td>
            <td>${subscription.expired}</td>

            <td>
                <input type="button" value="${locale.returnBook}" onclick="window.location.href = '${returnBookButton}'">
            </td>
        </tr>


    </c:forEach>

</table>

<br><br>

<form:form action="/homepage_again" modelAttribute="locale">

    <input type="submit" value="${locale.toHomePage}"/>

</form:form>

</body>

</html>