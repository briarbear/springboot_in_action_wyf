package xin.val1ant.ch8_4.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.val1ant.ch8_4.domain.Person;
import xin.val1ant.ch8_4.service.DemoService;

/**
 * 控制器
 *
 * @auther Val1ant
 * @blog http://www.val1ant.xin
 * @create 2018-05-06-22:31
 */
@RestController
public class MyController {
    @Autowired
    DemoService demoService;

    @RequestMapping("/rollback")
    public Person rollback(Person person){ //1

        return demoService.savePersonWithRollBack(person);
    }

    @RequestMapping("/norollback")
    public Person noRollback(Person person){//2

        return demoService.savePersonWithoutRollBack(person);


    }

}
