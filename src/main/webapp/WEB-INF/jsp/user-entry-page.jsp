<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<body>

<h2>${locale.booksListString}</h2>

<br><br><br>

<table border="1">
    <tr>
        <th>${locale.bookId}</th>
        <th>${locale.bookTitle}</th>
        <th>${locale.bookAuthor}</th>
        <th>${locale.bookYearOfPublishing}</th>
    </tr>

    <c:forEach var="book" items="${allBooks}">

        <c:url var="deleteBookButton" value="/deleteBook">
            <c:param name="bookId" value="${book.bookId}"/>
        </c:url>

        <tr>
            <td>${book.bookId}</td>
            <td>${book.bookTitle}</td>
            <td>${book.bookAuthor}</td>
            <td>${book.bookYearOfPublishing}</td>

            <td>

                <security:authorize access="hasRole('ADMIN')">

                    <input type="button" value="delete book" onclick="window.location.href = '${deleteBookButton}'">

                </security:authorize>

            </td>
        </tr>
    </c:forEach>

</table>

<br><br><br>

<form:form action="/homepage_again" modelAttribute="locale">

    <input type="submit" value="${locale.toHomePage}"/>

</form:form>

</body>

</html>