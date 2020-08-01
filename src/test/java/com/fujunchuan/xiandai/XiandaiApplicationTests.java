package com.fujunchuan.xiandai;

import com.fujunchuan.xiandai.pojo.test;
import com.github.crab2died.ExcelUtils;
import com.github.crab2died.exceptions.Excel4JException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class XiandaiApplicationTests {

    @Test
    public void testReadCSV() throws Excel4JException {
        List<test> list = ExcelUtils.getInstance().readCSV2Objects("J.csv", test.class);
        System.out.println(list);
    }

}
