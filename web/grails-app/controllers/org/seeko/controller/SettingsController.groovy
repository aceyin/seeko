package org.seeko.controller

class SettingsController {

    static allowedMethods = [password: ['POST','GET']]

    def index() {
        render (view: "/settings/index")
    }

    def password() {
        render (view: "/settings/password")
    }
}
