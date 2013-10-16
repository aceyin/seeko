package org.seeko

/**
 * TODO:Ace, move all CRUD operations in #link ProjectController into this class
 * When creating/deleting/updating Projects, we should:
 * 1. update the data in database
 * 2. create/update the project folder in seeko's workspace.
 *
 * NOTICE:
 * The project can not be renamed, since the project information not stores in database, but also saved into file system.
 * When creating a new project, we will save the project data into database, at the same time, a folder with the Project's name
 * will be created in ${seeko.home} folder. This folder is used to store all repositories of this project.
 */
class ProjectService {

    def exist(Project source) {
        Project proj = Project.findByName(source.name)
        if (proj) {
            return true
        }
        return false
    }

    def save(Project project) {
        project.save(flush: true)
    }
}
