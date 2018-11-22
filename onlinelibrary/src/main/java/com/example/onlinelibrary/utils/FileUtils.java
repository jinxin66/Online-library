package com.example.onlinelibrary.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * Class description
 *
 * @version 1.0.0, 16/03/31
 */
public class FileUtils {

    //private final static String FILEBASE_ROOT = "E:/filebase/";

    public static String getPath(String rootPath) {
        String id = IDGenerator.generator();
        StringBuffer sb = new StringBuffer();
        sb.append(rootPath).append(id.substring(0, 5)).append("/").append(id.substring(6, 12)).append("/");
        return sb.toString();
    }

    /**
     * Method description copyFileToTempDirectory
     *
     * @param path
     * @param tempPath
     * @return String
     */
    public static String copyFileToTempDirectory(String path, String tempPath) {
        String nonsuffix = path.substring(0, path.lastIndexOf("."));

        System.out.println("*****************testfile***************");
        System.out.println(nonsuffix);

        String filename = nonsuffix.substring(nonsuffix.lastIndexOf("/") + 1);

        System.out.println(filename);

        File srcFile = new File(nonsuffix + ".gif");

        if (srcFile.exists()) {
            String imagepath = tempPath + filename + ".gif";

            System.out.println(imagepath);

            try {
                org.apache.commons.io.FileUtils.copyFile(srcFile, new File(imagepath));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return filename + ".gif";
        }

        System.out.println("*****************endfile***************");

        return "";
    }

    /**
     * Method description write
     *
     * @param inputStream
     * @param tempPath
     * @return String
     */
    public static String write(InputStream inputStream, String tempPath) {
        OutputStream os = null;

        try {
            //删除原文件
            File orginalFile = new File(tempPath);
            if(orginalFile.exists()){
                orginalFile.delete();
            }

            //保存文件=====
            File file = new File(tempPath);
            os = new FileOutputStream(file);
            int bytesRead0 = 0;
            byte[] buffer0 = new byte[8192];
            while ((bytesRead0 = inputStream.read(buffer0, 0, 8192)) != -1) {
                os.write(buffer0, 0, bytesRead0);
            }
            os.close();
            inputStream.close();
            //保存完成=====

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return tempPath;
    }

    public static void saveTxt(String txt, String path) throws IOException {
        InputStream inputStream = new ByteArrayInputStream(txt.getBytes("UTF-8"));
        saveFile(inputStream, path);
    }

    public static void saveFile(InputStream inputStream, String path) throws IOException {
        File file = new File(path);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedInputStream dd = new BufferedInputStream(inputStream);
        int length = 0;
        byte[] b = new byte[1024];
        while ((length = dd.read(b)) != -1) {
            fileOutputStream.write(b, 0, length);
        }
        inputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();
        dd.close();
    }

    public static String readTxt(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(new String(line.getBytes(), "utf-8") + "\n");
            }
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static String readImg(InputStream inputStream) throws IOException {
        byte[] data = new byte[inputStream.available()];
        inputStream.read(data);
        inputStream.close();

        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }

    //base64字符串转化成图片
    public static boolean GenerateImage(String imgStr) {   //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {//调整异常数据
                    b[i] += 256;
                }
            }
            //生成jpeg图片
            String imgFilePath = "d://222.jpg";//新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //判断存在并删除
    public static boolean delete(String tempPath) {
        try {

            File tempFile = new File(tempPath);
            if(tempFile.exists()){
                return tempFile.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
