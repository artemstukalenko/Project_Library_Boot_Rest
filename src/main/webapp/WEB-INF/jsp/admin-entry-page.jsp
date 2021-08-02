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
        <th>${locale.usernameTableHeader}</th>
        <th>${locale.statusTableHeader}</th>
    </tr>

    <c:forEach var="user" items="${allUsers}">

        <c:url var="blockButton" value="/blockUser">
            <c:param name="userName" value="${user.username}"/>
        </c:url>
        <c:url var="unblockButton" value="/unblockUser">
            <c:param name="userName" value="${user.username}"/>
        </c:url>

        <tr>
            <td>${user.username}</td>
            <td>${user.enabled}</td>

            <td>
                <input type="button" value="${locale.blockButton}" onclick="window.location.href = '${blockButton}'"/>
                <input type="button" value="${locale.unblockButton}" onclick="window.location.href = '${unblockButton}'"/>
            </td>
        </tr>

    </c:forEach>
</table>

<form:form action="." modelAttribute="locale">

    <input type="submit" value="${locale.toHomePage}"/>

</form:form>

</body>

</html>