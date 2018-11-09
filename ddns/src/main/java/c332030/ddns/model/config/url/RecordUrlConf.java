package c332030.ddns.model.config.url;

import c332030.utils.data.model.interfaces.CConf;
import c332030.utils.tools.Tools;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RecordUrlConf implements CConf {
    private static final long serialVersionUID = 5926962458221222296L;

    private String list;
    public static final String LIST = "list";

    private String modify;
    public static final String MODIFY = "modify";

    private String remove;
    public static final String REMOVE = "remove";

    private String updateDdns;
    public static final String UPDATE_DDNS = "updateDdns";

    private String setRemark;
    public static final String SET_REMARK = "setRemark";

    private String setInfo;
    public static final String SET_INFO = "setInfo";

    private String setStatus;
    public static final String SET_STATUS = "setStatus";

    @Override
    public boolean setProperties(Map<String, Object> confMap) {
        if(null == confMap
                || confMap.isEmpty()
            ) {
            return false;
        }

        list = Tools.dealNull(confMap.get(LIST));
        modify = Tools.dealNull(confMap.get(MODIFY));
        remove = Tools.dealNull(confMap.get(REMOVE));
        updateDdns = Tools.dealNull(confMap.get(UPDATE_DDNS));
        setRemark = Tools.dealNull(confMap.get(SET_REMARK));
        setInfo = Tools.dealNull(confMap.get(SET_INFO));
        setStatus = Tools.dealNull(confMap.get(SET_STATUS));

        return true;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String toString() {
        return "RecordUrlConf{" +
                "list='" + list + '\'' +
                ", modify='" + modify + '\'' +
                ", remove='" + remove + '\'' +
                ", updateDdns='" + updateDdns + '\'' +
                ", setRemark='" + setRemark + '\'' +
                ", setInfo='" + setInfo + '\'' +
                ", setStatus='" + setStatus + '\'' +
                '}';
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public String getModify() {
        return modify;
    }

    public void setModify(String modify) {
        this.modify = modify;
    }

    public String getRemove() {
        return remove;
    }

    public void setRemove(String remove) {
        this.remove = remove;
    }

    public String getUpdateDdns() {
        return updateDdns;
    }

    public void setUpdateDdns(String updateDdns) {
        this.updateDdns = updateDdns;
    }

    public String getSetRemark() {
        return setRemark;
    }

    public void setSetRemark(String setRemark) {
        this.setRemark = setRemark;
    }

    public String getSetInfo() {
        return setInfo;
    }

    public void setSetInfo(String setInfo) {
        this.setInfo = setInfo;
    }

    public String getSetStatus() {
        return setStatus;
    }

    public void setSetStatus(String setStatus) {
        this.setStatus = setStatus;
    }
}
