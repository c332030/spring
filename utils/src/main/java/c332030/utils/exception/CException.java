package c332030.utils.exception;

/**
 * 
 * <T>Title: CException</T><br>
 * 
 * <T>desc: 自定义异常类</T><br>
 * 
 * <T>author: c332030 2018年6月14日 上午10:51:57</T><br>
 * 
 * <T>modify: <br>
 *         <D>修改人、修改时间、修改点描述、版本号</D><br>
 * </T><br>
 *
 */
public class CException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * 不支持的操作
     */
    public static final Exception unsupportedOperationException =
            new UnsupportedOperationException("不支持的操作！");

    /**
     * 
     * @Description: 见 exception
     * @author c332030
     * @time 2018年6月14日 上午10:50:29
     */
    public CException() {
        super();
    }

    /**
     * 
     * @Description: 见 exception
     * @author c332030
     * @time 2018年6月14日 上午10:50:24
     * @param message
     */
    public CException(String message) {
        super(message);
    }

    /**
     * 
     * @Description: 见 exception
     * @author c332030
     * @time 2018年6月14日 上午10:50:18
     * @param message
     * @param cause
     */
    public CException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 
     * @Description: 见 exception
     * @author c332030
     * @time 2018年6月14日 上午10:50:01
     * @param cause
     */
    public CException(Throwable cause) {
        super(cause);
    }

    /**
     * 
     * @Description: 见 exception
     * @author c332030
     * @time 2018年6月14日 上午10:50:10
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    protected CException(String message,
            Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace
        ) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
