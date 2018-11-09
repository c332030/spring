package c332030.utils.data.config;

import c332030.utils.tools.Tools;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;

public class YamlUtils {

    private YamlUtils(){}

    /**
     * 解析 yml 为 Map
     * @param resource
     * @return
     */
    public static Map<String, Object> loadYamlMap(Resource resource) {
        if(Tools.isEmpty(resource)) {
            return Collections.emptyMap();
        }

        YamlMapFactoryBean yamlMapFactoryBean = new YamlMapFactoryBean();
        yamlMapFactoryBean.setResources(resource);

        return yamlMapFactoryBean.getObject();
    }

    /**
     * 解析绝对路径的 yml 为 Map
     * @param path
     * @return
     */
    public static Map<String, Object> loadYamlMap(String path) {
        return Collections.emptyMap();
    }

    /**
     * 解析 Classpath 下的 yml 为 Map
     * @param path
     * @return
     */
    public static Map<String, Object> loadYamlMapClasspath(String path) {
        if(Tools.isEmpty(path)) {
            return Collections.emptyMap();
        }

        return loadYamlMap(new ClassPathResource(path));
    }

    /**
     * 解析 yaml 为 Properties
     * @param resource
     * @return
     */
    public static Properties loadYamlProperties(Resource resource) {
        if(Tools.isEmpty(resource)) {
            return null;
        }

        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        yamlPropertiesFactoryBean.setResources(resource);

        return yamlPropertiesFactoryBean.getObject();
    }

    /**
     * 解析 Classpath 下的 yml 为 Properties
     * @param path
     * @return
     */
    public static Properties loadYamlPropertiesClasspath(String path) {
        if(Tools.isEmpty(path)) {
            return null;
        }

        return loadYamlProperties(new ClassPathResource(path));
    }
}