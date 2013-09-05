package org.seeko

class SystemInitService {

    def grailsApplication

    boolean isSystemInitialized() {
        return homeExists()
    }

    private boolean homeExists() {
        File home = getWorkspaceHome()
        if (!home.exists()) {
            log.info("Workspace home directory not exists.")
            return false;
        }
        return true;
    }

    private File getWorkspaceHome () {
        return new File(grailsApplication.config.seeko.workspace.home)
    }

    /**
     * Initialize the system.
     * This method only called when the system is not initialized.
     */
    void initSystem() {
        if(!isSystemInitialized()) {
            getWorkspaceHome().mkdir()
        }
    }
}
