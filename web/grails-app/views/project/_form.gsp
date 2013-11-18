<%@ page import="org.seeko.Project" %>
<div class="form-group">
    <label for="name"><g:message code="seeko.lables.project.name"/></label>
    <g:textField name="name" class="form-control" value="${projectInstance?.name}"/>
</div>

<div class="form-group">
    <label for="description"><g:message code="seeko.lables.project.desc"/></label>
    <g:textArea name="description" rows="3" class="form-control">${projectInstance?.description}</g:textArea>
</div>

<div class="form-group">
    <span class="text-danger" id="projectCreationResult"></span>
    <a id="save-project-link" class="btn btn-success pull-right"
       onclick="javascript:ProjectController.saveProject();"><g:message code="seeko.lables.save"/></a>
</div>


