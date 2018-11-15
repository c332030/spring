package c332030.utils.data.model.message;

import c332030.utils.data.model.abstractclass.CUnmodify;
import c332030.utils.tools.Tools;

/**
 * @ClassName Status
 * @Description 通讯状态
 * @Author c332030
 * @Date 2018/10/30 10:05
 * @Version 1.0
 */
public class Status extends CUnmodify<Status> {
    private static final long serialVersionUID = 4490083538946455128L;

    /**
     * 成功标识
     */
    public static final String SUCCESS_FLG = "000000";

    /**
     * 失败标识
     */
    public static final String FAILED_FLG = "999999";

    public static final Status SUCCESS_STATUS =
            new Status(SUCCESS_FLG, "操作成功！").setUnmodify();

    public static final Status FAILED_STATUS =
            new Status(FAILED_FLG, "操作失败！").setUnmodify();

    private String retCode;
    private String retMsg;

    public Status() {}

    public Status(String retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    @Override
    public boolean isEmpty() {
        return Tools.isEmpty(retCode) || Tools.isEmpty(retMsg);
    }

    public String getRetCode() {
        return retCode;
    }
    public void setRetCode(String retCode) {
        if(isUnmodify()) {
            return;
        }
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }
    public void setRetMsg(String retMsg) {
        if(isUnmodify()) {
            return;
        }
        this.retMsg = retMsg;
    }
}
