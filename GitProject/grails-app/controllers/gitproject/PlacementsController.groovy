package gitproject

import org.springframework.dao.DataIntegrityViolationException

class PlacementsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [placementsInstanceList: Placements.list(params), placementsInstanceTotal: Placements.count()]
    }

    def create() {
        [placementsInstance: new Placements(params)]
    }

    def save() {
        def placementsInstance = new Placements(params)
        if (!placementsInstance.save(flush: true)) {
            render(view: "create", model: [placementsInstance: placementsInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'placements.label', default: 'Placements'), placementsInstance.id])
        redirect(action: "show", id: placementsInstance.id)
    }

    def show() {
        def placementsInstance = Placements.get(params.id)
        if (!placementsInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'placements.label', default: 'Placements'), params.id])
            redirect(action: "list")
            return
        }

        [placementsInstance: placementsInstance]
    }

    def edit() {
        def placementsInstance = Placements.get(params.id)
        if (!placementsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'placements.label', default: 'Placements'), params.id])
            redirect(action: "list")
            return
        }

        [placementsInstance: placementsInstance]
    }

    def update() {
        def placementsInstance = Placements.get(params.id)
        if (!placementsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'placements.label', default: 'Placements'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (placementsInstance.version > version) {
                placementsInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'placements.label', default: 'Placements')] as Object[],
                          "Another user has updated this Placements while you were editing")
                render(view: "edit", model: [placementsInstance: placementsInstance])
                return
            }
        }

        placementsInstance.properties = params

        if (!placementsInstance.save(flush: true)) {
            render(view: "edit", model: [placementsInstance: placementsInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'placements.label', default: 'Placements'), placementsInstance.id])
        redirect(action: "show", id: placementsInstance.id)
    }

    def delete() {
        def placementsInstance = Placements.get(params.id)
        if (!placementsInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'placements.label', default: 'Placements'), params.id])
            redirect(action: "list")
            return
        }

        try {
            placementsInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'placements.label', default: 'Placements'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'placements.label', default: 'Placements'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
