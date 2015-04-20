package foro

class Forum {
    String name
    Date dateCreated
    String category

    static constraints = {
        name size: 3..20, unique: true
        dateCreated min: new Date()
        category size: 3..15
    }
}
