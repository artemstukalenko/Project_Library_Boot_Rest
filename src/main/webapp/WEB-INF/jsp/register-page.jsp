<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<body>

<h2>${locale.registration}</h2>

<form:form action="/registerNewUser" modelAttribute="potentialUser" method="post">

    ${locale.loginUsername}: <form:input path="username"/>
    <form:errors path="username"/>
    ${locale.loginPassword}: <form:input path="password"/>
    <form:errors path="password"/>



<%--    <input type="text" id="username" name="username" placeholder="${locale.loginUsername}"/>--%>
<%--    <br>--%>
<%--    <input type="password" id="password" name="password" placeholder="${locale.loginPassword}"/>--%>
<%--    <br>--%>
<%--    <input type="text" id="firstName" name="firstName" placeholder="${locale.userFirstName}"/>--%>
<%--    <br>--%>
<%--    <input type="text" id="lastName" name="lastName" placeholder="${locale.userLastName}"/>--%>
<%--    <br>--%>
<%--    <input type="text" id="email" name="email" placeholder="${locale.userEmail}"/>--%>
<%--    <br>--%>
<%--    <input type="text" id="phoneNumber" name="phoneNumber" placeholder="${locale.userPhoneNumber}"/>--%>
<%--    <br>--%>
<%--    <input type="text" id="address" name="address" placeholder="${locale.userAddress}"/>--%>
    <br>

    <input type="submit" value="OK">

</form:form>

</body>

</html>