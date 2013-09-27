package org.seeko



import org.junit.*
import grails.test.mixin.*

@TestFor(RepositoryController)
@Mock(Repository)
class RepositoryControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/repository/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.repositoryInstanceList.size() == 0
        assert model.repositoryInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.repositoryInstance != null
    }

    void testSave() {
        controller.save()

        assert model.repositoryInstance != null
        assert view == '/repository/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/repository/show/1'
        assert controller.flash.message != null
        assert Repository.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/repository/list'

        populateValidParams(params)
        def repository = new Repository(params)

        assert repository.save() != null

        params.id = repository.id

        def model = controller.show()

        assert model.repositoryInstance == repository
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/repository/list'

        populateValidParams(params)
        def repository = new Repository(params)

        assert repository.save() != null

        params.id = repository.id

        def model = controller.edit()

        assert model.repositoryInstance == repository
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/repository/list'

        response.reset()

        populateValidParams(params)
        def repository = new Repository(params)

        assert repository.save() != null

        // test invalid parameters in update
        params.id = repository.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/repository/edit"
        assert model.repositoryInstance != null

        repository.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/repository/show/$repository.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        repository.clearErrors()

        populateValidParams(params)
        params.id = repository.id
        params.version = -1
        controller.update()

        assert view == "/repository/edit"
        assert model.repositoryInstance != null
        assert model.repositoryInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/repository/list'

        response.reset()

        populateValidParams(params)
        def repository = new Repository(params)

        assert repository.save() != null
        assert Repository.count() == 1

        params.id = repository.id

        controller.delete()

        assert Repository.count() == 0
        assert Repository.get(repository.id) == null
        assert response.redirectedUrl == '/repository/list'
    }
}
