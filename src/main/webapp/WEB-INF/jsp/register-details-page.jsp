<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<body>

<h2>Register Details</h2>

<form:form action="/registerDetails" modelAttribute="newUserDetails" method="post">

    ${locale.userFirstName}: <form:input path="userFirstName"/>
    <form:errors path="userFirstName"/>
    <br>
    ${locale.userLastName}: <form:input path="userLastName"/>
    <form:errors path="userLastName"/>
    <br>
    ${locale.userEmail}: <form:input path="userEmail"/>
    <form:errors path="userEmail"/>
    <br>
    ${locale.userPhoneNumber}: <form:input path="userPhoneNumber"/>
    <form:errors path="userPhoneNumber"/>
    <br>
    ${locale.userAddress}: <form:input path="userAddress"/>
    <form:errors path="userAddress"/>
    <br>

    <br>

    <input type="submit" value="OK">

</form:form>

<br><br><br>

<form:form action="/login">
    <input type="submit" value="${locale.cancel}">
</form:form>

</body>

</html>