package com.and.demo.webappall.base.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil{
    //獲取當前日期時間"yyyy-MM-dd HH:mm:ss"
    public static String getNowDateTimeString() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    //獲取當前日期"yyyy-MM-dd"
    public static String getNowDateString() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    // 獲取當前時間 "yyyy-MM-dd"字串
    public static String getDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//
        return dateFormat.format(date);
    }

    // 獲取當前時間 "yyyy-MM-dd HH:mm:ss"字串
    public static String getNowDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//
        return dateFormat.format(date);
    }

    //當前日期date加減天數
    public static Date addDay(Date date, int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, num);
        return calendar.getTime();
    }

    //得到兩個日期之間的天數
    public static Long getIntervelDays(Date dateBegin ,Date dateEnd) {
        if(dateBegin.compareTo(dateEnd) == 1)
            return (dateBegin.getTime() - dateEnd.getTime()) / (3600 * 24 * 1000);
        else
            return (dateEnd.getTime() - dateBegin.getTime()) / (3600 * 24 * 1000);
    }
/*
    //Calendar 取得當前時間的方法
    public static void main(String[] args) {
        // 字串轉換日期格式
        // DateFormat fmtDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 接收傳入引數
        // String strDate = args[1];
        // 得到日期格式物件
        // Date date = fmtDateTime.parse(strDate);

        // 完整顯示今天日期時間
        String str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(new Date());
        System.out.println(str);

        // 建立 Calendar 物件
        Calendar calendar = Calendar.getInstance();

        try
        {
            // 對 calendar 設定時間的方法
            // 設定傳入的時間格式
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d H:m:s");
            // 指定一個日期
            Date date = dateFormat.parse("2013-6-1 13:24:16");
            // 對 calendar 設定為 date 所定的日期
            calendar.setTime(date);

            // 按特定格式顯示剛設定的時間
            str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(calendar.getTime());
            System.out.println(str);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        // 或者另一種設定 calendar 方式
        // 分別為 year, month, date, hourOfDay, minute, second
        calendar = Calendar.getInstance();
        calendar.set(2013, 1, 2, 17, 35, 44);
        str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(calendar.getTime());
        System.out.println(str);

        // Calendar 取得當前時間的方法
        // 初始化 (重置) Calendar 物件
        calendar = Calendar.getInstance();
        // 或者用 Date 來初始化 Calendar 物件
        calendar.setTime(new Date());

        // setTime 類似上面一行
        // Date date = new Date();
        // calendar.setTime(date);

        str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(calendar.getTime());
        System.out.println(str);

        // 顯示年份
        int year = calendar.get(Calendar.YEAR);
        System.out.println("year is = " + String.valueOf(year));

        // 顯示月份 (從0開始, 實際顯示要加一)
        int month = calendar.get(Calendar.MONTH);
        System.out.println("nth is = " + (month + 1));

        // 本週幾
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println("week is = " + week);

        // 今年的第 N 天
        int DAY_OF_YEAR = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println("DAY_OF_YEAR is = " + DAY_OF_YEAR);

        // 本月第 N 天
        int DAY_OF_MONTH = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("DAY_OF_MONTH = " + String.valueOf(DAY_OF_MONTH));

        // 3小時以後
        calendar.add(Calendar.HOUR_OF_DAY, 3);
        int HOUR_OF_DAY = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println("HOUR_OF_DAY + 3 = " + HOUR_OF_DAY);

        // 當前分鐘數
        int MINUTE = calendar.get(Calendar.MINUTE);
        System.out.println("MINUTE = " + MINUTE);

        // 15 分鐘以後
        calendar.add(Calendar.MINUTE, 15);
        MINUTE = calendar.get(Calendar.MINUTE);
        System.out.println("MINUTE + 15 = " + MINUTE);

        // 30分鐘前
        calendar.add(Calendar.MINUTE, -30);
        MINUTE = calendar.get(Calendar.MINUTE);
        System.out.println("MINUTE - 30 = " + MINUTE);

        // 格式化顯示
        str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendar.getTime());
        System.out.println(str);

        // 重置 Calendar 顯示當前時間
        calendar.setTime(new Date());
        str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendar.getTime());
        System.out.println(str);

        // 建立一個 Calendar 用於比較時間
        Calendar calendarNew = Calendar.getInstance();

        // 設定為 5 小時以前，後者大，顯示 -1
        calendarNew.add(Calendar.HOUR, -5);
        System.out.println("時間比較：" + calendarNew.compareTo(calendar));

        // 設定7小時以後，前者大，顯示 1
        calendarNew.add(Calendar.HOUR, +7);
        System.out.println("時間比較：" + calendarNew.compareTo(calendar));

        // 退回 2 小時，時間相同，顯示 0
        calendarNew.add(Calendar.HOUR, -2);
        System.out.println("時間比較：" + calendarNew.compareTo(calendar));
    }
*/
}