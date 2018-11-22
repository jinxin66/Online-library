package com.example.onlinelibrary.utils;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

    /**
     * 完成的结果文件--输出的压缩文件
     */
    //File targetFile;

    public ZipUtil() {
    }

    /*public ZipUtil(File target) {
        targetFile = target;
        if (targetFile.exists())
            targetFile.delete();
    }*/

    /**
     * 压缩文件
     *
     * @param targetPath,resultFile
     */
    public void zipFiles(String targetPath,File resultFile) {
        File targetFile = new File(targetPath);
        ZipOutputStream out = null;
        try {
            out = new ZipOutputStream(new FileOutputStream(targetFile));

            if (resultFile.isFile()) {
                zipFile(resultFile, out, "");
            } else {
                File[] list = resultFile.listFiles();
                for (int i = 0; i < list.length; i++) {
                    compress(list[i], out, "");
                }
            }

            //index.out.println("压缩完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 压缩文件夹里的文件
     * 起初不知道是文件还是文件夹--- 统一调用该方法
     *
     * @param file
     * @param out
     * @param basedir
     */
    private void compress(File file, ZipOutputStream out, String basedir) {
        /* 判断是目录还是文件 */
        if (file.isDirectory()) {
            this.zipDirectory(file, out, basedir);
        } else {
            this.zipFile(file, out, basedir);
        }
    }

    /**
     * 压缩单个文件
     *
     * @param srcfile
     */
    public void zipFile(File srcfile, ZipOutputStream out, String basedir) {
        if (!srcfile.exists())
            return;
        if (srcfile.getName().startsWith("."))
            return;

        byte[] buf = new byte[1024];
        FileInputStream in = null;

        try {
            int len;
            in = new FileInputStream(srcfile);
            out.putNextEntry(new ZipEntry(basedir + srcfile.getName()));

            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.closeEntry();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 压缩文件夹
     *
     * @param dir
     * @param out
     * @param basedir
     */
    public void zipDirectory(File dir, ZipOutputStream out, String basedir) {
        if (!dir.exists())
            return;

        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            /* 递归 */
            compress(files[i], out, basedir + dir.getName() + "/");
        }
    }

    /**
     * 功能:解压缩
     *
     * @param zipfile：需要解压缩的文件
     * @param descDir：解压后的目标目录
     */
    public static void unZipFiles(File zipfile, String descDir) {
        try {
            ZipFile zf = new ZipFile(zipfile);
            for (Enumeration entries = zf.entries(); entries.hasMoreElements(); ) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                String zipEntryName = entry.getName();
                InputStream in = zf.getInputStream(entry);
                OutputStream out = new FileOutputStream(descDir + zipEntryName);
                byte[] buf1 = new byte[1024];
                int len;
                while ((len = in.read(buf1)) > 0) {
                    out.write(buf1, 0, len);
                }
                in.close();
                out.close();
                //index.out.println("解压缩完成.");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 功能测试
     */
    public static void main(String[] args) {
        //2个源文件
        File f1 = new File("D:\\workspace\\flexTest\\src\\com\\biao\\test\\abc.txt");
        File f2 = new File("D:\\workspace\\flexTest\\src\\com\\biao\\test\\test.zip");
        File[] srcfile = {f1, f2};
        //压缩后的文件
        File zipfile = new File("D:\\workspace\\flexTest\\src\\com\\biao\\test\\biao.zip");
        //TestZIP.zipFiles(srcfile, zipfile);
        //需要解压缩的文件
        File file = new File("D:\\workspace\\flexTest\\src\\com\\biao\\test\\biao.zip");
        //解压后的目标目录
        String dir = "D:\\workspace\\flexTest\\src\\com\\biao\\test\\";
        ZipUtil.unZipFiles(file, dir);

        File f = new File("E:/Study/Java");
        new ZipUtil().zipFiles("",new File(""));
    }
}