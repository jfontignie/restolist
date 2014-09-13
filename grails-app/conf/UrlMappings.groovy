class UrlMappings {

	static mappings = {

//        for (controller in grailsApplication.controllerClasses) {
//            def cName = controller.logicalPropertyName
//            def packageName = controller.packageName
//
//            if (packageName.contains(".admin") || packageName.contains(".springsecurity")) {
//                "/admin/${cName}/$action?/$id?"(controller: cName) {
//                    constraints {
//                    }
//                }
//            } else {
//                "/${cName}/$action?/$id?"(controller: cName) {
//                    constraints {
//                        // apply constraints here
//                    }
//                }
//            }
//        }

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "list")
        "/admin"(view: '/admin')
        "500"(view:'/error')


	}
}
