package c332030.ddns;

import c332030.ddns.dnspod.DnspodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Ddns implements CommandLineRunner {

    @Autowired
    private DnspodService dnspodService;

    @Override
    public void run(String... args) {

        System.out.println("Hello DDNS Module");

        if(null == dnspodService) {
            return;
        }

        System.out.println(dnspodService.load());
        System.out.println(dnspodService);

        Map<String, String> commMap = new HashMap<>();
        commMap.put("login_token", "27938,a004d83afce2617d9edf8d90ec8948b4");
        commMap.put("format", "json");

//        dnspodService.comm("Info.Version", commMap);
    }

    public static void main(String[] args) {
        SpringApplication.run(Ddns.class, args);
    }
}