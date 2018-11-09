package c332030.utils.tools.web;

import c332030.utils.data.constant.ConstantWeb;
import c332030.utils.tools.DataUtils;
import c332030.utils.tools.Tool;

import javax.servlet.http.HttpSession;

/**
 * Struts WebTools 工具类
 * 
 * 操作 Session
 * 
 * @author c332030
 *
 */

public class SessionUtils implements Tool {

	// Session
	protected static HttpSession getSessionObject() {
		
		HttpSession session = null;

		return session;
	}

	

	public static Object getSession(String key) {
		Object object = null;
		
		if(null == key || key.length() <= 0) {
			
			System.out.println("ToolsWeb.getSession：传值错误！");
			return object;
		}
		
		HttpSession session = getSessionObject();
		
		if(null == session) {
			
			System.out.println("ToolsWeb.getSession：Session 获取失败！");
			return object;
		}
		
		try {

			object = session.getAttribute(key);
		} catch (Exception e) {

			System.out.println("ToolsWeb.getSession：获取 Session 值失败！");
			e.printStackTrace();
		}
		
		return object;
	}
	
	public static boolean putSession(String key, Object value) {
		boolean result = false;
		
		if(null == key || key.length() <= 0 || null == value) {
			
			System.out.println("ToolsWeb.putSession：传值错误！");
			return result;
		}
		
		HttpSession session = getSessionObject();
		
		if(null == session) {
			
			System.out.println("ToolsWeb.putSession：Session 获取失败！");
			return result;
		}
		
		try {
			session.setAttribute(key, value);
			
			result = true;
		} catch (Exception e) {

			System.out.println("ToolsWeb.putSession：传入 Session 值失败！");
			e.printStackTrace();
		}

		return result;
	}
	
	public static boolean removeSession(String key) {
		boolean result = false;
		
		if(null == key || key.length() <= 0) {
			
			System.out.println("ToolsWeb.removeSession：传值错误！");
			return result;
		}
		
		HttpSession session = getSessionObject();
		
		if(null == session) {
			
			System.out.println("ToolsWeb.removeSession：Session 获取失败！");
			return result;
		}
		
		try {
			session.removeAttribute(key);

			result = true;
		} catch (Exception e) {

			System.out.println("ToolsWeb.removeSession：删除 Session 值失败！");
			e.printStackTrace();
		}

		return result;
	}

	public static boolean putSessionMessage(String str) {
		return putSession(ConstantWeb.Session.Message, str);
	}
	
	public static String getSessionMessage() {
		return (String) getSession(ConstantWeb.Session.Message);
	}
	
	public static boolean removeSessionMessage() {
		return removeSession(ConstantWeb.Session.Message);
	}

	public static void createRequestId() {

		putSession(ConstantWeb.Session.RequestId, DataUtils.getRandomHex());
	}
}