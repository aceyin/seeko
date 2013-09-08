import org.seeko.utils.SystemUtil

class BootStrap {

    def init = { servletContext ->
        SystemUtil.initWorkspace()
    }
    def destroy = {
    }
}
