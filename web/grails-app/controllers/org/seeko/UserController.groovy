package org.seeko

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class UserController {
    static scaffold = true

    static final Logger LOGGER = LoggerFactory.getLogger(UserController.class)

    def create () {
        LOGGER.debug("Creating account for type: {}",params.type)
        def tipMsg = ""
        switch (params.type) {
            case User.Type.normal.name():
                tipMsg = message(code:  'seeko.labels.create.user.account')
                break
            case User.Type.admin.name():
            default:
                tipMsg = message(code:  'seeko.labels.create.admin.account')
                break
        }
        render (view: '/user/create',model: [type:params.type,tip:tipMsg])
    }
}
