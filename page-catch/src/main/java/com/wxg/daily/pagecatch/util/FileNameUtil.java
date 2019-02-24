package com.wxg.daily.pagecatch.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FileNameUtil {

    private static SimpleDateFormat sdf_1 = new SimpleDateFormat("yyyyMMdd_HHmmss.SSS");

    public static String now() {
        Date date = new Date();
        String format = sdf_1.format(date);
        return format;
    }
}
