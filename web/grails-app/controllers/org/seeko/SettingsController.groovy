package org.seeko

import org.seeko.command.SettingsCommand

@Mixin(ControllerSupport)
class SettingsController {

    static allowedMethods = [save: "POST"]

    /**
     * Settings index page.
     * @return
     */
    def index() {
        if (!isLoggedIn()) {
            redirect(controller: 'admin', action: 'login')
            return
        }
        render(view: 'create')
    }

    /**
     * Save settings
     * @return
     */
    def save(SettingsCommand cmd) {
        def settingsInstance = new Settings(params)
        if (!settingsInstance.save(flush: true)) {
            render(view: "create", model: [settingsInstance: settingsInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'settings.label', default: 'Settings'), settingsInstance.id])
        redirect(action: "show", id: settingsInstance.id)
    }
}
