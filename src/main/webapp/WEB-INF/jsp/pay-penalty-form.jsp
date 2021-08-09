<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<body>

<h2>${locale.chooseSumToPay}</h2>

<form:form action="confirmPayment">

    <input type="number" value="0" max="${userPenaltySum}" min="0" name="userSum" id="userSum">
    <input type="submit" value="OK">

</form:form>

</body>

</html>