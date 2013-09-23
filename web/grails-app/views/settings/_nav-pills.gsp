<div class="col-lg-4">
    <ul class="nav nav-pills nav-stacked">
        <li class="active">
            <a href="${createLink(controller: 'settings')}">
                <g:message code="seeko.lables.settings.general"/>
            </a>
        </li>
        <li><a href="${createLink(controller: 'repository', action: 'index')}">
            <g:message code="seeko.lables.settings.repository"/>
        </a>
        </li>
        <li>
            <a href="${createLink(controller: 'elasticsearch', action: 'index')}">
                <g:message code="seeko.lables.settings.es"/>
            </a>
        </li>
    </ul>
</div>