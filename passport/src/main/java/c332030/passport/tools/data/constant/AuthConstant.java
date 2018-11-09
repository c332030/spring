package c332030.passport.tools.data.constant;

/**
 * @ClassName AuthConstant
 * @Description TODO
 * @Author c332030
 * @Date 2018/11/7 8:51
 * @Version 1.0
 */
public class AuthConstant {
    private AuthConstant() {}

    /**
     * 应用授权 id
     */
    public static final String ID = "auth_id";

    /**
     * 应用授权码
     */
    public static final String SECRET = "auth_secret";

    /**
     * 授权应用地址
     */
    public static final String URL = "url";

    public static class Cookies {

        /**
         * 来源 URL
         */
        public static final String REFER_URL = "referUrl";

        /**
         * 响应 URL
         */
        public static final String RESPONSE_URL = "responseUrl";
    }
}
