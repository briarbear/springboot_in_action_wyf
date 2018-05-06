package xin.val1ant.ch8.ch8_2.web;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import xin.val1ant.ch8.Ch8ApplicationTests;
import xin.val1ant.ch8.ch8_2.dao.PersonRepository;
import xin.val1ant.ch8.ch8_2.domain.Person;

import static org.junit.Assert.*;

public class DataControllerTest extends Ch8ApplicationTests {

    @Autowired
    private PersonRepository personRepository;
    @Test
    public void page() {

        //springboot2 新实现
//        Sort sort = new Sort(Sort.Direction.ASC,"id");
//        Pageable pageable = PageRequest.of(1,2,Sort.Direction.ASC,"id");

        Page<Person> pagePeople = personRepository.findAll(PageRequest.of(1,2));
        Assert.assertEquals(true,pagePeople.getSize()>0);
    }
}