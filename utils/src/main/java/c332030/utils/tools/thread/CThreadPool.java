package c332030.utils.tools.thread;

import c332030.utils.data.model.CThread;
import c332030.utils.tools.Tools;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CThreadPool {

    private static final LinkedBlockingQueue<Runnable> RUNNABLES_QUEUE =
            new LinkedBlockingQueue<>();

    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR =
            new ThreadPoolExecutor(100, 1000, 1, TimeUnit.MINUTES, RUNNABLES_QUEUE);

    static {
        THREAD_POOL_EXECUTOR.allowCoreThreadTimeOut(true);
    }

    public static boolean execute(CThread<?> cThread) {
        if(Tools.isEmpty(cThread)) {
            return false;
        }

        THREAD_POOL_EXECUTOR.execute(cThread);

        return true;
    }

    public static <E> CThread<E> execute(
            Class<E> eClass, String methodName,
            Class<?>[] paraTypes,
            Object[] paras
        ) throws Exception {

        CThread<E> cThread = CThread.newInstance(eClass, methodName, paraTypes, paras);

        if(execute(cThread)) {
            return cThread;
        }

        return null;
    }

    public static <E> CThread<E> execute(
            E e, String methodName,
            Class<?>[] paraTypes,
            Object[] paras
    ) throws Exception {

        CThread<E> cThread = CThread.newInstance(e, methodName, paraTypes, paras);

        if(execute(cThread)) {
            return cThread;
        }

        return null;
    }

    public static void close() {
        THREAD_POOL_EXECUTOR.shutdown();
    }
}
