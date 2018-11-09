package c332030.utils.data.model.aop;

/**
 * @ClassName Orange
 * @Description TODO
 * @Author c332030
 * @Date 2018-10-24 10:50
 * @Version 1.0
 */
//@Factory(type = OrangeFactory.class, id = "orange")
public class Orange implements IFood {

    private static final long serialVersionUID = -6728469874002088957L;

    @Override
    public double getPrice() {
        return 15;
    }
}
