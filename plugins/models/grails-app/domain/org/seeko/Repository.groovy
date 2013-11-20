package org.seeko


class Repository {
    /* the name of the repository */
    String name
    /* the type of this repository */
    String type
    /* the username of this repository */
    String user
    /* the password of this repository */
    String password
    /* the URL of this repository */
    String url
    /* the exclusions of this repository */
    String exclusions
    /* the latest revision of this repository */
    String latestRevision
    /* the latest update time */
    Long latestUpdate

    static belongsTo = [project: Project]

    static constraints = {
        name(blank: false,unique: true)
        type(blank: false, inList: ['SVN', 'GIT', 'CVS'])
        url(blank: false, unique: true)
        user(blank: true)
        password(blank: true)
        latestRevision(blank: true)
        latestUpdate
    }
}
