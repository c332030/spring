package c332030.ddns.model.config.url;

import c332030.utils.data.model.interfaces.CConf;
import c332030.utils.tools.Tools;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserUrlConf implements CConf {

    private static final long serialVersionUID = -9025760832350212439L;

    private String detail;
    public static final String DETAIL = "detail";

    private String modify;
    public static final String MODIFY = "modify";

    @Override
    public boolean setProperties(Map<String, Object> confMap) {

        if(null == confMap
                || confMap.isEmpty()
            ) {
            return false;
        }

        detail = Tools.dealNull(confMap.get(DETAIL));
        modify = Tools.dealNull(confMap.get(MODIFY));

        return true;
    }

    @Override
    public String toString() {
        return "UserUrlConf{" +
                "detail='" + detail + '\'' +
                ", modify='" + modify + '\'' +
                '}';
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getModify() {
        return modify;
    }
    public void setModify(String modify) {
        this.modify = modify;
    }
}
