<!DOCTYPE html>
<html lang="en">
<head>
    <title><g:message code="seeko.lables.create.admin.account.title"/></title>
    <g:render template="/layouts/head"/>
    <style>
    html, body {
        height: 100%;
        margin: 0;
        padding: 0 0
    }

    .container-fluid {
        height: 100%;
        display: table;
        width: 100%;
        padding-right: 0;
        padding-left: 0
    }

    .row-fluid {
        height: 100%;
        display: table-cell;
        vertical-align: middle;
        width: 100%
    }

    .centering {
        float: none;
        margin: 0 auto
    }
    </style>
</head>

<body>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="offset3 centering col-lg-5">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <g:message code="seeko.lables.create.admin.account.title"/>
                    </h3>
                </div>

                <div class="panel-body">
                    <g:hasErrors bean="${cmd}">
                        <g:eachError>
                            <span class="label label-warning"><g:message error="${it}"/></span>
                        </g:eachError>
                    </g:hasErrors>
                    <g:form action="save" role="form">
                        <fieldset class="form">
                            <g:render template="form"/>
                        </fieldset>
                        <fieldset class="buttons">
                            <g:submitButton name="create" class="btn btn-success"
                                            value="${message(code: 'default.button.create.label', default: 'Create')}"/>
                        </fieldset>
                    </g:form>
                </div>
            </div>
        </div>
    </div>
</div>

<g:render template="/layouts/footer"/>
</body>
</html>