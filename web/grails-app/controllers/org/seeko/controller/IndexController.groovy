package org.seeko.controller

import org.apache.commons.lang.StringUtils
import org.seeko.service.SettingService

class IndexController {

    SettingService settingService

    def index() {
        def pwd = settingService.getAdminPassword()
        if (StringUtils.isBlank(pwd)) {
            redirect(controller: SettingsController,action: "password")
        }else {
            render (view: "index")
        }
    }
}
