package foro

class File {
    String fileType
    byte[] content
    double size

    static belongsTo = [post : Post]

    static constraints = {
        fileType validator: {fileType ->
            def tokens = fileType.split("/") as List
            return tokens.size() >= 2 && tokens.every({it.length() > 0})
        }
        size max: (double)(10 * 1024 * 1024)
    }

    static mapping = {
        post column: 'post_belongs_id'
    }

    def download() {
        // TODO: implement download
    }

    def share() {
        // TODO: implement share
    }
}
