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
        if (!isLoggedIn()) {
            redirect(controller: 'admin', action: 'login')
            return
        }
        SettingsCommand settings = settingsService.loadSettings()
        if (!settings) {
            settings = settingsService.loadDefaultSettings()
        }

        render(view: 'create', model: ['settings', settings])
    }

    /**
     * Save settings
     * @return
     */
    def save(SettingsCommand cmd) {
    }
}
