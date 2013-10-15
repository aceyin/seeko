<%@ page import="org.seeko.Project" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title><g:message code="seeko.lables.settings.projects"/></title>
</head>

<body>

<div class="row">
    <div class="col-lg-8">
        <!-- title -->
        <div class="row">
            <h3><g:message code="seeko.lables.settings.projects"/>
                <a class="btn btn-default btn-sm" id="create-project-link"
                   href="${createLink(controller: 'project', action: 'create')}"><g:message
                        code="seeko.lables.create.project"/></a>
            </h3>
            <span class="help-block"><g:message code="seeko.lables.settings.project.desc"/></span>
        </div>
        <!-- end title -->
        <!-- project lists -->
        <div class="row">
            <div class="panel-group" id="accordion">
                <g:each in="${projectInstanceList}" var="proj">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
                                   href="#collapseOne">
                                    ${proj.name}
                                </a>
                                <a class="pull-right add-repository-link" id="add-repository-link-${proj.id}"
                                   href="<g:createLink controller="repository" action="create"
                                                       params='[pid: "${proj.id}"]'/>">
                                    <g:message code="seeko.lables.add.repository"/>
                                </a>
                            </h4>

                        </div>

                        <div id="collapseOne" class="panel-collapse collapse in">
                            <div class="panel-body">
                                <div class="row">${proj.description}</div>

                                <div class="row">
                                    <g:message code="seeko.lables.repositories"/>
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
