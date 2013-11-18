package org.seeko.command

import grails.validation.Validateable

/**
 * Created by eniayin on 13-9-23.
 */
@Validateable
class LoginCommand {
    String email
    String password

    static constraints = {
        email(blank: false)
        password(blank: false)
    }
}
