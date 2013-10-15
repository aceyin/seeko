<%@ page import="org.seeko.Repository" %>



<div class="fieldcontain ${hasErrors(bean: repositoryInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="seeko.lables.repository.name" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" required="" value="${repositoryInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: repositoryInstance, field: 'type', 'error')} required">
    <label for="type">
        <g:message code="seeko.lables.repository.type" default="Type"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="type" required="" value="${repositoryInstance?.type}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: repositoryInstance, field: 'url', 'error')} required">
    <label for="url">
        <g:message code="seeko.lables.repository.url" default="Url"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="url" required="" value="${repositoryInstance?.url}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: repositoryInstance, field: 'excludes', 'error')} ">
    <label for="excludes">
        <g:message code="seeko.lables.repository.excludes" default="Excludes"/>

    </label>
    <g:textField name="excludes" value="${repositoryInstance?.excludes}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: repositoryInstance, field: 'user', 'error')} ">
    <label for="user">
        <g:message code="seeko.lables.repository.user" default="User"/>

    </label>
    <g:textField name="user" value="${repositoryInstance?.user}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: repositoryInstance, field: 'password', 'error')} ">
    <label for="password">
        <g:message code="seeko.labels.repository.password" default="Password"/>

    </label>
    <g:textField name="password" value="${repositoryInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: repositoryInstance, field: 'project', 'error')} required">
    <label for="project">
        <g:message code="seeko.lables.repository.project" default="Project"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="project" name="project.id" from="${org.seeko.Project.list()}" optionKey="id" required=""
              value="${repositoryInstance?.project?.id}" class="many-to-one"/>
</div>


