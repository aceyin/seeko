package org.seeko.service

import org.apache.commons.beanutils.BeanUtils
import org.seeko.command.SettingsCommand

class SettingsService {

    def grailsApplication

    /**
     * Load the default configuration
     * @return
     */
    def SettingsCommand loadDefaultSettings() {
        SettingsCommand cmd = new SettingsCommand()
        Map<String, String> defaultCfg = grailsApplication.config['seeko.general.settings.default']
        if (!defaultCfg) {
            throw new RuntimeException("Can not load default configuration data.")
        }
        BeanUtils.populate(cmd, defaultCfg)
        return cmd
    }

    /**
     * Initialize the settings, save the default settings to file.
     */
    def initializeSettings() {
        String cfg = grailsApplication.config['seeko.conf.exposed']
        File file = new File(cfg)
        if (!file.exists()) {
            SettingsCommand settings = loadDefaultSettings()
            saveSettings(settings)
        }
    }

    /**
     * Load the settings from file.
     * @return
     */
    def SettingsCommand loadSettings() {
        SettingsCommand cmd = new SettingsCommand()
        String cfg = grailsApplication.config['seeko.conf.exposed']
        Properties p = new Properties()
        p.load(new FileInputStream(cfg))

        BeanUtils.populate(cmd, p)
        return cmd
    }

    /**
     * Save settings.
     */
    def saveSettings(SettingsCommand cmd) {
        String cfg = grailsApplication.config['seeko.conf.exposed']
        Map<String, String> map = BeanUtils.describe(cmd)
        Properties p = new Properties()
        p.putAll(map)
        p.store(new FileOutputStream(cfg), "Updated at " + new Date())
    }
}
