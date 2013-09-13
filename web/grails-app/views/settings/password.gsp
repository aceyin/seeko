<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <title>Seeko - Settings / password</title>
</head>

<body>
<g:form action="/settings/password" method="POST">
    Hi, please set the password for the administrator account :
    <ul class="list-group">
        <li>Password:</li>
        <li><input type="password" name="password" size="20"/></li>
        <li>Confirm Password:</li>
        <li><input type="password" name="password2" size="20"/></li>
        <li><input type="submit" name="save-password" value="Save"/></li>
    </ul>
</g:form>
</body>
</html>