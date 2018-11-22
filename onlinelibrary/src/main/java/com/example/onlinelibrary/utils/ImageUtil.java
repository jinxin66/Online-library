package com.example.onlinelibrary.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ImageUtil {

    private Logger log = LoggerFactory.getLogger(getClass());

    private static String DEFAULT_PREVFIX = "avatar_";
    private static Boolean DEFAULT_FORCE = false;//建议该值为false

    /**
     * <p>Title: thumbnailImage</p>
     * <p>Description: 依据图片路径生成缩略图 </p>
     * @param imagePath    原图片路径
     * @param w            缩略图宽
     * @param h            缩略图高
     * @param prevfix    生成缩略图的前缀
     * @param force        是否强制依照宽高生成缩略图(假设为false，则生成最佳比例缩略图)
     */
    public static void thumbnailImage(String imagePath, int w, int h, String prevfix, boolean force){
        File imgFile = new File(imagePath);
        if(imgFile.exists()){
            try {
                // ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
                String types = Arrays.toString(ImageIO.getReaderFormatNames());
                String suffix = null;
                // 获取图片后缀
                if(imgFile.getName().indexOf(".") > -1) {
                    suffix = imgFile.getName().substring(imgFile.getName().lastIndexOf(".") + 1);
                }// 类型和图片后缀所有小写，然后推断后缀是否合法
                if(suffix == null || types.toLowerCase().indexOf(suffix.toLowerCase()) < 0){
                    //log.error("Sorry, the image suffix is illegal. the standard image suffix is {}." + types);
                    return ;
                }
                //log.debug("target image's size, width:{}, height:{}.",w,h);
                Image img = ImageIO.read(imgFile);
                if(!force){
                    // 依据原图与要求的缩略图比例，找到最合适的缩略图比例
                    int width = img.getWidth(null);
                    int height = img.getHeight(null);
                    if((width*1.0)/w < (height*1.0)/h){
                        if(width > w){
                            h = Integer.parseInt(new java.text.DecimalFormat("0").format(height * w/(width*1.0)));
                            //log.debug("change image's height, width:{}, height:{}.",w,h);
                        }
                    } else {
                        if(height > h){
                            w = Integer.parseInt(new java.text.DecimalFormat("0").format(width * h/(height*1.0)));
                            //log.debug("change image's width, width:{}, height:{}.",w,h);
                        }
                    }
                }
                BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                Graphics g = bi.getGraphics();
                g.drawImage(img, 0, 0, w, h, Color.LIGHT_GRAY, null);
                g.dispose();
                String p = imgFile.getPath();
                // 将图片保存在原文件夹并加上前缀
                ImageIO.write(bi, suffix, new File(p.substring(0,p.lastIndexOf(File.separator)) + File.separator + prevfix +imgFile.getName()));
                System.out.println("success !");
            } catch (IOException e) {
                //log.error("generate thumbnail image failed.",e);
                e.printStackTrace();
            }
        }else{
            //log.warn("the image is not exist.");
            System.out.println("imgFile.exists()");
        }
    }

    //测试
    public static void main(String[] args) {
        String path = "/Users/wangxinfeng/Documents/tomcat8/filebase/wms/";
        File file = new File(path);
        if (file.isDirectory()) {
            String[] filelist = file.list();
            for (int i = 0; i < filelist.length; i++) {
                File file2 = new File(path + "/" + filelist[i]);
                if(file2.isDirectory()) {
                    String[] filelist2 = file2.list();
                    for (int k = 0; k < filelist2.length; k++) {
                        thumbnailImage(path + "/" + filelist[i]+"/"+filelist2[k], 300, 300,DEFAULT_PREVFIX,DEFAULT_FORCE);
                    }
                }
            }
        }
        thumbnailImage("C:/Users/cm/Desktop/我的页面/images/girlNoImg.jpg", 100, 150,DEFAULT_PREVFIX,DEFAULT_FORCE);
    }
}