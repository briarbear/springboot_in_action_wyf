package com.xzp.ch1_2_3.ch2.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;


public class DemoBean {

    private String content;

    public DemoBean(String content) {
        super();
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
