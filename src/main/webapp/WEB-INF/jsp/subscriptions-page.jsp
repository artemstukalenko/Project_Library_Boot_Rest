<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<body>

<h2>${locale.subscriptionsListString}</h2>

<br><br><br>

<table border="1">

    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Book ID</th>
        <th>Start date</th>
        <th>End date</th>
        <th>Is expired</th>
    </tr>

    <c:forEach var="subscription" items="${allSubscriptions}">

        <tr>
            <td>${subscription.subscriptionId}</td>
            <td>${subscription.username}</td>
            <td>${subscription.bookId}</td>
            <td>${subscription.startOfThePeriod}</td>
            <td>${subscription.endOfThePeriod}</td>
            <td>${subscription.expired}</td>
        </tr>

    </c:forEach>

</table>

<br><br><br>
<form:form action="/homepage_again" modelAttribute="locale">

    <input type="submit" value="${locale.toHomePage}"/>

</form:form>

</body>

</html>