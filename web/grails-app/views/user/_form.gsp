<%@ page import="org.seeko.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'type', 'error')} required">
	<label for="type">
		<g:message code="user.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="type" from="${org.seeko.User$UserType?.values()}" keys="${org.seeko.User$UserType.values()*.name()}" required="" value="${userInstance?.type?.name()}"/>
</div>

