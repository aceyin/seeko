package org.seeko

/**
 * TODO:Fish, move all CRUD operations in #link ProjectController into this class
 * When creating/deleting/updating Projects, we should:
 * 1. update the data in database
 * 2. create/update the project folder in seeko's workspace.
 *
 * NOTICE:
 * The project can not be renamed, since the project information not stores in database, but also saved into file system.
 * When creating a new project, we will save the project data into database, at the same time, a folder with the Project's name
 * will be created in ${seeko.repo.dir} folder. This folder is used to store all repositories of this project.
 */
class ProjectService {

    /**
     * Check if a project exists by the project's name.
     * @param source
     * @return true if the project exists, otherwise false.
     */
    def exist(Project source) {
        Project project = Project.findByName(source.name)
        if (project) {
            return true
        }
        return false
    }

    /**
     * Save the project.
     * Main logic:
     * 1. check if the project exists by name
     * 2. save the project data into database
     * 3. creating corresponding folder (folder name is project name) in ${seeko.repo.dir}*
     * 4. save the project data (JSON format) into the directory created in step 3, the file name is : project.conf.
     *    this file will be read by "indexer" node and other nodes.
     *
     * @param project
     * @return the saved project
     */
    def save(Project project) {
        //TODO: Fish implement
        project.save(flush: true)
    }
}
