package foro

class Regular extends User {
    int postViews
    int strikesNumber
    int starsNumber

    static hasMany = [posts : Post]

    static constraints = {
        posts nullable: true
        postViews min: 0
        strikesNumber min: 0, max: 3
        starsNumber min: 0, max: 5
    }

    def beforeDelete(){
        Post.withNewSession{
            posts*.delete()
        }
    }
}
