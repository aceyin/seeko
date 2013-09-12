package org.seeko.service

import org.seeko.domain.Settings

class SettingService {

    def grailsApplication

    def getAdminPassword() {
        Settings.findByKey(grailsApplication.config["seeko.settings.keys.admin.password"])
    }
}
