class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }

        // controllers
        "/"(controller: "home", action: "index")
        "/settings/"(controller: 'settings', action: 'index')
        "/admin"(controller: 'admin', action: 'index')

        // errors
        "500"(view: '/error')
        "404"(view: '/not_found')
    }
}
