package org.seeko

/**
 *
 * The common functions for all controller classes.
 * Will be Mixin by the controllers.
 *
 */
class ControllerSupport {

    /**
     * Check if current user is logged in.
     * @return
     */
    boolean isLoggedIn() {
        def admin = session.getAttribute(Constants.ADMIN_SESSION_KEY)
        if (admin) {
            return true
        }
        return false
    }
}
