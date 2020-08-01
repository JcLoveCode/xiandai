package com.fujunchuan.xiandai.pojo;


import com.github.crab2died.annotation.ExcelField;



public class dataDto {
    @ExcelField(title = "日期", order = 1)
    String data;
    @ExcelField(title = "媒体", order = 2)
    String channel;
    @ExcelField(title = "PV", order = 3)
    String pcpv;
    @ExcelField(title = "UV", order = 4)
    String pcuv;
    @ExcelField(title = "平均停留时长", order = 5)
    String pctime;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getPcpv() {
        return pcpv;
    }

    public void setPcpv(String pcpv) {
        this.pcpv = pcpv;
    }

    public String getPcuv() {
        return pcuv;
    }

    public void setPcuv(String pcuv) {
        this.pcuv = pcuv;
    }

    public String getPctime() {
        return pctime;
    }

    public void setPctime(String pctime) {
        this.pctime = pctime;
    }

    public dataDto(String data, String channel, String pcpv, String pcuv, String pctime) {
        this.data = data;
        this.channel = channel;
        this.pcpv = pcpv;
        this.pcuv = pcuv;
        this.pctime = pctime;
    }
}
