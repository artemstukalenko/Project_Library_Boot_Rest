<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<body>

<h2>${locale.subscriptionsListString}</h2>

<br><br><br>

<form:form action="." modelAttribute="locale">

    <input type="submit" value="${locale.toHomePage}"/>

</form:form>

</body>

</html>