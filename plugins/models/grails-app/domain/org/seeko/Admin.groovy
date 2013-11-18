package org.seeko

class Admin {

    String email
    String password

    static constraints = {
        email(email: true)
        password(blank: false)
    }
}
