package com.asomepig.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by eric on 15-5-15.
 */
public class StringUtil {
    /**
     * 如果为null 或者 ""返回false 否则返回true
     *
     * @param obj
     * @return
     */
    public static boolean isNotNull(Object obj) {
        if (obj != null && !obj.toString().trim().equals(""))
            return true;
        return false;
    }

    /**
     * 将日期格式的object转换为String
     *
     * @param obj
     * @return
     */
    public static String dateObjToStr(Object obj) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (isNotNull(obj))
            return sdf.format((Date) obj);
        else
            return "";
    }

    /**
     * 将的object String转换为日期格式
     *
     * @param obj
     * @return
     */
    public static Date strToDate(Object obj) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            return sdf.parse(obj.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将Thu Feb 12 00:00:00 UTC+0800 2015 转换为日期格式
     *
     * @param str
     * @return
     * @throws ParseException
     */
    public static Date strToDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat(
                "EEE MMM dd HH:mm:ss 'UTC'Z yyyy", Locale.ENGLISH);
        if (isNotNull(str)) {
            try {
                return sdf.parse(str);
            } catch (Exception e) {
            }
            return null;
        } else
            return null;
    }

    /**
     * 将object类型装换为字符串，如果为空就返回""
     *
     * @param obj
     * @return
     */
    public static String toStr(Object obj) {
        if (obj != null)
            return obj.toString();
        return "";
    }

    /**
     * 将object类型转换为Long类型，如果失败返回-1l
     *
     * @param obj
     * @return
     */
    public static Long toLong(Object obj) {
        if (obj != null && isNotNull(obj.toString()))
            return Long.parseLong(obj.toString());
        return -1l;
    }
    /**
     * 将object类型转换为Integer类型，如果失败返回-1
     *
     * @param obj
     * @return
     */
    public static Integer toInteger(Object obj) {
        if (obj != null && isNotNull(obj.toString()))
            return Integer.valueOf(obj.toString());
        return -1;
    }

    /**
     * @Description: 数据库存的时间类型的数据时类似"20140401235959999+0800"的22位字符，显示的时候要转换成
     *               "2014-04-01 00:00:00" 样式
     * @param s
     * @return
     */
    public static String dateForStr(Object s) {
        if (s != null && !s.equals("")) {
            String reg = s.toString();
            String returnvalue = reg.substring(0, 4) + "-"
                    + reg.substring(4, 6) + "-" + reg.substring(6, 8) + " "
                    + reg.substring(8, 10) + ":" + reg.substring(10, 12) + ":"
                    + reg.substring(12, 14);
            if (reg.substring(8, 10).equals("00")
                    && reg.substring(10, 12).equals("00")
                    && reg.substring(12, 14).equals("00"))
                return returnvalue.substring(0, 10);
            return returnvalue;
        } else {
            return "";
        }
    }

    /**
     * 数据库存的时间类型的数据时类似"20140401235959999+0800"的22位字符，显示的时候要转换成
     *               "2014-04-01" 日期样式
     * @param s
     * @return
     */
    public static String datetimeForStr(Object s){
        if (s != null && !s.equals("")) {
            String reg = s.toString();
            String returnvalue = reg.substring(0, 4) + "-"
                    + reg.substring(4, 6) + "-" + reg.substring(6, 8);
            return returnvalue;
        } else {
            return "";
        }
    }

    /**
     * @Description:
     *  查询的时候有按日期查询的，后台得到的时间格式为"2014-04-01",查询的时候转换成"20140401000000000+0800"
     * @return
     */
    public static String transfor(Object obj) {
        if (obj == null)
            return "";
        String s = obj.toString();
        if (s != null && !s.equals("")) {
            String reg = s;

            String[] arrreg = reg.split("-");
            if (arrreg[1].length() == 1) {
                arrreg[1] = "0" + arrreg[1];
            }
            if (arrreg[2].length() == 1) {
                arrreg[2] = "0" + arrreg[2];
            }
            String returnvalue = arrreg[0] + arrreg[1] + arrreg[2]
                    + "000000000+0800";
            return returnvalue;
        } else {
            return "";
        }
    }

    /**
     * JSON字符串特殊字符处理
     *
     * @return String
     */
    public static String stringJson(Object obj) {
        if (obj == null)
            return "";
        String s = obj.toString();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '\"':
                    sb.append("\\\"");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                case '/':
                    sb.append("\\/");
                    break;
                case '\b':
                    sb.append("\\b");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * js过滤
     *
     * @param s
     * @return String
     */
    public static String stringFilter(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '\"':
                    sb.append("&quot;");
                    break;
                case '\'':
                    sb.append("&#39;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                case '<':
                    sb.append("&lt;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * js反过滤
     *
     * @param s
     * @return String
     */
    public static String stringReverseFilter(String s) {
        if (s == null || s.equals(""))
            return "";
        return s.replace("&quot;", "\"").replace("&#39;", "\'")
                .replace("&gt;", ">").replace("&lt;", "<")
                .replace("&amp;", "&");
    }

    public static long NewDate_OldDate(Date newDate, Date oldDate) {
        Calendar cNewDate = Calendar.getInstance(), cOldDate = Calendar
                .getInstance();
        cNewDate.setTime(newDate);// 设置
        cOldDate.setTime(oldDate);// 设置
        long timeNew = cNewDate.getTimeInMillis();
        long timeOld = cOldDate.getTimeInMillis();
        long cha = (timeNew - timeOld) / (1000 * 60 * 60 * 24);// 化为天
        // System.out.println("相隔"+相隔天数+"天");
        return cha;
    }

    /**
     * 生成字符串对应的MD5
     * @param original 需要生成的字符串
     * @param len 生成md5 的长度,默认32 ,可取(16/32)
     * @param ifUpperCase 生成md5的是否大写
     * @return 生成的md5
     * @throws NoSuchAlgorithmException
     */
    public static String GenerateMD5(String original,int len,int ifUpperCase) throws NoSuchAlgorithmException {
        if (!isNotNull(original))return "";
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(original.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        String res = sb.toString();
        if(len==16) res = res.substring(8,24);
        if (ifUpperCase==1) res = res.toUpperCase();
        return res;
    }
}
