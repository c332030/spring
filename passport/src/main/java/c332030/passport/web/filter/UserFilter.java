package c332030.passport.web.filter;

import c332030.passport.model.LoginInfo;
import c332030.utils.data.constant.ConstantWeb;
import c332030.utils.tools.LogUtils;
import c332030.utils.tools.Tools;
import c332030.utils.tools.web.CookieUtils;
import c332030.utils.web.filter.Filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*@Component
@WebFilter(urlPatterns = "/*", filterName = "loginFilter")*/
public class UserFilter extends Filters {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
        ) throws IOException, ServletException {
        String methodName = "UserFilter.doFilter：";

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

//        HttpSession httpSession = httpRequest.getSession();
//        Object object = httpSession.getAttribute(ConstantWeb.Session.User);

        String url = httpRequest.getServletPath();
        LogUtils.print(methodName + url);

        if(url.endsWith(ConstantWeb.ROOT)

            || url.endsWith(ConstantWeb.JS)
            || url.endsWith(ConstantWeb.CSS)
            || url.endsWith(ConstantWeb.JPG)
            || url.endsWith(ConstantWeb.GIF)
            || url.endsWith(ConstantWeb.PNG)
            || url.endsWith(ConstantWeb.ICO)

            || url.endsWith(ConstantWeb.Html.Index)
            || url.endsWith(ConstantWeb.Html.IndexEx)
            || url.endsWith(ConstantWeb.Html.Login)
            || url.endsWith(ConstantWeb.Html.LoginEx)
            || url.endsWith(ConstantWeb.Html.Error)

            || url.endsWith(ConstantWeb.Jsp.Index)
            || url.endsWith(ConstantWeb.Jsp.Login)
            || url.endsWith(ConstantWeb.Jsp.Error)

            || url.endsWith(ConstantWeb.Action.Login)
            || url.endsWith(ConstantWeb.Action.LoginEx)
            || url.endsWith(ConstantWeb.Action.VerifyLogin)
            || url.endsWith(ConstantWeb.Action.VerifyLoginEx)

            || url.endsWith(ConstantWeb.Action.Test)
            || url.endsWith(ConstantWeb.Action.Close)
        ) {

            chain.doFilter(request, response);
            return;
        }

        String userKey = CookieUtils.getLoginKey(httpRequest);
//        LogUtils.print(methodName + userKey);
        if(Tools.isEmpty(userKey)) {

            LogUtils.print(methodName + "userKey 为空！");

            toLogin(httpRequest, httpResponse);
            return;
        }

        Object obj = redisUtil.hGet(LoginInfo.class, userKey);
        if(Tools.isEmpty(obj)) {

            LogUtils.print(methodName + "redis 不存在当前值+ " + userKey);

            toLogin(httpRequest, httpResponse);
            return;
        }

//        CookieUtils.flushUserKeyAge(httpRequest, httpResponse); // 有效期未变化
        chain.doFilter(request, response);
    }
}
