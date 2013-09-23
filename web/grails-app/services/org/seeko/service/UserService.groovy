package org.seeko.service

import org.codehaus.groovy.grails.plugins.codecs.MD5Codec
import org.seeko.Admin

class UserService {

    /**
     * Check if the administrator account exist.
     * @return
     */
    def adminExists() {
        Admin admin = getAdmin()
        if (admin != null) {
            return true
        }
        return false
    }

    /**
     * Get the first administrator account
     * @return
     */
    def getAdmin() {
        Admin.first()
    }

    /**
     * Create administrator account.
     * @param admin
     * @return
     */
    def createAdmin(Admin admin) {
        if (!admin) {
            return false
        }

        String pwd = MD5Codec.encode(admin.getPassword())
        admin.setPassword(pwd)
        if (!admin.save(flush: true)) {
            admin.errors.each {
                println it
            }
            return false
        }
        return true
    }

    /**
     * Update the password of the given administrator account.
     * @param email
     * @param password
     */
    def updateAdminPassword(String password) {
        Admin admin = Admin.first()
        admin.setPassword(MD5Codec.encode(password))
        if (!admin.save()) {
            return false
        }
        return true
    }

    /**
     * Get the administrator account by the given email and password
     * @param email
     * @param password
     */
    def getAdmin(String email, String password) {
        String pwd = MD5Codec.encode(password)
        Admin.findByEmailAndPassword(email, pwd)
    }

}
