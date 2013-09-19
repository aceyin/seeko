package org.seeko

import org.seeko.service.UserService

class HomeController {

    UserService userService

    def index() {
        if (!userService.hasAdminAccount()) {
            redirect([controller: "user",action: "create",params: ['type':User.Type.admin.name()]])
        }else{
            render(view: "/home/index")
        }
    }
}
