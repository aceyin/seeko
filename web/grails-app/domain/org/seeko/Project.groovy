package org.seeko

class Project {

    String name
    String description
    String lastSync

    static hasMany = [repositories: Repository]

    static constraints = {
        name(unique: true, blank: false, maxSize: 100)
        description(nullable: true, maxSize: 255)
        lastSync(nullable: true)
    }
}
