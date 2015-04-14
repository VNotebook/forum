package foro

class File {
    String fileType
    byte[] content
    double size

    static constraints = {
        fileType validator: {fileType ->
            def tokens = fileType.split("/") as List
            return token.size() >= 2 && tokens.every({it.length() > 0})
        }
        size max: (double)(10 * 1024 * 1024)
    }

    def download() {
        // TODO: implement download
    }

    def share() {
        // TODO: implement share
    }
}
