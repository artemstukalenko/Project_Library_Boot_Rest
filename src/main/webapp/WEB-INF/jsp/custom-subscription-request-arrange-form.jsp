<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<body>

<h2>${currentBook.bookTitle}</h2>
<h2>${currentBook.bookAuthor}</h2>
<h2>${currentSubscription.endOfThePeriod}</h2>

<form:form action="/registerRequest">

    <input type="date" name="startDate" value="Start date"
        <c:if test="${currentBook.taken}"><c:out value="min=${currentSubscription.endOfThePeriod}"/></c:if>>
    <input type="date" min="" name="endDate" value="End date"/>

    <br>

    <input type="submit" value="OK"/>

</form:form>

</body>

</html>