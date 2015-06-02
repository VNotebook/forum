package foro

class AdminController extends CRUDController {
    AdminController() {
        super(Admin)
    }

    @Override
    protected createInstance() {
        def result = super.createInstance()
        result.password = SecurityUtils.md5(result.password)
        return result
    }

    @Override
    protected updateInstance(Object instance) {
        def result = super.updateInstance(instance)
        instance.password = SecurityUtils.md5(instance.password)
        return result
    }
}
