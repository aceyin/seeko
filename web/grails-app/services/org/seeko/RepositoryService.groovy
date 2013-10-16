package org.seeko

/**
 * TODO: Ace, move all CRUD operations in #link RepositoryController into here
 * The service class for Repository.
 * With create/delete repositories, we should update the database and the repository files in ${seeko.home} directory.
 *
 * The repository name also can not be changed after it created, since when creating repository, the data of this repository
 * will be stored in database, and a folder with the repository name will be created in ${seeko.home}/${project.name} folder.
 * The repository folder will be used to store all the source files checkouted from remote SCM.
 */
class RepositoryService {

}
