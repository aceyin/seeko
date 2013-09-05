class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

        // Mapping the / to IndexController
		"/"(controller: IndexController, action: index)
		"500"(view:'/error')
	}
}
