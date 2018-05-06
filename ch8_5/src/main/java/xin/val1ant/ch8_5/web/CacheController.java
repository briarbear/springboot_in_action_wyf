package xin.val1ant.ch8_5.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.val1ant.ch8_5.domain.Person;
import xin.val1ant.ch8_5.service.IDemoService;

/**
 * 控制器
 *
 * @auther Val1ant
 * @blog http://www.val1ant.xin
 * @create 2018-05-06-23:52
 */

@RestController
public class CacheController {

    @Autowired
    IDemoService demoService;




    @RequestMapping("/put")
    public Person put(Person person){
        return demoService.save(person);

    }


    @RequestMapping("/able")
    public Person cacheable(Person person){


        return demoService.findOne(person);

    }

    @RequestMapping("/evit")
    public String  evit(Long id){
        demoService.remove(id);
        return "ok";

    }


}
