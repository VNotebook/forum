package foro

class Regular extends User {
    int postViews
    int strikesNumber
    int starsNumber

    static hasOne = [user : User]
    static hasMany = [posts : Post]

    static constraints = {
        hasMany nullabel: true
        postViews min: 0
        strikesNumber min: 0, max: 3
        starsNumber min: 0, max: 5
    }
}
