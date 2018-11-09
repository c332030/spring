package c332030.utils.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils implements Tool {
	
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static final DateFormat dateFormatEx = new SimpleDateFormat("yyyyMMddHHmmss");
	
	private static String backupTime = "";
	private static int orderNum = 1;


	/**
	 * 获取当前日期
	 * 
	 * @author	c332030
	 * @return	字符串类型的当前日期：'yyyy-MM-dd'
	 */
	public static String getDate() {
		String nowDate = null;
		
		synchronized (dateFormat) {

			nowDate = dateFormat.format(new Date());
		}

		return nowDate;
	}
	
	/**
	 * 获取格式化的时间
	 * 
	 * @return	字符串类型的当前日期："yyyyMMddHHmmss"
	 */
	public static String getDateString() {
		String nowTime = null;
		
		synchronized (dateFormatEx) {

			nowTime = dateFormatEx.format(new Date());
		}
		
//		System.out.println("OrderUtils.getDateString：nowTime = " + nowTime);

		return nowTime;
	}
	
	/**
	 * 获取格式化的时间，为订单表主键
	 * 
	 * @return	字符串类型的当前日期："yyyyMMddHHmmss" + "xxx"
	 */
	public static String getIdByTime() {
		
	//	System.out.println("OrderUtils.getIdByTime：backupTime = " + backupTime);
	//	System.out.println("orderNum = " + orderNum);

		String nowTime = getDateString();

		synchronized (backupTime) {

			if(nowTime.equals(backupTime)) {

				if (orderNum < 10) {

					nowTime += "00";
				//	System.out.println("OrderUtils.getIdByTime：两个 0：" + nowTime);
				} else if(orderNum >= 10 || orderNum < 100) {

					nowTime += "0";
				//	System.out.println("OrderUtils.getIdByTime：一个 0：" + nowTime);
				}
			} else {

				orderNum = 1;
				backupTime = nowTime;
				
				nowTime += "00";
			}
				
			nowTime += orderNum++;
		}
		
//		System.out.println("OrderUtils.getIdByTime：生成的订单 ID = " + nowTime);

		return nowTime;
	}

	private static String backupTime2 = "";
	private static int orderNum2 = 1;
	
	public static String getIdByTime2() {
		
	//	System.out.println("OrderUtils.getIdByTime：backupTime = " + backupTime);
	//	System.out.println("orderNum = " + orderNum);

		String nowTime = getDateString();

		synchronized (backupTime2) {

			if(nowTime.equals(backupTime2)) {

				if (orderNum2 < 10) {

					nowTime += "00";
				//	System.out.println("OrderUtils.getIdByTime：两个 0：" + nowTime);
				} else if(orderNum2 >= 10 || orderNum2 < 100) {

					nowTime += "0";
				//	System.out.println("OrderUtils.getIdByTime：一个 0：" + nowTime);
				}
			} else {

				orderNum2 = 1;
				backupTime2 = nowTime;
				
				nowTime += "00";
			}
				
			nowTime += orderNum2++;
		}
		
//		System.out.println("OrderUtils.getIdByTime：生成的订单 ID = " + nowTime);

		return nowTime;
	}
	
	/**
	 * 计算年龄
	 * 
	 * @author	c332030
	 * @param	born	字符串类型的日期：'yyyy-MM-dd'
	 * @return	计算出的年纪
	 */
	public static int getAge(String born) {
		int age = -1;

		if(null == born || "".equals(born)) {
			return age;
		}

		Calendar bornCalendar = Calendar.getInstance();
		Calendar nowCalendar = Calendar.getInstance();
		
		Date nowDate = new Date();
		nowCalendar.setTime(nowDate);
		
		try {
			// 字符串转日期
			
			Date bornDate = null;
			
			synchronized (dateFormat) {
				bornDate = dateFormat.parse(born);
			}

			bornCalendar.setTime(bornDate);

		} catch (ParseException e) {
			
			System.out.println("UserUtils：字符串转时间失败！");
			e.printStackTrace();
			return age;
		}

		age = nowCalendar.get(Calendar.YEAR) - bornCalendar.get(Calendar.YEAR);

		return age;
	}
}
