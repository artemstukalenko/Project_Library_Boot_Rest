<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>

<form:form action="/addNewBook" modelAttribute="newBook" method="post">

    Book title: <form:input path="bookTitle"/>
    <form:errors path="bookTitle"/>
    Book author: <form:input path="bookAuthor"/>
    <form:errors path="bookAuthor"/>
    Book year of publishing: <form:input path="bookYearOfPublishing"/>
    <form:errors path="bookYearOfPublishing"/>

    <br><br>

    <input type="submit" value="OK">

</form:form>

</body>

</html>