package c332030.ddns.dnspod;

import c332030.ddns.model.config.DnspodCommonConf;
import c332030.ddns.model.config.DnspodConf;
import c332030.ddns.model.config.error.ErrorMsgConf;
import c332030.ddns.model.config.url.DnspodUrlConf;
import c332030.utils.data.config.YamlUtils;
import c332030.utils.data.constant.Constant;
import c332030.utils.data.model.interfaces.C;
import c332030.utils.tools.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class DnspodService implements C {

    private static final long serialVersionUID = -3718687474360463656L;

    private Lock lock  = new ReentrantLock();

    private Map<String, Object> dnspodConfMap;

    @Autowired
    private DnspodConf dnspodConf;

    @Autowired
    private DnspodCommonConf dnspodCommonConf;

    @Autowired
    private DnspodUrlConf dnspodUrlConf;

    @Autowired
    private ErrorMsgConf errorMsgConf;

    public DnspodService() {}

    public boolean load() {

        try {

            lock.lock();
            Map<String, Object> yamlMap = YamlUtils.loadYamlMapClasspath("config/ddns/dnspod.yml");

            if(null == yamlMap
                    || yamlMap.isEmpty()
                ) {
                throw new NullPointerException("yamlMap is empty!");
            }

            dnspodConfMap = Collections.unmodifiableMap(yamlMap);
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        } finally {
            lock.unlock();
        }

        // 属性设置
        LogUtils.print(dnspodConfMap.toString());
        return setProperties();
    }

    public Map<String, Object> getDnspodConfMap() {
        return dnspodConfMap;
    }

    public boolean setProperties() {
        if(null == dnspodConf) {
            return false;
        }

        return dnspodConf.setProperties(dnspodConfMap);
    }

    public Object comm(String name, Map<String, String> commMap) {

        if(null == name
                || name.isEmpty()
                || null == commMap
                || commMap.isEmpty()
            ) {
            return null;
        }

        if(null == dnspodConf
                || dnspodConf.isEmpty()
            ) {
            LogUtils.print("dnspodConf 为空！");
            return null;
        }

        String protocol = dnspodConf.getProtocol();
        if(null == protocol
                || protocol.isEmpty()
            ) {
            LogUtils.print("protocol 为空！");
            return null;
        }

        String host = dnspodConf.getHost();
        if(null == host
                || host.isEmpty()
            ) {
            LogUtils.print("host 为空！");
            return null;
        }

        String port = dnspodConf.getPort();
        if(null == port) {
            port = Constant.string.EMPTY_STR;
        } else if(port.length() > 0) {
            port = ':' + port;
        }

        String urlStr = protocol + "://" + host + port + '/' + name;

        StringBuilder result = new StringBuilder();

        URL url = null;
        HttpURLConnection urlConnection = null;
//        URLConnection urlConnection = null;
        BufferedReader bufferedReader = null;
        try {
            url = new URL(urlStr);
            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestProperty("accepy", "*/*");
            urlConnection.setRequestProperty("connection", "Keep-Alive");
            urlConnection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (comptible: MSIE6.0; Windows NT6.1; SV1)");
            urlConnection.setRequestMethod("POST");

            for(Map.Entry<String, String> entry: commMap.entrySet()) {
                urlConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }

            urlConnection.connect();

            Map<String, List<String>> headMap = urlConnection.getHeaderFields();
            if(null == headMap) {
                return null;
            }

            for(Map.Entry entry: headMap.entrySet()) {

                LogUtils.print("" + entry.getKey()
                + '\n' + entry.getValue() + "\n\n");
            }

            bufferedReader = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));

            String line;
            while((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }

            LogUtils.print(result.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if(null != bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
    
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String toString() {
        return "DnspodService{" +
                "lock=" + lock +
                ", dnspodConfMap=" + dnspodConfMap +
                ", dnspodConf=" + dnspodConf +
                ", dnspodCommonConf=" + dnspodCommonConf +
                ", dnspodUrlConf=" + dnspodUrlConf +
                ", errorMsgConf=" + errorMsgConf +
                '}';
    }
}
