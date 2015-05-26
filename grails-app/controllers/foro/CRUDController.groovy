package foro

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
abstract class CRUDController {
    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE",
                             "create": "GET", "edit": "GET", "show": "GET"]

    def beforeInterceptor = {
        println "Se va a ejecutar la acción: ${actionUri}"
    }

    def afterInterceptor = {
        println "Se ha ejecutado la acción: ${actionUri}"
    }

    private def domainClass

    protected def createInstance() {
        domainClass.newInstance(params)
    }

    protected def updateInstance(instance) {
        instance.properties = params
        return true
    }

    def CRUDController(domainClass) {
        this.domainClass = domainClass
    }

    def index() {
        respond domainClass.list()
    }

    def create() {
        respond createInstance()
    }

    def show(int id) {
        def instance = domainClass.get(id)
        if (!instance)
            notFound()
        else
            respond instance
    }

    def edit(int id) {
        def instance = domainClass.get(id)
        if (!instance)
            notFound()
        else
            respond instance
    }

    @Transactional
    def save() {
        def instance = createInstance()

        if (!instance) return

        def result = instance.save flush: true

        if (!result) {
            println("Errors while creating entity: " + instance.errors)
            respond instance.errors, view: 'create'
            return
        }

        redirect instance
    }

    @Transactional
    def update() {
        def instance = domainClass.get(params.id)

        if (!instance) {
            println("Entity with id ${params.id} not found")
            notFound()
            return
        }

        def updateResult = updateInstance(instance)

        if (!updateResult) return

        def result = instance.save flush:true

        if (!result) {
            println("Errors while updating entity: " + instance.errors)
            respond instance.errors, view: 'edit'
            return
        }

        redirect instance
    }

    @Transactional
    def delete() {
        def instance = domainClass.get(params.id)

        if (instance == null) {
            println("No user with id ${params.id}")
            notFound()
            return
        }

        instance.delete flush:true

        redirect action: "index", method: "GET"
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
