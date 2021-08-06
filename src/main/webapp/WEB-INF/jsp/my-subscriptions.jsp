<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>

<h2>Your subscriptions:</h2>

<table border="1">
    <tr>
        <th>Subscription ID</th>
        <th>Book ID</th>
        <th>Start of the period</th>
        <th>End of the period</th>
        <th>Is expired</th>
    </tr>

    <c:forEach var="subscription" items="${userSubscriptionList}">

        <tr>
            <td>${subscription.subscriptionId}</td>
            <td>${subscription.bookId}</td>
            <td>${subscription.startOfThePeriod}</td>
            <td>${subscription.endOfThePeriod}</td>
            <td>${subscription.expired}</td>
        </tr>


    </c:forEach>

</table>

</body>

</html>