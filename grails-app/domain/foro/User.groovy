package foro

class User {

    String name
    String lastname
    int age
    String username
    String password

    static constraints = {
        name blank: false, size: 3..50
        lastname blank: false, size: 3..50
        age blank: false, min: 13
        username blank: false, unique: true
        password blank: false, minSize: 8, validator: { password ->
            boolean hasUpperCase, hasLowerCase, hasNumber
            hasLowerCase = hasNumber = hasUpperCase = false
            password.each({
                hasUpperCase = hasUpperCase || Character.isUpperCase(it)
                hasLowerCase = hasLowerCase || Character.isLowerCase(it)
                hasNumber = hasNumber || Character.isDigit(it)
            })
            return hasNumber && hasUpperCase && hasLowerCase
        }
    }
}
