package foro

class Admin extends User {
    int level
    double rating

    static constraints = {
        level range: 1..5
        rating range: 0..100
    }
}
