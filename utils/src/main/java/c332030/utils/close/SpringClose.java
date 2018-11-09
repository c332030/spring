package c332030.utils.close;

import c332030.utils.tools.thread.CThreadPool;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
public class SpringClose implements DisposableBean {

    @Override
    public void destroy() {

        CThreadPool.close(); // 关闭线程池
    }
}
