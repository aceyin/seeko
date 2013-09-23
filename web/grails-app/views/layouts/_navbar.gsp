<nav class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="row">
                    <div class="col-md-2">
                        <a class="navbar-brand" href="${createLink([controller: 'home', action: 'index'])}">
                            <img src="/images/seeko.png" border="0" title="Seeko"/></a>
                    </div>

                    <div class="col-md-6">
                        <div class="row nav-q">
                            <g:textField name="q" size="30" class="form-control input-group-lg"/>
                        </div>
                    </div>
                </div>
            </div><!-- navbar-header -->
            <div class="col-md-4">
                <div class="row nav-menu">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="${createLink(controller: 'settings', action: 'index')}">
                                <g:message code="seeko.menus.settings"/>
                            </a>
                        </li>
                        <li>
                            <a href="${createLink(controller: 'status', action: 'index')}">
                                <g:message code="seeko.menus.status"/>
                            </a>
                        </li>
                        <li>
                            <a href="${createLink(controller: 'statistics', action: 'index')}">
                                <g:message code="seeko.menu.statistics"/>
                            </a>
                        </li>
                        <g:if test="${session.ADMIN_SESSION != null}">
                            <li>
                                <a href="${createLink(controller: 'admin', action: 'logout')}">
                                    <g:message code="seeko.menus.logout"/>
                                </a>
                            </li>
                        </g:if>
                    </ul>
                </div>
            </div><!-- navbar-collapse -->
        </div>
    </div>
</nav>