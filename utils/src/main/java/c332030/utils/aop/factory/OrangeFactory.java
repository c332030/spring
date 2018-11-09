package c332030.utils.aop.factory;

import c332030.utils.data.model.aop.IFood;
import c332030.utils.data.model.aop.Orange;

/**
 * @ClassName OrangeFactory
 * @Description TODO
 * @Author c332030
 * @Date 2018-10-24 11:17
 * @Version 1.0
 */
public class OrangeFactory implements IFactory {

    @Override
    public IFood newInstance() {
        return new Orange();
    }
}
