package c332030.ddns.model.config;

import c332030.utils.data.model.interfaces.CConf;
import c332030.utils.tools.Tools;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName DnspodCommonConf
 * @Description Dnspod api common parameter
 * @Author c332030
 * @Date 2018-10-10 19:39
 * @Version 1.0
 */
@Component
public class DnspodCommonConf implements CConf {

    private static final long serialVersionUID = -7372842173863036646L;

    /**
     * 程序英文名称/版本(联系邮箱)
     */
    private String userAgent;
    public static final String USER_AGENT = "userAgent";

    /**
     * 用于鉴权的 API Token
     */
    private String login_token;
    public static final String LOGIN_TOKEN = "login_token";

    /**
     * {json,xml} 返回的数据格式，可选，默认为xml，建议用json
     */
    private String format;
    public static final String FORMAT = "format";

    /**
     * {en,cn} 返回的错误语言，可选，默认为en，建议用cn
     */
    private String lang;
    public static final String LANG = "lang";

    /**
     * {yes,no} 没有数据时是否返回错误，可选，默认为yes，建议用no
     */
    private String error_on_empty;
    public static final String ERROR_ON_EMPTY = "error_on_empty";

    /**
     * 用户的ID，可选，仅代理接口需要， 用户接口不需要提交此参数
     */
    private String user_id;
    public static final String USER_ID = "user_id";

    /**
     * D令牌生成的随机验证码，必选
     */
    private String login_code;
    public static final String LOGIN_CODE = "login_code";

    /**
     * {yes,no} 是否记住验证码，可选，默认为yes
     */
    private String login_remember;
    public static final String LOGIN_REMEMBER = "login_remember";

    @Override
    public boolean setProperties(Map<String, Object> confMap) {

        if(null == confMap
                || confMap.isEmpty()
            ) {
            return false;
        }

        setUserAgent(Tools.dealNull(confMap.get(USER_AGENT)));
        setLogin_token(Tools.dealNull(confMap.get(LOGIN_TOKEN)));
        setFormat(Tools.dealNull(confMap.get(FORMAT)));
        setLang(Tools.dealNull(confMap.get(LANG)));
        setError_on_empty(Tools.dealNull(confMap.get(ERROR_ON_EMPTY)));
        setUser_id(Tools.dealNull(confMap.get(USER_ID)));
        setLogin_code(Tools.dealNull(confMap.get(LOGIN_CODE)));
        setLogin_remember(Tools.dealNull(confMap.get(LOGIN_REMEMBER)));

        return true;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String toString() {
        return "DnspodCommonConf{" +
                "userAgent='" + userAgent + '\'' +
                ", login_token='" + login_token + '\'' +
                ", format='" + format + '\'' +
                ", lang='" + lang + '\'' +
                ", error_on_empty='" + error_on_empty + '\'' +
                ", user_id='" + user_id + '\'' +
                ", login_code='" + login_code + '\'' +
                ", login_remember='" + login_remember + '\'' +
                '}';
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getLogin_token() {
        return login_token;
    }

    public void setLogin_token(String login_token) {
        this.login_token = login_token;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getError_on_empty() {
        return error_on_empty;
    }

    public void setError_on_empty(String error_on_empty) {
        this.error_on_empty = error_on_empty;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getLogin_code() {
        return login_code;
    }

    public void setLogin_code(String login_code) {
        this.login_code = login_code;
    }

    public String getLogin_remember() {
        return login_remember;
    }

    public void setLogin_remember(String login_remember) {
        this.login_remember = login_remember;
    }
}
