package com.xzp.ch1_2_3.ch2.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
        DemoSingletonService demoSingletonService1 = context.getBean(DemoSingletonService.class);
        DemoSingletonService demoSingletonService2 = context.getBean(DemoSingletonService.class);

        DemoPrototypeService prototypeService1 = context.getBean(DemoPrototypeService.class);
        DemoPrototypeService prototypeService2 = context.getBean(DemoPrototypeService.class);

        System.out.println(demoSingletonService1.equals(demoSingletonService2));
        System.out.println(prototypeService1.equals(prototypeService2));
    }
}
