
<%@ page import="org.seeko.Repository" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'repository.label', default: 'Repository')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-repository" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-repository" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list repository">
			
				<g:if test="${repositoryInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="repository.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${repositoryInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${repositoryInstance?.type}">
				<li class="fieldcontain">
					<span id="type-label" class="property-label"><g:message code="repository.type.label" default="Type" /></span>
					
						<span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${repositoryInstance}" field="type"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${repositoryInstance?.url}">
				<li class="fieldcontain">
					<span id="url-label" class="property-label"><g:message code="repository.url.label" default="Url" /></span>
					
						<span class="property-value" aria-labelledby="url-label"><g:fieldValue bean="${repositoryInstance}" field="url"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${repositoryInstance?.excludes}">
				<li class="fieldcontain">
					<span id="excludes-label" class="property-label"><g:message code="repository.excludes.label" default="Excludes" /></span>
					
						<span class="property-value" aria-labelledby="excludes-label"><g:fieldValue bean="${repositoryInstance}" field="excludes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${repositoryInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="repository.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${repositoryInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${repositoryInstance?.project}">
				<li class="fieldcontain">
					<span id="project-label" class="property-label"><g:message code="repository.project.label" default="Project" /></span>
					
						<span class="property-value" aria-labelledby="project-label"><g:link controller="project" action="show" id="${repositoryInstance?.project?.id}">${repositoryInstance?.project?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${repositoryInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="property-label"><g:message code="repository.user.label" default="User" /></span>
					
						<span class="property-value" aria-labelledby="user-label"><g:fieldValue bean="${repositoryInstance}" field="user"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${repositoryInstance?.id}" />
					<g:link class="edit" action="edit" id="${repositoryInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
