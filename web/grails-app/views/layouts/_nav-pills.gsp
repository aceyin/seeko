<div class="col-lg-3">
    <ul class="nav nav-pills nav-stacked">
        <li <g:if test="${active_menu == 'settings'}">class="active"</g:if>>
            <a href="${createLink(controller: 'settings')}">
                <g:message code="seeko.lables.settings.general"/>
            </a>
        </li>
        <li <g:if test="${active_menu == 'projects'}">class="active"</g:if>>
            <a href="${createLink(controller: 'project', action: 'index')}">
                <g:message code="seeko.lables.settings.projects"/>
            </a>
        </li>
        <li <g:if test="${active_menu == 'elasticsearch'}">class="active"</g:if>>
            <a href="${createLink(controller: 'elasticsearch', action: 'index')}">
                <g:message code="seeko.lables.settings.es"/>
            </a>
        </li>
    </ul>
</div>