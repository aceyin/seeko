<nav class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <div class="row">
            <div class="col-lg-7">
                <div class="row">
                    <div class="col-lg-2">
                        <a class="navbar-brand" href="${createLink([controller: 'home', action: 'index'])}">
                            <img src="/images/seeko.png" border="0" title="Seeko"/>
                        </a>
                    </div>

                    <div class="col-lg-10 nav-q">
                        <g:form action="${createLink(controller: 'search', action: 'index')}" method="POST">
                            <div class="input-group">
                                <g:textField name="q" class="form-control" placeholder="input something here"/>
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">Go!</button>
                                </span>
                            </div>
                        </g:form>
                    </div>
                </div>
            </div><!-- navbar-header -->
            <div class="col-lg-5">
                <div class="row nav-menu">
                    <ul class="nav navbar-nav navbar-right" id="nav-items">
                        <li>
                            <a href="${createLink(controller: 'settings')}">
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
                        <li>
                            <a href="${createLink(controller: 'help', action: 'index')}">
                                <g:message code="seeko.menu.help"/>
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