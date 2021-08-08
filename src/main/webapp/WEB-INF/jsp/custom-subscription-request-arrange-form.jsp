<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<body>

<h2>${locale.bookTitle}: ${currentBook.bookTitle}</h2>
<h2>${locale.bookAuthor}: ${currentBook.bookAuthor}</h2>
<h3>${locale.requestChoosePeriod}, ${notTaken}</h3>

<form:form action="/registerRequest">

    <input type="date" name="startDate"
        <c:if test="${currentBook.taken}"><c:out value="min=${currentSubscription.endOfThePeriod}"/></c:if>
        <c:if test="${currentBook.taken}"><c:out value="value=${currentSubscription.endOfThePeriod}"/></c:if>
        <c:if test="${notTaken}"><c:out value="value=${today}"/></c:if>>
    <input type="date" min="" name="endDate"
        <c:if test="${currentBook.taken}"><c:out value="min=${currentSubscription.endOfThePeriod}"/></c:if>
        <c:if test="${currentBook.taken}"><c:out value="value=${currentSubscription.endOfThePeriod}"/></c:if>
        <c:if test="${notTaken}"><c:out value="value=${today}"/></c:if>>

    <br>
    <br>
    <input type="submit" value="${locale.arrangeCustomRequest}"/>

</form:form>

</body>

</html>