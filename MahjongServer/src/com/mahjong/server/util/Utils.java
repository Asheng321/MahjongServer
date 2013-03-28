package com.mahjong.server.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * 
 * @author Simple
 * @date 2013-3-5 上午11:00:30
 * @Description 工具类
 */
public class Utils {

  /**
   * 获取当前操作系统类型
   * 
   * @return 未知(-1) windows(0) linux(1)
   */
  public static int getCurrentSystem() {
    int sys=-1;
    String os=System.getProperty("os.name");
    os=os.toLowerCase();
    os=os.trim();
    if(os.indexOf("windows") != -1) {
      sys=0;
    } else {
      sys=1;
    }
    return sys;
  }

  /**
   * 获取单个文件md5
   * 
   * @param file
   * @return 字符串md5
   */
  public static String getFileMD5(File file) {
    if(!file.isFile()) {
      return null;
    }
    MessageDigest digest=null;
    FileInputStream in=null;
    byte buffer[]=new byte[1024];
    int len;
    try {
      digest=MessageDigest.getInstance("MD5");
      in=new FileInputStream(file);
      while((len=in.read(buffer, 0, 1024)) != -1) {
        digest.update(buffer, 0, len);
      }
      in.close();
    } catch(Exception e) {
      e.printStackTrace();
      return null;
    }
    BigInteger bigInt=new BigInteger(1, digest.digest());
    return bigInt.toString(16);
  }

  /**
   * yyyy-MM-dd HH:mm:ss
   */
  public static String dateToStr(Date date) {
    if(date != null) {
      DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      return df.format(date);
    }
    return "";
  }

  /**
   * yyyy-MM-dd
   */
  public static String dateToStr2(Date date) {
    if(date != null) {
      DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
      return df.format(date);
    }
    return "";
  }

  /**
   * 获取�?��日期字符串中当前的天序号
   * 
   * @param t
   *        字符串，格式为：yyyy-MM-dd HH:mm:ss
   * @return 解析后日期天，失败返�?0
   */
  public static int getDayFromString(String t) {
    if(!isNotNull(t)) {
      return 0;
    }
    int day=0;
    DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      Date date=df.parse(t);
      Calendar c=Calendar.getInstance();
      c.setTime(date);
      day=c.get(Calendar.DAY_OF_MONTH);
    } catch(ParseException e) {
      e.printStackTrace();
    }
    return day;
  }

  /**
   * 获取当前系统时间
   * 
   * @return yyyy-MM-dd HH:mm:ss
   */
  public static String getCurrentTime() {
    DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return df.format(new Date());
  }

  /**
   * 获取系统当前日期
   * 
   * @return yyyy-MM-dd
   */
  public static String getCurrentDate() {
    DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
    return df.format(new Date());
  }

  /**
   * 获取当前系统年份
   */
  public static String getCurrentSystemYear() {
    DateFormat df=new SimpleDateFormat("yyyy-01-01 00:00:00");
    return df.format(new Date());
  }

  /**
   * 获取系统当前月份
   */
  public static String getCurrentMonth() {
    DateFormat df=new SimpleDateFormat("yyyy-MM-01 00:00:00");
    return df.format(new Date());
  }

  /**
   * 获取本周�?���?
   */
  public static String getMonday() {
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd 00:00:00", Locale.CHINA);
    Calendar calendar=Calendar.getInstance(Locale.CHINA);
    calendar.setFirstDayOfWeek(Calendar.MONDAY); // 以周1为首�?
    calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    return simpleDateFormat.format(calendar.getTime());
  }

  /**
   * 获取零时刻时间日�?
   */
  public static String getToDay() {
    DateFormat df=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
    return df.format(new Date());
  }

  /**
   * string 2 data
   * 
   * @param str
   * @return yyyy-MM-dd HH:mm:ss
   */
  public static Date strToDate(String str) {
    if(str != null && "".equals(str)) {
      DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      try {
        return df.parse(str);
      } catch(ParseException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  /**
   * string 2 data
   * 
   * @param str
   * @return yyyy-MM-dd
   */
  public static Date strToDate2(String str) {
    if(str != null && !"".equals(str)) {
      DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
      try {
        return df.parse(str);
      } catch(ParseException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  public static boolean isNotNull(Integer i) {
    boolean flag=false;
    if(null == i) {
      flag=false;
    } else {
      flag=true;
    }
    return flag;
  }

  public static boolean isNotNull(String str) {
    boolean flag=false;
    if(str == null || "".equals(str)) {
      flag=false;
    } else {
      flag=true;
    }
    return flag;
  }

  public static boolean isNull(Integer i) {
    boolean flag=false;
    if(null != i) {
      flag=false;
    } else {
      flag=true;
    }
    return flag;
  }

  /**
   * 判断字符串是不是为空
   * 
   * @param str
   * @return
   */
  public static boolean isNull(String str) {
    boolean flag=false;
    if(str == null || "".equals(str)) {
      flag=true;
    } else {
      flag=false;
    }
    return flag;
  }

  public static boolean isNotNull(String[] str) {
    boolean flag=false;
    if(str == null) {
      return false;
    }
    for(int i=0; i < str.length; i++) {
      if(isNotNull(str[i].trim())) {
        flag=true;
        break;
      }
    }
    return flag;
  }

  public static boolean isNull(String[] str) {
    boolean flag=true;
    if(str == null) {
      return true;
    }
    for(int i=0; i < str.length; i++) {
      if(isNotNull(str[i].trim())) {
        flag=false;
        break;
      }
    }
    return flag;
  }

  public static String isNullToString(String str) {
    return isNull(str) ? "" : str;
  }

  public String getWebRoot() throws IllegalAccessException {
    String path=getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
    if(path.indexOf("WEB-INF") > 0) {
      path=path.substring(0, path.indexOf("WEB-INF/classes"));
    } else {
      throw new IllegalAccessException("get root failed!");
    }
    return path;
  }

  /**
   * 获取计算机名
   * 
   * @return
   */
  public static String getComputerName() {
    Map<String, String> map=System.getenv();
    String computerName=map.get("COMPUTERNAME");// 获取计算机名
    return computerName;
  }

  /**
   * 获取MAC地址
   * 
   * @return
   */
  public static String getMacAddress() {
    String mac="";
    String line="";
    String os=System.getProperty("os.name");
    if(os != null && os.startsWith("Windows")) {
      try {
        String command="cmd.exe /c ipconfig /all";
        Process p=Runtime.getRuntime().exec(command);
        BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
        while((line=br.readLine()) != null) {
          if(line.indexOf("Physical Address") > 0) {
            int index=line.indexOf(":") + 2;
            mac=line.substring(index);
            break;
          }
        }
        br.close();
      } catch(IOException e) {
      }
    }
    return mac;
  }

  public static double getRound(double val, int pre) {
    BigDecimal bd1=new BigDecimal(val);
    bd1=bd1.setScale(pre, BigDecimal.ROUND_HALF_UP);
    return val;
  }
}
