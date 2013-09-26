package org.seeko

class AuthenticateFilters {

    def filters = {
        loginCheck(controller: 'settings') {
            before = {
                if (!session[Constants.ADMIN_SESSION_KEY]) {
                    redirect(controller: 'admin', action: 'login')
                    return false
                }
            }
        }
    }
}
