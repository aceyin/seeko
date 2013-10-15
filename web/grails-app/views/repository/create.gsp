<%@ page import="org.seeko.Repository" %>

<div class="col-lg-6 col-lg-offset-3" id="add-repository">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title"><g:message code="seeko.lables.add.repository"/></h3>
        </div>

        <div class="panel-body">
            <g:form action="save" method="POST" name="repositoryCreationForm">
                <g:render template="form"/>
            </g:form>
        </div>
    </div>
</div>