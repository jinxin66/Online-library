package com.example.onlinelibrary.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class description
 *
 * @version 1.0.0, 18/05/8
 */
public class TimeUtils {

    public static String timeStampToFormat(long seconds,String format) {
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(seconds));
    }
}
