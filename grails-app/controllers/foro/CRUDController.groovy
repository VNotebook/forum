package foro

import grails.converters.JSON
import grails.transaction.Transactional

@Transactional(readOnly = true)
abstract class CRUDController {
    static allowedMethods = [create: "POST", update: "POST", delete: "DELETE"]

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
        render domainClass.list() as JSON
    }

    def get(int id) {
        def instance = domainClass.get(id)

        if (!instance) {
            println("No user with id $id")
            render "No such item"
            return
        }

        render domainClass.get(id) as JSON
    }

    @Transactional
    def create() {
        def instance = createInstance()

        if (!instance) return

        def result = instance.save flush: true

        if (!result) {
            println("Errors while creating entity: " + instance.errors)
            render "Errors sent to console"
            return
        }

        render "Ok"
    }

    @Transactional
    def update() {
        def instance = domainClass.get(params.id)

        if (!instance) {
            println("Entity with id ${params.id} not found")
            render "No item with such id"
            return
        }

        def updateResult = updateInstance(instance)

        if (!updateResult) return

        def result = instance.save flush:true

        if (!result) {
            println("Errors while updating entity: " + instance.errors)
            render "Errors sent to console"
            return
        }

        render "Ok"
    }

    @Transactional
    def delete() {
        def instance = domainClass.get(params.id)

        if (instance == null) {
            println("No user with id ${params.id}")
            render "No such item"
            return
        }

        instance.delete flush:true

        render "Ok"
    }
}
