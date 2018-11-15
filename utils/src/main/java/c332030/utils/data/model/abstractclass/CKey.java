package c332030.utils.data.model.abstractclass;

import c332030.utils.data.model.interfaces.C;

/**
 * C 适配器，添加 key 属性
 */
public abstract class CKey implements C {

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
