<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<body>
<h1>${today}</h1>
<h2>${locale.bookTitle}: ${currentBook.bookTitle}</h2>
<h2>${locale.bookAuthor}: ${currentBook.bookAuthor}</h2>
<h3>${locale.requestChoosePeriod}</h3>

<form:form action="/registerRequest">

    <input type="date" name="startDate"
        <c:if test="${!currentBook.taken}"><c:out value="min=${today} value=${today}"/></c:if>
        <c:if test="${currentBook.taken}"><c:out value="min=${currentSubscription.endOfThePeriod} value=${currentSubscription.endOfThePeriod}"/></c:if>>
    <input type="date" name="endDate"
        <c:if test="${!currentBook.taken}"><c:out value="min=${today} value=${today}"/></c:if>
        <c:if test="${currentBook.taken}"><c:out value="min=${currentSubscription.endOfThePeriod} value=${currentSubscription.endOfThePeriod}"/></c:if>>
    <br>
    <br>
    <input type="submit" value="${locale.arrangeCustomRequest}"/>

</form:form>
<br><br>

<form:form action="/booksList">
    <input type="submit" value="${locale.cancel}">
</form:form>

</body>

</html>