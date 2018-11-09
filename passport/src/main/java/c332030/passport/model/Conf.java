package c332030.passport.model;

import c332030.utils.data.model.interfaces.C;
import c332030.utils.tools.Tools;

/**
 * @ClassName Conf
 * @Description 系统运行参数
 * @Author c332030
 * @Date 2018/11/7 17:46
 * @Version 1.0
 */
public class Conf implements C {
    private static final long serialVersionUID = 8675616254803184623L;

    private String parameter;
    private String value;
    private String comment;

    @Override
    public boolean isEmpty() {
        return Tools.isEmpty(parameter) || Tools.isEmpty(value);
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
