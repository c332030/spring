package c332030.utils.data.model.aop;

/**
 * @ClassName Banana
 * @Description TODO
 * @Author c332030
 * @Date 2018-10-24 10:45
 * @Version 1.0
 */
//@Factory(type = BananaFactory.class, id = "banana")
public class Banana implements IFood {

    private static final long serialVersionUID = -4454162940824870899L;

    @Override
    public double getPrice() {
        return 12.0;
    }
}
