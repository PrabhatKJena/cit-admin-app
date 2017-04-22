<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>
<h1>Login</h1>
<form:form action="./login" method="post" commandName="loginData" name="loginData">
    <form:input path="userName"></form:input>
    <form:password path="userCredential"></form:password>
    <button type="submit">Login</button>
</form:form>
</body>
</html>