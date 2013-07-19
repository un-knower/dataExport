package com.test.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

/**
 * Date时间工具类.
 * 
 * @author 姜浩
 * @update 2011-9-2 下午04:21:33
 */

public class DateUtil {
	/**
	 * 获取系统时间的string串，时间格式为yyyy-MM-dd HH:mm:ss.
	 * 
	 * @return
	 * @author 姜浩
	 * @update 2011-9-2 下午04:21:46
	 */
	public static String getSysDateStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String str = sdf.format(date);
		return str;
	}

	/**
	 * 获取时间DATE.
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            时间格式
	 * @return
	 * @author 姜浩
	 * @update 2011-9-2 下午04:22:13
	 */
	public static Date getDate(Date date, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			String str = sdf.format(date);
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 按给定时间格式获取系统时间的string串.
	 * 
	 * @param format
	 * @return
	 * @author 姜浩
	 * @update 2011-9-2 下午04:22:56
	 */
	public static String getSysDateStr(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = new Date();
		String str = sdf.format(date);
		return str;
	}

	/**
	 * 按给定时间格式获取某时间对象的string串.
	 * 
	 * @param date
	 * @param format
	 * @return
	 * @author 姜浩
	 * @update 2011-9-2 下午04:23:10
	 */
	public static String getDateStr(Date date, String format) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String str = sdf.format(date);
		return str;
	}

	/**
	 * 把一时间string串按制定格式转换成Date类型.
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 * @author 姜浩
	 * @update 2011-9-2 下午04:23:22
	 */
	public static Date toDate(String dateStr, String format) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 获取某月份最大天数.
	 * 
	 * @param ym
	 *            时间字符必须为"yyyy-MM"格式
	 * @return
	 * @author 姜浩
	 * @update 2011-9-2 下午04:23:36
	 */
	public static int getDays(String ym) {
		String[] aym = ym.split("-");
		int year = Integer.parseInt(aym[0]);
		int month = Integer.parseInt(aym[1]);
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 判断是否是周末.
	 * 
	 * @param dateStr
	 *            时间字符必须为"yyyy-MM-dd"格式
	 * @return
	 * @throws ParseException
	 * @author 姜浩
	 * @update 2011-9-2 下午04:25:45
	 */
	public static boolean getWeek(String dateStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance(TimeZone
				.getTimeZone("GMT+08:00"));
		calendar.setTime(sdf.parse(dateStr));
		int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		switch (week) {
		case 0:
			return true;
		case 1:
			return false;
		case 2:
			return false;
		case 3:
			return false;
		case 4:
			return false;
		case 5:
			return false;
		case 6:
			return true;
		}
		return false;
	}

	/**
	 * 获取周末天数.
	 * 
	 * @param dateStr
	 *            时间字符必须为"yyyy-MM"格式
	 * @return
	 * @throws ParseException
	 * @author 姜浩
	 * @update 2011-9-2 下午04:26:10
	 */
	public static int getWeekCount(String dateStr) throws ParseException {
		int weekCount = 0;
		int days = getDays(dateStr);
		for (int i = 1; i <= days; i++) {
			if (getWeek(dateStr + "-" + i)) {
				weekCount++;
			}
		}
		return weekCount;

	}

	/**
	 * 获取工作日天数.
	 * 
	 * @param dateStr
	 *            时间字符必须为"yyyy-MM"格式
	 * @return
	 * @throws ParseException
	 * @author 姜浩
	 * @update 2011-9-2 下午04:26:39
	 */
	public static int getWorkCount(String dateStr) throws ParseException {
		return getDays(dateStr) - getWeekCount(dateStr);

	}

	/**
	 * 返回"yyyy-MM-dd"格式的时间类型.
	 * 
	 * @param dateStr
	 * @return
	 * @author 姜浩
	 * @update 2011-9-2 下午04:26:59
	 */
	public static Date toDate(String dateStr) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 比较两个日期的大小.
	 * 
	 * @param date1
	 * @param date2
	 * @return 0:两时间相等，小于0:date1在date2之前，大于0:date1在date2之后
	 * @author 姜浩
	 * @update 2011-9-2 下午04:27:23
	 */
	public static int compare(Date date1, Date date2) {
		return date1.compareTo(date2);
	}

	/**
	 * 得到给定时间string串的前一天的string串.
	 * 
	 * @param dateStr
	 *            日期串
	 * @param format
	 *            日期格式
	 * @return
	 * @author 姜浩
	 * @update 2011-9-2 下午04:27:55
	 */
	public static String getPreDay(String dateStr, String format) {
		Date date = toDate(dateStr, format);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, -1);
		Date preDate = c.getTime();
		return getDateStr(preDate, format);
	}

	/**
	 * 得到给定时间string串的后一天的string串.
	 * 
	 * @param dateStr
	 *            时间串
	 * @param format
	 *            时间格式
	 * @return
	 * @author 姜浩
	 * @update 2011-9-2 下午04:28:42
	 */
	public static String getNextDay(String dateStr, String format) {
		Date date = toDate(dateStr, format);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		Date rightDateStr = c.getTime();
		return getDateStr(rightDateStr, format);
	}

	/**
	 * 得到当前时间的前七天.
	 * 
	 * @param format
	 *            时间格式
	 * @return
	 * @author 姜浩
	 * @update 2011-9-2 下午04:29:19
	 */
	public static String getLast7Day(String format) {
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, -7);
		Date rightDateStr = c.getTime();
		return getDateStr(rightDateStr, format);
	}

	/**
	 * 得到当前月的第一天或者最后一天.
	 * 
	 * @param type
	 *            0第一天 1最后一天
	 * @return
	 * @author 姜浩
	 * @update 2011-9-2 下午04:29:48
	 */
	public static String getSysMonthFirstLastDay(int type) {
		Calendar curCal = Calendar.getInstance(TimeZone
				.getTimeZone("GMT+08:00"));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if (type == 1) {
			curCal.set(Calendar.DATE, 1);
			curCal.roll(Calendar.DATE, -1);
			Date endTime = curCal.getTime();
			return df.format(endTime);
		} else if (type == 0) {
			curCal.set(Calendar.DAY_OF_MONTH, 1);
			Date beginTime = curCal.getTime();
			return df.format(beginTime);
		} else {
			return null;
		}
	}

	/**
	 * 计算两段日期相差月份.
	 * 
	 * @param tm1
	 * @param tm2
	 * @return 返回-1为非法
	 * @author 姜浩
	 * @update 2011-9-2 下午04:31:21
	 */
	public static int getMonthLength(Date tm1, Date tm2) {
		GregorianCalendar t1 = new GregorianCalendar();
		GregorianCalendar t2 = new GregorianCalendar();
		t1.setTime(tm1);
		t2.setTime(tm2);
		int x = 0;
		if ((t1.get(1) > t2.get(1)) && (t1.get(2) > t2.get(2))) {
			return -1;
		}
		while ((t1.get(1) != t2.get(1)) || (t1.get(2) != t2.get(2))) {
			x++;
			t1.add(2, 1);
		}
		return x;
	}

	/**
	 * 获取时间段内 指定日期的时间字符集合 yyyy-MM-dd格式.
	 * 
	 * @param tm1
	 * @param tm2
	 * @param sign
	 * @return
	 * @author 姜浩
	 * @update 2011-9-2 下午04:31:44
	 */
	public static List<String> getSpecialDateList(String tm1, String tm2,
			int sign) {
		List<String> list = new ArrayList<String>();
		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			int length = getMonthLength(sf.parse(tm1), sf.parse(tm2));
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(sf.parse(tm1));
			calendar.set(calendar.get(1), calendar.get(2), sign);
			// 增量上限不能小于开始日期
			if (calendar.getTime().getTime() >= sf.parse(tm1).getTime()) {
				list.add(sf.format(calendar.getTime()));
			}
			for (int i = 0; i < length; i++) {
				calendar.add(Calendar.MONTH, 1);
				// 增量下限不能大于结束日期
				if (calendar.getTime().getTime() <= sf.parse(tm2).getTime()) {
					list.add(sf.format(calendar.getTime()));
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 格式化一个日期.
	 * 
	 * @param date
	 * @param format
	 * @return
	 * @author 姜浩
	 * @update 2011-9-2 下午04:32:30
	 */
	public static Date getDateFormat(Date date, String format) {
		SimpleDateFormat dsf = new SimpleDateFormat(format);
		String dateStr = dsf.format(date);
		Calendar calendar = new GregorianCalendar();
		try {
			calendar.setTime(dsf.parse(dateStr));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return calendar.getTime();

	}

	// public static void main(String args[]){
	// getDateFormat(new Date(),"yyyy-MM-dd HH:mm:ss");
	// }
	/**
	 * 字符串转换为Timestamp
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Timestamp stringToTimestamp(String dateStr) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		try {
			Date date = sdf.parse(dateStr);
			date.getTime();
			cal.setTime(date);
			return new Timestamp(cal.getTimeInMillis());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		cal.setTime(new Date());
		return new Timestamp(cal.getTimeInMillis());
	}

	/**
	 * 字符串转换为Timestamp
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Timestamp stringToTimestamp(String dateStr, String formatstr) {

		SimpleDateFormat sdf = new SimpleDateFormat(formatstr);
		Calendar cal = Calendar.getInstance();
		try {
			Date date = sdf.parse(dateStr);
			date.getTime();
			cal.setTime(date);
			return new Timestamp(cal.getTimeInMillis());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		cal.setTime(new Date());
		return new Timestamp(cal.getTimeInMillis());
	}
}
