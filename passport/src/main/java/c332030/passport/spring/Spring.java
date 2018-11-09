package c332030.passport.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Spring {

    // 关闭 Spring Boot 使用
    @Autowired
    private ConfigurableApplicationContext configurableApplicationContext;
    public ConfigurableApplicationContext getConfigurableApplicationContext() {
        return configurableApplicationContext;
    }
}
