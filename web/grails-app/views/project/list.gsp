<%@ page import="org.seeko.Project" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title><g:message code="seeko.lables.settings.projects"/></title>
</head>

<body>
<!--
TODO: Fish:
1. fix the popup layer UX issue.
-->
<div class="row">
    <div class="col-lg-8">
        <!-- title -->
        <div class="row">
            <h3><g:message code="seeko.lables.settings.projects"/></h3>
            <span class="help-block">
                <g:message code="seeko.lables.settings.project.desc"/>

                <a id="create-project-link"
                   href="${createLink(controller: 'project', action: 'create')}"><g:message
                        code="seeko.lables.create.project"/></a>
            </span>
        </div>
        <!-- end title -->
        <!-- project lists -->
        <div class="row">
            <div class="panel-group" id="accordion">
                <g:each in="${projectInstanceList}" var="project">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a class="accordion-toggle text-info" data-toggle="collapse" data-parent="#accordion"
                                   href="#collapseOne">
                                    ${project.name}
                                </a> <span class="sm-text">( ${project.description} )</span>
                            </h4>

                        </div>

                        <div id="collapseOne" class="panel-collapse collapse in">
                            <div class="panel-body">
                                <div class="container">
                                    <div class="row">
                                        <g:message code="seeko.lables.repositories"/>

                                        <a href="<g:createLink controller="repository" action="create"
                                                               params='[pid: "${project.id}"]'/>"
                                           class="pull-right add-repository-link"
                                           id="add-repository-link-${project.id}">
                                            <g:message code="seeko.lables.add.repository"/>
                                        </a>
                                    </div>

                                    <div class="row">
                                        <ul class="list-group">
                                            <g:each in="${project.repositories}" var="repository">
                                                <li class="list-group-item">
                                                    <a id="edit-repository-link-${repository.id}"
                                                       class="text-info edit-repository-link"
                                                       href="<g:createLink controller="repository"
                                                                           action="edit"
                                                                           id="${repository.id}"/>">
                                                        ${repository.name} - ${repository.url}
                                                    </a>
                                                </li>
                                            </g:each>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </g:each>
            </div>
        </div>
        <!-- project list -->
    </div>
    <!-- nav-pills -->
    <g:render template="/layouts/settings-navi-pills" model="['active_menu': 'projects']"/>
</div>
<script type="application/javascript">
    $(document).ready(function () {
        ProjectController.init();
    })
</script>
</body>
</html>
