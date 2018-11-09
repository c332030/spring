package c332030.passport.tools.retcode;

import c332030.utils.data.config.YamlUtils;

import java.util.Map;

/**
 * @ClassName RetCodeMsg
 * @Description TODO
 * @Author c332030
 * @Date 2018/11/2 11:42
 * @Version 1.0
 */
public class RetCodeMsg {

    public static Map<String, Object> codeMap =
            YamlUtils.loadYamlMapClasspath("config/RetCodeMsg.yml");
}
