package c332030.utils.data.redis;

import c332030.utils.data.constant.Constant;
import c332030.utils.data.model.abstractclass.CAdapter;
import c332030.utils.tools.LogUtils;
import c332030.utils.tools.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils implements Redis {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private RedisTemplate<String, String> redisTemplateStr;

    /**
     * 
     * @Title: expire 
     * @Description: 指定缓存失效的时间
     * @author c332030
     * @time 2018年7月31日 上午8:36:56
     * @param key
     * @param second
     * @return
     */
    public boolean expire(String key, Long second) {
        if(Tools.isEmpty(key)
                || second <= 0
        ) {
            LogUtils.error(this, "key 为空或有效时间不合法！");
            return false;
        }

        redisTemplate.expire(key, second, TimeUnit.SECONDS);

        return true;
    }

    /**
     * 
     * @Title: set 
     * @Description: 存入 Str 类型
     * @author c332030
     * @time 2018年7月31日 上午8:42:27
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, String value) {

        if(Tools.isEmpty(key)
                || Tools.isEmpty(value)
            ) {
            LogUtils.error(this, "key 和 value 都不能为空！");
            return false;
        }

        redisTemplateStr.opsForValue().set(key, value);
        return true;
    }

    /**
     * 
     * @Title: get 
     * @Description: 获取 Str 类型
     * @author c332030
     * @time 2018年7月31日 上午8:48:18
     * @param key
     * @return
     */
    public String get(String key) {

        if(Tools.isEmpty(key)) {
            LogUtils.error(this, "key 不能为空！");
            return Constant.string.EMPTY_STR;
        }

        return Tools.dealNull(redisTemplateStr.opsForValue().get(key));
    }

    /**
     * 
     * @Title: hSet
     * @Description: 设置 Hash 数据
     * @author c332030
     * @time 2018年8月6日 上午9:39:37
     * @param hashName
     * @param hashKey
     * @param obj
     * @return
     */
    public boolean hSet(String hashName, String hashKey, Object obj) {

        if(Tools.isEmpty(hashName)
                || Tools.isEmpty(hashKey)
                || Tools.isEmpty(obj)
            ) {
            LogUtils.error(this, "hashName、hashKey、obj 都不能为空！");
            return false;
        }

        redisTemplate.opsForHash().put(hashName, hashKey, obj);

        return true;
    }

    /**
     * 
     * @Title: hGet 
     * @Description: 获取 Hash 数据
     * @author c332030
     * @time 2018年8月6日 上午9:46:50
     * @param hashName
     * @param hashKey
     * @return
     */
    public Object hGet(String hashName, String hashKey) {

        if(Tools.isEmpty(hashName)
                || Tools.isEmpty(hashKey)
            ) {
            LogUtils.error(this, "hashName 或 hashKey 为空！");
            return false;
        }

        return redisTemplate.opsForHash().get(hashName, hashKey);
    }

    /**
     * 
     * @Title: set 
     * @Description: 存储对象信息到 redis
     * @author c332030
     * @time 2018年8月6日 上午9:08:08
     * @param cls
     * @param e
     * @return
     */
    public <E extends CAdapter> boolean hSet(Class<E> cls, E e) {

        if(Tools.isEmpty(cls)) {
            LogUtils.error(this, "存入到 redis 的对象为空！");
            return false;
        }

        return hSet(cls.getCanonicalName(), e.getKey(), e);
    }

    /**
     * 
     * @Title: get 
     * @Description: 设置 Hash
     * @author c332030
     * @time 2018年8月6日 上午9:38:29
     * @param cls
     * @param key
     * @return
     */
    public <E> E hGet(Class<E> cls, String key) {

        if(Tools.isEmpty(cls)) {
            LogUtils.error(this, "类名为空！");
            return null;
        }

        return (E) hGet(cls.getCanonicalName(), key);
    }
}
