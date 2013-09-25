import org.seeko.utils.SystemUtil

class BootStrap {

    def init = { servletContext ->
        println "Bootstrap init method called"
        SystemUtil.initSystem()
        println "After SystemUtil.initSystem"
    }
    def destroy = {
    }
}
