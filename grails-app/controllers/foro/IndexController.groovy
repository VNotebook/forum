package foro

class IndexController {

    def index() {
        render(view: "/index", model: [lastPosts: Post.list(max: 10, sort: "lastUpdated", order: "desc"),
                topForums: Forum.findAll("from Forum as f order by size(f.posts) desc", [max: 10])])
    }
}
