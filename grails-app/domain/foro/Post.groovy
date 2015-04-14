package foro

class Post {
    String topic
    Date dataCreated
    Date lastUpdate
    boolean itsAllowed

    static constraints = {
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
