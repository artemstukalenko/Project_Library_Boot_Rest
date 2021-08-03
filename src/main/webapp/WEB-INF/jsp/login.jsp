<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>
<h2>HELLO!!!!!</h2>

<form:form method="post">
    Username: <input type="text" id="username" placeholder="Username" name="username">
    <br>
    Password: <input type="password" id ="password" placeholder="Password" name="password">
    <input type="submit" value="Login">
</form:form>

</body>

</html>