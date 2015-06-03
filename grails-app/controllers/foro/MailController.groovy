package foro

class MailController {

    def index() {
        render (view: "sendMail")
    }

    def sendTestMail(MailCommand command) {
        def mail = command.to
        if (!mail) {
            redirect(action: 'index')
            return
        }

        if (command.hasErrors()) {
            render (view: "mailSent", model: [error: 'La dirección de correo electrónico no es válida'])
            return
        }

        sendMail {
            to mail
            from "vnotebook@yahoo.com"
            subject "Mensaje de nuestro foro"
            body "Este es un mensaje de prueba"
        }

        render (view: "mailSent")
    }
}

@grails.validation.Validateable
class MailCommand {
    String to

    static constraints = {
        to(blank: false, email: true)
    }
}
