package org.seeko

import org.springframework.dao.DataIntegrityViolationException

class RepositoryController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [repositoryInstanceList: Repository.list(params), repositoryInstanceTotal: Repository.count()]
    }

    def create() {
        [repositoryInstance: new Repository(params)]
    }

    def save() {
        def repositoryInstance = new Repository(params)
        if (!repositoryInstance.save(flush: true)) {
            render(view: "create", model: [repositoryInstance: repositoryInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'repository.label', default: 'Repository'), repositoryInstance.id])
        redirect(action: "show", id: repositoryInstance.id)
    }

    def show(Long id) {
        def repositoryInstance = Repository.get(id)
        if (!repositoryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'repository.label', default: 'Repository'), id])
            redirect(action: "list")
            return
        }

        [repositoryInstance: repositoryInstance]
    }

    def edit(Long id) {
        def repositoryInstance = Repository.get(id)
        if (!repositoryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'repository.label', default: 'Repository'), id])
            redirect(action: "list")
            return
        }

        [repositoryInstance: repositoryInstance]
    }

    def update(Long id, Long version) {
        def repositoryInstance = Repository.get(id)
        if (!repositoryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'repository.label', default: 'Repository'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (repositoryInstance.version > version) {
                repositoryInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'repository.label', default: 'Repository')] as Object[],
                          "Another user has updated this Repository while you were editing")
                render(view: "edit", model: [repositoryInstance: repositoryInstance])
                return
            }
        }

        repositoryInstance.properties = params

        if (!repositoryInstance.save(flush: true)) {
            render(view: "edit", model: [repositoryInstance: repositoryInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'repository.label', default: 'Repository'), repositoryInstance.id])
        redirect(action: "show", id: repositoryInstance.id)
    }

    def delete(Long id) {
        def repositoryInstance = Repository.get(id)
        if (!repositoryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'repository.label', default: 'Repository'), id])
            redirect(action: "list")
            return
        }

        try {
            repositoryInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'repository.label', default: 'Repository'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'repository.label', default: 'Repository'), id])
            redirect(action: "show", id: id)
        }
    }
}
