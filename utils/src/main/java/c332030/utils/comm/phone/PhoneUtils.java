package c332030.utils.comm.phone;

import c332030.utils.data.config.YamlUtils;
import c332030.utils.tools.Tools;
import io.netty.util.internal.ConcurrentSet;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName PhoneUtils
 * @Description TODO
 * @Author c332030
 * @Date 2018/11/2 11:05
 * @Version 1.0
 */
public class PhoneUtils {

    private PhoneUtils(){}

    private static Set<String> PRE_NUM_SET = null;
    private static final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
    private static final Lock readLock = readWriteLock.readLock();
    private static final Lock writeLock = readWriteLock.writeLock();

    static {
        loadPreNum();
    }

    public static boolean loadPreNum() {
        Map<String, Object> yamlMap = YamlUtils.loadYamlMapClasspath("config/phone.yml");
        if(Tools.isEmpty(yamlMap)) {
            return false;
        }

        Object prenumObj = yamlMap.get("prenum");
        if(!(prenumObj instanceof List)) {
            return false;
        }

        PRE_NUM_SET = new ConcurrentSet<>();
        List<?> preNumList = (List<?>)prenumObj;
        for(int i = 0; i < preNumList.size(); i++) {
            PRE_NUM_SET.add(Tools.dealNull(preNumList.get(i)));
        }

        return true;
    }

    /**
     * 判断号码前缀是否在配置中
     * @param str
     * @return
     */
    public static boolean isPreNumContain(String str) {
        if(null == str) {
            return false;
        }

        str = str.trim();
        if(str.length() != 3) {
            return false;
        }

        if(null == PRE_NUM_SET) {
            writeLock.lock();
            if(null == PRE_NUM_SET) {
                loadPreNum();
            }
            writeLock.unlock();
        }

        readLock.lock();
        boolean contain = PRE_NUM_SET.contains(str);
        readLock.unlock();

        return contain;
    }

    /**
     * 校验字符串内容是否为手机号
     * @param phoneNumber
     * @return
     */
    public static final boolean isPhone(String phoneNumber) {
        if(null == phoneNumber
                || phoneNumber.contains(" ")
            ) {
            return false;
        }

        return 11 == phoneNumber.trim().length();
    }
}
