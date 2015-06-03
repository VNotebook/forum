package foro

import grails.transaction.Transactional

@Transactional
class BuscarService {
    def buscarUsuarios(params) {
        def query = params.textoBuqueda

        if (!query) {
            return null
        }

        //return User.search(query, escape: true, properties: ["username"])
        // Not implemented because the searchable plugin is not supported
        return null
    }

    def buscarForos(params) {
        def query = params.textoBuqueda

        if (!query) {
            return null
        }

        //return Forum.search(query, escape: true, properties: ["name"])
        // Not implemented because the searchable plugin is not supported
        return null
    }
}
