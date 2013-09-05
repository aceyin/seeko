package org.seeko.utils

import grails.util.Holders

/**
 * Created by aceyin on 13-9-6.
 */
class SystemInitializer {

    static void initlize () {
        def workspace = Holders.grailsApplication.config.seeko.workspace;
        def home = new File (workspace.home)
        if(!home.exists()) {
            home.mkdir()
        }


    }
}
