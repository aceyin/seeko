<%@ page import="org.seeko.Admin" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
</head>

<body>

<div>
    <h3><g:message code="seeko.labels.create.admin.account"/></h3>
    <g:hasErrors bean="${cmd}">
        <g:eachError>
            <span class="label label-warning"><g:message error="${it}"/></span>
        </g:eachError>
    </g:hasErrors>
    <g:form action="save" role="form">
        <fieldset class="form">
            <g:render template="form"/>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="create" class="btn btn-success"
                            value="${message(code: 'default.button.create.label', default: 'Create')}"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
