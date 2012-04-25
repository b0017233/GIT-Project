package gitproject



import org.junit.*
import grails.test.mixin.*

@TestFor(PlacementsController)
@Mock(Placements)
class PlacementsControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/placements/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.placementsInstanceList.size() == 0
        assert model.placementsInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.placementsInstance != null
    }

    void testSave() {
        controller.save()

        assert model.placementsInstance != null
        assert view == '/placements/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/placements/show/1'
        assert controller.flash.message != null
        assert Placements.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/placements/list'


        populateValidParams(params)
        def placements = new Placements(params)

        assert placements.save() != null

        params.id = placements.id

        def model = controller.show()

        assert model.placementsInstance == placements
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/placements/list'


        populateValidParams(params)
        def placements = new Placements(params)

        assert placements.save() != null

        params.id = placements.id

        def model = controller.edit()

        assert model.placementsInstance == placements
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/placements/list'

        response.reset()


        populateValidParams(params)
        def placements = new Placements(params)

        assert placements.save() != null

        // test invalid parameters in update
        params.id = placements.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/placements/edit"
        assert model.placementsInstance != null

        placements.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/placements/show/$placements.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        placements.clearErrors()

        populateValidParams(params)
        params.id = placements.id
        params.version = -1
        controller.update()

        assert view == "/placements/edit"
        assert model.placementsInstance != null
        assert model.placementsInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/placements/list'

        response.reset()

        populateValidParams(params)
        def placements = new Placements(params)

        assert placements.save() != null
        assert Placements.count() == 1

        params.id = placements.id

        controller.delete()

        assert Placements.count() == 0
        assert Placements.get(placements.id) == null
        assert response.redirectedUrl == '/placements/list'
    }
}
