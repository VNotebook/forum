package foro

class Post {
    String topic
    Date dataCreated
    Date lastUpdated
    boolean itsAllowed

    static hasMany = [files : File]
    static belongsTo = [owner : Regular, forum : Forum]

    static constraints = {
        topic size: 3..50
        dataCreated min: new Date()
        lastUpdated min: new Date()
    }

    static mapping = {
        owner column: 'owner_id'
        forum column: 'fatherForum_id'
    }

    def comment() {
        // TODO: implement comment
    }

    def rate() {
        // TODO: implement rate
    }

    def share() {
        // TODO: implement share
    }
}
