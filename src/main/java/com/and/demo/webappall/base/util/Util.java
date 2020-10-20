package com.and.demo.webappall.base.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public static boolean isMissing(String str) {
        return str == null || str.length() == 0;
    }

    public static Date strToDate(String str) {
        if ( isMissing(str) ) return null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(str);
        } catch ( Exception ex) {
            return null;
        }
    }
}
