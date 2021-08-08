<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<body>

<h2>${currentBook.bookTitle}</h2>
<h2>${currentBook.bookAuthor}</h2>

<form:form action="/registerRequest">

    <input type="date" name="startDate" value="Start date"/>
    <input type="date" name="endDate" value="End date"/>

    <br>

    <input type="submit" value="OK"/>

</form:form>

</body>

</html>