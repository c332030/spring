package c332030.utils.web.filter;

import c332030.utils.data.constant.ConstantWeb;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class Filters implements Filter {

    public Filters() {
        // 构造函数
    }

    public void init(FilterConfig fConfig) {
        // 初始化函数
    }

    public void destroy() {
        // 销毁执行函数
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
    }

    /**
     *
     * @Title: toLogin
     * @Description: 去登录
     * @author c332030
     * @time 2018年8月4日 下午5:46:15
     * @param request
     * @param response
     * @throws IOException
     */
    protected void toLogin(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        response.sendRedirect(request.getContextPath() + "/"
                + ConstantWeb.Action.Login);
    }
}
