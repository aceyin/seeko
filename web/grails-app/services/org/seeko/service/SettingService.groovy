package org.seeko.service

import org.codehaus.groovy.grails.plugins.codecs.MD5Codec
import org.seeko.domain.Settings
import sun.security.provider.MD5

import javax.annotation.PostConstruct

class SettingService {

    def grailsApplication
    def passwordKey

    @PostConstruct
    init() {
        passwordKey = grailsApplication.config.seeko.settings.keys["admin.password"]
    }

    /**
     * Get the password of administrator account.
     * @return
     */
    def getAdminPassword() {
        Settings.findWhere(["key":passwordKey])
    }

    /**
     * Save the password of administrator account.
     * @param password
     * @return
     */
    def savePassword (String password) {
        String md5 = MD5Codec.encode (password)
        Settings settings = getAdminPassword();
        if (settings == null) {
            settings = new Settings();
            settings.setKey(passwordKey)
        }
        settings.setValue(md5)
        settings.save()
    }
}
