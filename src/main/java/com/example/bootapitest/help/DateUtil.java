package com.example.bootapitest.help;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 时间工具类
 * @author hailin
 *
 */
public class DateUtil {
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT = "yyyy-MM-dd";

	public static final DateFormat DATE_YMDHHMM_FORMAT = new SimpleDateFormat("Y年M月d日 HH:mm");
	public static final DateFormat DATE_MDHHMM_FORMAT = new SimpleDateFormat("M月d日 HH:mm");
	public static final DateFormat DATE_TODAY_FORMAT = new SimpleDateFormat("HH:mm");
	public static final DateFormat DATE_YESTERDAY_FORMAT = new SimpleDateFormat("昨天 HH:mm");
	public static final DateFormat DATE_BEFORE_YESTERDAY_FORMAT = new SimpleDateFormat("前天 HH:mm");
	public static final DateFormat DATE_MMDDHHMM_FORMAT = new SimpleDateFormat("MM-dd HH:mm");
	public static final DateFormat DATE_YYMMDD_FORMAT = new SimpleDateFormat("yyMMdd");
	public static final DateFormat DATE_YYMM_FORMAT = new SimpleDateFormat("yyMM");
	public static DateFormat DATE_YYYYMMDD_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 对日期添加年限
	 * @param date 日期
	 * @param year 年限
	 * @return 返回日期
	 */
	public static Date addYear(Date date,int year){
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.YEAR, 1);
		return calendar.getTime();
	}
	
	/**
	 * 获取当前时间并转换成毫秒数
	 * 
	 * @return
	 */
	public static Long getCurrentTimeMillis() {
		Date date = new Date();
		return date.getTime();
	}
	
	/**
	 * 字符串日期格式化类
	 * @param format 日期格式，如："yyyy-MM-dd" 表示格式为"2010-06-10"
	 * @param stringDate 日期
	 * @return 格式化后的日期对象
	 */
	public static Date format(String format, String stringDate){
		//格式化对象
		SimpleDateFormat sdFormat = new SimpleDateFormat(format);
		
		Date date = null;;
		try {
			//字符串对象转换成日期对象
			date = sdFormat.parse(stringDate);
		} catch (ParseException e) {
//			System.out.println("转换日期出错！！");
			e.printStackTrace();
		}
		return date;		
	}
	
	public static Date LongToDate(Long date, String pattern) {
		Date d = new Date();
		if (date != null && date != 0) {
			d.setTime(date);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("", Locale.CHINESE);
			simpleDateFormat.applyPattern(pattern);
		}
		return d;
	}
	
	/**
	 * 日期型转字符串
	 * @param format 日期格式
	 * @param date 日期对象
	 * @return 格式化后的字符串
	 */
	public static String dateToString(Date date, String format){
		SimpleDateFormat sdFormat = new SimpleDateFormat(format);
		return sdFormat.format(date);
	}
	
	/**
	 * 格式化字符串
	 * @param date 日期
	 * @return 返回格式化后的日期字符串
	 */
	public static String dateToString(Date date){
		String format = "yyyy-MM-dd HH:mm:ss";
		return dateToString(date, format);
	}
	
	/**
	 * 日期转换成毫秒
	 * 
	 * @param date 日期或时间
	 * @param pattern 格式
	 * @return
	 */
	public static Long stringToLong(String date, String pattern) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.CHINESE);
		Date date1 = null;
		try {
			if (StringUtils.isNotBlank(date)) {
				date1 = simpleDateFormat.parse(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (date1 == null ? 0L : date1.getTime());
	}
	
	public static String longToString(Long date, String pattern) {
		Date d = new Date();
		String timeStr = "";
		if (date != null && date != 0) {
			d.setTime(date);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("", Locale.CHINESE);
			simpleDateFormat.applyPattern(pattern);
			timeStr = simpleDateFormat.format(d);
		}
		return timeStr;
	}
	
	/**
	 * 系统时间加上amount的时间之后是否大于date日期
	 * @param date 日期
	 * @param field 日历字段
	 * @param amount 为字段添加的日期或时间量
	 * @return 成功返回true,失败返回false
	 */
	public static boolean dateSubtract(Date date, int field, int amount){
		GregorianCalendar calendar = new GregorianCalendar();
		GregorianCalendar calendar1 = new GregorianCalendar();
		calendar1.setTime(new Date());
		calendar.setTime(date);
		calendar.add(field, amount);
		System.out.println(calendar.getTime());
		return calendar.before(calendar1);
	}
	
	/**
     * 取得系统的当前日期(年-月-日)。
     * 
     * @return 系统的当前日期或者时间，java.util.date对象。
     */
    public static String getSystemCurrentTime() {
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	
    	String date = df.format(new Date());
    	
    	return date;
    	
    }

    /**
     * 取得系统的当前日期(年-月-日 时:分:秒)。
     * 
     * @return 系统的当前日期，java.util.date对象。
     */
    public static Date getSystemCurrentDate() {
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String date = df.format(new Date());
  
    	return Timestamp.valueOf(date);
    	
    }
    
    /**
     * 取得系统的当前日期(年-月-日)。
     * 
     * @return 系统的当前日期，java.util.date对象。
     */
    public static String getSystemCurrentDate(String dateFormat) {
    	
    	DateFormat df = new SimpleDateFormat(dateFormat);
    	
    	return df.format(new Date());
    }
    
    /**
     * 计算当前日期上加上多少天或者多少年以后的日期
     * return 计算后的日期
     */
	public static String getAddDate(String currentDate, int day, int year) {
		String deadline = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(sdf.parse(currentDate));

			if (day != 0) {
				calendar.add(Calendar.DATE, day);
			}
			if (year != 0) {
				calendar.add(Calendar.YEAR, year);
			}
			deadline = sdf.format(calendar.getTime());
		} catch (Exception e) {
		}
		return deadline;
	}

	/**
	 * 计算当前日期上加上多少天或者多少年以后的日期
	 * return 计算后的日期
	 */
	public static Date getAddDateDayYear(String currentDate, int day, int year) {
		String deadline = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(sdf.parse(currentDate));

			if (day != 0) {
				calendar.add(Calendar.DATE, day);
			}
			if (year != 0) {
				calendar.add(Calendar.YEAR, year);
			}
			deadline = sdf.format(calendar.getTime());
		} catch (Exception e) {
		}
		return Timestamp.valueOf(deadline);
	}

	/**
     * 计算当前日期上加上多少天以后的日期
     * return 计算后的日期
     */
	public static String getAddDate(int days) {
		Date d=new Date();   
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd"); 
        return df.format(new Date(d.getTime() + (long)days * 24 * 60 * 60 * 1000));
	}

	/**
	 * 计算当前日期上加上多少天以后的日期
	 * return 计算后的日期
	 */
	public static String getAddDatSS(int days) {
		Date d=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date(d.getTime() + (long)days * 24 * 60 * 60 * 1000));
	}
	
	/**
     * 计算当前日期上减去多少天以后的日期
     * return 计算后的日期
     */
	public static String getRemoveDate(int days) {
		Date d=new Date();   
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd"); 
        return df.format(new Date(d.getTime() - (long)days * 24 * 60 * 60 * 1000));
	}
	
	/**
	 * 计算倒计时
	 * 
	 * @param strDate 计算日期
	 * @param pattern 日期格式 (比如 yyyy/MM/dd)
	 * @return 倒计时天数
	 */
	public static Long countDown(String strDate, String pattern) {
		Long longDate = stringToLong(strDate, pattern);
		Long longNow = stringToLong(longToString(getCurrentTimeMillis(), pattern), pattern);
		Long countDown = (longDate - longNow) / 1000 / 3600 / 24;
		return countDown;
	}
	
	/**
	 * 获取“今天”零点的毫秒数
	 * 
	 * @return
	 */
	public static Long getBeginOfToday() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}

	/**
	 * 获得某天的开始时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getBeginOfDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获得某天的开始时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getBeginOfYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_YEAR, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 返回两者之间的分钟差
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int subMinute(Date date1, Date date2) {
		Long subTime = date1.getTime() - date2.getTime();
		Long subMinute = subTime / 60000;
		return subMinute.intValue();
	}

	public static boolean isMonthFirst() {
		Calendar localTime = Calendar.getInstance();
		int x = localTime.get(Calendar.DAY_OF_MONTH);
		return x == 1 ? true : false;
	}

	/**
	 * 取本月最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static int getLastDayOfMonth(Long date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(LongToDate(date, "yyyy-MM-dd"));
		// 某年某月的最后一天
		return cal.getActualMaximum(Calendar.DATE);
	}

	/***
	 * 获取当前日期偏移后的时间的毫秒数
	 * 
	 * @author scott.wan
	 * @param day
	 * @return
	 */
	public static long getCurrDateOffsetTime(int day) {
		Calendar cal = Calendar.getInstance();// 使用默认时区和语言环境获得一个日历。
		cal.add(Calendar.DAY_OF_MONTH, day);
		return cal.getTimeInMillis();
	}

	/**
	 * 格式化日期类型
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		if (date == null)
			return null;
		SimpleDateFormat f = new SimpleDateFormat(format);
		return f.format(date);
	}

	/**
	 * 格式化字符串 formatDate
	 * 
	 * @param date 日期
	 * @return 返回格式化后的日期字符串
	 */
	public static String formatDateTime(Date date) {
		DateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (date == null) {
			return null;
		} else {
			return DATE_TIME_FORMAT.format(date);
		}
	}

	/**
	 * 在当前时间基础上加分钟
	 * 
	 * @param date 基础时间
	 * @param days 所要加的天数
	 * @param hour 所要加的小时数
	 * @param minute 所要加的分钟数
	 * @return
	 */
	public static Date addTime(Date date, int days, int hour, int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);
		calendar.add(Calendar.HOUR, hour);
		calendar.add(Calendar.MINUTE, minute);
		return calendar.getTime();
	}
	
	/**
	 * 在当前时间基础上加分钟
	 * 
	 * @param date 基础时间
	 * @param days 所要加的天数
	 * @param hour 所要加的小时数
	 * @param minute 所要加的分钟数
	 * @return
	 */
	public static Date addTime(Date date, int days, int hour, int minute, int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);
		calendar.add(Calendar.HOUR, hour);
		calendar.add(Calendar.MINUTE, minute);
		calendar.add(Calendar.SECOND, second);
		return calendar.getTime();
	}
	
	/***
	 * 
	 * @param date
	 * @param months
	 * @return
	 */
	public static String addMonth(Long date, int months) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(date));
		calendar.add(Calendar.MONTH, months);
		return longToString(calendar.getTime().getTime(), "yyyy年MM月dd日");
	}

	public static long addMonthToLong(Long date, int months) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(date));
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime().getTime();
	}

	/**
	 * 获得某一天的最小间
	 * 
	 * @param date 时间
	 * @return 当天最时间
	 */
	public static Date getMinOfDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获得某一天的最大时间
	 * 
	 * @param date 时间
	 * @return 当天最时间
	 */
	public static Date getMaxOfDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}
	
	public static String formatDateToHours(Date date, String format) {
		if (date != null) {
			Date crrDate = new Date();
			if (date.after(DateUtil.addTime(crrDate, 0, 0, -1))) {
				return "刚刚";
			} else if (date.after(DateUtil.addTime(crrDate, 0, -1, 0))) {
				return DateUtil.subMinute(crrDate, date) + "分钟前";
			} else if (date.after(DateUtil.getBeginOfDate(crrDate))) {
				return DateUtil.DATE_TODAY_FORMAT.format(date);
			} else {
				Calendar c1 = Calendar.getInstance();
				c1.setTime(date);


				Calendar c2 = Calendar.getInstance();
				c2.setTime(new Date());

				if(c1.get(Calendar.YEAR) < c2.get(Calendar.YEAR)){
					return DateUtil.DATE_YMDHHMM_FORMAT.format(date);
				}
				if (StringUtils.isNotBlank(format)) {
					return formatDate(date, format);
				} else {
					return DateUtil.DATE_MDHHMM_FORMAT.format(date);
				}
			}
		}
		return null;
	}

	/**
	 * 抽取社区计算时间的方法
	 * 
	 * @author 李军 2013.1.27
	 */
	public static String formatDateToHours(Long time, String format) {
		if (null == time) {
			return "";
		}
		Date date = new Date(time);
		if (date != null) {
			Date crrDate = new Date();
			if (date.after(DateUtil.addTime(crrDate, 0, 0, -1))) {
				return "刚刚";
			} else if (date.after(DateUtil.addTime(crrDate, 0, -1, 0))) {
				return DateUtil.subMinute(crrDate, date) + "分钟前";
			} else if (date.after(DateUtil.getBeginOfDate(crrDate))) {
				return DateUtil.DATE_TODAY_FORMAT.format(date);
			} else {
				if (StringUtils.isNotBlank(format)) {
					return formatDate(date, format);
				} else {
					return DateUtil.DATE_MDHHMM_FORMAT.format(date);
				}
			}
		}
		return null;
	}

	/**
	 * 格式化yyyy-MM-dd的日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date parseDate(String date) {
		try {
			return DATE_YYYYMMDD_FORMAT.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 计算两个日期相差多少天
	 * 
	 * @param begin 起始日期
	 * @param end 结束日期
	 * @return 返回相差的天数
	 */
	public static int countDays(String begin, String end) {
		int days = 0;
		Calendar c_b = Calendar.getInstance();
		Calendar c_e = Calendar.getInstance();
		c_b.setTime(parseDate(begin));
		c_e.setTime(parseDate(end));

		if (c_b.after(c_e)) {
			return -1;
		} else {
			while (c_b.before(c_e)) {
				days++;
				c_b.add(Calendar.DAY_OF_YEAR, 1);
			}
		}
		return days;
	}

	/**
	 * 计算两个日期相差多少小时
	 *
	 * @param begin 起始日期
	 * @param end 结束日期
	 * @return 返回相差的天数
	 */
	public static int countHours(String begin, String end) {
		int Hour = 0;
		Calendar c_b = Calendar.getInstance();
		Calendar c_e = Calendar.getInstance();
		c_b.setTime(parseDate(begin));
		c_e.setTime(parseDate(end));

		if (c_b.after(c_e)) {
			return -1;
		} else {
			while (c_b.before(c_e)) {
				Hour++;
				c_b.add(Calendar.HOUR_OF_DAY, 1);
			}
		}
		return Hour;
	}

	/**
	 * 计算两个日期相差多少天
	 *
	 * @param begin 起始日期
	 * @param end 结束日期
	 * @return 返回相差的天数
	 */
	public static int countHours(Date begin, Date end) {
		int Hour = 0;
		Calendar c_b = Calendar.getInstance();
		Calendar c_e = Calendar.getInstance();
		c_b.setTime(begin);
		c_e.setTime(end);
		if (c_b.after(c_e)) {
			return -1;
		} else {
			while (c_b.before(c_e)) {
				Hour++;
				c_b.add(Calendar.HOUR_OF_DAY, 1);
			}
		}
		return Hour;
	}

	/**
	 * 计算两个日期相差多少天
	 * 
	 * @param begin 起始日期
	 * @param end 结束日期
	 * @return 返回相差的天数
	 */
	public static int countDays(Date begin, Date end) {
		int days = 0;
		Calendar c_b = Calendar.getInstance();
		Calendar c_e = Calendar.getInstance();
		c_b.setTime(begin);
		c_e.setTime(end);
		if (c_b.after(c_e)) {
			return -1;
		} else {
			while (c_b.before(c_e)) {
				days++;
				c_b.add(Calendar.DAY_OF_YEAR, 1);
			}
		}
		return days;
	}

	public static Date getDateByMonth(int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date getMonthFirstDay(int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date getMonthLastDay(int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date getYearMonthFirstDay(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date getYearMonthLastDay(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date getYearFirstDay(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date getYearLastDay(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year + 1);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}


	//获取当前时间所在周的开始日期
	public static Date getFirstDayOfWeek(Date date){
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK,c.getFirstDayOfWeek()); // Monday
		return c.getTime();
	}

	//获取当前时间所在周的结束日期
	public static Date getLastDayOfWeek(Date date){
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK,c.getFirstDayOfWeek()+ 6); // Sunday
		return c.getTime();
	}



	/**
	 * 通过日期获取时间
	 * 
	 * @param sDate
	 * @return
	 */
	public static String getFullDateWeekTime(String sDate, String formater) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(formater);
			Date date = format.parse(sDate);
			format.applyPattern("E");
			return format.format(date);
		} catch (Exception ex) {
		}

		return "";
	}

	/**
	 * 
	 * @return
	 */
	public static String showTime(Date time) {
		Date date = new Date();
		Date today = DateUtil.getBeginOfDate(date);
		if (time != null) {
			if (time.after(DateUtil.addTime(date, 0, 0, -1))) {// 60秒内
				Long subTime = date.getTime() - time.getTime();
				return (subTime < 1000 ? 1000 : subTime) / 1000 + "秒前";
			} else if (time.after(today)) {// 60秒前，当天内
				return DateUtil.DATE_TODAY_FORMAT.format(time);
			} else if (time.after(DateUtil.addTime(today, -1, 0, 0))) {// 昨天
				return DateUtil.DATE_YESTERDAY_FORMAT.format(time);
			} else if (time.after(DateUtil.addTime(today, -2, 0, 0))) {// 前天
				return DateUtil.DATE_BEFORE_YESTERDAY_FORMAT.format(time);
			} else if (time.after(DateUtil.getBeginOfYear(date))) {// 前天以前，当年
				return DateUtil.DATE_MMDDHHMM_FORMAT.format(time);
			} else {
				return DateUtil.DATE_YYYYMMDD_FORMAT.format(time);
			}
		} else {
			return "";
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public static String showNewsTime(Date time) {
		Date date = new Date();
		Date today = DateUtil.getBeginOfDate(date);
		if (time != null) {
			if (time.after(DateUtil.addTime(date, 0, 0, -1))) {// 60秒内
				return "刚刚";
			} else if (time.after(DateUtil.addTime(date, 0, -1, 0))) {// 1小时内
				return (date.getTime() - time.getTime()) / 60000 + "分钟前";
			} else if (time.after(DateUtil.addTime(date, -1, 0, 0))) {// 24小时内
				return (date.getTime() - time.getTime()) / 3600000 + "小时前";
			} else if (time.after(DateUtil.addTime(today, -30, 0, 0))) {// 30天内
				return (date.getTime() - time.getTime()) / (24 * 3600000) + "天前";
			} else {
				return DateUtil.DATE_YYYYMMDD_FORMAT.format(time);
			}
		} else {
			return "";
		}
	}
	
	public static void main(String args[]){
		System.out.println(countDays("2011-01-05","2011-02-10"));
		
        System.out.println(getRemoveDate(1));   
        System.out.println(getAddDate(1));   

	}
}
