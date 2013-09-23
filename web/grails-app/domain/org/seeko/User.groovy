package org.seeko

class User {

    static enum Type {
        admin, normal
    }

    String email
    String password
    Type type

    static constraints = {
        email(email: true)
        password(blank: false)
    }
}
