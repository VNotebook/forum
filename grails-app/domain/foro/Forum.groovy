package foro

class Forum {
    String name
    Date dateCreated
    String category

    static hasMany = [posts : Post]

    static constraints = {
        posts nullable: true
        name size: 3..20, unique: true
        dateCreated min: new Date()
        category size: 3..15
    }

    def beforeInsert(){
        dateCreated=new Date()
    }

    def beforeDelete(){
        Post.withNewSession{
            posts*.delete()
        }
    }
}
