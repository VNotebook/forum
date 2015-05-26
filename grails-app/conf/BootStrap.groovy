import foro.*

class BootStrap {

    def init = { servletContext ->
        def user = new Regular(name: "The User", lastname: "The last", age: 20, username: "user", password: "qwertY12")
        user.save()

        def admin = new Admin(name: "The Admin", lastname: "The last", age: 20, username: "admin", password: "qwertY12",
            level: 1, rating: 5)

        def forum = new Forum(name: "Forum 1", category: "Forums")
        admin.addToForums(forum)

        admin.save()

        def post = new Post(topic: "A topic", itsAllowed: true, owner: user, forum: forum)

        post.save(flush: true)
    }
    def destroy = {
    }
}
