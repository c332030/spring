package c332030.passport;

import c332030.passport.tools.data.LRedisUtils;
import c332030.utils.tools.LogUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@MapperScan(value = "c332030.passport.mapper")
public class Passport implements CommandLineRunner {

    private final LRedisUtils lRedisUtils;

    @Autowired
    public Passport(LRedisUtils lRedisUtils) {
        this.lRedisUtils = lRedisUtils;
    }

    @Override
    public void run(String... args) {
        LogUtils.debug(this, "Redis dbsize= " + lRedisUtils.dbSize());
    }

/*    @Bean
    public ExitCodeGenerator exitCodeGenerator() {
        return () -> 332030;
    }*/

    public static void main(String[] args) {
        SpringApplication.run(Passport.class, args);

//        System.exit(SpringApplication.exit(SpringApplication.run(Login.class, args)));
    }
}
