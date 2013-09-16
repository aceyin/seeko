<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <title>Seeko - <g:message code="seeko.menus.settings"/> / <g:message code="seeko.labels.password"/> </title>
</head>

<body>
<g:form action="/settings/password" method="POST">
    <g:message code="seeko.labels.please.set.password"/>
    <ul class="list-group">
        <li><g:message code="seeko.labels.password"/> :</li>
        <li><input type="password" name="password" size="20"/></li>
        <li><g:message code="seeko.lables.confirm.password"/>:</li>
        <li><input type="password" name="password2" size="20"/></li>
        <li><input type="submit" name="save-password" value="Save"/></li>
    </ul>
</g:form>
</body>
</html>