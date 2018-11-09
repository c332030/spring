package c332030.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @ClassName Spring
 * @Description TODO
 * @Author c332030
 * @Date 2018/10/30 19:23
 * @Version 1.0
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Spring implements CommandLineRunner {

    @Override
    public void run(String... args) {}

    public static void main(String[] args) {
        SpringApplication.run(Spring.class, args);
    }
}
