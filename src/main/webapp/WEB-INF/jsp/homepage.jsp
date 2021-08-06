<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<body>

<form:form action="en" modelAttribute="locale">

    <input type="submit" value="EN"/>

</form:form>

<br>

<form:form action="ua" modelAttribute="locale">

    <input type="submit" value="UA"/>

</form:form>

<br><br>

<h2>${locale.loggedInAs} <i>${currentUsername}</i> ${currentAuthority}</h2>
<h3>${locale.userFirstName}: ${currentUser.userDetails.userFirstName}</h3>
<h3>${locale.userLastName}: ${currentUser.userDetails.userLastName}</h3>
<h3>${locale.userEmail}: ${currentUser.userDetails.userEmail}</h3>
<h3>${locale.userPhoneNumber}: ${currentUser.userDetails.userPhoneNumber}</h3>
<h3>${locale.userAddress}: ${currentUser.userDetails.userAddress}</h3>

<form:form action="booksList" modelAttribute="locale">

    <input type="submit" value="${locale.seeBooksList}"/>

</form:form>

<br><br><br>

<security:authorize access="hasRole('USER')">

    <input type="button" value="view my subscriptions" onclick="window.location.href = 'viewSubscriptions'">

</security:authorize>

<br><br><br>

<security:authorize access="hasAnyRole('LIBRARIAN', 'ADMIN')">

    <input type="button" value="${locale.seeSubscriptionsList}" onclick="window.location.href = 'asLibrarian'">

</security:authorize>

<br><br><br>

<security:authorize access="hasRole('ADMIN')">

    <input type="button" value="${locale.seeUsersList}" onclick="window.location.href = 'asAdmin'">

</security:authorize>

<br><br><br>
<input type="button" value="logout" onclick="window.location.href = 'logout'">

</body>

</html>