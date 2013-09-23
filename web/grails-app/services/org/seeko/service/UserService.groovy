package org.seeko.service

import org.seeko.User

class UserService {

    def hasAdminAccount () {
        User admin = getAdminAccount()
        if(admin) {
            return true
        }
        return false
    }

    def getAdminAccount() {
        User.find {type == User.Type.admin}
    }
}
