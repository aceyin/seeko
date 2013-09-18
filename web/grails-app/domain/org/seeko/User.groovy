package org.seeko

class User {

    static enum UserType {
        ADMIN,NORMAL
    }

    String email
    String password
    UserType type

    static constraints = {
        email(email:true)
        password(blank:false)
    }
}
