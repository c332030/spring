package c332030.passport.controller;

import c332030.passport.model.LoginInfo;
import c332030.passport.tools.data.LRedisUtils;
import c332030.utils.controller.AbstractController;
import c332030.utils.data.constant.ConstantWeb;
import c332030.utils.tools.DataUtils;
import c332030.utils.tools.LogUtils;
import c332030.utils.tools.Tools;
import c332030.utils.tools.web.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName LController
 * @Description TODO
 * @Author c332030
 * @Date 2018/10/25 9:51
 * @Version 1.0
 */
public abstract class LController extends AbstractController {

    @Autowired
    protected LRedisUtils lRedisUtils;

    /**
     * 是否登录
     * @return
     */
    protected boolean isLogin() {

        String loginKey = CookieUtils.getLoginKey(request);
        if(Tools.isEmpty(loginKey)) {
            return false;
        }

        try {
            loginKey = DataUtils.deBase64(loginKey);
        } catch (Exception exception) {
            LogUtils.debug(this, exception);
            return false;
        }

        LogUtils.debug(this, "Login key= " + loginKey);

        String[] keys = loginKey.split(LoginInfo.SPLIT);
        if(keys.length != 2) {
            return false;
        }

        return !Tools.isEmpty(lRedisUtils.lHGet(loginKey));
    }

    /**
     * 错误信息 key
     */
    private static final String ERROR_MESSAGE = "errorMessage";

    /**
     * 返回错误信息
     * @param errorInfo
     * @return
     */
    protected String error(String errorInfo) {
        if(Tools.isEmpty(errorInfo)) {
            errorInfo = "未知错误！";
        }

        request.setAttribute(ERROR_MESSAGE, errorInfo);
        return ConstantWeb.Html.Error;
    }
}
