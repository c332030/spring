package c332030.utils.tools.web;

import c332030.utils.data.constant.Constant;
import c332030.utils.data.constant.ConstantWeb;
import c332030.utils.tools.Tool;
import c332030.utils.tools.Tools;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils implements Tool {

    /**
     * 添加 Cookie
     * @param response
     * @param cookie
     * @return
     */
    public static boolean setCookie(
            HttpServletResponse response,
            Cookie cookie
        ) {
        if(null == response
                || null == cookie) {
            return false;
        }

        /**
         * 重新设置域名，避免产生多个子域名的 Cookie
         * 获取 Cookie 时不会有域名信息
         */
        cookie.setDomain(ConstantWeb.DOMAIN);
        response.addCookie(cookie);

        return true;
    }

    /**
     * 添加 Cookie
     * @param response
     * @param key
     * @param val
     * @return
     */
    public static boolean setCookie(
            HttpServletResponse response,
            String key, String val
        ) {

        if(Tools.isEmpty(key)
                || Tools.isEmpty(val)
            ) {
            return false;
        }

        Cookie cookie = new Cookie(ConstantWeb.Cookies.LOGIN_INFO_KEY, val);
        cookie.setMaxAge(ConstantWeb.Cookies.MAX_AGE);
        cookie.setDomain(ConstantWeb.DOMAIN);

        return setCookie(response, cookie);
    }

    /**
     * 
     * @Title: getCookies 
     * @Description: 获取 Cookie 数组
     * @author c332030
     * @time 2018年8月4日 下午5:25:17
     * @param request
     * @return
     */
    public static Cookie[] getCookies(HttpServletRequest request) {
        if(Tools.isEmpty(request)) {
            return null;
        }

        return request.getCookies();
    }


    /**
     * getCookie
     * @param cookies
     * @param key
     * @return
     */
    public static Cookie getCookie(Cookie[] cookies, String key) {
        if(Tools.isEmpty(cookies)
                || Tools.isEmpty(key)
            ){
            return null;
        }

        for(Cookie cookie: cookies) {
            if(key.equals(cookie.getName())) {
                return cookie;
            }
        }

        return null;
    }

    /**
     * getCookie
     * @param request
     * @return
     */
    public static Cookie getCookie(HttpServletRequest request, String key) {
        if(null == request) {
            return null;
        }

        return getCookie(getCookies(request), key);
    }

    /**
     * 刷新 Cookie
     * @param cookie
     * @param maxAge
     * @return
     */
    public static boolean flushCookie(
            HttpServletResponse response,
            Cookie cookie, int maxAge
        ) {
        if(Tools.isEmpty(cookie)
                || Tools.isEmpty(maxAge)
            ) {
            return false;
        }

        cookie.setMaxAge(maxAge);
        return setCookie(response, cookie);
    }

    /**
     * 刷新 Cookie
     * @param request
     * @param response
     * @param key
     * @param maxAge
     * @return
     */
    public static boolean flushCookie(
            HttpServletRequest request,
            HttpServletResponse response,
            String key, int maxAge
        ) {
        if(Tools.isEmpty(key)
                || Tools.isEmpty(maxAge)
            ) {

            return false;
        }

        return flushCookie(response, getCookie(request, key), maxAge);
    }

    /**
     * 
     * @Title: getCookieVal 
     * @Description: 获取 Cookie 值
     * @author c332030
     * @time 2018年8月4日 下午5:26:17
     * @param request
     * @param cookieKey
     * @return
     */
    public static String getCookieVal(HttpServletRequest request, String cookieKey) {
        return getCookieVal(getCookies(request), cookieKey);
    }

    /**
     * 
     * @Title: getCookieVal 
     * @Description: 获取 Cookie 值
     * @author c332030
     * @time 2018年8月4日 下午5:25:04
     * @param cookies
     * @param cookieKey
     * @return
     */
    public static String getCookieVal(Cookie[] cookies, String cookieKey) {
        if(Tools.isEmpty(cookies)
                || Tools.isEmpty(cookieKey)
            ) {
            return Constant.string.EMPTY_STR;
        }

        Cookie cookie = getCookie(cookies, cookieKey);
        if(null == cookie) {
            return Constant.string.EMPTY_STR;
        }

        return cookie.getValue();
    }

    public static Cookie getUserCookie(Cookie[] cookies) {
        return getCookie(cookies, ConstantWeb.Cookies.LOGIN_INFO_KEY);
    }

    public static Cookie getUserCookie(HttpServletRequest request) {
        return getUserCookie(getCookies(request));
    }
    
    public static String getLoginKey(HttpServletRequest request) {
        return getLoginKey(getCookies(request));
    }

    public static String getLoginKey(Cookie[] cookies) {

        Cookie cookie = getUserCookie(cookies);

        if(Tools.isEmpty(cookies)) {
            return Constant.string.EMPTY_STR;
        }

        return cookie.getValue();
    }

    /**
     * 设置 Cookies
     * @param response
     * @param val
     * @return
     */
    public static boolean setLoginKey(
            HttpServletResponse response,
            String val
        ) {
        if(null == response
                || Tools.isEmpty(val)
            ) {
            return false;
        }

        return setCookie(response, ConstantWeb.Cookies.LOGIN_INFO_KEY, val);
    }

    /**
     * 刷新有效时间
     * @param request
     * @return
     */
    public static boolean flushLoginKeyAge(
            HttpServletRequest request,
            HttpServletResponse response
        ) {
        if(null == request
                || null == response) {
            return false;
        }

        return flushCookie(request, response, ConstantWeb.Cookies.LOGIN_INFO_KEY,
                ConstantWeb.Cookies.MAX_AGE);
    }
}
