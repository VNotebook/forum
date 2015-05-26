package foro

class Post {
    String topic
    int rate
    Date dateCreated
    Date lastUpdated
    boolean itsAllowed

    static hasMany = [files : File, comments : String]
    static belongsTo = [owner : Regular, forum : Forum]

    static constraints = {
        topic size: 3..50
        // Enabling the following will prevent updates to existing objects
        /*dateCreated min: new Date()
        lastUpdated min: new Date()*/
        rate min: 0
    }

    static mapping = {
        owner column: 'owner_id'
        forum column: 'fatherForum_id'
    }
}
