package c332030.utils.exception;

public class CRuntimeException extends CException {

	/**
	 * @Fields	serialVersionUID
	 * @Description	TODO
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @Description: 见 exception
	 * @author c332030
	 * @time 2018年6月14日 上午10:50:29
	 */
	public CRuntimeException() {
		super();
	}

	/**
	 * 
	 * @Description: 见 exception
	 * @author c332030
	 * @time 2018年6月14日 上午10:50:24
	 * @param message
	 */
	public CRuntimeException(String message) {
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
	public CRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 
	 * @Description: 见 exception
	 * @author c332030
	 * @time 2018年6月14日 上午10:50:01
	 * @param cause
	 */
	public CRuntimeException(Throwable cause) {
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
	protected CRuntimeException(String message,
			Throwable cause,
			boolean enableSuppression,
			boolean writableStackTrace
		) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
