package com.example.onlinelibrary.utils;

/**
 * Class description
 *
 * @version 1.0.0, 18/05/8
 */
public class StringUtils {

    public static boolean isEmpty(String str){
        return str == null || str.equals("");
    }

    //num 被补0的数 补完后的长度 len
    public static String lpad(int num,int len){
        String str = String.valueOf(num);
        int length = len-str.length();
        for(int i=0;i<length;i++){
            str = 0+str;
        }
        return str;
    }

}
