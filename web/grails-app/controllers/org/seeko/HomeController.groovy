package org.seeko

import org.seeko.service.UserService

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
