<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<body>

<h2>${locale.booksListString}</h2>

<br><br><br>

<form:form action="searchBook" modelAttribute="searcher">
    <form:input path="userInput"/>
    <form:select path="searchCriteria">
        <form:option value="byTitle" label="${locale.filterByTitle}"/>
        <form:option value="byAuthor" label="${locale.filterByAuthor}"/>
        <form:option value="byYear" label="${locale.filterByYear}"/>
    </form:select>
    <input type="submit" value="${locale.search}">
</form:form>


<br><br>

<table border="1">
    <tr>
        <th>${locale.bookId}</th>
        <th>${locale.bookTitle}</th>
        <th>${locale.bookAuthor}</th>
        <th>${locale.bookYearOfPublishing}</th>
        <th>
            <form:form action="filter" modelAttribute="listSorter">
                <form:select path="sortMethod">
                    <form:option value="byTitle" label="${locale.filterByTitle}"/>
                    <form:option value="byAuthor" label="${locale.filterByAuthor}"/>
                    <form:option value="byYear" label="${locale.filterByYear}"/>
                </form:select>
                <input type="submit" value="${locale.filter}">
            </form:form>

        </th>
    </tr>

    <c:forEach var="book" items="${allBooks}">

        <c:url var="deleteBookButton" value="/deleteBook">
            <c:param name="bookId" value="${book.bookId}"/>
        </c:url>
        <c:url var="arrangeSubscriptionButton" value="/arrangeSubscription">
            <c:param name="bookId" value="${book.bookId}"/>
        </c:url>

        <tr>
            <td>${book.bookId}</td>
            <td>${book.bookTitle}</td>
            <td>${book.bookAuthor}</td>
            <td>${book.bookYearOfPublishing}</td>

            <td>

                <security:authorize access="hasRole('ADMIN')">
                    <input type="button" value="${locale.deleteBook}" onclick="window.location.href = '${deleteBookButton}'">
                </security:authorize>
                <security:authorize access="hasRole('USER')">
                    <input type="button" value="${locale.arrangeSubscriptionButton}" onclick="window.location.href = '${arrangeSubscriptionButton}'"
                    <c:if test="${book.taken}"><c:out value="disabled='disabled'"/></c:if>>
                </security:authorize>

            </td>
        </tr>
    </c:forEach>

</table>

<br><br>
<security:authorize access="hasRole('ADMIN')">
    <input type="button" value="${locale.addNewBook}" onclick="window.location.href = '/enterInfoForNewBook'">
</security:authorize>

<br><br><br>

<form:form action="/homepage_again" modelAttribute="locale">

    <input type="submit" value="${locale.toHomePage}"/>

</form:form>

</body>

</html>