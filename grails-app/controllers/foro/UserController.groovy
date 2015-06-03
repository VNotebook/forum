package foro

class UserController extends CRUDController {
    def loginService
    def buscarService

    def UserController() {
        super(User) // pun intended :)
    }

    def login() {
        render(view: "login")
    }

    def myProfile() {
        def user = User.get(session.userId)

        if (user instanceof Admin) {
            render(view: "adminProfile", model: [user: user])
        } else if (user instanceof Regular) {
            render(view: "regularProfile", model: [user: user])
        }
    }

    def doLogin() {
        if (session.authStatus == "logged") {
            redirect(action: "index", controller: "index")
            return
        }

        def username = params.username
        def password = params.password

        if (!username || !password) {
            redirect (action: "login")
            return
        }

        def result = loginService.login(session, params)

        if (result == null) {
            render (model: [error: "Usuario o contraseña incorrecta"], view: 'login')
            return
        }

        redirect(action: "index", controller: "index")
    }

    def logout() {
        loginService.logout(session)
        redirect(action: "index", controller: "index")
    }

    def buscar() {
        render buscarService.buscarUsuarios(params)
    }

    @Override
    protected createInstance() {
        def result = super.createInstance()
        result.password = SecurityUtils.md5(result.password)
        return result
    }

    @Override
    protected updateInstance(Object instance) {
        def result = super.updateInstance(instance)
        instance.password = SecurityUtils.md5(instance.password)
        return result
    }
}
