package org.seeko

/**
 * The filter for authenticate.
 */
class AuthenticateFilters {

    def filters = {
        loginCheck(controller: 'settings|project', action: '*') {
            before = {
                if (!session[Constants.ADMIN_SESSION_KEY]) {
                    redirect(controller: 'admin', action: 'index')
                    return false
                }
            }
        }
    }
}
