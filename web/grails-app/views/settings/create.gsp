<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title><g:message code="seeko.lables.title.general.settings"/></title>
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
                        <g:textField name="HTTP_PORT" class="form-control input-group-lg"
                                     value="${settings.HTTP_PORT}"/>
                        <span class="help-block"><g:message code="seeko.lables.settings.http.port.desc"/></span>
                    </div>
                </div><!-- http port -->

            <!-- memory-searcher -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><g:message code="seeko.lables.settings.title.memory.searcher"/></h3>
                    </div>

                    <div class="panel-body">
                        <g:textField name="SEACHER_MEMORY" class="form-control input-group-lg" placeholder="1024m"/>
                        <span class="help-block"><g:message code="seeko.lables.settings.memory.searcher.desc"/></span>
                    </div>
                </div><!-- memory-searcher -->

            <!-- memory-indexer -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><g:message code="seeko.lables.settings.title.memory.indexer"/></h3>
                    </div>

                    <div class="panel-body">
                        <g:textField name="INDEXER_MEMORY" class="form-control input-group-lg" placeholder="1024m"/>
                        <span class="help-block"><g:message code="seeko.lables.settings.memory.indexer.desc"/></span>
                    </div>
                </div><!-- memory-indexer -->

            <!-- memory-elastic-search -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><g:message code="seeko.lables.settings.title.memory.es"/></h3>
                    </div>

                    <div class="panel-body">
                        <g:textField name="ES_MEMORY" class="form-control input-group-lg" placeholder="2048m"/>
                        <span class="help-block"><g:message code="seeko.lables.settings.memory.es.desc"/></span>
                    </div>
                </div><!-- memory-elastic-search -->

            <!-- file type filters -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><g:message code="seeko.lables.settings.title.file.filters"/></h3>
                    </div>

                    <div class="panel-body">
                        <g:textField name="FILE_TYPE_FILTERS" class="form-control input-group-lg"
                                     placeholder=".exe, .zip, .gz, .tar, .jar, .7z, .bin, .war, .ear"/>
                        <span class="help-block"><g:message code="seeko.lables.settings.file.filters.desc"/></span>
                    </div>
                </div><!-- file type filters -->

            <!-- directory filters -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><g:message code="seeko.lables.settings.title.directory.filters"/></h3>
                    </div>

                    <div class="panel-body">
                        <g:textField name="DIRECTORY_FILTERS" class="form-control input-group-lg"
                                     placeholder="tags, releases"/>
                        <span class="help-block"><g:message code="seeko.lables.settings.directory.filters.desc"/></span>
                    </div>
                </div><!-- directory filters -->

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
