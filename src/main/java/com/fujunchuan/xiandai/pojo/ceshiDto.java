package com.fujunchuan.xiandai.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ceshiDto {
    //@ExcelProperty("日期")
    private String channel;
   // @ExcelProperty({"PC", "pv"})
    private String pcpv;
   // @ExcelProperty({"PC", "uv"})
    private String pcuv;
    ///@ExcelProperty({"PC", "平均停留市场"})
    private String pctime;
}
