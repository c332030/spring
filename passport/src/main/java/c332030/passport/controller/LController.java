package c332030.passport.controller;

import c332030.passport.model.LoginInfo;
import c332030.passport.tools.data.LRedisUtils;
import c332030.utils.data.constant.ConstantWeb;
import c332030.utils.spring.controller.AbstractController;
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

        return !Tools.isEmpty(lRedisUtils.hGet(
                LoginInfo.class, CookieUtils.getLoginKey(request)
        ));
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
