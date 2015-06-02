package foro

class UserController extends CRUDController {
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
        session.authStatus = "logged"
        // Temporarily setting a specific id manually
        session.userId = 2
        def user = User.get(session.userId)
        session.userName = user.username

        redirect(action: "index", controller: "index")
    }

    def logout() {
        session.removeAttribute("authStatus")
        redirect(action: "index", controller: "index")
    }
}
