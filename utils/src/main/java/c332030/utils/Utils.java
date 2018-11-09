package c332030.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@MapperScan(value = "c332030.utils.data.mapper")
public class Utils implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("Hello Utils Application");
    }

    public static void main(String[] args) {
        SpringApplication.run(Utils.class, args);
    }
}