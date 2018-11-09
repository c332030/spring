package c332030.utils.tools.web;

import c332030.utils.tools.Tool;
import c332030.utils.tools.Tools;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils implements Tool {

    public static String getIp(HttpServletRequest request) {
        String realIp = request.getHeader("X-Real-IP");

        // 10.47.103.13,4.2.2.2,10.96.112.230
        String xForwardIP = request.getHeader("x-forwarded-for");
        String remoteAddr = request.getRemoteAddr();

        String ip;

        if(!Tools.isEmpty(realIp)) {

            ip = realIp;
        } else if(!Tools.isEmpty(xForwardIP)) {
            ip = xForwardIP.substring(0, xForwardIP.indexOf(','));
        } else {
            ip = remoteAddr;
        }

        request.setAttribute("realIp", realIp);
        request.setAttribute("xForwardIp", xForwardIP);
        request.setAttribute("remoteAddr", remoteAddr);

        request.setAttribute("ip", ip);

        return ip;
    }
}
