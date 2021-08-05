<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<body>

<h2>Register Details</h2>

<form:form action="/registerDetails" modelAttribute="newUserDetails" method="post">

    First name: <form:input path="userFirstName"/>
    <form:errors path="userFirstName"/>
    Last name: <form:input path="userLastName"/>
    <form:errors path="userLastName"/>

    <br>

    <input type="submit" value="OK">

</form:form>

</body>

</html>