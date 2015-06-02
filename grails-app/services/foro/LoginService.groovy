package foro

import grails.transaction.Transactional

@Transactional
class LoginService {

    def login(session, params) {
        def hashedPassword = SecurityUtils.md5(params.password)
        def user = User.where {
            username == params.username && password == hashedPassword
        }.find()

        if (user != null) {
            session.authStatus = "logged"

            // Internal additions
            session.userId = 2
            session.userName = user.username
        }

        return user
    }

    def logout(session) {
        session.authStatus = null

        // Internal cleanup
        session.userId = null
        session.userName = null
    }
}
