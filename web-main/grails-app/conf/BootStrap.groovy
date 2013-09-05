import org.seeko.SystemInitService

class BootStrap {

    SystemInitService systemInitService

    def init = { servletContext ->
        if(!systemInitService.isSystemInitialized()) {
            systemInitService.initSystem()
        }
    }
    def destroy = {
    }
}
