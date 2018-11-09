package c332030.passport.web.filter;

/**
 * @ClassName HtmlFilter
 * @Description TODO
 * @Author c332030
 * @Date 2018/11/2 16:59
 * @Version 1.0
 */

import c332030.utils.data.constant.ConstantWeb;
import c332030.utils.web.filter.Filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*@Component
@WebFilter(urlPatterns = "/", filterName = "HtmlFilter")*/
public class HtmlFilter extends Filters {

    @Override
    public void doFilter(
            ServletRequest arg0,
            ServletResponse arg1,
            FilterChain arg2
    ) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;

        String url = request.getServletPath();
        if(url.endsWith(ConstantWeb.HTML)) {
            System.out.println("HtmlFilter tologin");
            toLogin(request, response);
        }

        super.doFilter(arg0, arg1, arg2);
    }
}
