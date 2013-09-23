<%@ page import="org.seeko.Admin" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title><g:message code="seeko.labels.admin.login"/></title>
</head>

<body>

<div>
    <h3><g:message code="seeko.labels.admin.login"/></h3>
    <g:if test="${flash.message}">
        <span class="label label-warning">${flash.message}</span>
    </g:if>
    <g:form action="login" role="form">
        <fieldset class="form">
            <g:render template="login"/>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="login" class="btn btn-success"
                            value="${message(code: 'seeko.lables.login', default: 'Login')}"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
