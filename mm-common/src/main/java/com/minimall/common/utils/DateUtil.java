package com.minimall.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 北京京东世纪贸易有限公司<br>
 * Created with IntelliJ IDEA.
 * Date:2015/10/18
 * Time:12:12
 *
 * @author daifeng<br>
 * daifeng@jd.com
 * @since JDK 1.6 <br>
 * Copyright (c) 2015 JD System Incorporated All Rights Reserved.
 */
public class DateUtil {
    /**
     * 格式为：yyyy-MM-dd HH:mm:ss.SSS
     */
    public static final String DATE_MODEL_1 = "yyyy-MM-dd HH:mm:ss.SSS";
    /**
     * 格式为：yyyy-MM-dd HH:mm:ss
     */
    public static final String DATE_MODEL_2 = "yyyy-MM-dd HH:mm:ss";
    /**
     * 格式为：yyyy-MM-dd HH:mm
     */
    public static final String DATE_MODEL_3 = "yyyy-MM-dd HH:mm";
    /**
     * 格式为：yyyy-MM-dd HH
     */
    public static final String DATE_MODEL_4 = "yyyy-MM-dd HH";
    /**
     * 格式为：yyyy-MM-dd
     */
    public static final String DATE_MODEL_5 = "yyyy-MM-dd";
    /**
     * 格式为：yyyy-MM
     */
    public static final String DATE_MODEL_6 = "yyyy-MM";

    /**
     * 格式为：yyyyMMddHHmmss.SSS
     */
    public static final String DATE_MODEL_7 = "yyyyMMddHHmmss.SSS";
    /**
     * 格式为：yyyyMMddHHmmss
     */
    public static final String DATE_MODEL_8 = "yyyyMMddHHmmss";
    /**
     * 格式为：yyyyMMddHHmm
     */
    public static final String DATE_MODEL_9 = "yyyyMMddHHmm";
    /**
     * 格式为：yyyyMMddHH
     */
    public static final String DATE_MODEL_10 = "yyyyMMddHH";
    /**
     * 格式为：yyyyMMdd
     */
    public static final String DATE_MODEL_11 = "yyyyMMdd";
    /**
     * 格式为：yyyyMM
     */
    public static final String DATE_MODEL_12 = "yyyyMM";

    /**
     * 格式为：yyyy/MM/dd HH:mm:ss.SSS
     */
    public static final String DATE_MODEL_13 = "yyyy/MM/dd HH:mm:ss.SSS";
    /**
     * 格式为：yyyy/MM/dd HH:mm:ss
     */
    public static final String DATE_MODEL_14 = "yyyy/MM/dd HH:mm:ss";
    /**
     * 格式为：yyyy/MM/dd HH:mm
     */
    public static final String DATE_MODEL_15 = "yyyy/MM/dd HH:mm";
    /**
     * 格式为：yyyy/MM/dd HH
     */
    public static final String DATE_MODEL_16 = "yyyy/MM/dd HH";
    /**
     * 格式为：yyyy/MM/dd
     */
    public static final String DATE_MODEL_17 = "yyyy/MM/dd";
    /**
     * 格式为：yyyy/MM
     */
    public static final String DATE_MODEL_18 = "yyyy/MM";
    /**
     * 每分毫秒数
     */
    public static final int MILLISECONDS_PER_MINUTE = 60000;


