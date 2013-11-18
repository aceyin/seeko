package org.seeko

import org.seeko.command.SettingsCommand
import org.seeko.service.SettingsService

@Mixin(ControllerSupport)
class SettingsController {

    static allowedMethods = [save: "POST"]

    SettingsService settingsService

    /**
     * Settings index page.
     * @return
     */
    def index() {
        SettingsCommand cmd = settingsService.loadSettings()
        if (!cmd) {
            cmd = settingsService.loadDefaultSettings()
        }

        render(view: 'create', model: ['settings': cmd])
    }

    /**
     * Save settings
     * @return
     */
    def save(SettingsCommand cmd) {
        settingsService.saveSettings(cmd)
        redirect(controller: 'settings', action: 'index')
    }
}
