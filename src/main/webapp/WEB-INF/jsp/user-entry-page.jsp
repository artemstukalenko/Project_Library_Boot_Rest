<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<body>

<h2>${locale.booksListString}</h2>

<br><br><br>

<table>
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Author</th>
        <th>Year of publishing</th>
    </tr>

    <c:forEach var="book" items="${allBooks}">
        <tr>
            <td>${book.bookId}</td>
            <td>${book.bookTitle}</td>
            <td>${book.bookAuthor}</td>
            <td>${book.bookYearOfPublishing}</td>
        </tr>
    </c:forEach>

</table>

<br><br><br>

<form:form action="." modelAttribute="locale">

    <input type="submit" value="${locale.toHomePage}"/>

</form:form>

</body>

</html>