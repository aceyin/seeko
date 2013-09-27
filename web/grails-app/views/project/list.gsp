<%@ page import="org.seeko.Project" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title><g:message code="seeko.lables.settings.projects"/></title>
</head>

<body>

<div class="row">
    <!-- project lists -->
    <div class="col-lg-9">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><g:message code="seeko.lables.settings.projects"/></h3>
                </div>

                <div class="panel-body">
                    <!-- description -->
                    <div class="row">
                        <div class="col-lg-10 pull-left">
                            <span class="help-block"><g:message code="seeko.lables.settings.project.desc"/></span>
                        </div>

                        <div class="col-lg-2 pull-right">
                            <a data-toggle="modal"
                               href="<g:createLink controller="project" action="create"/>"
                               data-target="#addProjectForm"><g:message code="seeko.lables.create.project"/></a>
                        </div>
                    </div>
                    <!-- description -->
                    <!-- project lists -->
                    <div class="row">
                    </div>
                    <!-- project list -->
                </div>
            </div>
        </div><!-- http port -->
    </div>
    <!-- nav-pills -->
    <g:render template="/layouts/nav-pills" model="['active_menu': 'projects']"/>
</div>

<g:render template="/layouts/modal"
          model="['modal_id': 'addProjectForm', 'modal_title': 'aaa']"/>
</body>
</html>
