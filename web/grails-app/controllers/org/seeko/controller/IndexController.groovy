package org.seeko.controller

import org.apache.commons.lang.StringUtils
import org.seeko.service.SettingService
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class IndexController {

    SettingService settingService
    private static Logger LOGGER = LoggerFactory.getLogger("IndexController")

    def index() {
        def pwd = settingService.getAdminPassword()
        if (StringUtils.isBlank(pwd)) {
            LOGGER.info("No password set for administrator account, redirect to Settings. ")
            redirect(["controller":"settings","action":"password"])
        }else {
            render (view: "/index")
        }
    }
}
