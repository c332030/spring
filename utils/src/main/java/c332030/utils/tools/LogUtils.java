package c332030.utils.tools;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogUtils implements Tool {

    public enum Type {
        CONSOLE, LOG, BOTH
    }

    public enum Level {
        INFO, TRACE, DEBUG, ERROR
    }

    /**
     * 
     * @Title: print 
     * @Description: 输出到控制台
     * @author c332030
     * @time 2018年8月4日 下午5:54:15
     * @param methodName
     */
    public static void print(
            String methodName
        ) {
        print(methodName, Type.CONSOLE);
    }

    /**
     * 
     * @Title: print 
     * @Description: 日志输出时默认 debug 级别
     * @author c332030
     * @time 2018年8月4日 下午5:54:24
     * @param methodName
     * @param type
     */
    public static void print(
            String methodName,
            Type type
        ) {
        print(methodName, type, Level.DEBUG);
    }

    /**
     * 
     * @Title: print 
     * @Description: 信息输出选项
     * @author c332030
     * @time 2018年8月4日 下午5:54:54
     * @param methodName
     * @param type
     * @param level
     */
    public static void print(
            String methodName,
            Type type,
            Level level
        ) {
        if(Tools.isEmpty(methodName)
                || null == type
                || null == level
            ) {
            return;
        }

        if(Type.CONSOLE == type) {
            consolePrint(methodName);
            return;
        }

        if(Type.BOTH == type) {
            consolePrint(methodName);
        }

        if(Level.DEBUG == level) {

            debug(methodName);
        } else if(Level.ERROR == level) {

            error(methodName);
        } else if(Level.INFO == level) {

            info(methodName);
        } else if(Level.TRACE == level) {

            trace(methodName);
        }
    }

    /**
     * 
     * @Title: getLog 
     * @Description:
     * @author c332030
     * @time 2018年6月13日 下午3:30:38
     * @param clazz
     * @return
     */
    private static Log getLog(Class<?> clazz) {
        return LogFactory.getLog(Tools.dealNull(clazz, LogUtils.class));
    }

    public static void debug(Object obj) {
        debug(null, obj);
    }
    public static void debug(Object object, Object obj) {
        if(Tools.isEmpty(object)) {
            debug(obj);
        }

        debug(object.getClass(), obj);
    }
    public static void debug(Class<?> clazz, Object obj) {
        if(null == obj) {
            return;
        }

        Log log = getLog(clazz);
        if(log.isDebugEnabled()) {
            log.debug(obj.toString());
        }
    }

    public static void trace(String traceStr) {
        trace(null, traceStr);
    }
    public static void trace(Object object, String traceStr) {
        if(Tools.isEmpty(object)) {
            trace(traceStr);
        }

        trace(object.getClass(), traceStr);
    }
    public static void trace(Class<?> clazz, String traceStr) {
        Log log = getLog(clazz);

        if(log.isTraceEnabled()) {
            log.trace(traceStr);
        }
    }

    public static void info(String infoStr) {
        info(null, infoStr);
    }
    public static void info(Object object, String infoStr) {
        if(Tools.isEmpty(object)) {
            info(infoStr);
        }

        info(object.getClass(), infoStr);
    }
    public static void info(Class<?> clazz, String infoStr) {
        Log log = getLog(clazz);

        if(log.isInfoEnabled()) {
            log.info(infoStr);
        }
    }

    public static void warn(String warnStr) {
        warn(null, warnStr);
    }
    public static void warn(Object object, String warnStr) {
        if(Tools.isEmpty(object)) {
            warn(warnStr);
        }

        warn(object.getClass(), warnStr);
    }
    public static void warn(Class<?> clazz, String warnStr) {
        Log log = getLog(clazz);

        if(log.isWarnEnabled()) {
            log.warn(warnStr);
        }
    }

    public static void error(String errorStr) {
        error(null, errorStr);
    }
    public static void error(Object object, String errorStr) {
        if(Tools.isEmpty(object)) {
            error(errorStr);
        }

        error(object.getClass(), errorStr);
    }
    public static void error(Class<?> clazz, String errorStr) {
        Log log = getLog(clazz);

        if(log.isErrorEnabled()) {
            log.error(errorStr);
        }
    }

    /**
     * 输出到控制台
     */
    public static void consolePrint (String methodName) {
        System.out.println(methodName);
    }
}