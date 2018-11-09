package c332030.ddns.model.config;

import c332030.ddns.model.config.error.ErrorMsgConf;
import c332030.ddns.model.config.url.DnspodUrlConf;
import c332030.utils.data.model.interfaces.CConf;
import c332030.utils.tools.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName DnspodConf
 * @Description TODO
 * @Author c332030
 * @Date 2018-10-10 8:46
 * @Version 1.0
 */
@Component
public class DnspodConf implements CConf {
    private static final long serialVersionUID = 680951411690410002L;

    /**
     * 协议，http，https
     */
    private String protocol;
    public static final String PROTOCOL = "protocol";

    /**
     * dnspod api 网址
     */
    private String host;
    public static final String HOST = "host";

    /**
     * 端口
     */
    private String port;
    public static final String PORT = "port";

    /**
     * 域名
     */
    private String domain;
    public static final String DOMAIN = "domain";

    /**
     * 域名前缀
     */
    private String preDomain;
    public static final String PRE_DOMAIN = "preDomain";

    @Autowired
    private DnspodCommonConf dnspodCommonConf;
    public static final String DNSPOD_COMMON_CONF = "common";

    @Autowired
    private DnspodUrlConf dnspodUrlConf;
    public static final String DNSPOD_URL_CONF = "url";

    @Autowired
    private ErrorMsgConf errorMsgConf;
    public static final String ERROR_MSG_CONF = "error";

    @Override
    public boolean setProperties(Map<String, Object> confMap) {

        if(null == confMap
                || confMap.isEmpty()
            ) {
            return false;
        }

        protocol = Tools.dealNull(confMap.get(PROTOCOL));
        host = Tools.dealNull(confMap.get(HOST));
        port = Tools.dealNull(confMap.get(PORT));
        domain = Tools.dealNull(confMap.get(DOMAIN));
        preDomain = Tools.dealNull(confMap.get(PRE_DOMAIN));

        boolean notFailure = true;
        if(null != dnspodCommonConf) {

            Object obj = confMap.get(DNSPOD_COMMON_CONF);
            if(!(obj instanceof Map)
                    || !dnspodCommonConf.setProperties((Map<String, Object>)obj)
                ) {
                notFailure = false;
            }
        }

        if(null != dnspodUrlConf) {

            Object obj = confMap.get(DNSPOD_URL_CONF);
            if(!(obj instanceof Map)
                    || !dnspodUrlConf.setProperties((Map<String, Object>)obj)
                ) {
                System.out.println("Failure");
                notFailure = false;
            }
        }

        if(null != errorMsgConf) {

            Object obj = confMap.get(ERROR_MSG_CONF);
            if(!(obj instanceof Map)
                    || !errorMsgConf.setProperties((Map<String, Object>)obj)
                ) {
                notFailure = false;
            }
        }

        return notFailure;

    }

    @Override
    public String toString() {
        return "DnspodConf{" +
                "protocol='" + protocol + '\'' +
                ", host='" + host + '\'' +
                ", domain='" + domain + '\'' +
                ", preDomain='" + preDomain + '\'' +
                ", dnspodCommonConf=" + dnspodCommonConf +
                ", dnspodUrlConf=" + dnspodUrlConf +
                ", errorMsgConf=" + errorMsgConf +
                '}';
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }
    public void setPort(String port) {
        this.port = port;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPreDomain() {
        return preDomain;
    }

    public void setPreDomain(String preDomain) {
        this.preDomain = preDomain;
    }

    public DnspodCommonConf getDnspodCommonConf() {
        return dnspodCommonConf;
    }
    public void setDnspodCommonConf(DnspodCommonConf dnspodCommonConf) {
        this.dnspodCommonConf = dnspodCommonConf;
    }

    public DnspodUrlConf getDnspodUrlConf() {
        return dnspodUrlConf;
    }

    public void setDnspodUrlConf(DnspodUrlConf dnspodUrlConf) {
        this.dnspodUrlConf = dnspodUrlConf;
    }

    public ErrorMsgConf getErrorMsgConf() {
        return errorMsgConf;
    }

    public void setErrorMsgConf(ErrorMsgConf errorMsgConf) {
        this.errorMsgConf = errorMsgConf;
    }
}
