package c332030.passport;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@MapperScan(value = "c332030.passport.mapper")
public class Passport implements CommandLineRunner {

    @Override
    public void run(String... args) {}

/*    @Bean
    public ExitCodeGenerator exitCodeGenerator() {
        return () -> 332030;
    }*/

    public static void main(String[] args) {
        SpringApplication.run(Passport.class, args);

//        System.exit(SpringApplication.exit(SpringApplication.run(Login.class, args)));
    }
}
