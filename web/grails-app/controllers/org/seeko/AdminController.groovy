package org.seeko

import org.seeko.command.AdminCreationCommand
import org.seeko.command.LoginCommand
import org.seeko.service.UserService

@Mixin(ControllerSupport)
class AdminController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST", login: "POST"]

    UserService userService

    def index() {
        if (!userService.adminExists()) {
            redirect(action: 'create')
            return
        }
        render(view: '/admin/login')
    }

    /**
     * Login to system
     */
    def login(LoginCommand cmd) {
        Admin admin = userService.getAdmin(cmd.email, cmd.password)
        if (!admin) {
            flash.message = message([code: 'seeko.message.login.fail'])
            redirect([action: 'index'])
            return
        }
        session.setAttribute Constants.ADMIN_SESSION_KEY, admin
        redirect([controller: "home", action: "index"])
    }

    /**
     * Logout current user.
     */
    def logout() {
        session.removeAttribute(Constants.ADMIN_SESSION_KEY)
        session.invalidate()
        redirect(controller: 'home', action: 'index')
    }

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
}
