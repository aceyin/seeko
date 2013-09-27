package org.seeko

class Project {

    String name
    String lastUpdate

    static hasMany = [repositories: Repository]

    static constraints = {
        name(unique: true, blank: false, maxSize: 100)
    }
}
