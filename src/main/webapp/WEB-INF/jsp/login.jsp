<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>

<form:form action="en" modelAttribute="locale">

    <input type="submit" value="EN"/>

</form:form>

<br>

<form:form action="ua" modelAttribute="locale">

    <input type="submit" value="UA"/>

</form:form>
<br><br><br>
<h2>Welcome</h2>

<form:form method="post">
    Username: <input type="text" id="username" placeholder="Username" name="username">
    <br>
    Password: <input type="password" id ="password" placeholder="Password" name="password">
    <br>
    <input type="submit" value="Login">
</form:form>

<br><br>

<a href="/register">Register</a>

</body>

</html>