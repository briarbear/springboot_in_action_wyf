package com.xzp.ch1_2_3.ch2.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan("com.xzp.ch1_2_3.ch2.profile")
public class ProfileConfig {
    @Bean
    @Profile("dev") //1
    public DemoBean devDemoBean() {
        return new DemoBean("from development profile");
    }

    @Bean
    @Profile("prod") //2
    public DemoBean prodDemoBean() {
        return new DemoBean("from production profile");
    }
}
