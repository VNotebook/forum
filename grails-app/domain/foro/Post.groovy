package foro

class Post {
    String topic
    Date dataCreated
    Date lastUpdate
    boolean itsAllowed

    static hasMany = [files : File]

    static constraints = {
        hasMany nullable: true
        topic size: 3..50
        dataCreated min: new Date()
        lastUpdate min: new Date()
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
