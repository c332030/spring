package c332030.passport.controller;

import c332030.passport.model.Auth;
import c332030.passport.service.AuthService;
import c332030.passport.service.UserService;
import c332030.passport.tools.data.constant.AuthConstant;
import c332030.passport.web.config.LoginConf;
import c332030.utils.data.constant.ConstantWeb;
import c332030.utils.tools.LogUtils;
import c332030.utils.tools.Tools;
import c332030.utils.tools.web.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName LoginController
 * @Description 登录控制器
 * @Author c332030
 * @Date 2018-10-23 18:07
 * @Version 1.0
 */
@Controller
public class LoginController extends LController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @Autowired
    private LoginConf loginConf;

    @RequestMapping("/Login")
    public String Login(
            String responseUrl, String auth_id, String auth_secset
        ) {

        String referer = request.getHeader("Referer");

        LogUtils.debug(this, AuthConstant.Cookies.REFER_URL + ": " + referer);
        LogUtils.debug(this, AuthConstant.ID + ": " + auth_id);
        LogUtils.debug(this, AuthConstant.SECRET + ": " + auth_secset);
        LogUtils.debug(this, AuthConstant.Cookies.RESPONSE_URL + ": " + responseUrl);

        if(!Tools.isEmpty(referer)
                && !Tools.isEmpty(responseUrl)
                && !Tools.isEmpty(auth_id)
                && !Tools.isEmpty(auth_secset)
        ) {
            Auth auth = authService.findByIdAndSecret(auth_id, auth_secset);
            if(Tools.isEmpty(auth)) {

                LogUtils.debug(this, "授权验证失败!");
                return error("授权验证失败，请检查!");
            }

            if(isLogin()) {
                return To(responseUrl);
            }

            CookieUtils.setCookie(response, AuthConstant.Cookies.RESPONSE_URL, responseUrl);

            return ConstantWeb.Html.Login;
        }

        LogUtils.debug(this, "授权信息为空，不走 SSO");

        if(isLogin()) {
            return To();
        }

        return ConstantWeb.Html.Login;
    }

    /**
     * 验证 app 信息
     * @param authUrl
     * @param referer
     * @return
     */
    private boolean verifyApp(String authUrl, String referer) {
        if(Tools.isEmpty(authUrl)
                || Tools.isEmpty(referer)

                // 除去 'http://' 后，referer 应长于 authUrl，referer 中域名以 '/' 结尾
                || authUrl.length() > referer.length() - 8
            ) {
            return false;
        }

        boolean isHttps = false;
        if(referer.startsWith("https://")) {
            isHttps = true;
        } else if(!referer.startsWith("http://")) {
            return false;
        }

        int index = referer.indexOf(authUrl);
        if(-1 == index) { // referer 中应该包括 authUrl
            return false;
        }

        char endOfDomain = referer.charAt(index + authUrl.length() + 1);

        LogUtils.debug("endOfDomain: " + endOfDomain);
        if('/' != endOfDomain) { // 域名以 '/' 结尾
            return false;
        }

        /**
         * http 后，域名前的内容
         */
        String preReferer = referer.substring(7 + (isHttps ? 1 : 0), index);
        LogUtils.debug(this, "preReferer= " + preReferer);

        /**
         * 域名前缀不能有的内容：'/', '&', '='
         */
        return !preReferer.contains("/")
                && !preReferer.contains("&")
                && !preReferer.contains("=");
    }
}
