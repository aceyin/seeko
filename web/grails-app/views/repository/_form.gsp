<%@ page import="org.seeko.Repository" %>
<div class="form-group">
    <label for="type">
        <g:message code="seeko.lables.repository.type" default="Type"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select name="type" from="${repositoryInstance.constraints.type.inList}" required=""
              value="${repositoryInstance?.type}" valueMessagePrefix="repository.type" class="form-control"/>
</div>

<div class="form-group">
    <label for="url">
        <g:message code="seeko.lables.repository.url" default="Url"/>
        <span class="required-indicator">*</span>
    </label>

    <g:textField name="url" required="" class="form-control" value="${repositoryInstance?.url}"/>
</div>

<div class="form-group">
    <label for="excludes">
        <g:message code="seeko.lables.repository.excludes" default="Excludes"/>
    </label>
    <g:textField name="excludes" class="form-control" value="${repositoryInstance?.excludes}"/>
</div>

<div class="form-group">
    <label for="user">
        <g:message code="seeko.lables.repository.user" default="User"/>
    </label>
    <g:textField name="user" class="form-control" value="${repositoryInstance?.user}"/>
</div>

<div class="form-group">
    <label for="password">
        <g:message code="seeko.labels.repository.password" default="Password"/>
    </label>
    <g:passwordField name="password" class="form-control" value="${repositoryInstance?.password}"/>
    <g:hiddenField name="pid" value="${repositoryInstance?.project.id}"/>
</div>

