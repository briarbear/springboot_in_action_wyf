package com.val1ant.ch6_6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.val1ant.HelloService;

@RestController
@SpringBootApplication
public class Ch66Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch66Application.class, args);
    }

    @Autowired
    HelloService helloService;

    @GetMapping("/")
    public String index(){
        return helloService.sayHello();
    }
}
