package com.cqjtu.cms.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * DateUtils Utility for date.
 *
 * @author johnniang
 * @since 11/26/18
 */
@Slf4j
public class DateUtils {

  private static final int AUTUMN_MONTH = 9;

  public static final String DEFAULT_PATTERN = "yyyy-MM-dd";
  public static final String DEFAULT_YEAR_MONTH = "yyyy-MM";
  public static final String DEFAULT_SIMPLE_PATTERN = "yyyy-MM-dd HH:mm";
  public static final String DEFAULT_FULL_PATTERN = "yyyy-MM-dd HH:mm:ss";

  private DateUtils() {}

  /**
   * Get current time.
   *
   * @return current time
   */
  public static Date now() {
    return new Date();
  }

  /** 获取当前日期 格式类似：2018-08-01 00:00:00 */
  public static Date getStartTime(Date date) {
    Calendar todayStart = Calendar.getInstance();
    todayStart.setTime(date);
    todayStart.set(Calendar.HOUR_OF_DAY, 0);
    todayStart.set(Calendar.MINUTE, 0);
    todayStart.set(Calendar.SECOND, 0);
    todayStart.set(Calendar.MILLISECOND, 0);
    return todayStart.getTime();
  }

  public static Date getSpecifyTime(Date date, int hour, int minute, int second) {
    Calendar todayStart = Calendar.getInstance();
    todayStart.setTime(date);
    todayStart.set(Calendar.HOUR_OF_DAY, hour);
    todayStart.set(Calendar.MINUTE, minute);
    todayStart.set(Calendar.SECOND, second);
    todayStart.set(Calendar.MILLISECOND, 0);
    return todayStart.getTime();
  }

  /** 获取给定日期的月份 */
  public static int getMonthOfDate(Date date) {
    Assert.notNull(date, "date must not be null");

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar.get(Calendar.MONTH);
  }

  /**
   * Check specified month if it is in autumn month.
   *
   * @param month specified month, start with 1
   * @return true if the specified month is a autumn month, false otherwise
   */
  private static boolean isAutumnMonth(int month) {
    return month >= (AUTUMN_MONTH - 1) && month <= (AUTUMN_MONTH + 1);
  }

  public static String formatDate(Date date) {
    return formatDate(date, DEFAULT_PATTERN);
  }

  /** 格式化日期 */
  public static String formatDate(Date date, String pattern) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    String result = simpleDateFormat.format(date);
    return result;
  }

  public static Date parse(String dateStr) {
    return parse(dateStr, DEFAULT_PATTERN);
  }
  /** 日期格式字符串转换为日期对象 */
  public static Date parse(String dateStr, String pattern) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    Date date = null;
    try {
      date = simpleDateFormat.parse(dateStr);
    } catch (ParseException e) {
      log.warn("日期格式字符串解析错误", e);
    }
    return date;
  }

  public static String nowTerm() {
    LocalDate date = LocalDate.now();
    int year1 = date.getYear();
    int month = date.getMonthValue();
    int term;
    int year2;
    if (month >= 9) {
      year2 = year1 + 1;
      term = 1;
      return year1 + "-" + year2 + "-" + term;
    } else if (month <= 2) {
      year2 = year1 - 1;
      term = 1;
      return year2 + "-" + year1 + "-" + term;

    } else {
      year2 = year1 - 1;
      term = 2;
      return year2 + "-" + year1 + "-" + term;
    }
  }
}
