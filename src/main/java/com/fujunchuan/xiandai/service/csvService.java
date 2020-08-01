package com.fujunchuan.xiandai.service;

import com.fujunchuan.xiandai.pojo.dataDto;
import com.github.crab2died.ExcelUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class csvService {

    public static void main(String[] args) {
        //第一步：先获取csv文件的路径，通过BufferedReader类去读该路径中的文件
        File csv = new File("D:\\360MoveData\\Users\\Administrator\\Desktop\\j.csv");
        String tempPath = "D:/b.xlsx";
        try {
            //第二步：从字符输入流读取文本，缓冲各个字符，从而实现字符、数组和行（文本的行数通过回车符来进行判定）的高效读取。
            //          BufferedReader textFile = new BufferedReader(new FileReader(csv));
            InputStreamReader isr = new InputStreamReader(new FileInputStream(csv), "utf8");
            InputStreamReader isr2 = new InputStreamReader(new FileInputStream(csv), "utf8");
            BufferedReader textFile = new BufferedReader(isr);
            BufferedReader textFile2 = new BufferedReader(isr2);
            String lineDta = "";
            String lineDta2 = "";
            //第三步：将文档的下一行数据赋值给lineData，并判断是否为空，若不为空则输出
            //标记
            int lineNO = 0;
            int lineNO2 = 0;
            //菲斯塔纯电动
            int lineType1 = 0;
            //十代索纳塔
            int lineType2 = 0;
            Map<String, String> type2Data = new HashMap<>();
            Map<String, String> type1Data = new HashMap<>();
            while ((lineDta = textFile.readLine()) != null) {
                System.out.println(lineDta);
                lineNO = lineNO + 1;
                if (lineDta.contains("菲斯塔纯电动")) {
                    lineType1 = lineNO;
                    System.out.println(lineType1);
                }
                if (lineDta.contains("第十代索纳塔")) {
                    lineType2 = lineNO;
                    System.out.println(lineType2);
                }
            }
            while ((lineDta2 = textFile2.readLine()) != null) {
                System.out.println(lineDta2);
                lineNO2 = lineNO2 + 1;
                if (!lineDta2.contains("Campaign Name") && !lineDta2.contains("第十代索纳塔") & lineNO2 < lineType2) {
                    if (StringUtils.isNotBlank(lineDta2.split(",")[0])) {
                        type1Data.put(lineDta2.split(",")[0], lineDta2.replace(lineDta2.split(",")[0] + ",", ""));
                    }
                }
                if (lineNO2 >= lineType2) {
                    if (StringUtils.isNotBlank(lineDta2.split(",")[0])) {
                        type2Data.put(lineDta2.split(",")[0], lineDta2.replace(lineDta2.split(",")[0] + ",", ""));
                    }
                }
            }
            //使用迭代器的remove()方法删除元素--lamda
            type1Data.entrySet().removeIf(entry -> !HasDigit(entry.getValue()));
            type2Data.entrySet().removeIf(entry -> !HasDigit(entry.getValue()));
            System.out.println(type1Data.toString());
            System.out.println(type2Data.toString());
            textFile.close();
            textFile2.close();
            //ExcelUtils.getInstance().exportObjects2Excel(list, Student2.class, true, "sheet0", true, "D:/D.xlsx");
            HashMap<String, String> data = new HashMap<>();
            data.put("info","PC");
            List list = new ArrayList<>();
            list.add(new dataDto("2020-7-30 17:49:40", "1", "1", "1", "1"));
            list.add(new dataDto("2020-7-30 17:50:13", "2", "2", "2", "2"));
            ExcelUtils.getInstance().exportObjects2Excel(tempPath, 0, list, data, dataDto.class, true, "D:/A.xlsx");



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


    //判断是否含有数字
    private static boolean HasDigit(String content) {
        boolean flag = false;
        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(content);
        if (m.matches()) {
            flag = true;
        }
        return flag;
    }
}