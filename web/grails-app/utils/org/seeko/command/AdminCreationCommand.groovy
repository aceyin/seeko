package org.seeko.command

import grails.validation.Validateable

/**
 * Created by eniayin on 13-9-23.
 */
@Validateable
class AdminCreationCommand {
    String email
    String password
    String password2

    static constraints = {
        email(email: true, blank: false)
        password(blank: false)
        password2(blank: false, validator: { pwd, obj ->
            def pwd1 = obj.password
            if (pwd != pwd1) {
                return ['AdminCreationCommand.two.passwords.not.equals']
            }
            return true
        })
    }
}
