package org.seeko

import org.seeko.service.UserService

class HomeController {

    UserService userService

    def index() {
        if (!userService.hasAdminAccount()) {
            redirect([controller: "user",action: "create",params: ['admin':'true']])
        }else{
            render(view: "/home/index")
        }
    }
}
