package c332030.passport.model;

import c332030.utils.data.model.abstractclass.CAdapter;
import c332030.utils.tools.Tools;

import java.util.Date;

/**
 * @ClassName LoginInfo
 * @Description TODO
 * @Author c332030
 * @Date 2018/10/26 15:08
 * @Version 1.0
 */
public class LoginInfo extends CAdapter {

    private static final long serialVersionUID = 366304798511332389L;

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
    
    private Date date;

    public LoginInfo() {}
    public LoginInfo(User user) {this.user = user;}
    public LoginInfo(String key, User user) {
        this(user);
        setKey(key);
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "user=" + user +
                ", loginTime='" + loginTime + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean isEmpty() {

        return Tools.isEmpty(user);

    }
}
