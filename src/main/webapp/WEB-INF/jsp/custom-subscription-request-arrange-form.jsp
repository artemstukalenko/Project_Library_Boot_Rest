<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<body>

<h2>${locale.bookTitle}: ${currentBook.bookTitle}</h2>
<h2>${locale.bookAuthor}: ${currentBook.bookAuthor}</h2>
<h3>${locale.requestChoosePeriod}</h3>

<form:form action="/registerRequest">

    <input type="date" name="startDate" value="${today}"
        <c:if test="${currentBook.taken}"><c:out value="min=${currentSubscription.endOfThePeriod}"/></c:if>>
    <input type="date" min="" name="endDate" value="${today}"/>

    <br>
    <br>
    <input type="submit" value="${locale.arrangeCustomRequest}"/>

</form:form>

</body>

</html>