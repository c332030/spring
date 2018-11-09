package c332030.utils.spring.controller;

/**
 * @ClassName AbstractController
 * @Description TODO
 * @Author c332030
 * @Date 2018/10/24 21:50
 * @Version 1.0
 */

import c332030.utils.data.constant.ConstantWeb;
import c332030.utils.tools.Tools;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class AbstractController {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    @Autowired
    protected HttpSession session;

    /**
     * 通过 html 跳转页面
     * @param url
     * @return
     */
    protected String To(String url) {
        request.setAttribute(ConstantWeb.TO, Tools.dealNull(url));
        return ConstantWeb.Html.TO;
    }

    /**
     * 通过 html 跳转页面，跳转首页
     * @return
     */
    protected String To() {
        return To(null);
    }
}
