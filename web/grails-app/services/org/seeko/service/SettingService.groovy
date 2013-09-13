package org.seeko.service

import org.seeko.domain.Settings

class SettingService {

    def grailsApplication

    def getAdminPassword() {
        Settings.findWhere(["key":grailsApplication.config.seeko.settings.keys["admin.password"]])
    }
}
