package org.seeko.utils

import grails.util.Holders
import org.seeko.service.SettingsService
/**
 * Created by aceyin on 13-9-7.
 */
class SystemUtil {

    /**
     * Initialize the workspaces - creating the directories
     */
    static void initSystem() {
        initWorkspace()
        initEsWorkspace()
        initRepoWorkspace()
        initDatabaseWorkspace()
        initDefaultSettings()
    }

    private static void initWorkspace() {
        File dir = new File(Holders.grailsApplication.config.seeko.workspace)
        if (!dir.exists()) {
            dir.mkdir()
        }
    }

    private static void initDefaultSettings() {
        SettingsService settingsService = Holders.applicationContext.getBean(SettingsService.class)
        settingsService.initializeSettings()
    }

    private static boolean initDatabaseWorkspace() {
        File file = new File(Holders.grailsApplication.config.seeko.db.dir)
        if (!file.exists()) {
            file.mkdir()
        }
    }

    private static boolean initRepoWorkspace() {
        File file = new File(Holders.grailsApplication.config.seeko.repo.dir)
        if (!file.exists()) {
            file.mkdir()
        }
    }

    private static void initEsWorkspace() {
        // create home directory for es
        String esdir = Holders.grailsApplication.config.seeko.es.dir
        println "Creating es workspace :" + esdir
        File esHome = new File(esdir)

        if (!esHome.exists()) {
            esHome.mkdir()
        }
        // create conf directory for es
        File esConf = new File(Holders.grailsApplication.config.seeko.es.conf.dir)
        if (!esConf.exists()) {
            esConf.mkdir()
        }
        // create data directory for es
        File esData = new File(Holders.grailsApplication.config.seeko.es.data.dir)
        if (!esData.exists()) {
            esData.mkdir()
        }
    }

}
