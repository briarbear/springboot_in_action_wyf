package xin.val1ant.ch8_5.service;

import xin.val1ant.ch8_5.domain.Person;

/**
 * 服务接口
 */
public interface IDemoService {
    public Person save(Person person);

    public void remove(Long id);

    public Person findOne(Person person);
}
