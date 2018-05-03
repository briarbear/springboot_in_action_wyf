package com.xzp.ch1_2_3.ch2.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:ch2/test.properties")
public class DemoService {

//    @Value("#{book.auother}")
//    @Value("其他类的属性") //1
    @Value("${book.author}")
    private String another;

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }



}