package org.seeko

class Project {

    String name
    String lastSync

    static hasMany = [repositories: Repository]

    static constraints = {
        name(unique: true, blank: false, maxSize: 100)
        lastSync(nullable: true)
    }
}
