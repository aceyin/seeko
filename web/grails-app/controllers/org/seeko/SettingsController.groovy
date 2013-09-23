package org.seeko

import org.springframework.dao.DataIntegrityViolationException

@Mixin(ControllerSupport)
class SettingsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        if (!isLoggedIn()) {
            redirect(controller: 'admin', action: 'login')
            return
        }
        render(view: 'create')
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [settingsInstanceList: Settings.list(params), settingsInstanceTotal: Settings.count()]
    }

    def create() {
        [settingsInstance: new Settings(params)]
    }

    def save() {
        def settingsInstance = new Settings(params)
        if (!settingsInstance.save(flush: true)) {
            render(view: "create", model: [settingsInstance: settingsInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'settings.label', default: 'Settings'), settingsInstance.id])
        redirect(action: "show", id: settingsInstance.id)
    }

    def show(Long id) {
        def settingsInstance = Settings.get(id)
        if (!settingsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'settings.label', default: 'Settings'), id])
            redirect(action: "list")
            return
        }

        [settingsInstance: settingsInstance]
    }

    def edit(Long id) {
        def settingsInstance = Settings.get(id)
        if (!settingsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'settings.label', default: 'Settings'), id])
            redirect(action: "list")
            return
        }

        [settingsInstance: settingsInstance]
    }

    def update(Long id, Long version) {
        def settingsInstance = Settings.get(id)
        if (!settingsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'settings.label', default: 'Settings'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (settingsInstance.version > version) {
                settingsInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'settings.label', default: 'Settings')] as Object[],
                        "Another user has updated this Settings while you were editing")
                render(view: "edit", model: [settingsInstance: settingsInstance])
                return
            }
        }

        settingsInstance.properties = params

        if (!settingsInstance.save(flush: true)) {
            render(view: "edit", model: [settingsInstance: settingsInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'settings.label', default: 'Settings'), settingsInstance.id])
        redirect(action: "show", id: settingsInstance.id)
    }

    def delete(Long id) {
        def settingsInstance = Settings.get(id)
        if (!settingsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'settings.label', default: 'Settings'), id])
            redirect(action: "list")
            return
        }

        try {
            settingsInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'settings.label', default: 'Settings'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'settings.label', default: 'Settings'), id])
            redirect(action: "show", id: id)
        }
    }
}
