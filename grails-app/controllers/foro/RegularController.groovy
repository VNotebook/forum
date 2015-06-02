package foro

class RegularController extends CRUDController {
    RegularController() {
        super(Regular)
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
