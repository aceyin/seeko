import org.seeko.IndexController

class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(controller: IndexController)

		"500"(view:'/error')
	}
}
