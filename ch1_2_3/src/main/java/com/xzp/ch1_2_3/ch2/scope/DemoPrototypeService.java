package com.xzp.ch1_2_3.ch2.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")//1每次调用了新建一个bean
public class DemoPrototypeService {

}