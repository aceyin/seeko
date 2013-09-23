<%@ page import="org.seeko.Admin" %>



<div>
    <ul class="list-unstyled">
        <li><g:message code="seeko.labels.email"/> <g:message code="seeko.lables.required.field"/></li>
        <li><g:textField name="email" size="30" class="form-control input-lg" placeholder="abc@email.com"
                         required="true" value="${fieldValue(bean: cmd, field: 'email')}"/></li>
        <li><g:message code="seeko.labels.password"/> <g:message code="seeko.lables.required.field"/></li>
        <li><g:passwordField name="password" class="form-control input-lg" size="30" required="true"
                             value="${fieldValue(bean: cmd, field: 'password')}"/></li>
        <li><g:message code="seeko.labels.confirm.password"/> <g:message code="seeko.lables.required.field"/></li>
        <li><g:passwordField name="password2" class="form-control input-lg" size="30" required="true"
                             value="${fieldValue(bean: cmd, field: 'password2')}"/></li>
    </ul>
</div>

