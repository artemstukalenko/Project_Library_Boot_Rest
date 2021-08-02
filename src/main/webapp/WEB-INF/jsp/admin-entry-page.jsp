<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<body>

<h2>${locale.usersListString}</h2>

<br><br><br>

<table>
    <tr>
        <th>Username</th>
    </tr>

    <c:forEach var="user" items="${allUsers}">

        <tr>
            <td>${user.username}</td>
        </tr>

    </c:forEach>
</table>

<form:form action="." modelAttribute="locale">

    <input type="submit" value="${locale.toHomePage}"/>

</form:form>

</body>

</html>