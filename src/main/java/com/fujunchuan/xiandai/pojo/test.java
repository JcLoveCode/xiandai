package com.fujunchuan.xiandai.pojo;

import com.github.crab2died.annotation.ExcelField;

public class test {

    @ExcelField(title = "学号", order = 1)
    private Long id;

    @ExcelField(title = "姓名", order = 2)
    private String name;


    @ExcelField(title = "班级", order = 4)
    private Integer classes;


}
