package foro

class User {
    //static searchable = [only: ['username']]

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
        password blank: false, minSize: 8/*, validator: { password -> // Deshabilitado para usar MD5
            boolean hasUpperCase, hasLowerCase, hasNumber
            hasLowerCase = hasNumber = hasUpperCase = false
            password.each({
                hasUpperCase = hasUpperCase || Character.isUpperCase(it.charAt(0))
                hasLowerCase = hasLowerCase || Character.isLowerCase(it.charAt(0))
                hasNumber = hasNumber || Character.isDigit(it.charAt(0))
            })
            return hasNumber && hasUpperCase && hasLowerCase
        }*/
    }
}
