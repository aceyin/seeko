package org.seeko

/**
 * Created by aceyin on 13-9-24.
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
