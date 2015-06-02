package foro

class FileController extends CRUDController {
    static knownContentTypes = ["txt": "text/plain", "png": "image/png"]

    FileController() {
        super(File)
    }

    def share() {
        render "Not implemented yet"
    }

    def download() {
        def id = params.actualFile
        def file = File.get(id)
        render file: file.content, contentType: file.fileType
    }

    @Override
    protected createInstance() {
        def result = new File(params)
        if (!fillFile(result))
            return false
        return result
    }

    @Override
    protected updateInstance(instance) {
        super.updateInstance(instance)
        return fillFile(instance)
    }

    private boolean fillFile(instance) {
        if (!request.getFile) {
            return false
        }

        def file = request.getFile('file')

        if (file.empty) {
            println("Empty file not allowed")
            render "File error"
            return false
        }

        instance.content = file.getBytes()
        def tokens = file.getOriginalFilename().tokenize(".")
        // Return an empty extension if it has no extension
        def extension = tokens.size() > 1 ? tokens[-1] : ""
        def fileType = FileController.knownContentTypes.get(extension)

        if (!fileType) {
            println("File type \"${extension}\" not allowed")
            render "File type not allowed"
            return false
        }

        instance.fileType = fileType
        instance.size = file.getSize()

        return true
    }
}
