package c332030.ddns.model.config.error;

import c332030.utils.data.constant.Constant;
import c332030.utils.data.model.interfaces.CConf;
import c332030.utils.tools.Tools;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ErrorMsgConf implements CConf {

    private static final long serialVersionUID = 790276441827956710L;

    public static final int RANGE_COMMON = 0;
    public static final int RANGE_D = 1;
    public static final int RANGE_RECORD = 2;

    /**
     * 公共错误代码
     */
    private Map<String, String> common;
    public static final String COMMON = "common";

    /**
     * D 监控错误代码
     */
    private Map<String, String> d;
    public static final String D = "d";

    /**
     * 记录错误代码
     */
    private Map<String, String> record;
    public static final String RECORD = "record";

    @Override
    public boolean setProperties(Map<String, Object> confMap) {
        if(null == confMap
                || confMap.isEmpty()
            ) {
            return false;
        }

        Object commConfMap = confMap.get(COMMON);
        if(commConfMap instanceof Map) {
            setCommon((Map<String, String>)commConfMap);
        }

        Object dMap = confMap.get(D);
        if(dMap instanceof Map) {
            setD((Map<String, String>)dMap);
        }

        Object recordMap = confMap.get(RECORD);
        if(recordMap instanceof Map) {
            setRecord((Map<String, String>)recordMap);
        }

        return true;
    }

    /**
     * 获取返回值对应的含义
     * @param retCode
     * @return
     */
    public String getRetMsg(String retCode) {
        return getRetMsg(retCode, RANGE_COMMON);
    }

    /**
     * 获取返回值对应的含义
     * @param retCode
     * @param range
     * @return
     */
    public String getRetMsg(String retCode, int range) {

        if(Tools.isEmpty(retCode)) {
            return Constant.string.EMPTY_STR;
        }

        Map<String, String> codeMsgMap = null;

        switch (range) {
            case RANGE_COMMON:
                codeMsgMap = common;
                break;
            case RANGE_D:
                codeMsgMap = d;
                break;
            case RANGE_RECORD:
                codeMsgMap = record;
                break;
            default:
                break;
        }

        String retMsg = null;
        if(null != codeMsgMap) {
            retMsg = codeMsgMap.get(retCode);
        }

        if(codeMsgMap != common
                && null != common
                && Tools.isEmpty(retMsg)
            ) {
            retMsg = common.get(retMsg);
        }

        return retMsg;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String toString() {
        return "ErrorMsgConf{" +
                "common=" + common +
                ", d=" + d +
                ", record=" + record +
                '}';
    }

    public Map<String, String> getCommon() {
        return common;
    }
    public void setCommon(Map<String, String> common) {
        this.common = common;
    }

    public Map<String, String> getD() {
        return d;
    }
    public void setD(Map<String, String> d) {
        this.d = d;
    }

    public Map<String, String> getRecord() {
        return record;
    }
    public void setRecord(Map<String, String> record) {
        this.record = record;
    }
}
