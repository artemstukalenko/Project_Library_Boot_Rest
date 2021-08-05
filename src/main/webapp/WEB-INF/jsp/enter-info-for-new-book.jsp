<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<body>

<form:form action="/addNewBook" modelAttribute="newBook" method="post">

    ${locale.bookTitle}: <form:input path="bookTitle"/>
    <form:errors path="bookTitle"/>
    ${locale.bookAuthor}: <form:input path="bookAuthor"/>
    <form:errors path="bookAuthor"/>
    ${locale.bookYearOfPublishing}: <form:input path="bookYearOfPublishing"/>
    <form:errors path="bookYearOfPublishing"/>

    <br><br>

    <input type="submit" value="OK">

</form:form>

</body>

</html>