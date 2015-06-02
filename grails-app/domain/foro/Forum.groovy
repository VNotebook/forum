package foro

class Forum {
    //static searchable = [only: ['name']]

    String name
    Date dateCreated
    String category

    Admin admin

    static hasMany = [posts : Post]

    static constraints = {
        name size: 3..20, unique: true
        dateCreated min: new Date()
        category size: 3..15
    }
}
