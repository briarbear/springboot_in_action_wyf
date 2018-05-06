package xin.val1ant.ch7.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.val1ant.ch7.entity.Person;

/**
 * angular演示控制器
 *
 * @auther Val1ant
 * @blog http://www.val1ant.xin
 * @create 2018-05-05-16:48
 */
@RestController
public class PersonController {

    @RequestMapping(value="/search",produces={MediaType.APPLICATION_JSON_VALUE})
    public Person search(String personName){

        return new Person(personName, 32, "uestc");

    }
}
