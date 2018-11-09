package c332030.passport.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Close extends Thread {

    @Autowired
    private Spring spring;

    public void run()  {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        spring.getConfigurableApplicationContext().close();
    }
}
