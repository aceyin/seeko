<div class="col-lg-6 col-lg-offset-3" id="add-repository">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title"><g:message code="seeko.lables.add.repository"/></h3>
        </div>

        <div class="panel-body">
            <g:form action="save" method="POST" name="addRepositoryForm" role="form">
                <div class="form-group">
                    <label for="name">
                        <g:message code="seeko.lables.repository.name" default="Name"/>
                    </label>

                    <g:textField name="name" required="" class="form-control" value="${repositoryInstance?.name}"/>
                </div>
                <g:render template="form"/>
                <div class="form-group">
                    <span class="text-danger" id="addRepositoryResult"></span>
                    <a class="btn btn-success pull-right"
                       onclick="javascript:ProjectController.saveRepository();"><g:message
                            code="seeko.lables.save"/></a>
                </div>
            </g:form>
        </div>
    </div>
</div>