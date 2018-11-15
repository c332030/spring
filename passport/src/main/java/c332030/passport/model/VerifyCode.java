package c332030.passport.model;

import c332030.utils.data.model.interfaces.C;
import c332030.utils.tools.Tools;

/**
 * @ClassName VerifyCode
 * @Description 验证码
 * @Author c332030
 * @Date 2018/11/15 11:07
 * @Version 1.0
 */
public class VerifyCode implements C {
    private static final long serialVersionUID = 7879943532859398321L;

    public static final String WAIT_TIMES_STR = "WaitingTime";
    public static final int WAIT_TIMES = 60;

    private String username;
    private String code;
    private long lastCodeTime = 0L;

    public VerifyCode(String username) {
        this.username = username;
    }

    public VerifyCode(String username, String code) {
        this.username = username;
        setCode(code);
    }

    public void setCode(String code) {
        this.code = code;
        lastCodeTime = System.currentTimeMillis();
    }

    /**
     * @Description 一分钟只允许发送一次
     * @author c332030
     * @date 2018/11/15 11:12
     */
    public static boolean notAllowReSend(long lastCodeTime) {
        return System.currentTimeMillis() - lastCodeTime <= WAIT_TIMES * 1000;
    }

    /**
     * @Description 一分钟只允许发送一次
     * @author c332030
     * @date 2018/11/15 11:12
     */
    public boolean notAllowReSend() {
        return notAllowReSend(lastCodeTime);
    }

    @Override
    public boolean isEmpty() {
        return Tools.isEmpty(username) || Tools.isEmpty(code) || lastCodeTime < 0;
    }

    @Override
    public String toString() {
        return "VerifyCode{" +
                "username='" + username + '\'' +
                ", code='" + code + '\'' +
                ", lastCodeTime=" + lastCodeTime +
                '}';
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getCode() {
        return code;
    }

    public long getLastCodeTime() {
        return lastCodeTime;
    }
    public void setLastCodeTime(long lastCodeTime) {
        this.lastCodeTime = lastCodeTime;
    }
}
