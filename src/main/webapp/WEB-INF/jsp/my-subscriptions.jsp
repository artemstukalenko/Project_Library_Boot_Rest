<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>

<h2>Your subscriptions:</h2>

<table border="1">
    <tr>
        <th>Book ID</th>
        <th>Start of the period</th>
        <th>End of the period</th>
        <th>Is expired</th>
        <th></th>
    </tr>

    <c:forEach var="subscription" items="${userSubscriptionList}">

        <c:url var="returnBookButton" value="/returnBook">
            <c:param name="subscriptionId" value="${subscription.subscriptionId}"/>
        </c:url>

        <tr>
            <td>${subscription.bookId}</td>
            <td>${subscription.startOfThePeriod}</td>
            <td>${subscription.endOfThePeriod}</td>
            <td>${subscription.expired}</td>

            <td>
                <input type="button" value="return book" onclick="window.location.href = '${returnBookButton}'">
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