    public static Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }


    private DateUtil(){}
    /**
     * 到下一分钟0秒的毫秒数
     *
     * @param rightnow 当前时间
     * @return the int 到下一分钟的毫秒数
     */
    public static int getDelayToNextMinute(long rightnow) {
        return (int) (MILLISECONDS_PER_MINUTE - (rightnow % MILLISECONDS_PER_MINUTE));
    }

    /**
     * 上一分钟的最后一毫秒
     *
     * @param rightnow 当前时间
     * @return 上一分钟的最后一毫秒
     */
    public static long getPreMinuteMills(long rightnow) {
        return rightnow - (rightnow % MILLISECONDS_PER_MINUTE) - 1;
    }

    /**
     * 得到时间字符串
     *
     * @param date 时间
     * @return 时间字符串
     */
    public static String dateToStr(Date date) {
        return dateToStr(date, DATE_MODEL_2);
    }

    /**
     * 时间转字符串
     *
     * @param date   时间
     * @param format 格式化格式
     * @return 时间字符串
     */
    public static String dateToStr(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 字符串转时间
     *
     * @param dateStr 时间字符串
     * @return 时间字符串
     */
    public static Date strToDate(String dateStr) throws ParseException {
        return strToDate(dateStr, DATE_MODEL_2);
    }

    /**
     * 字符串转时间
     *
     * @param dateStr 时间字符串
     * @param format  格式化格式
     * @return 时间字符串
     */
    public static Date strToDate(String dateStr, String format) throws ParseException {
        return new SimpleDateFormat(format).parse(dateStr);
    }

    /**
     * 得到毫秒级时间字符串
     *
     * @param date 时间
     * @return 时间字符串
     */
    public static String dateToMillisStr(Date date) {
        return dateToStr(date, DATE_MODEL_1);
    }

    /**
     * 得到Date
     *
     * @param millisDateStr 毫秒级时间字符串
     * @return Date
     */
    public static Date millisStrToDate(String millisDateStr) throws ParseException {
        return strToDate(millisDateStr, DATE_MODEL_1);
    }

    /**
     * 获取日期格式
     *
     * @param dateStr 日期字符串
     * @return 日期格式
     */
    public static String getFormat(String dateStr) {
        String result = null;
        if (dateStr.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}.\\d+")) {
            result = DATE_MODEL_1;
        } else if (dateStr.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
            result = DATE_MODEL_2;
        } else if (dateStr.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}")) {
            result = DATE_MODEL_3;
        } else if (dateStr.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}")) {
            result = DATE_MODEL_4;
        } else if (dateStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
            result = DATE_MODEL_5;
        } else if (dateStr.matches("\\d{4}-\\d{2}")) {
            result = DATE_MODEL_6;
        } else if (dateStr.matches("\\d{14}.\\d+")) {
            result = DATE_MODEL_7;
        } else if (dateStr.matches("\\d{14}")) {
            result = DATE_MODEL_8;
        } else if (dateStr.matches("\\d{12}")) {
            result = DATE_MODEL_9;
        } else if (dateStr.matches("\\d{10}")) {
            result = DATE_MODEL_10;
        } else if (dateStr.matches("\\d{8}")) {
            result = DATE_MODEL_11;
        } else if (dateStr.matches("\\d{6}")) {
            result = DATE_MODEL_12;
        } else if (dateStr.matches("\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2}:\\d{2}.\\d+")) {
            result = DATE_MODEL_13;
        } else if (dateStr.matches("\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
            result = DATE_MODEL_14;
        } else if (dateStr.matches("\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2}")) {
            result = DATE_MODEL_15;
        } else if (dateStr.matches("\\d{4}/\\d{2}/\\d{2} \\d{2}")) {
            result = DATE_MODEL_16;
        } else if (dateStr.matches("\\d{4}/\\d{2}/\\d{2}")) {
            result = DATE_MODEL_17;
        } else if (dateStr.matches("\\d{4}/\\d{2}")) {
            result = DATE_MODEL_18;
        }
        return result;
    }

    /**
     * 日期转字符串
     *
     * @param date   日期时间
     * @param format 格式化字符串
     * @return 日期字符串
     */
    public static String format(Date date, String format) {
        if (date == null) {
            return null;
        }
        String resultStr = "";
        String formatTemp = format;
        if (formatTemp == null || "".equals(formatTemp)) {
            formatTemp = DATE_MODEL_5;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatTemp);

        resultStr = dateFormat.format(date).trim();

        return resultStr;
    }

    /**
     * 字符串转日期
     *
     * @param dateStr 日期字符串
     * @param format  转换格式
     * @return 日期时间
     * @throws ParseException
     */
    public static Date parse(String dateStr, String format) throws ParseException {
        String formatTemp = format;
        if (formatTemp == null || "".equals(formatTemp)) {
            formatTemp = DATE_MODEL_5;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatTemp);
        return dateFormat.parse(dateStr);
    }

    /**
     * 字符串转日期，自动适配字符串格式
     *
     * @param dateStr 日期字符串
     * @return
     * @throws ParseException
     */
    public static Date parse(String dateStr) throws ParseException {
        String format = getFormat(dateStr);
        return parse(dateStr, format);
    }

    /**
     * 增加日期中某类型的某数值。如增加日期
     *
     * @param date     日期
     * @param dateType 类型
     * @param amount   数值
     * @return 计算后日期
     */
    private static Date addInteger(Date date, int dateType, int amount) {
        Date myDate = null;
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(dateType, amount);
            myDate = calendar.getTime();
        }
        return myDate;
    }

    /**
     * 增加日期的小时。失败返回null。
     *
     * @param date         日期
     * @param minuteAmount 增加数量
     * @return 增加小时后的日期
     */
    public static Date addMinute(Date date, int minuteAmount) {
        return addInteger(date, Calendar.MINUTE, minuteAmount);
    }

    /**
     * 增加日期的小时。失败返回null。
     *
     * @param date       日期
     * @param hourAmount 增加数量
     * @return 增加小时后的日期
     */
    public static Date addHour(Date date, int hourAmount) {
        return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);
    }

    /**
     * 增加日期。失败返回null。
     *
     * @param date     日期
     * @param paramInt 增加数量
     * @return 增加日期后的日期
     */
    public static Date addDays(Date date, int paramInt) {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime(date);
        int i = localCalendar.get(Calendar.DAY_OF_YEAR);
        localCalendar.set(Calendar.DAY_OF_YEAR, i + paramInt);
        return localCalendar.getTime();
    }

    /**
     * 从当前日期减少指定天数并返回计算后得到的日期
     *
     * @param paramInt 减少的天数
     * @return 减少天数后的日期
     */
    public static Date subDaysFromNow(int paramInt) {
        Calendar localCalendar = Calendar.getInstance();
        int i = localCalendar.get(Calendar.DAY_OF_YEAR);
        localCalendar.set(Calendar.DAY_OF_YEAR, i - paramInt);
        return localCalendar.getTime();
    }

    /**
     * 计算两个日期之间间隔的天数
     *
     * @param date1 日期1
     * @param date2 日期2
     * @return 间隔的天数
     */
    public static Integer calcDaysBetweenDates(Date date1, Date date2) {
        return (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
    }

    /**
     * 计算输入值是否为周末
     *
     * @return 周末返回true，工作日返回false
     */
    public static boolean isWeekend(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 计算输入值是不是上午
     *
     * @return 上午返回true，下午返回false
     */
    public static boolean isAM(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int r = cal.get(Calendar.AM_PM);
        return r == Calendar.AM;
    }

    /**
     * 获取当前小时（24小时制）
     */
    public static int getHour(Date date) {
        int hour = Integer.parseInt(DateUtil.dateToStr(date, "HH"));
        return hour;
    }

    /**
     * 获取精确到秒的时间戳（单位是秒）
     *
     * @param date
     * @return
     */
    public static int getSecondTimestamp(Date date) {
        if (null == date) {
            return 0;
        }
        String timestamp = String.valueOf(date.getTime() / 1000);
        return Integer.valueOf(timestamp);
    }

    /**
     * 比较两个时间是否相等（精确到秒，秒以后的时间被忽略，不参与比较）
     */
    public static boolean isEquals(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return date1 == null && date2 == null;
        }

        int date1Timestamp = getSecondTimestamp(date1);
        int date2Timestamp = getSecondTimestamp(date2);
        return date1Timestamp == date2Timestamp;
    }

    /**
     * 获得指定日期的指定时间点
     *
     * @param date        指定的日期
     * @param hourOfDay   指定的小时
     * @param minute      指定的分钟
     * @param second      指定的秒
     * @param millisecond 指定的微妙
     */
    public static Date getPointOfTime(Date date, int hourOfDay, int minute, int second, int millisecond) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, millisecond);

        return calendar.getTime();
    }

    /**
     * 获得指定日期的零点时间
     */
    public static Date getZeroTimeOfDate(Date date) {
        return getPointOfTime(date, 0, 0, 0, 0);
    }

    /**
     * 获得指定日期的00点00分00秒的时间对象
     */
    public static Date getBeginTimeOfDate(Date date) {
        return getPointOfTime(date, 00, 00, 00, 000);
    }

    /**
     * 获得指定日期的23点59分59秒时间
     */
    public static Date getEndTimeOfDate(Date date) {
        return getPointOfTime(date, 23, 59, 59, 999);
    }

    /**
     * 获得指定日期指定时间的日期对象
     */
    public static Date getGivenTime(String yyyyMMddHHmmss) throws ParseException {
        return new SimpleDateFormat(DATE_MODEL_2).parse(yyyyMMddHHmmss);
    }

    /**
     * 获得指定年月的最后一天，需要注意的是：月份是从0开始的，
     * 比如说如果输入5的话，实际上显示的是4月份的最后一天，千万不要搞错了哦
     *
     * @param year  年份
     * @param month 月份
     * @return int 某年某月的最后一天
     */
    public static int getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        // 某年某月的最后一天
        return cal.getActualMaximum(Calendar.DATE);
    }

    /**
     * 功能描述：返回月
     *
     * @param date Date 日期
     * @return 返回月份
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 功能描述：返回日期
     *
     * @param date Date 日期
     * @return 返回日份
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 功能描述：返回分
     *
     * @param date 日期
     * @return 返回分钟
     */
    public static int getMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 返回秒钟
     *
     * @param date Date 日期
     * @return 返回秒钟
     */
    public static int getSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 功能描述：返回毫
     *
     * @param date 日期
     * @return 返回毫
     */
    public static long getMillis(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    /**
     * 或得两个日期之前的小时数
     * @param endDate
     * @param nowDate
     * @return
     */
    public static Long getDateHours(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day* 24 + hour;
    }

}
