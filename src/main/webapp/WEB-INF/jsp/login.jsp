<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<br><br><br>
<h2>${locale.loginWelcome}</h2>

<form:form method="post">
    <input type="text" id="username" placeholder="${locale.loginUsername}" name="username">
    <br>
    <input type="password" id ="password" placeholder="${locale.loginPassword}" name="password">
    <br>
    <input type="submit" value="${locale.loginButton}">
</form:form>

<br><br>

<a href="/register">${locale.registration}</a>

</body>

</html>