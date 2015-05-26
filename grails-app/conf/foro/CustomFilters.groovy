package foro

class CustomFilters {

    def filters = {
        all(controller:'*', action:'*', actionExclude:'index') {
            before = {
                println("Hello from filter")

                // Custom auth filter. It is temporarily disabled as there is no way to login
                /*if (session.authStatus != "logged") {
                    println("Not logged in, redirecting to index")
                    redirect(action: "index")
                }*/
            }
        }
    }
}
