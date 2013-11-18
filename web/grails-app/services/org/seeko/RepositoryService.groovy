package org.seeko

/**
 * TODO: Fish, move all CRUD operations in #link RepositoryController into here
 * The service class for Repository.
 * With create/delete repositories, we should update the database and the repository files in ${seeko.home} directory.
 *
 * The repository name also can not be changed after it created, since when creating repository, the data of this repository
 * will be stored in database, and a folder with the repository name will be created in ${seeko.home}/${project.name} folder.
 * The repository folder will be used to store all the source files checkouted from remote SCM.
 */
class RepositoryService {

    /**
     * Check if the repository exists according to it's URL.
     * @param repository
     * @return true if the repository exists, otherwise false.
     */
    def exist(Repository repository) {
        //TODO: Fish , implement
    }

    /**
     * Save the repository.
     * Main logic:
     * 1. check if the repository exists
     * 2. save the repository data to database
     * 3. create corresponding repository directory (the directory name is repository name) in ${seeko.repo.dir}/${project.name} folder.
     * 4. save the repository data (JSON format) into the directory, the JSON file name is : repository.conf.
     *    This config file will be read by "indexer" node for checkout/update codes from remote SCM.
     *
     * @param repository
     * @return the saved repository.
     */
    def save(Repository repository) {
        //TODO: Fish, implement
    }
}
