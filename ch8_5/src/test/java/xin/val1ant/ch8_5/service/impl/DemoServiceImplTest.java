package xin.val1ant.ch8_5.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import xin.val1ant.ch8_5.Ch85ApplicationTests;
import xin.val1ant.ch8_5.domain.Person;
import xin.val1ant.ch8_5.service.IDemoService;

import static org.junit.Assert.*;

public class DemoServiceImplTest extends Ch85ApplicationTests {

    @Autowired
    IDemoService demoService;
    @Test
    public void findOne() {
        Person p = new Person();
        p.setId(Long.valueOf(1));
        Person p2 = demoService.findOne(p);
        System.out.println(p2.getName());
    }
}