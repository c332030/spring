package c332030.passport.tools.data;

import c332030.passport.model.LoginInfo;
import c332030.utils.data.redis.RedisUtils;
import c332030.utils.tools.Tools;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName LRedisUtils
 * @Description TODO
 * @Author c332030
 * @Date 2018/11/7 10:27H
 * @Version 1.0
 */
@Component
public class LRedisUtils extends RedisUtils {

    /**
     * 存入 用户登录信息
     * @param loginInfo
     * @return
     */
    public boolean lHSet(LoginInfo loginInfo) {
        if(Tools.isEmpty(loginInfo)) {
            return false;
        }

        String loginKey = LoginInfo.PRE_LOGIN_KEY + loginInfo.getDate();

        if(!hSet(loginKey, loginInfo.getKey(), loginInfo)) {
            return false;
        }

        expire(loginKey, 3L, TimeUnit.MINUTES);
        return true;
    }

    public LoginInfo lHGet(String loginKey) {
        if(Tools.isEmpty(loginKey)) {
            return null;
        }

        String[] keys = loginKey.split(LoginInfo.SPLIT);
        if(keys.length < 2) {
            return null;
        }

        return (LoginInfo) hGet(keys[0], keys[1]);
    }
}
