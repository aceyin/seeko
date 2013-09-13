package org.seeko.controller

import org.apache.commons.lang.StringUtils
import org.seeko.service.SettingService

import javax.servlet.http.HttpServletRequest

class SettingsController {

    static final String GET = 'GET';
    static final String POST = 'POST';

    SettingService settingService


    static allowedMethods = [password: ['POST', 'GET']]

    def index() {
        render(view: "/settings/index")
    }

    /**
     * update/initialize password
     * @return
     */
    def password() {
        switch (request.method) {
            case GET:
                render(view: "/settings/password")
                break
            case POST:
                savePassword(request);
                break
        }
    }

    private void savePassword(HttpServletRequest request) {
        String password = request.getParameter('password')
        String password2 = request.getParameter('password2')
        if (StringUtils.isBlank(password) || StringUtils.isBlank(password2) || !(password == password2)) {
        }
    }
}
