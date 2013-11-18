package org.seeko
/**
 * TODO: Fish, move the operations into service class
 */
class RepositoryController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]


    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [repositoryInstanceList: Repository.list(params), repositoryInstanceTotal: Repository.count()]
    }

    def create() {
        Project project = Project.get(params.pid)
        if (!project) {
            render message(code: 'seeko.message.no.project.with.id.found', params.pid)
            return
        }
        def repositoryInstance = new Repository(params)
        repositoryInstance.project = project
        return [repositoryInstance: repositoryInstance]
    }

    def save() {
        def repositoryInstance = new Repository(params)
        def pid = params.pid

        Project project = Project.get(pid)

        if (!project) {
            render message(code: 'seeko.message.no.project.with.id.found', pid)
            return
        }

        repositoryInstance.project = project

        if (!repositoryInstance.save(flush: true)) {
            render repositoryInstance.errors.allErrors.collect {
                message(error: it, encodeAs: 'HTML')
            }
            return
        }
        render message(code: 'seeko.message.save.data.success')
    }


    def edit(Long id) {
        def repositoryInstance = Repository.get(id)
        if (!repositoryInstance) {
            //TODO:Fish, update the default message code
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'repository.label', default: 'Repository'), id])
            redirect(action: "list")
            return
        }

        [repositoryInstance: repositoryInstance]
    }

    def update(Long id, Long version) {
        def repositoryInstance = Repository.get(id)
        if (!repositoryInstance) {
            render message(code: 'seeko.message.no.repository.with.id.found', id)
            return
        }

        if (version != null) {
            if (repositoryInstance.version > version) {
                //TODO: Fish update the default message code
                repositoryInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'repository.label', default: 'Repository')] as Object[],
                        "Another user has updated this Repository while you were editing")

                render repositoryInstance.errors.allErrors.collect {
                    message(error: it, encodeAs: 'HTML')
                }

                return
            }
        }

        repositoryInstance.properties = params

        if (!repositoryInstance.save(flush: true)) {
            render repositoryInstance.errors.allErrors.collect {
                message(error: it, encodeAs: 'HTML')
            }
            return
        }
        render message(code: 'seeko.message.save.data.success')
    }

}
