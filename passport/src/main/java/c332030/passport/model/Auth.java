package c332030.passport.model;

import c332030.utils.data.model.interfaces.C;
import c332030.utils.tools.Tools;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @ClassName AuthConstant
 * @Description TODO
 * @Author c332030
 * @Date 2018/11/7 11:28
 * @Version 1.0
 */
public class Auth implements C {

    private static final long serialVersionUID = -1933044043117606466L;

    Set<String> set = new LinkedHashSet<>();

    /**
     * 应用 id
     */
    private String auth_id;

    /**
     * 应用授权码
     */
    private String auth_secset;

    /**
     * 授权地址
     */
    private String url;

    private String time;

    private String ip;

    private String author;

    public Auth() {}
    public Auth(String authId, String authSecset) {
        auth_id = authId;
        auth_secset = authSecset;
    }
    public Auth(String authId, String authSecset, String url) {
        this(authId, authSecset);
        this.url = url;
    }

    @Override
    public boolean isEmpty() {
        return Tools.isEmpty(auth_id)
                || Tools.isEmpty(auth_secset)
                || Tools.isEmpty(url);
    }

    public String getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(String auth_id) {
        this.auth_id = auth_id;
    }

    public String getAuth_secset() {
        return auth_secset;
    }

    public void setAuth_secset(String auth_secset) {
        this.auth_secset = auth_secset;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
