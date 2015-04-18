package foro

class Post {
    String topic
    Date dataCreated
    Date lastUpdated
    boolean itsAllowed

    static hasMany = [files : File]

    static constraints = {
        files nullable: true
        topic size: 3..50
        dataCreated min: new Date()
        lastUpdated min: new Date()
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

    def beforeInsert(){
        dateCreated=new Date()
    }

    def beforeUpdate(){
        lastUpdated=new Date()
    }

    def beforeDelete(){
        File.withNewSession{
            files*.delete()
        }
    }
}
