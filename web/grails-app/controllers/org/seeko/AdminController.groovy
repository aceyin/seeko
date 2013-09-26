package org.seeko

import org.seeko.command.AdminCreationCommand
import org.seeko.command.LoginCommand
import org.seeko.service.UserService

@Mixin(ControllerSupport)
class AdminController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    UserService userService

    /**
     * Login to system
     */
    def login(LoginCommand cmd) {
        if (request.method == 'GET') {
            render(view: '/admin/login')
            return
        } else {
            Admin admin = userService.getAdmin(cmd.email, cmd.password)
            if (!admin) {
                flash.message = message([code: 'seeko.message.login.fail'])
                redirect([action: 'login'])
                return
            }
            session.setAttribute Constants.ADMIN_SESSION_KEY, admin
            redirect([controller: "home", action: "index"])
        }
    }

    /**
     * Logout current user.
     */
    def logout() {
        session.removeAttribute(Constants.ADMIN_SESSION_KEY)
        session.invalidate()
        redirect(controller: 'home', action: 'index')
    }

/*
    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [userInstanceList: Admin.list(params), userInstanceTotal: Admin.count()]
    }
*/

    /**
     * create admin form.
     * @return
     */
    def create() {
        [userInstance: new Admin(params)]
    }

    /**
     * Save administrator account
     * @return
     */
    def save(AdminCreationCommand cmd) {
        if (cmd.hasErrors()) {
            render(view: 'create', model: [cmd: cmd])
            return
        }

        def userInstance = new Admin(params)
        boolean success = userService.createAdmin(userInstance)
        if (!success) {
            render(view: "create", model: [cmd: cmd])
            return
        }
        redirect(controller: "home", action: "index")
    }
/*
    def show(Long id) {
        def userInstance = Admin.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'Admin'), id])
            redirect(action: "list")
            return
        }

        [userInstance: userInstance]
    }

    def edit(Long id) {
        def userInstance = Admin.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'Admin'), id])
            redirect(action: "list")
            return
        }

        [userInstance: userInstance]
    }

    def update(Long id, Long version) {
        def userInstance = Admin.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'Admin'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (userInstance.version > version) {
                userInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'user.label', default: 'Admin')] as Object[],
                          "Another user has updated this Admin while you were editing")
                render(view: "edit", model: [userInstance: userInstance])
                return
            }
        }

        userInstance.properties = params

        if (!userInstance.save(flush: true)) {
            render(view: "edit", model: [userInstance: userInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'Admin'), userInstance.id])
        redirect(action: "show", id: userInstance.id)
    }

    def delete(Long id) {
        def userInstance = Admin.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'Admin'), id])
            redirect(action: "list")
            return
        }

        try {
            userInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'Admin'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'user.label', default: 'Admin'), id])
            redirect(action: "show", id: id)
        }
    }
    */
}
