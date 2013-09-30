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
            <h3><g:message code="seeko.lables.settings.projects"/></h3>
            <a data-toggle="modal" class="pull-right"
               href="${createLink(controller: 'project', action: 'create')}" data-backdrop="true"
               data-target="#addProjectForm"><g:message code="seeko.lables.create.project"/></a>
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
                                    ${proj.name} - ${proj.description}
                                </a>
                            </h4>
                        </div>

                        <div id="collapseOne" class="panel-collapse collapse in">
                            <div class="panel-body">
                                repositories
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
    <g:render template="/layouts/modal"
              model="['modal_id': 'addProjectForm', 'modal_title': 'aaa']"/>
</div>

</body>
</html>
