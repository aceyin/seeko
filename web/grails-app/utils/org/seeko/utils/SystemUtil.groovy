package org.seeko.utils

import grails.util.Holders
import org.seeko.service.SettingsService
/**
 * Created by aceyin on 13-9-7.
 */
class SystemUtil {

    private static File WORKSPACE = new File(Holders.grailsApplication.config.seeko.workspace)

    /**
     * Check if workspace exists
     * @return
     */
    static boolean workspaceExists() {
        WORKSPACE.exists()
    }

    /**
     * Initialize the workspaces - creating the directories
     */
    static void initSystem() {
        if (!workspaceExists()) {
            WORKSPACE.mkdir()
            initEsWorkspace()
            initRepoWorkspace()
            initDatabaseWorkspace()
            initDefaultSettings()
        }
    }

    private static void initDefaultSettings() {
        SettingsService settingsService = Holders.applicationContext.getBean(SettingsService.class)
        settingsService.initializeSettings()
    }

    private static boolean initDatabaseWorkspace() {
        new File(Holders.grailsApplication.config.seeko.db.dir).mkdir()
    }

    private static boolean initRepoWorkspace() {
        new File(Holders.grailsApplication.config.seeko.repo.dir).mkdir()
    }

    private static void initEsWorkspace() {
        Holders.grailsApplication.config.seeko.es.conf.each { k, v ->
            new File(v).mkdir()
        }
    }

}
