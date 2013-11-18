package org.seeko

import org.seeko.service.UserService

@Mixin(ControllerSupport)
class HomeController {

    UserService userService

    def index() {
        if (!userService.adminExists()) {
            redirect([controller: "admin", action: "create"])
        } else {
            render(view: "/home/index")
        }
    }
}
