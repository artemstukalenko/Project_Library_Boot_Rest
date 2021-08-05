<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<body>

<h2>${locale.registration}</h2>

<form:form action="/registerNewUser" modelAttribute="potentialUser" method="post">

    ${locale.loginUsername}: <form:input path="username"/>
    <form:errors path="username"/>
    ${locale.loginPassword}: <form:password path="password"/>
    <form:errors path="password"/>


    <br><br>

    <input type="submit" value="OK">

</form:form>

</body>

</html>