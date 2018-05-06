package xin.val1ant.ch8.ch8_2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.val1ant.ch8.ch8_2.dao.PersonRepository;
import xin.val1ant.ch8.ch8_2.domain.Person;

import java.util.List;

/**
 * 控制器
 *
 * @auther Val1ant
 * @blog http://www.val1ant.xin
 * @create 2018-05-05-20:47
 */
@RestController
public class DataController {

    //1 Spring Data JPA已自动为你注册bean，所以可自动注入
    @Autowired
    PersonRepository personRepository;

    /**
     * 保存
     * save支持批量保存：<S extends T> Iterable<S> save(Iterable<S> entities);
     *
     * 删除：
     * 删除支持使用id，对象以，批量删除及删除全部：
     * void delete(ID id);
     * void delete(T entity);
     * void delete(Iterable<? extends T> entities);
     * void deleteAll();
     *
     */
    @RequestMapping("/save")
    public Person save(String name, String address, Integer age){

        Person p = personRepository.save(new Person(null, name, age, address));

        return p;

    }



    /**
     * 测试findByAddress
     */
    @RequestMapping("/q1")
    public List<Person> q1(String address){

        List<Person> people = personRepository.findByAddress(address);

        return people;

    }

    /**
     * 测试findByNameAndAddress
     */
    @RequestMapping("/q2")
    public Person q2(String name,String address){

        Person people = personRepository.findByNameAndAddress(name, address);

        return people;

    }

    /**
     * 测试withNameAndAddressQuery
     * 使用自定义的Query,实现参数绑定
     */
    @RequestMapping("/q3")
    public Person q3(String name,String address){

        Person p = personRepository.withNameAndAddressQuery(name, address);

        return p;

    }

    /**
     * 测试withNameAndAddressNamedQuery
     * 查询方法在实体类中定义的
     */
    @RequestMapping("/q4")
    public Person q4(String name,String address){

        Person p = personRepository.withNameAndAddressNamedQuery(name, address);

        return p;

    }

    /**
     * 测试排序
     */
    @RequestMapping("/sort")
    public List<Person> sort(){

        List<Person> people = personRepository.findAll(new Sort(Direction.ASC,"age"));

        return people;

    }

    /**
     * 测试分页 失效
     */
    @RequestMapping("/page")
    public Page<Person> page(){

//        Page<Student> pagePeople = personRepository.findAll(new PageRequest(1, 2));

        //springboot2 新实现
//        Sort sort = new Sort(Direction.ASC,"id");
        Page<Person> pagePeople = personRepository.findAll(PageRequest.of(1,2));

        return pagePeople;

    }


//    @RequestMapping("/auto")
//    public Page<Student> auto(Student person){
//
//        Page<Student> pagePeople = personRepository.findByAuto(person, new PageRequest(0, 10));
//
//        return pagePeople;
//
//    }


}
