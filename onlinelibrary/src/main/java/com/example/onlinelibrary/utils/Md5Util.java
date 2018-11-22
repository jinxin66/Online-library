package com.example.onlinelibrary.utils;

import java.security.MessageDigest;

/**
 * Class description
 *
 * @version        1.0.0, 16/03/31
 */
public class Md5Util {

    /**
     *
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer md5str = new StringBuffer();

        //
        int digital;

        for (int i = 0; i < bytes.length; i++) {
            digital = bytes[i];

            if (digital < 0) {
                digital += 256;
            }

            if (digital < 16) {
                md5str.append("0");
            }

            md5str.append(Integer.toHexString(digital));
        }

        return md5str.toString().toUpperCase();
    }

    /**
     * md5
     * @param message
     * @return
     */
    public static String getMD5(String message) {
        String md5str = "";

        try {

            // 1
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 2
            byte[] input = message.getBytes();

            // 3
            byte[] buff = md.digest(input);

            // 4
            md5str = bytesToHex(buff);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return md5str;
    }

    //测试
    public static void main(String[] args) {
        System.out.println("==========>>>>>>");
        System.out.println(getMD5("superadmin123"));
        System.out.println("==========>>>>>>");
    }
}
