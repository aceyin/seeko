package org.seeko

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
