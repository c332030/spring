package c332030.utils.aop.factory;

import c332030.utils.data.model.aop.Apple;
import c332030.utils.data.model.aop.IFood;

/**
 * @ClassName AppleFactory
 * @Description TODO
 * @Author c332030
 * @Date 2018-10-24 11:15
 * @Version 1.0
 */
public class AppleFactory implements IFactory {

    @Override
    public IFood newInstance() {
        return new Apple();
    }
}
