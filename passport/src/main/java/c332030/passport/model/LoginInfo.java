package c332030.passport.model;

import c332030.utils.data.model.abstractclass.CAdapter;
import c332030.utils.tools.Tools;

/**
 * @ClassName LoginInfo
 * @Description TODO
 * @Author c332030
 * @Date 2018/10/26 15:08
 * @Version 1.0
 */
public class LoginInfo extends CAdapter {

    private static final long serialVersionUID = 366304798511332389L;

    public static final String SPLIT = "_";
    public static final String PRE_LOGIN_KEY;

    static {
        String str = LoginInfo.class.getCanonicalName();
        PRE_LOGIN_KEY = str.substring(str.lastIndexOf('.') + 1);
    }

    /**
     * 日期格式
     */
    public static final String DATA_FORMAT = "yyyyMMddHHmm";

    /**
     * 登录的用户
     */
    private User user;

    /**
     * 登录时间
     */
    private String loginTime;

    /**
     * 登录Ip
     */
    private String loginIp;
    
    private String date;

    @Override
    public String toString() {
        return "LoginInfo{" +
                "user=" + user +
                ", loginTime='" + loginTime + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public LoginInfo() {}
    public LoginInfo(User user) {this.user = user;}
    public LoginInfo(String key, User user) {
        this(user);
        setKey(key);
    }

    @Override
    public boolean isEmpty() {
        return Tools.isEmpty(user)
                || Tools.isEmpty(date);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
