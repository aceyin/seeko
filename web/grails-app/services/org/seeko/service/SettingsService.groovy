package org.seeko.service

import org.apache.commons.beanutils.BeanUtils
import org.seeko.command.SettingsCommand

class SettingsService {

    def grailsApplication

    private static GRAILS_AUTO_ADDED_PROPERTIES = ['class', 'properties', 'metaClass', 'errors']

    /**
     * Load the default configuration
     * @return
     */
    def SettingsCommand loadDefaultSettings() {
        SettingsCommand cmd = new SettingsCommand()
        Map<String, String> defaultCfg = grailsApplication.config.seeko.general.settings.default
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
        File file = new File(grailsApplication.config.seeko.conf.exposed)
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
        Properties p = new Properties()
        p.load(new FileInputStream(grailsApplication.config.seeko.conf.exposed))
        if (p.size() == 0) {
            return loadDefaultSettings()
        } else {
            BeanUtils.populate(cmd, p)
            return cmd
        }
    }

    /**
     * Save settings.
     */
    def saveSettings(SettingsCommand cmd) {
        Map<String, String> map = BeanUtils.describe(cmd)
        removeGrailsAutoAddedProperties(map)
        Properties p = new Properties()
        p.putAll(map)
        p.store(new FileOutputStream(grailsApplication.config.seeko.conf.exposed), "Updated at " + new Date())
    }

    /**
     *
     * since grails will auto add some fields into grails class, these fields do not need
     * to be saved into files, so here we remove these fields.
     * @param map
     */
    private void removeGrailsAutoAddedProperties(Map<String, String> map) {
        GRAILS_AUTO_ADDED_PROPERTIES.each { k ->
            map.remove(k)
        }
    }
}
