package com.xzp.ch1_2_3.ch1.di;

import org.springframework.stereotype.Service;

@Service
public class FunctionService {
    public String sayHello(String word){
        return "Hello " + word +" !";
    }

}
