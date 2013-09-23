package org.seeko



import org.junit.*
import grails.test.mixin.*

@TestFor(SettingsController)
@Mock(Settings)
class SettingsControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/settings/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.settingsInstanceList.size() == 0
        assert model.settingsInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.settingsInstance != null
    }

    void testSave() {
        controller.save()

        assert model.settingsInstance != null
        assert view == '/settings/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/settings/show/1'
        assert controller.flash.message != null
        assert Settings.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/settings/list'

        populateValidParams(params)
        def settings = new Settings(params)

        assert settings.save() != null

        params.id = settings.id

        def model = controller.show()

        assert model.settingsInstance == settings
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/settings/list'

        populateValidParams(params)
        def settings = new Settings(params)

        assert settings.save() != null

        params.id = settings.id

        def model = controller.edit()

        assert model.settingsInstance == settings
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/settings/list'

        response.reset()

        populateValidParams(params)
        def settings = new Settings(params)

        assert settings.save() != null

        // test invalid parameters in update
        params.id = settings.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/settings/edit"
        assert model.settingsInstance != null

        settings.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/settings/show/$settings.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        settings.clearErrors()

        populateValidParams(params)
        params.id = settings.id
        params.version = -1
        controller.update()

        assert view == "/settings/edit"
        assert model.settingsInstance != null
        assert model.settingsInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/settings/list'

        response.reset()

        populateValidParams(params)
        def settings = new Settings(params)

        assert settings.save() != null
        assert Settings.count() == 1

        params.id = settings.id

        controller.delete()

        assert Settings.count() == 0
        assert Settings.get(settings.id) == null
        assert response.redirectedUrl == '/settings/list'
    }
}
