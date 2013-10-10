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
               href="#addProjectForm" data-backdrop="true"
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

    <!-- bootstrap modal div -->
    <div class="modal fade" id="addProjectForm" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">&times;</button>
                    <h4 class="modal-title"><g:message code="seeko.lables.create.project"/></h4>
                </div>

                <!-- modal content display here -->
                <div class="modal-body">
                    <g:form action="save" method="POST" name="projectCreationForm">
                        <g:render template="form"/>
                        <button name="saveProject" id="saveProject" class="btn btn-success">Save</button>
                    </g:form>
                </div>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal"><g:message
                        code="seeko.lables.close"/></button>
                <button type="button" class="btn btn-primary"><g:message
                        code="seeko.lables.save"/></button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- end bootstrap modal div -->
</div>

</body>
</html>
