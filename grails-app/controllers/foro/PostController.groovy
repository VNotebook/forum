package foro

class PostController extends CRUDController {
    PostController() {
        super(Post)
    }

    def myPosts() {
        def foreignKey = session.userId
        def posts = Post.where {
            owner.id == foreignKey
        }.findAll()
        render(view: "myPosts", model: [posts: posts])
    }

    def comment() {
        def content = params.commentContent
        content = content.trim()
        if (!content) {
            println("Empty comment")
            render "Empty comment"
            return
        }

        def id = params.actualPost
        def post = Post.get(id)

        if (!post) {
            println("Cannot comment post with id $id because it was not found")
            render "No such post"
            return
        }

        post.addToComments(content)

        post.save(flush: true)

        render "Ok"
    }

    def rate() {
        def id = params.actualPost
        def post = Post.get(id)

        if (!post) {
            println("Cannot rate post with id $id because it was not found")
            render "No such post"
            return
        }

        ++post.rate;

        post.save(flush: true)

        render "Ok"
    }

    def share() {
        render "Not implemented yet"
    }
}
