<%@ page import="org.seeko.Settings" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body>
<div class="row">
    <!-- general settings -->
    <div class="col-lg-8">
        <g:form action="save" method="POST">
            <div class="row">
                <!-- http port -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><g:message code="seeko.lables.settings.title.http.port"/></h3>
                    </div>

                    <div class="panel-body">
                        <g:textField name="httpPort" class="form-control input-group-lg" placeholder="8080"/>
                        <span class="help-block"><g:message code="seeko.lables.settings.http.port.desc"/></span>
                    </div>
                </div><!-- http port -->

            <!-- memory -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><g:message code="seeko.lables.settings.title.memory"/></h3>
                    </div>

                    <div class="panel-body">
                        <g:textField name="memory" class="form-control input-group-lg" placeholder="2048"/>
                        <span class="help-block"><g:message code="seeko.lables.settings.memory.desc"/></span>
                    </div>
                </div><!-- memory -->

            <!-- workspace -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><g:message code="seeko.lables.settings.title.workspace"/></h3>
                    </div>

                    <div class="panel-body">
                        <g:textField name="workspace" class="form-control input-group-lg" placeholder="~/.seeko"/>
                        <span class="help-block"><g:message code="seeko.lables.settings.workspace.desc"/></span>
                    </div>
                </div><!-- workspace -->


            <!-- filters -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><g:message code="seeko.lables.settings.title.filters"/></h3>
                    </div>

                    <div class="panel-body">
                        <g:textField name="filters" class="form-control input-group-lg"
                                     placeholder=".exe, .zip, .gz, .tar, .jar, .7z, .bin, .war, .ear"/>
                        <span class="help-block"><g:message code="seeko.lables.settings.filters.desc"/></span>
                    </div>
                </div><!-- filters -->

            <!-- scm checkout options -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><g:message code="seeko.lables.settings.title.scm.skip.folders"/></h3>
                    </div>

                    <div class="panel-body">
                        <g:textField name="folderToIgnore" class="form-control input-group-lg"
                                     placeholder="tags, releases"/>
                        <span class="help-block"><g:message code="seeko.lables.settings.scm.skip.folders.desc"/></span>
                    </div>
                </div><!-- scm checkout options -->

                <div class="row pull-right">
                    <g:submitButton name="save" class="btn btn-success"
                                    value="${message(code: 'seeko.lables.save', default: 'Save')}"/>
                </div>

                <div class="row">&nbsp;</div>
            </div>
        </g:form>
    </div><!-- general settings -->

<!-- nav-pills -->
<g:render template="nav-pills"/>
</div>
</body>
</html>
