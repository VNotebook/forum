package foro

class ForumController extends CRUDController {
    def buscarService

    ForumController() {
        super(Forum)
    }

    def buscar() {
        render buscarService.buscarForos(params)
    }
}
