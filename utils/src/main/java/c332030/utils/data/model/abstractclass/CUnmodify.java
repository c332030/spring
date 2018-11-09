package c332030.utils.data.model.abstractclass;

import c332030.utils.data.model.interfaces.C;

/**
 * @ClassName CUnmodify
 * @Description TODO
 * @Author c332030
 * @Date 2018/11/2 11:31
 * @Version 1.0
 */
public abstract class CUnmodify<E> implements C {

    /**
     * 是否不可修改
     */
    private boolean unmodify = false;

    public E setUnmodify() {
        unmodify = true;
        return (E)this;
    }

    public boolean isUnmodify() {
        return unmodify;
    }
}
