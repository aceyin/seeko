
<%@ page import="org.seeko.Repository" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'repository.label', default: 'Repository')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-repository" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-repository" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'repository.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="type" title="${message(code: 'repository.type.label', default: 'Type')}" />
					
						<g:sortableColumn property="url" title="${message(code: 'repository.url.label', default: 'Url')}" />
					
						<g:sortableColumn property="excludes" title="${message(code: 'repository.excludes.label', default: 'Excludes')}" />
					
						<g:sortableColumn property="password" title="${message(code: 'repository.password.label', default: 'Password')}" />
					
						<th><g:message code="repository.project.label" default="Project" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${repositoryInstanceList}" status="i" var="repositoryInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${repositoryInstance.id}">${fieldValue(bean: repositoryInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: repositoryInstance, field: "type")}</td>
					
						<td>${fieldValue(bean: repositoryInstance, field: "url")}</td>
					
						<td>${fieldValue(bean: repositoryInstance, field: "excludes")}</td>
					
						<td>${fieldValue(bean: repositoryInstance, field: "password")}</td>
					
						<td>${fieldValue(bean: repositoryInstance, field: "project")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${repositoryInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
