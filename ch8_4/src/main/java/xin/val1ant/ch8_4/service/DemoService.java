package xin.val1ant.ch8_4.service;

import xin.val1ant.ch8_4.domain.Person;

/**
 * 服务接口
 *
 * @auther Val1ant
 * @blog http://www.val1ant.xin
 * @create 2018-05-06-22:18
 */
public interface DemoService {
    public Person savePersonWithRollBack(Person person);
    public Person savePersonWithoutRollBack(Person person);

}

