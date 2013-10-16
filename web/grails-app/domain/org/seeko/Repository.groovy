package org.seeko

class Repository {
    String name
    String type
    String user
    String password
    String url
    String excludes

    static belongsTo = [project: Project]

    static constraints = {
        name(blank: false)
        type(blank: false, inList: ['SVN', 'GIT', 'CVS'])
        url(blank: false, unique: true)
        user(blank: false)
        password(blank: false)
    }
}
