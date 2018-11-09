package c332030.utils.data.model.aop;

/**
 * @ClassName Apple
 * @Description TODO
 * @Author c332030
 * @Date 2018-10-24 10:43
 * @Version 1.0
 */

import c332030.utils.aop.annotation.Factory;
import c332030.utils.aop.factory.AppleFactory;

@Factory(type = AppleFactory.class, id = "apple")
public class Apple implements IFood {

    private static final long serialVersionUID = 1297592124979294651L;

    @Override
    public double getPrice() {
        return 10.0;
    }
}
