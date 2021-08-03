<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<body>

<h2>Registration</h2>

<form:form action="/addNewUser">

    <input type="text" id="username" name="username" placeholder="username"/>
    <br>
    <input type="password" id="password" name="password" placeholder="password"/>
    <br>
    <input type="text" id="firstName" name="firstName" placeholder="first name"/>
    <br>
    <input type="text" id="lastName" name="lastName" placeholder="last name"/>
    <br>
    <input type="text" id="email" name="email" placeholder="email"/>
    <br>
    <input type="text" id="phoneNumber" name="phoneNumber" placeholder="phone number"/>
    <br>
    <input type="text" id="address" name="address" placeholder="address"/>
    <br>

    <input type="submit" value="OK">

</form:form>

</body>

</html>