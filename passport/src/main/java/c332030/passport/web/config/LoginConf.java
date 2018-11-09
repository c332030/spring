package c332030.passport.web.config;

import c332030.utils.data.config.YamlUtils;
import c332030.utils.tools.LogUtils;
import c332030.utils.tools.Tools;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName LoginConf
 * @Description TODO
 * @Author c332030
 * @Date 2018/11/7 17:35
 * @Version 1.0
 */
@Component
public class LoginConf {

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    /**
     * 最大加载次数
     */
    private static final int DEFAULT_MAX_TIMES = 10000;

    /**
     * 当前加载次数
     */
    private int loadTimes = 0;

    private Map<String, Object> confMap;

    public LoginConf() {
        load();
    }

    public void load() {
        confMap = YamlUtils.loadYamlMapClasspath("config/login.yml");
    }

    /**
     * 从配置 Map 中获取值
     * @param key
     * @return
     */
    public Object get(String key) {

        if(Tools.isEmpty(key)) {
            return null;
        }

        if(null == confMap) {
            writeLock.lock();
            if(null == confMap) {
                LogUtils.debug(this, "系统配置信息不存在，重新获取！");
                load();
            }
            writeLock.unlock();
        }

        String[] keys = key.split("\\.");
        try {

            int i = 0;
            Map<String, Object> map = confMap;

            readLock.lock();
            while(i < keys.length - 1) {
                if(Tools.isEmpty(map)) {
                    return null;
                }

                map = (Map<String, Object>) map.get(keys[i++]);
            }

            return map == null ? null : map.get(keys[i]);
        } catch (Exception e) {

            e.printStackTrace();
            LogUtils.error(this, "发生异常：" + e.toString());
            LogUtils.error(this, "获取系统配置失败：" + key);
            return null;
        } finally {
            readLock.unlock();
        }
    }

    /**
     * 从配置 Map 中获取值，转给 String
     * @param key
     * @return
     */
    public String getStr(String key) {
        Object obj = get(key);
        return obj != null ? obj.toString() : null;
    }
}
