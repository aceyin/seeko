import org.seeko.utils.SystemUtil

class BootStrap {

    def init = { servletContext ->
        SystemUtil.initSystem()
    }
    def destroy = {
    }
}
