package xin.val1ant.ch8_5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import xin.val1ant.ch8_5.dao.PersonRepository;
import xin.val1ant.ch8_5.domain.Person;
import xin.val1ant.ch8_5.service.IDemoService;

import java.util.List;

/**
 * shixian
 *
 * @auther Val1ant
 * @blog http://www.val1ant.xin
 * @create 2018-05-06-23:46
 */
@Service
public class DemoServiceImpl implements IDemoService {

    @Autowired
    PersonRepository personRepository;

    //@Cache Put 缓存新增的或更新的数据到缓存，其中缓存名称为people ，数据的key 是person 的id
    @Override
    @CachePut(value = "people", key = "#person.id")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("为id、key为:"+p.getId()+"数据做了缓存");
        return p;
    }

    /**
     * ＠CacheEvict 从缓存people 中删除key 为id 的数据
     * @param id
     */
    @Override
    @CacheEvict(value = "people")//2
    public void remove(Long id) {
        System.out.println("删除了id、key为"+id+"的数据缓存");
        //这里不做实际删除操作
    }

    /**
     * Cacheable 缓存key 为person 的id 数据到缓存people中
     * @param person
     * @return
     */
    @Override
    @Cacheable(value = "people", key = "#person.id")//3
    public Person findOne(Person person) {
//        Person p = personRepository.findOne(person.getId());
//        Person p = personRepository.getOne(person.getId());
        Person p = personRepository.findById(person.getId()).get();
        System.out.println("为id、key为:"+p.getId()+"数据做了缓存");
        return p;
    }

}
