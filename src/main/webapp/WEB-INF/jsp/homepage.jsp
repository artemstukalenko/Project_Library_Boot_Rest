<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<body>

<form:form action="en" modelAttribute="locale">

    <input type="submit" value="EN"/>

</form:form>

<br><br>

<form:form action="ua" modelAttribute="locale">

    <input type="submit" value="UA"/>

</form:form>

<br><br><br><br>

<form:form action="booksList" modelAttribute="locale">

    <input type="submit" value="${locale.seeBooksList}"/>

</form:form>

<br><br><br>

<security:authorize access="hasAnyRole('LIBRARIAN', 'ADMIN')">

    <input type="button" value="${locale.seeSubscriptionsList}" onclick="window.location.href = 'asLibrarian'">

</security:authorize>

<br><br><br>

<security:authorize access="hasRole('ADMIN')">

    <input type="button" value="${locale.seeUsersList}" onclick="window.location.href = 'asAdmin'">

</security:authorize>

</body>

</html>