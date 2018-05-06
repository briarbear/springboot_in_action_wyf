package xin.val1ant.ch8_4.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import xin.val1ant.ch8_4.Ch84ApplicationTests;
import xin.val1ant.ch8_4.domain.Person;
import xin.val1ant.ch8_4.service.DemoService;

import static org.junit.Assert.*;

public class DemoServiceImplTest extends Ch84ApplicationTests {

    @Autowired
    private DemoService demoService;
    @Test
    public void savePersonWithRollBack() {

        Person person = new Person();
        person.setName("汪云飞");
        person.setAge(32);
        demoService.savePersonWithRollBack(person);
    }
}