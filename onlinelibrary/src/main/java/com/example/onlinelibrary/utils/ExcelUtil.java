package com.example.onlinelibrary.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExcelUtil {
    private static HSSFFont font;
    private static HSSFCellStyle style;
    private static HSSFCellStyle warning_style;
    private static HSSFCellStyle titleStyle;
    private static HSSFFont warning_font;

    /*
    * headers List<Header> 表头信息 Header（中文名称、字段名、列宽、select信息）
    * mapList List<Map>格式 内容数据（自动识别时间格式的数据）
    * outputStream OutputStream 目标输出流 (可为文件输出流、也可为HttpServlet的response.getOutputStream())
    */
    public static void excel(List<Header> headers, List<Map<String,Object>> mapList,OutputStream outputStream){

        // 创建Excel的工作书册 Workbook,对应到一个excel文档
        HSSFWorkbook wb = new HSSFWorkbook();
        init(wb);
        // 创建Excel的工作sheet,对应到一个excel文档的tab
        HSSFSheet sheet = wb.createSheet("sheet1");
        // 创建Excel的sheet的一行
        HSSFRow row = sheet.createRow(0);
        // 创建一个Excel的单元格

        int k = 0;
        for(int i=0;i<headers.size();i++){
            HSSFCell cell = row.createCell(i);
            // 给Excel的单元格设置样式和赋值
            //cell.getCellStyle().cloneStyleFrom(style);
            //cell.setCellStyle(style);
            if(headers.get(i).getColumnWidth()!=null){
                sheet.setColumnWidth(i,headers.get(i).getColumnWidth()*10);
            }
            cell.setCellValue(headers.get(i).getName());
        }

        for(Map<String,Object> map :mapList){
            row = sheet.createRow(++k);
            for(int j=0;j<headers.size();j++){
                HSSFCell cell = row.createCell(j);
                if(map.containsKey(headers.get(j).getFieldName())){
                    if(headers.get(j).getSelects()!=null){
                        if(headers.get(j).getFieldName().equals("is_warning")){
                            if((""+map.get(""+headers.get(j).getFieldName())).equals("1")){
                                cell.setCellStyle(warning_style);
                            }
                        }
                        cell.setCellValue(""+headers.get(j).getSelects().get(""+map.get(""+headers.get(j).getFieldName())));
                    }else if(map.get(headers.get(j).getFieldName()) instanceof Date){
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        cell.setCellValue(sdf.format((Date)map.get(headers.get(j).getFieldName())));
                    }else{
                        cell.setCellValue(""+map.get(headers.get(j).getFieldName()));
                    }
                }else{
                    cell.setCellValue("");
                }

            }
        }

        try {
            wb.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // 属性
    public static class Header{
        String name;
        String fieldName;
        Map<String,String> selects;
        Integer columnWidth;

        public Header(){ }
        public Header(String name,String fieldName,HashMap<String,String> selects){
            this.fieldName = fieldName;
            this.name = name;
            this.selects = selects;
        }
        public Header(String name,String fieldName){
            this.fieldName = fieldName;
            this.name = name;
        }
        public Header(String name,String fieldName,Integer columnWidth){
            this.fieldName = fieldName;
            this.name = name;
            this.columnWidth = columnWidth;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public Map<String,String> getSelects() {
            return selects;
        }

        public void setSelects(Map<String,String> selects) {
            this.selects = selects;
        }

        public Integer getColumnWidth() {
            return columnWidth;
        }

        public void setColumnWidth(Integer columnWidth) {
            this.columnWidth = columnWidth;
        }
    }

    // 样式
    public static void init(HSSFWorkbook wb) {

        // 创建字体样式
        font = wb.createFont();
        font.setFontName("Verdana");
        font.setBoldweight((short) 200);
        font.setFontHeight((short) 200);
        font.setColor(HSSFColor.BLACK.index);

        //标题样式
        HSSFFont titleFont = wb.createFont();
        titleFont.setFontName("Verdana");
        titleFont.setBold(true);
        titleFont.setFontHeight((short) 150);
        titleFont.setFontHeight((short) 300);
        titleFont.setColor(HSSFColor.BLACK.index);

        titleStyle = wb.createCellStyle();
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        titleStyle.setFont(titleFont);

        // 创建单元格样式
        style = wb.createCellStyle();
        style.setShrinkToFit(true);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        //style.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
        //style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        // 设置边框
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        style.setRightBorderColor(HSSFColor.BLACK.index);
        style.setTopBorderColor(HSSFColor.BLACK.index);
        style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);

        //自动换行
        style.setWrapText(true);

        // 设置字体F
        style.setFont(font);

        warning_font=wb.createFont();
        warning_font.setFontName("Verdana");
        warning_font.setBoldweight((short) 200);
        warning_font.setFontHeight((short) 200);

        //HSSFColor.VIOLET.index //字体颜色
        warning_font.setColor(HSSFColor.RED.index);

        warning_style = wb.createCellStyle();
        warning_style.setFont(warning_font);
    }

    //测试实例
    public static void main(String[] args) {

        List<Header> headers = new ArrayList<Header>(){{
            add(new Header("姓名","name"));
            add(new Header("学号","no",400));
            add(new Header("性别","gender"));
            add(new Header("角色","role",new HashMap<String, String>(){{
                put("1","超级管理员");
                put("2","管理员");
                put("3","普通用户");
            }}));
        }};

        List<Map<String,Object>> mapList = new ArrayList<Map<String, Object>>() {{
            add(new HashMap<String, Object>() {{
                put("name","张三");
                put("no","1400001");
                put("gender","男");
                put("role","1");
            }});
            add(new HashMap<String, Object>() {{
                put("name","李四");
                put("no","1400002");
                put("gender","男");
                put("role","2");
            }});
            add(new HashMap<String, Object>() {{
                put("name","王五");
                put("no","1400003");
                put("gender","女");
                put("role","3");
            }});
            add(new HashMap<String, Object>() {{
                put("name","赵六");
                put("no","1400004");
                put("gender","男");
                put("role","3");
            }});
        }};

        try {
            OutputStream outputStream = new FileOutputStream(new File("/Users/wangxinfeng/Documents/example.xls"));
            ExcelUtil.excel(headers,mapList,outputStream);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
